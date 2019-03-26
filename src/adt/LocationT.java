package adt;

public class LocationT implements Comparable<LocationT>{
	
	public enum locTypeT {
		SHELTER, COMM_CNTR;
	}
	
	private String name, address;
	private locTypeT type;
	private double lat, lon, score;
	
	public LocationT(String name, String address) {
		this.name    = name;
		this.address = address;
	}
	
	public LocationT(String name, String address, locTypeT type) {
		this.name    = name;
		this.address = address;
		this.type    = type;
	}
	
	public LocationT(String name, String address, locTypeT type, double lat, double lon) {
		this.name    = name;
		this.address = address;
		this.type    = type;
		this.lat     = lat;
		this.lon     = lon;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public locTypeT getLocType() {
		return this.type;
	}
	
	public double getScore() {
		return this.score;
	}
	
	public double getLat() {
		return this.lat;
	}
	
	public double getLon() {
		return this.lon;
	}
	
	public void setScore(double nScore) {
		this.score = nScore;
	}
	
	public void setLon(double lon) {
		this.lon = lon;
	}
	
	public void setLat(double lat) {
		this.lat = lat;
	}
	
	
	@Override
    public int compareTo(LocationT that){
        if      (score < that.getScore()) return -1;
        else if (score > that.getScore()) return 1;
        else                              return 0;
    }
	
}
