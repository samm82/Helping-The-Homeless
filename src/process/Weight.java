package process;

import java.lang.IllegalArgumentException;

import adt.ShelterT;
import adt.UserT;

public class Weight {
	
	public static int calcCapacity(int cap17, int cap18) {
		return (int) (cap17 * 0.3 + cap18 * 0.7);
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
		else return 1.0;
	}
}
