package adt;

import adt.UserT.GenderT;

public class ShelterT extends LocationT {
	
	private enum ResidentT {
		MALE,
		FEMALE,
		COED,
		FAMILY,
		YOUTH
	}
	
	private ResidentT type;
	
	public boolean isValidType(UserT user) {
		GenderT gen  = user.getGender();
		
		if (user.isFamily()) return (type == ResidentT.FAMILY);
		if (user.isYouth())  return (type == ResidentT.YOUTH);
		
		if      (user.isFlexible()     && type == ResidentT.COED  ) return true;
		else if (gen == GenderT.MALE   && type == ResidentT.MALE  ) return true;
		else if (gen == GenderT.FEMALE && type == ResidentT.FEMALE) return true;
		else                                                        return false;
		
	}

}
