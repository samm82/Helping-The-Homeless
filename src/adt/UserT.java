package adt;

public class UserT {
	
	public enum UserResT {
		MALE_ONLY,
		MALE_COED,
		FEMALE_ONLY,
		FEMALE_COED,
		FAMILY,
		YOUTH
	}
	
	private UserResT resType;
	
	public UserResT getResType() { return resType; }
	
}
