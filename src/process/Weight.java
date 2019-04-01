package process;

import java.lang.IllegalArgumentException;

import java.util.Calendar;

import adt.LocationT;
import adt.LocationT.locTypeT;
import adt.ShelterT;
import adt.UserT;
import adt.UserT.UserResT;
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
	
	/* Copyright (C) 2002 — 2019 Andrew Hedges

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
		
		double latDiff = Math.toRadians((latS - latU));
		double lonDiff = Math.toRadians((lonS - lonU));
		
		double a = Math.pow(Math.sin(latDiff/2), 2) + 
				   Math.cos(Math.toRadians(latS)) * Math.cos(Math.toRadians(latU)) *
				   Math.pow(Math.sin(lonDiff/2), 2);
		return (12742 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)));
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
				return (weightDist(calcDist(loc, user)) + weightCap(shel, dayIndex) / 2);
			}
		} else {
			return weightDist(calcDist(loc, user));
		}
	}
	
	public static void main(String args[]) {
		ShelterT male   = new ShelterT(shelterResT.MALE,   "Christie Ossington Neighbourhood Centre", 
														   "Christie Ossington Men's Hostel",
														   "Christie Ossington Men's Hostel", 
														   "Christie Ossington Extreme Weather Program",  
														   "973 Lansdowne Avenue");
		ShelterT female = new ShelterT(shelterResT.FEMALE, "Christie Refugee Welcome Centre, Inc.", 
														   "Christie Refugee Welcome Centre", 
														   "CR Welcome Centre(Singles)", 
														   "Christe Refugee Welcome Centre - Singles",
														   "43 Christie Street");
		
		male.setLat(43.237000);
		male.setLon(-73.100000);
		
		female.setLat(43.104728);
		female.setLon(-73.248102);
		
		UserT me = new UserT(UserResT.MALE_ONLY, 43.239487, -73.109472);
		
		System.out.println("Distance: " + calcDist(male, me));   // 32.218km
		System.out.println("Distance: " + calcDist(female, me)); // 18.739km
		System.out.println();
//		System.out.println("Score: " + calcScore(male, me));   // 0.9 + cap
//		System.out.println("Score: " + calcScore(female, me)); // 0.0 -> wrong type
	}
}
