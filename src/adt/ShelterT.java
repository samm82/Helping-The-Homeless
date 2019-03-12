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
	private String name, address;
	private int occupancy, capacity;
	
	public ShelterT(ResidentT type, String name, String address, int occupancy, int capacity) {
		super(name, address);
		this.type = type;
		this.occupancy = occupancy;
		this.capacity = capacity;
	}
	
	
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
