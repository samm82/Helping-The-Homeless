package adt;

public class CoolingCentreT extends LocationT {
	
	private enum CentreT { // might not end up using
		LIBRARY,
		COMM_CNTR
	}
	
	private CentreT type;
	
	public CoolingCentreT(CentreT type, String name, String address) {
		super(name, address);
		this.type = type;
	}
	
	public CentreT getType() {
		return this.type;
	}

}
