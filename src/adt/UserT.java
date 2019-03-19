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
	
	public UserT(UserResT type) {
		this.resType = type;
	}
	
	//public UserResT getResType() { return resType; }
	
	public boolean isFamily() { return (resType == UserResT.FAMILY); }
	
	public boolean isYouth() { return (resType == UserResT.YOUTH); }
	
	public boolean isFlexible() { return ((resType == UserResT.MALE_COED) || 
										  (resType == UserResT.FEMALE_COED)); }
	
	public boolean isMale() { return ((resType == UserResT.MALE_COED) || 
			  						  (resType == UserResT.MALE_ONLY)); }
	
	public boolean isFemale() { return ((resType == UserResT.FEMALE_COED) || 
			  							(resType == UserResT.FEMALE_ONLY)); }
}
