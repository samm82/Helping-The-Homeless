package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import adt.CoolingCentreT;
import adt.CoolingCentreT.CentreT;
import adt.ShelterT;
import adt.ShelterT.shelterResT;

public class Read {
	
	public static ShelterT[][] readShelterData() {
		ArrayList<ShelterT> maleArray = new ArrayList<ShelterT>();
		ArrayList<ShelterT> femaleArray = new ArrayList<ShelterT>();
		ArrayList<ShelterT> coedArray = new ArrayList<ShelterT>();
		ArrayList<ShelterT> familyArray = new ArrayList<ShelterT>();
		ArrayList<ShelterT> youthArray = new ArrayList<ShelterT>();
		
		//reads 2018 data
		try {
			Scanner lineScanner = new Scanner(new File("data/SMIS_Daily_Occupancy_2018.csv"));

			lineScanner.nextLine();
	    	while(lineScanner.hasNextLine()) {
			//for (int i = 0; i < 1; i++) {
	    	    String line = lineScanner.nextLine();
	    	    //System.out.println(line);
	    	    
	    	    //Data set has commas in some of it's values but there are some empty cells represented by a space
	    	    //So to be safe we replace ", ," (An ampty cell) with random symbols so when we remove the extra commas
	    	    //the extra cell is not deleted (if the empty cell was deleted there would be index errors)
	    	    line = line.replaceAll(", ", " ");
//	    	    System.out.println(line);
	    	    String[] data = line.split(",");
//	    	    for (int i = 0; i < data.length; i++) {
//					System.out.print(data[i] + " | ");
//				}
//	    	    System.out.println();
	    	    
	    	    String  orgName = data[1], shelterName = data[2], address = data[3], facilityName = data[7], progName = data[8],  type = data[9];
	    	    int occ = Integer.parseInt(data[10]), cap = Integer.parseInt(data[11]);
	    	    String[] vals = {orgName, shelterName, facilityName, progName, address};
	    	    
	    	    switch (type) {
				case "Men":
		    	    addToList(maleArray, vals, shelterResT.MALE, occ, cap, 2018);
					break;
				case "Women":
		    	    addToList(femaleArray, vals, shelterResT.FEMALE, occ, cap, 2018);
					break;
				case "Co-ed":
		    	    addToList(coedArray, vals, shelterResT.COED, occ, cap, 2018);
					break;
				case "Families":
		    	    addToList(familyArray, vals, shelterResT.FAMILY, occ, cap, 2018);
					break;
				case "Youth":
		    	    addToList(youthArray, vals, shelterResT.YOUTH, occ, cap, 2018);
					break;
	    	    }
	    	}
	    	lineScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//reads 2017 data
		try {
			Scanner lineScanner = new Scanner(new File("data/SMIS_Daily_Occupancy_2017.csv"));

			lineScanner.nextLine();
	    	while(lineScanner.hasNextLine()) {
			//for (int i = 0; i < 1; i++) {
	    	    String line = lineScanner.nextLine();
	    	    
	    	    //Data set has commas in some of it's values but there are some empty cells which result in a ",," in the line
	    	    //So to be safe we replace ", " with a space so when we remove the extra commas
	    	    //the extra cell is not deleted (if the empty cell was deleted there would be index errors)
	    	    line = line.replaceAll(", ", " ");
	    	    String[] data = line.split(",");
//	    	    for (int i = 0; i < data.length; i++) {
//					System.out.print(data[i] + " | ");
//				}
//	    	    System.out.println();
//	    	    System.out.println(line);
	    	    String  orgName = data[1], shelterName = data[2], address = data[3], facilityName = data[7], progName = data[8],  type = data[9];
	    	    int occ = Integer.parseInt(data[10]), cap = Integer.parseInt(data[11]);
	    	    String[] vals = {orgName, shelterName, facilityName, progName, address};
	    	    
	    	    switch (type) {
				case "Men":
		    	    addToList(maleArray, vals, shelterResT.MALE, occ, cap, 2017);
					break;
				case "Women":
		    	    addToList(femaleArray, vals, shelterResT.FEMALE, occ, cap, 2017);
					break;
				case "Co-ed":
		    	    addToList(coedArray, vals, shelterResT.COED, occ, cap, 2017);
					break;
				case "Families":
		    	    addToList(familyArray, vals, shelterResT.FAMILY, occ, cap, 2017);
					break;
				case "Youth":
		    	    addToList(youthArray, vals, shelterResT.YOUTH, occ, cap, 2017);
					break;
	    	    }
	    	}
	    	lineScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		ShelterT[][] sheltersList = new ShelterT[5][];
		
		sheltersList[0] = new ShelterT[maleArray.size()];
		sheltersList[0] = maleArray.toArray(sheltersList[0]);
		
		sheltersList[1] = new ShelterT[femaleArray.size()];
		sheltersList[1] = femaleArray.toArray(sheltersList[1]);
		
		sheltersList[2] = new ShelterT[coedArray.size()];
		sheltersList[2] = coedArray.toArray(sheltersList[2]);
		
		sheltersList[3] = new ShelterT[familyArray.size()];
		sheltersList[3] = maleArray.toArray(sheltersList[3]);
		
		sheltersList[4] = new ShelterT[youthArray.size()];
		sheltersList[4] = youthArray.toArray(sheltersList[4]);
		
		return sheltersList;
	}

	private static void addToList(ArrayList<ShelterT> arr, String[] vals, shelterResT type, int occ, int cap, int year) {
		
		for(ShelterT i : arr) {
			if(contains(i,vals)) {
				i.setCapOcc(occ, cap, year);
				return;
			}
		}
		
		//public ShelterT(shelterResT type, String orgName, String shelterName, String facilityName, String progName,  String address)
		arr.add(new ShelterT(type, vals[0], vals[1], vals[2], vals[3], vals[4]));
		arr.get(arr.size()-1).setCapOcc(occ, cap, year);
	}
	
	private static boolean contains(ShelterT shelter, String[] vals) {
		//String[] vals = {orgName, shelterName, facilityName, progName, address};
		return shelter.getOrgName().equals(vals[0]) && shelter.getName().equals(vals[1]) && shelter.getFacilityName().equals(vals[2]) 
				&& shelter.getProgName().equals(vals[3]) && shelter.getAddress().equals(vals[4]);
	}
	
	
	public static CoolingCentreT[] readCoolingData() {
		
		ArrayList<CoolingCentreT> coolingArray = new ArrayList<CoolingCentreT>();
		
		try {
			Scanner lineScanner = new Scanner(new File("data/cooling_center_locations.csv"));
			lineScanner.nextLine();
			
	    	while(lineScanner.hasNextLine()) {
			//for (int i = 0; i < 1; i++) {
	    	    String line = lineScanner.nextLine();
	    	    
	    	    line = line.replaceAll("\"", "");
	    	    line = line.replaceAll(", ", " ");
	    	    
	    	    
	    	    System.out.println(line);
	    	    String[] data = line.split(",");
	    	    String type = data[2];
	    	    String name = data[4] + " " + data[3];
	    	    String address = data[5];
	    	    double lat = Double.parseDouble(data[8]);
	    	    double lon = Double.parseDouble(data[9]);
	    	    
	    	    switch (type) {
				case "LIBRARY":
		    	    coolingArray.add(new CoolingCentreT(CentreT.LIBRARY, name, address, lat, lon));
					break;
				case "COMM_CNTR":
					coolingArray.add(new CoolingCentreT(CentreT.COMM_CNTR, name, address, lat, lon));
					break;
				}
	    	    
	    	}
	    	lineScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		CoolingCentreT[] coolList = new CoolingCentreT[coolingArray.size()];
		coolList = coolingArray.toArray(coolList);
		
		return coolList;
	}
}
