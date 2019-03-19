package process;

import adt.ShelterT;
import adt.UserT;

public class Weight {
	
	public static int calcCapacity(int cap17, int cap18) {
		return (int) (cap17 * 0.3 + cap18 * 0.7);
	}
	
	// Work in progress
	public static double calcScore(ShelterT loc, UserT user) {
		if (!loc.isValidType(user)) return 0.0;
		else return 1.0;
	}
}
