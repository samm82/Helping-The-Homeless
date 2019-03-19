package adt;

public class LocationT implements Comparable<LocationT>{
	
	private String name, address;
	private double lat, lon, score;
	
	public LocationT(String name, String address) {
		this.name    = name;
		this.address = address;
	}
	
	public LocationT(String name, String address, double lat, double lon) {
		this.name    = name;
		this.address = address;
		this.lat     = lat;
		this.lon     = lon;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public double getScore() {
		return this.score;
	}
	
	public double getLatitude() {
		return this.lat;
	}
	
	public double getLongtitude() {
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
