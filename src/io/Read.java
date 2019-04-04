package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import adt.AddressT;
import adt.CoolingCentreT;
import adt.CoolingCentreT.CentreT;
import adt.ShelterT;
import adt.ShelterT.shelterResT;
import algsstructs.TST;

public class Read {
	
	/*
	 * A Method that reads data from an input file and returns a list of shelters that s organized into one of 5 requirement categories (Male, female, coed, family, youth).
	 * @return returns a 2D array of type ShelterT, represents all the shelters being used as recommendations.
	 */
	public static ShelterT[][] readShelterData() {
		ArrayList<ShelterT> maleArray   = new ArrayList<ShelterT>();
		ArrayList<ShelterT> femaleArray = new ArrayList<ShelterT>();
		ArrayList<ShelterT> coedArray   = new ArrayList<ShelterT>();
		ArrayList<ShelterT> familyArray = new ArrayList<ShelterT>();
		ArrayList<ShelterT> youthArray  = new ArrayList<ShelterT>();
		
		for (int i = 2018; i > 2016; i--) {
		
			String file = "data/SMIS_Daily_Occupancy_" + i + ".csv";
			
			//reads 2018 data
			try {
				Scanner lineScanner = new Scanner(new File(file));

				lineScanner.nextLine();
				while(lineScanner.hasNextLine()) {
					//for (int i = 0; i < 1; i++) {
					String line = lineScanner.nextLine();
					//System.out.println(line);
	    	    
					//Data set has commas in some of it's values but there are some empty cells represented by an empty string (,, in the csv)
					//the extra cell should not be deleted so we replace ", " a comma that would be found in a cell vaule to prevent
					//errors when splitting the string.
					line = line.replaceAll(", ", " ");
//	    	    	System.out.println(line);
					String[] data = line.split(",");
//	    	    	for (int i = 0; i < data.length; i++) {
//						System.out.print(data[i] + " | ");
//					}
//	    	    	System.out.println();
	    	    
					String  orgName = data[1], shelterName = data[2], address = data[3], facilityName = data[7], progName = data[8],  type = data[9];
					
					address = address.replace("Avenue", "Ave").replace("Ave Toronto", "Ave").replace("Ave.", "Ave");
					address = address.replace("Court", "Crt").replace("Crt Toronto", "Crt").replace("Crt.", "Crt");
					address = address.replace("Drive", "Dr").replace("Dr Toronto", "Dr").replace("Dr.", "Dr");
					address = address.replace("Place", "Pl").replace("Pl Toronto", "Pl").replace("Pl.", "Pl");
					address = address.replace("Road", "Rd").replace("Rd Toronto", "Rd").replace("Rd.", "Rd");
					address = address.replace("Street", "St").replace("St Toronto", "St").replace("St.", "St");
					address = address.replace("East", "E").replace("West", "W").replace("North", "N").replace("South", "S");
					address = address.replace("E.", "E").replace("W.", "W").replace("N.", "N").replace("S.", "S");
					address = address.replace("Bathrust", "Bathurst");
					address = address.replace("265 Queens Dr", "101 Ontario St").replace("72 Kennedy Rd", "90 Shuter St"); // wrong addresses in shelter data set
					
					int occ = Integer.parseInt(data[10]), cap = Integer.parseInt(data[11]);
					String[] vals = {orgName, shelterName, facilityName, progName, address};
	    	    
					switch (type) {
					case "Men":
						addToList(maleArray, vals, shelterResT.MALE, occ, cap, i);
						break;
					case "Women":
						addToList(femaleArray, vals, shelterResT.FEMALE, occ, cap, i);
						break;
					case "Co-ed":
						addToList(coedArray, vals, shelterResT.COED, occ, cap, i);
						break;
					case "Families":
						addToList(familyArray, vals, shelterResT.FAMILY, occ, cap, i);
						break;
					case "Youth":
						addToList(youthArray, vals, shelterResT.YOUTH, occ, cap, i);
						break;
					}
				}
				lineScanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		ShelterT[][] sheltersList = new ShelterT[5][];
		
		sheltersList[0] = new ShelterT[maleArray.size()];
		sheltersList[0] = maleArray.toArray(sheltersList[0]);
		
		sheltersList[1] = new ShelterT[femaleArray.size()];
		sheltersList[1] = femaleArray.toArray(sheltersList[1]);
		
		sheltersList[2] = new ShelterT[coedArray.size()];
		sheltersList[2] = coedArray.toArray(sheltersList[2]);
		
		sheltersList[3] = new ShelterT[familyArray.size()];
		sheltersList[3] = familyArray.toArray(sheltersList[3]);
		
		sheltersList[4] = new ShelterT[youthArray.size()];
		sheltersList[4] = youthArray.toArray(sheltersList[4]);
		
		return sheltersList;
	}

	/*
	 * A method used to add data to the list of shelters specified by arr
	 * @param arr The arraylist of type ShelterT that the occupancy data for that shelter is being added to
	 * @param vals the list of string values used to create an instance of ADT ShelterT
	 * @param type the enumerated type that represents what type of shelter it is (male, female, coed, family, youth)
	 * @param occ the integer value representing the occupancy data of the shelter
	 * @param cap the integer value representing the capacity data of the shelter
	 * @param year the year the data is from
	 */
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
	
	/*
	 * checks if the values in the parameters represent the same shelter
	 * @param sheter a variable of type ShelterT that represents a shelter
	 * @param vals a list of string values to check against a shelter
	 * @return returns a boolean if the shelter and the values represent the same shelter
	 */
	private static boolean contains(ShelterT shelter, String[] vals) {
		//String[] vals = {orgName, shelterName, facilityName, progName, address};
		return shelter.getOrgName().equals(vals[0]) && shelter.getName().equals(vals[1]) && shelter.getFacilityName().equals(vals[2]) 
				&& shelter.getProgName().equals(vals[3]) && shelter.getAddress().equals(vals[4]);
	}
	
	/*
	 * A Method used to read a dataset of all the cooling centers in Toronto and create an array of CoolingCentreT
	 * @return returns an array of type CoolingCentreT
	 */
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
	    	    
	    	    
//	    	    System.out.println(line);
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
	
	/*
	 * Reads a dataset of all municipal address point in Toronto and returns a TST that has all the data points stored.
	 * @return returns a TST that stores all the address points in the dataset
	 */
	public static TST<AddressT> readAddressData() {
		
		TST<AddressT> addresses = new TST<AddressT>();
		
		try {
			Scanner lineScanner = new Scanner(new File("data/address_points.csv"));
			lineScanner.nextLine();
			
			while(lineScanner.hasNextLine()) {
			//for (int i = 0; i < 5; i++) {
				String line = lineScanner.nextLine();
	    	    line = line.replaceAll(", ", " ");
	    	    String data[] = line.split(",");
	    	    
	    	    String num = data[4];
	    	    String name = data[5];
	    	    double lon = Double.parseDouble(data[18]);
	    	    double lat = Double.parseDouble(data[19]);
	    	    
	    	    AddressT temp = new AddressT(num, name, lat, lon);
	    	    addresses.put(temp.getNum() + " " + temp.getSt(), temp);
			}

			lineScanner.close();
		} catch (Exception e) {
		}
		
		return addresses;
	
	}
	
}
