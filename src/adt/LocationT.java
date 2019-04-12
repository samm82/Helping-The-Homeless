package adt;

/**
 * ADT for a Location
 * 
 * @author Sam and Nicholas
 *
 */
public class LocationT implements Comparable<LocationT> {

	/**
	 * Enum for type of location
	 * 
	 * @author Sam
	 *
	 */
	public enum locTypeT {
		SHELTER, COMM_CNTR;
	}

	private String name, address;
	private locTypeT type;
	private double lat, lon, score;

	/**
	 * Constructor for new LocationT
	 * 
	 * @param name    Name of location
	 * @param address Address of location
	 */
	public LocationT(String name, String address) {
		this.name = name;
		this.address = address;
	}

	/**
	 * Constructor for new LocationT
	 * 
	 * @param name    Name of location
	 * @param address Address of location
	 * @param type    Type of location
	 */
	public LocationT(String name, String address, locTypeT type) {
		this.name = name;
		this.address = address;
		this.type = type;
	}

	/**
	 * Constructor for new LocationT
	 * 
	 * @param name    Name of location
	 * @param address Address of location
	 * @param type    Type of location
	 * @param lat     Latitude
	 * @param lon     Longitude
	 */
	public LocationT(String name, String address, locTypeT type, double lat, double lon) {
		this.name = name;
		this.address = address;
		this.type = type;
		this.lat = lat;
		this.lon = lon;
	}

	/**
	 * 
	 * @return Name of location
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @return Address of location
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * 
	 * @return Type of location
	 */
	public locTypeT getLocType() {
		return this.type;
	}

	/**
	 * 
	 * @return Score of location
	 */
	public double getScore() {
		return this.score;
	}

	/**
	 * 
	 * @return Latitude
	 */
	public double getLat() {
		return this.lat;
	}

	/**
	 * 
	 * @return Longitude
	 */
	public double getLon() {
		return this.lon;
	}

	/**
	 * Sets the score
	 * 
	 * @param nScore New score
	 */
	public void setScore(double nScore) {
		this.score = nScore;
	}

	/**
	 * Sets the longitude
	 * 
	 * @param lon Longitude
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}

	/**
	 * Sets the latitude
	 * 
	 * @param lat Latitude
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}

	/**
	 * Compares two locations by their score
	 * 
	 * @param LocationT
	 * @return Int after comparison
	 */
	@Override
	public int compareTo(LocationT that) {
		if (score < that.getScore())
			return -1;
		else if (score > that.getScore())
			return 1;
		else
			return 0;
	}

}
