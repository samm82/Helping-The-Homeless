package process;

import java.lang.IllegalArgumentException;

import java.util.Calendar;

import adt.LocationT;
import adt.LocationT.locTypeT;
import adt.ShelterT;
import adt.UserT;
import adt.UserT.UserResT;
import io.Read;
import adt.ShelterT.shelterResT;

public class Weight {
	
	public static double weightCap(ShelterT shel, int date) {
		double cap = 0.3 * shel.getOcc2017(date) + 0.7 * shel.getOcc2018(date);
		if (shel.getCap2018(date) != 0)
			return (1 - (cap / shel.getCap2018(date)));
		else if (shel.getCap2017(date) != 0)
			return (1 - (shel.getOcc2017(date) / shel.getCap2017(date)));
		else 
			throw new IllegalArgumentException("Capacity undefined");
	}
	
	/* Copyright (C) 2002-2019 Andrew Hedges

	 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
	 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the 
	 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
	 * persons to whom the Software is furnished to do so, subject to the following conditions:
	 * 
	 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of 
	 * the Software.
	 * 
	 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE 
	 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR 
	 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR 
	 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
	 * 
	 */
	
	public static double calcDist(LocationT loc, UserT user) {
		double latS = loc.getLat(), latU = user.getLat();
		double lonS = loc.getLon(), lonU = user.getLon();

		// a simplified calculation since Toronto is relatively flat
		// from https://stackoverflow.com/questions/1664799/calculating-distance-between-two-points-using-pythagorean-theorem
		double d_ew = 111.320 * (lonS - lonU) * Math.cos(Math.toRadians(latU));
		double d_ns = 110.574 * (latS - latU);
		
		return Math.sqrt(d_ew * d_ew + d_ns * d_ns);
	}
	
	public static double weightDist(double dist) {
		if   (dist < 0.0)  throw new IllegalArgumentException("Distance must be positive");
		else return (1 - (dist / (5 + dist))); // new formula for more gradual mapping of distances
	}
	
	// Work in progress
	public static double calcScore(LocationT loc, UserT user) {
		Calendar calendar = Calendar.getInstance();
		int dayIndex = calendar.get(Calendar.DAY_OF_YEAR) - 1;
		if (loc.getLocType() == locTypeT.SHELTER) {
			ShelterT shel = (ShelterT) loc;
			if ((!(shel.isValidType(user) && shel.isValidCap(dayIndex))) || shel.isFull(dayIndex)) {
				return 0.0;
			} else {
//				System.out.println("   " + weightDist(calcDist(loc, user)));
//				System.out.println("   " + weightCap(shel, dayIndex));
				return (0.75 * weightDist(calcDist(loc, user)) + 0.25 * weightCap(shel, dayIndex));
			}
		} else {
			return weightDist(calcDist(loc, user));
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
				
				System.out.println("Distance: " + calcDist(shel, user));
				System.out.println("WghtDist: " + weightDist(calcDist(shel, user)));
				Calendar calendar = Calendar.getInstance();
				int dayIndex = calendar.get(Calendar.DAY_OF_YEAR) - 1;
				System.out.println("Cap:      " + weightCap(shel, dayIndex));
				System.out.println("Score:    " + calcScore(shel, user));
			}
		}

		
//		System.out.println("Distance: " + calcDist(male, me));   // 32.218km
//		System.out.println("Distance: " + calcDist(female, me)); // 18.739km
//		System.out.println();
//		System.out.println("Score: " + calcScore(male, me));   // 0.9 + cap
//		System.out.println("Score: " + calcScore(female, me)); // 0.0 -> wrong type
	}
}
