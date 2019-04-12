package adt;

/**
 * ADT for a cooling centre
 * 
 * @author Sam and Nicholas
 *
 */
public class CoolingCentreT extends LocationT {

	/**
	 * Enum for type of cooling center
	 * 
	 * @author Sam
	 *
	 */
	public enum CentreT { // might not end up using
		LIBRARY, COMM_CNTR
	}

	private CentreT type;

	/**
	 * Constructor for new CoolingCentreT
	 * 
	 * @param type    Type of center
	 * @param name    Name of center
	 * @param address Address of center
	 * @param lat     Latitude
	 * @param lon     Longitude
	 */
	public CoolingCentreT(CentreT type, String name, String address, double lat, double lon) {
		super(name, address, locTypeT.COMM_CNTR, lat, lon);
		this.type = type;
	}

	/**
	 * 
	 * @return Cooling center type
	 */
	public CentreT getType() {
		return this.type;
	}

	/**
	 * Converts the cooling center info to a string
	 * 
	 * @return String of cooling center info
	 */
	@Override
	public String toString() {
		return this.getName() + " | " + this.getAddress();
	}

}
