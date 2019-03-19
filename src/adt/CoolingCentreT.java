package adt;

public class CoolingCentreT extends LocationT {
	
	public enum CentreT { // might not end up using
		LIBRARY,
		COMM_CNTR
	}
	
	private CentreT type;
	
	public CoolingCentreT(CentreT type, String name, String address, double lat, double lon) {
		super(name, address, lat, lon);
		this.type = type;
	}
	
	public CentreT getType() {
		return this.type;
	}

}
