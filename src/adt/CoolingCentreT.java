package adt;

/**
 * ADT for a cooling centre.
 * 
 * @author Sam and Nicholas
 *
 */
public class CoolingCentreT extends LocationT {

	/**
	 * Constructor for new CoolingCentreT.
	 * 
	 * @param name    Name of center.
	 * @param address Address of center.
	 * @param lat     Latitude of center.
	 * @param lon     Longitude of center.
	 */
	public CoolingCentreT(String name, String address, double lat, double lon) {
		super(name, address, locTypeT.COOL_CNTR, lat, lon);
	}

	/**
	 * Converts the cooling center info to a string.
	 * 
	 * @return String of cooling center info.
	 */
	@Override
	public String toString() {
		return this.getName() + " | " + this.getAddress();
	}

}
