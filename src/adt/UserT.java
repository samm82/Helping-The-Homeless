package adt;

/**
 * ADT for a user
 * 
 * @author Sam and Nicholas
 *
 */
public class UserT {

	/**
	 * Enum for user type
	 * 
	 * @author Sam
	 *
	 */
	public enum UserResT {
		MALE_ONLY, MALE_COED, FEMALE_ONLY, FEMALE_COED, FAMILY, YOUTH
	}

	private UserResT resType;
	private double lat, lon;

	/**
	 * Constructor for new UserT (for use with shelter)
	 * 
	 * @param type User type
	 * @param lat  User latitude
	 * @param lon  User longitude
	 */
	public UserT(UserResT type, double lat, double lon) {
		this.resType = type;
		this.lat = lat;
		this.lon = lon;
	}
	
	/**
	 * Constructor for new UserT (for use with cooling centre).
	 * 
	 * @param lat  User latitude
	 * @param lon  User longitude
	 */
	public UserT(double lat, double lon) {
		this.lat = lat;
		this.lon = lon;
	}

	/**
	 * 
	 * @return Type of user
	 */
	public UserResT getResType() {
		return resType;
	}

	/**
	 * 
	 * @return Boolean whether user is type family
	 */
	public boolean isFamily() {
		return (resType == UserResT.FAMILY);
	}

	/**
	 * 
	 * @return Boolean whether user is type youth
	 */
	public boolean isYouth() {
		return (resType == UserResT.YOUTH);
	}

	/**
	 * 
	 * @return Boolean whether user is open to co-ed shelters
	 */
	public boolean isFlexible() {
		return ((resType == UserResT.MALE_COED) || (resType == UserResT.FEMALE_COED));
	}

	/**
	 * Boolean whether user type is male
	 * 
	 * @return
	 */
	public boolean isMale() {
		return ((resType == UserResT.MALE_COED) || (resType == UserResT.MALE_ONLY));
	}

	/**
	 * 
	 * @return Boolean whether user type is female
	 */
	public boolean isFemale() {
		return ((resType == UserResT.FEMALE_COED) || (resType == UserResT.FEMALE_ONLY));
	}

	/**
	 * 
	 * @return Latitude
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * 
	 * @return Longitude
	 */
	public double getLon() {
		return lon;
	}
}
