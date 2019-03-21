package process;

import java.lang.IllegalArgumentException;

import adt.LocationT;
import adt.ShelterT;
import adt.UserT;
import adt.UserT.UserResT;
import adt.ShelterT.shelterResT;

public class Weight {
	
	public static int calcCapacity(int cap17, int cap18) {
		return (int) (cap17 * 0.3 + cap18 * 0.7);
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
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double dist = c * 6371;
		return dist;
	}
	
	public static double weightDist(double dist) {
		if      (dist < 0.0)  throw new IllegalArgumentException("Distance must be positive");
		else if (dist < 0.5)  return 1.0;
		else if (dist < 1.0)  return 0.9;
		else if (dist < 1.5)  return 0.8;
		else if (dist < 2.0)  return 0.7;
		else if (dist < 3.0)  return 0.6;
		else if (dist < 5.0)  return 0.5;
		else if (dist < 7.0)  return 0.4;
		else if (dist < 10.0) return 0.3;
		else if (dist < 15.0) return 0.2;
		else if (dist < 25.0) return 0.1;
		else                  return 0.0;
	}
	
	// Work in progress
	public static double calcScore(ShelterT loc, UserT user) {
		if (!loc.isValidType(user)) return 0.0;
		else return weightDist(calcDist(loc, user));
	}
	
	public static void main(String args[]) {
		ShelterT male   = new ShelterT(shelterResT.MALE,   "ORG", "Sam's Shelter", "Fac", "Get Gud Program",  "420 Blaze Ave");
		ShelterT female = new ShelterT(shelterResT.FEMALE, "ORG", "Sam's Women  ", "Fac", "Get Girl Program", "422 Blaze Ave");
		
		male.setLat(43.420420);
		male.setLon(-73.420420);
		
		female.setLat(43.104728);
		female.setLon(-73.248102);
		
		UserT me = new UserT(UserResT.MALE_ONLY, 43.239487, -73.109472);
		
		System.out.println("Distance: " + calcDist(male, me));   // 32.218km
		System.out.println("Distance: " + calcDist(female, me)); // 18.739km
		System.out.println();
		System.out.println("Score: " + calcScore(male, me));   // 0.0 -> too far
		System.out.println("Score: " + calcScore(female, me)); // 0.0 -> wrong type
	}
}
