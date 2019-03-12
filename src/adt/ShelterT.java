package adt;

public class ShelterT extends LocationT {
	
	private enum shelterResT {
		MALE,
		FEMALE,
		COED,
		FAMILY,
		YOUTH
	}
		
	private shelterResT type;
	private String name, address;
	private int[] occupancy2018, capacity2018, occupancy2017, capacity2017;
	private int N;
	
	public ShelterT(shelterResT type, String name, String address) {
		super(name, address);
		this.type = type;
		
		occupancy2018 = new int[365];
		capacity2018  = new int[365];
		occupancy2017 = new int[365];
		capacity2017  = new int[365];
		N = 0;
	}
	
	public void setOccupancy(int occupancy, int year) {
		if (year == 2018) {
			this.occupancy2018[N] = occupancy;
		}
		if (year == 2017) {
			this.occupancy2017[N] = occupancy;
		}
	}
	
	public void setCapacity(int capacity, int year) {
		if (year == 2018) {
			this.capacity2018[N] = capacity;
		}
		if (year == 2017) {
			this.capacity2017[N] = capacity;
		}
	}
	
//  May not be used due to changing the implementation of user type	
//	public boolean isValidType(UserT user) {
//		GenderT gen  = user.getGender();
//		
//		if (user.isFamily()) return (type == ResidentT.FAMILY);
//		if (user.isYouth())  return (type == ResidentT.YOUTH);
//		
//		if      (user.isFlexible()     && type == ResidentT.COED  ) return true;
//		else if (gen == GenderT.MALE   && type == ResidentT.MALE  ) return true;
//		else if (gen == GenderT.FEMALE && type == ResidentT.FEMALE) return true;
//		else                                                        return false;
//		
//	}

}
