package io;

import java.util.ArrayList;
import adt.ShelterT;

public class Read {

	public ShelterT[][] readShelterData() {
		ArrayList<ShelterT> maleArray = new ArrayList<ShelterT>();
		ArrayList<ShelterT> femaleArray = new ArrayList<ShelterT>();
		ArrayList<ShelterT> coedArray = new ArrayList<ShelterT>();
		ArrayList<ShelterT> familyArray = new ArrayList<ShelterT>();
		ArrayList<ShelterT> youthArray = new ArrayList<ShelterT>();
		ShelterT[] var = new ShelterT[1];
		
		maleArray.add(new ShelterT( ShelterT.shelterResT.MALE, "Test", "123 Fun Street"));
		
		
		ShelterT[][] temp = new ShelterT[5][100];
		return temp;
	}
	
	
	
	
}
