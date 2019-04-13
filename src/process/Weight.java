package process;

import java.lang.IllegalArgumentException;

import java.util.Calendar;

import adt.LocationT;
import adt.LocationT.locTypeT;
import adt.ShelterT;
import adt.UserT;
import adt.UserT.UserResT;
import io.Read;

public class Weight {
	
	public static double weightCap(ShelterT shel, int date) {
		double sumCap = 0; 
		int numberDays = 0;
		
		for (int index = date-3; index < date+4; index++) {
			if (!(index < 0 || index > 364)) {
				if (shel.getCap2018(index) != 0 && shel.getCap2017(index) != 0) {
					sumCap += 0.3 * shel.getOcc2017(index) + 0.7 * shel.getOcc2018(index);
					numberDays++;
				} else if (shel.getCap2017(index) != 0) {
					sumCap += shel.getOcc2018(index);
					numberDays++;
				} else if (shel.getCap2018(index) != 0) {
					sumCap += shel.getOcc2017(index);
					numberDays++;
				} else { continue; }
			}
		}
		
		if (numberDays == 0) {
			throw new IllegalArgumentException("Capacity undefined");
			
		}
		
		double avg = sumCap / numberDays;
		
		if (shel.getCap2018(date) != 0)
			return (1 - (avg / shel.getCap2018(date)));
		else if (shel.getCap2017(date) != 0)
			return (1 - (avg / shel.getCap2017(date)));
		else 
			throw new IllegalArgumentException("Capacity undefined");
	}

	public static double weightDist(LocationT loc, UserT user) {
		double latS = loc.getLat(), latU = user.getLat();
		double lonS = loc.getLon(), lonU = user.getLon();

		// a simplified calculation since Toronto is relatively flat from:
		// https://stackoverflow.com/questions/1664799/calculating-distance-between-two-points-using-pythagorean-theorem
		double d_ew = 111.320 * (lonS - lonU) * Math.cos(Math.toRadians(latU));
		double d_ns = 110.574 * (latS - latU);
		
		double dist = Math.sqrt(d_ew * d_ew + d_ns * d_ns);
		return (1 - (dist / (5 + dist))); // Maps distance to a weighting between 0 and 1.
	}
	
	public static double calcScore(LocationT loc, UserT user) {
		Calendar calendar = Calendar.getInstance();
		int dayIndex = calendar.get(Calendar.DAY_OF_YEAR) - 1;
		if (loc.getLocType() == locTypeT.SHELTER) {
			ShelterT shel = (ShelterT) loc;
			if (!(shel.isValidType(user) && shel.isValidCap(dayIndex))) {
				return 0.0;
			} else {
				return (0.8 * weightDist(loc, user) + 0.2 * weightCap(shel, dayIndex));
			}
		} else {
			return weightDist(loc, user);
		}
	}
	
	
	public static void main(String args[]) {
		ShelterT[][] masterArray = Read.readShelterData();
		
		UserT user = new UserT(UserResT.MALE_ONLY, 43.59631373, -79.54658312);	
		
		for (int i = 0; i < masterArray.length; i++) {
			for (int j = 0; j < masterArray[i].length; j++) {
				// sets score for each shelter
				masterArray[i][j].setScore(Weight.calcScore(masterArray[i][j], user));
			}
		}
		
		for (ShelterT shel : masterArray[2]) {
			if (shel.getAddress().equalsIgnoreCase("38 Bathrust St")) {
				System.out.println(shel.getAddress());
				
				System.out.println("Lat: " + shel.getLat() + " Lon: " + shel.getLon());
				
				System.out.println("WghtDist: " + weightDist(shel, user));
				Calendar calendar = Calendar.getInstance();
				int dayIndex = calendar.get(Calendar.DAY_OF_YEAR) - 1;
				System.out.println("Cap:      " + weightCap(shel, dayIndex));
				System.out.println("Score:    " + calcScore(shel, user));
			}
		}
	}
}
