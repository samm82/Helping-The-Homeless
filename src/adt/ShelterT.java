package adt;

/**
 * ADT for a shelter, parent class is LocationT
 * @author Sam and Nicholas
 *
 */
public class ShelterT extends LocationT {
	
	/**
	 * Enum for type of shelter
	 * @author Sam
	 *
	 */
	public enum shelterResT {
		MALE, FEMALE, COED, FAMILY, YOUTH;
	}
	
	private shelterResT type;
	private String orgName, facilityName, progName;
	private int[] occupancy2018, capacity2018, occupancy2017, capacity2017;
	private int N, M;
	
	/**
	 * Constructor for new ShelterT
	 * @param type Shelter type
	 * @param orgName Organization name
	 * @param shelterName Shelter name
	 * @param facilityName Facility name
	 * @param progName Program name
	 * @param address Address
	 */
	public ShelterT(shelterResT type, String orgName, String shelterName, String facilityName, String progName,  String address) {
		super(shelterName, address, locTypeT.SHELTER);
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
	
	/**
	 * Sets the occupancy and capacity
	 * @param occupancy Sets the occupancy
	 * @param capacity Sets the capacity
	 * @param year Year data is from
	 */
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
	
	/**
	 * 
	 * @return Type of shelter
	 */
	public shelterResT getType() {
		return this.type;
	}
	
	/**
	 * 
	 * @return Type of shelter in string form
	 */
	public String getTypeString() {
		switch (getType()) {
		case MALE:
			return "Male";
		case FEMALE:
			return "Female";		
		case COED:
			return "Coed";
		case FAMILY:
			return "Family";
		case YOUTH:
			return "Youth";
		default:
			return "Error";
		}
		
	}
	
	/**
	 * 
	 * @return Organization name
	 */
	public String getOrgName() {
		return this.orgName;
	}
	
	/**
	 * 
	 * @return Facility name
	 */
	public String getFacilityName() {
		return this.facilityName;
	}
	
	/**
	 * 
	 * @return Program name
	 */
	public String getProgName() {
		return this.progName;
	}
	
	/**
	 * Gets the 2018 occupancy on a certain date
	 * @param i Date index
	 * @return Occupancy
	 */
	public int getOcc2018(int i) {
		return this.occupancy2018[i];
	}
	
	/**
	 * Gets the 2017 occupancy on a certain date
	 * @param i Date index
	 * @return Occupancy
	 */
	public int getOcc2017(int i) {
		return this.occupancy2017[i];
	}
	
	/**
	 * Gets the 2018 capacity on a certain date
	 * @param i Date index
	 * @return Capacity
	 */
	public int getCap2018(int i) {
		return this.capacity2018[i];
	}
	
	/**
	 * Gets the 2017 capacity on a certain date
	 * @param i Date index
	 * @return Capacity
	 */
	public int getCap2017(int i) {
		return this.capacity2017[i];
	}
	
	/**
	 * Returns true if the shelter is a possible match for the user based on shelter type
	 * @param user The user
	 * @return
	 */
	public boolean isValidType(UserT user) {	
		if (user.isFamily()) return (type == shelterResT.FAMILY);
		if (user.isYouth())  return (type == shelterResT.YOUTH);
		
		if      (user.isFlexible() && type == shelterResT.COED  ) return true;
		else if (user.isMale()     && type == shelterResT.MALE  ) return true;
		else if (user.isFemale()   && type == shelterResT.FEMALE) return true;
		else                                                      return false;
		
	}
	
	/**
	 * Checks to see whether the shelter has a capacity greater than zero on a certain date
	 * @param date Date index
	 * @return Boolean
	 */
	public boolean isValidCap(int date) {
		return !(this.getCap2018(date) == 0 | this.getCap2017(date) == 0);
	}
	
	/**
	 * Checks to see whether the shelter was full historically
	 * @param date Date index
	 * @return Boolean
	 */
	public boolean isFull(int date) {
		return (this.getOcc2018(date) == this.getCap2018(date) && this.getOcc2017(date) == this.getCap2017(date));
	}
	
	/**
	 * Converts the shelter info to a string
	 * @return String of shelter info
	 */
	@Override
	public String toString() {
		return this.getName() + ", " + this.getProgName() + " | " + this.getAddress();
	}

}
