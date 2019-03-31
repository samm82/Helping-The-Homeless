package adt;

public class AddressT {
	
	private final String num;
	private final String st;
	private final double lat;
	private final double lon;
	
	public AddressT(String num, String st, double lat, double lon) {
		this.num = num;
		this.st  = st;
		this.lat = lat;
		this.lon = lon;
	}
	
	public String getNum()    { return num; }
	public String getSt()  { return st;  }
	public double getLat() { return lat; }
	public double getLon() { return lon; }
	

}
