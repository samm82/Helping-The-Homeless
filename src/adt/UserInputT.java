package adt;

import adt.UserT.UserResT;

public class UserInputT {
	
	private UserResT type;
	private String   add;
	
	public 	UserInputT(UserResT type, String add) {
		this.type = type;
		this.add  = add;
	}
	
	public UserResT getType() { return this.type; }
	public String   getAdd()  { return this.add;  }

}
