package adt;

public class LocationT {
	
	private String name, address;
	private float score;
	
	public LocationT(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public float getScore() {
		return this.score;
	}
	
	public void setScore(float nScore) {
		this.score = nScore;
	}
	
}
