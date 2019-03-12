package adt;

import adt.UserT.GenderT;

public class ShelterT extends LocationT {
	
	enum ResidentT {
		MALE,
		FEMALE,
		COED,
		FAMILY,
		YOUTH
	}
	
	private ResidentT type;
	
	public boolean isValidType(UserT user) {
		GenderT gen  = user.getGender();
		boolean flex = user.getFlexibility();
		
		if (flex                  && type == ResidentT.COED  ) return true;
		if (gen == GenderT.MALE   && type == ResidentT.MALE  ) return true;
		if (gen == GenderT.FEMALE && type == ResidentT.FEMALE) return true;
		else                                                   return false;
		
	}

}
