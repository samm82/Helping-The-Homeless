package adt;

import adt.UserT.UserResT;

/**
 * ADT for user input
 * @author Sam
 *
 */
public class UserInputT {
	
	private UserResT type;
	private String add;
	
	/**
	 * Constructor for new UserInputT
	 * @param type Type of user
	 * @param add User address
	 */
	public 	UserInputT(UserResT type, String add) {
		this.type = type;
		this.add  = add;
	}
	
	/**
	 * 
	 * @return Type of user
	 */
	public UserResT getType() { return this.type; }
	
	/**
	 * 
	 * @return User address
	 */
	public String   getAdd()  { return this.add;  }

}
