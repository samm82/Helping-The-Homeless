package adt;

public class ShelterT extends LocationT {
	
	public enum shelterResT {
		MALE, FEMALE, COED, FAMILY, YOUTH;
	}
	
	private shelterResT type;
	private String orgName, facilityName, progName;
	private int[] occupancy2018, capacity2018, occupancy2017, capacity2017;
	private int N, M;
	
	public ShelterT(shelterResT type, String orgName, String shelterName, String facilityName, String progName,  String address) {
		super(shelterName, address);
		this.type = type;
		
		this.orgName = orgName;
		this.progName = progName;
		this.facilityName = facilityName;
		
		this.occupancy2018 = new int[365];
		this.capacity2018  = new int[365];
		this.occupancy2017 = new int[365];
		this.capacity2017  = new int[365];
		N = 0;
		M = 0;
	}
	
	public void setCapOcc(int occupancy, int capacity, int year) {
		if (year == 2018) {
			this.occupancy2018[N] = occupancy;
			this.capacity2018[N] = capacity;
			N++;
		}
		if (year == 2017) {
			this.occupancy2017[M] = occupancy;
			this.capacity2017[M] = capacity;
			M++;
		}
	}
	
	public shelterResT getType() {
		return this.type;
	}
	
	public String getOrgName() {
		return this.orgName;
	}
	
	public String getFacilityName() {
		return this.facilityName;
	}
	
	public String getProgName() {
		return this.progName;
	}
	
	public int[] getOccupancy2018() {
		return this.occupancy2018;
	}
	
	public int[] getOccupancy2017() {
		return this.occupancy2017;
	}
	
	public int[] getCapacity2018() {
		return this.capacity2018;
	}
	
	public int[] getCapacity2017() {
		return this.capacity2017;
	}
	
//  May not be used due to changing the implementation of user type	
	public boolean isValidType(UserT user) {	
		if (user.isFamily()) return (type == shelterResT.FAMILY);
		if (user.isYouth())  return (type == shelterResT.YOUTH);
		
		if      (user.isFlexible() && type == shelterResT.COED  ) return true;
		else if (user.isMale()     && type == shelterResT.MALE  ) return true;
		else if (user.isFemale()   && type == shelterResT.FEMALE) return true;
		else                                                      return false;
		
	}

}
