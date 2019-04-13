package adt;

/**
 * ADT for a user.
 * 
 * @author Sam and Nicholas
 *
 */
public class UserT {

	/**
	 * Enumerated type that represents the type of user.
	 * 
	 */
	public enum UserResT {
		MALE_ONLY, MALE_COED, FEMALE_ONLY, FEMALE_COED, FAMILY, YOUTH
	}

	private UserResT resType;
	private double lat, lon;

	/**
	 * Constructor for new UserT (for use with shelter).
	 * 
	 * @param type The user type.
	 * @param lat  The user latitude.
	 * @param lon  The user longitude.
	 */
	public UserT(UserResT type, double lat, double lon) {
		this.resType = type;
		this.lat = lat;
		this.lon = lon;
	}
	
	/**
	 * Constructor for new UserT (for use with cooling centre).
	 * 
	 * @param lat  The user latitude.
	 * @param lon  The user longitude.
	 */
	public UserT(double lat, double lon) {
		this.lat = lat;
		this.lon = lon;
	}

	/**
	 * 
	 * @return The type of user.
	 */
	public UserResT getResType() {
		return resType;
	}

	/**
	 * 
	 * @return The latitude of the user.
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * 
	 * @return The longitude of the user.
	 */
	public double getLon() {
		return lon;
	}
}
