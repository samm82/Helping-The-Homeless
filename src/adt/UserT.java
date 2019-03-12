package adt;

public class UserT {
	
	enum GenderT {
		MALE,
		FEMALE
	}
	
	private GenderT gender;
	private boolean flexible; // OK with being with other gender
	
	public GenderT getGender()      { return gender; }
	public boolean getFlexibility() { return flexible; }
	
}
