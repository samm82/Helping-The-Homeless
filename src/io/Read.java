package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import adt.ShelterT;

public class Read {
	
	public static ShelterT[][] readShelterData() {
		ArrayList<ShelterT> maleArray = new ArrayList<ShelterT>();
		ArrayList<ShelterT> femaleArray = new ArrayList<ShelterT>();
		ArrayList<ShelterT> coedArray = new ArrayList<ShelterT>();
		ArrayList<ShelterT> familyArray = new ArrayList<ShelterT>();
		ArrayList<ShelterT> youthArray = new ArrayList<ShelterT>();
		
        Scanner scanner;
		try {
			Scanner lineScanner = new Scanner(new File("data/SMIS_Daily_Occupancy_2018.csv"));

	    	for(int i = 0; i < 12; i++) {
	    	    String line = lineScanner.nextLine();
	    	    String[] data = line.split(",");
	    	}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ShelterT[][] temp = new ShelterT[5][100];
		return temp;
	}
	
	public static void main(String[] args) {
		readShelterData();
	}
	
	
}
