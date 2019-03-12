package adt;

public class UserT {
	
	public enum GenderT {
		MALE,
		FEMALE
	}
	
	private GenderT gender;
	private boolean flexible; // OK with being with other gender
	private boolean family;   // If a family
	private boolean youth;    // If a youth
	
	public GenderT getGender()  { return gender;   }
	public boolean isFlexible() { return flexible; }
	public boolean isFamily()   { return family;   }
	public boolean isYouth()    { return youth;    }
	
}
