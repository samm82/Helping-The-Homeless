package adt;

/**
 * ADT for a City of Toronto municipal addresses
 * 
 * @author Sam and Nicholas
 *
 */
public class AddressT {

	private final String num;
	private final String st;
	private final double lat;
	private final double lon;

	/**
	 * Constructor for new AddressT
	 * 
	 * @param num Street number
	 * @param st  Street name
	 * @param lat Latitude
	 * @param lon Longitude
	 */
	public AddressT(String num, String st, double lat, double lon) {
		this.num = num;
		this.st = st;
		this.lat = lat;
		this.lon = lon;
	}

	/**
	 * 
	 * @return Street number
	 */
	public String getNum() {
		return num;
	}

	/**
	 * 
	 * @return Street name
	 */
	public String getSt() {
		return st;
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
