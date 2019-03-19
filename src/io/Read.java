package io;

import java.io.FileReader;
import java.util.ArrayList;

import adt.ShelterT;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Read {
	
	public static ShelterT[][] readShelterData() {
		ArrayList<ShelterT> maleArray = new ArrayList<ShelterT>();
		ArrayList<ShelterT> femaleArray = new ArrayList<ShelterT>();
		ArrayList<ShelterT> coedArray = new ArrayList<ShelterT>();
		ArrayList<ShelterT> familyArray = new ArrayList<ShelterT>();
		ArrayList<ShelterT> youthArray = new ArrayList<ShelterT>();
		ShelterT[] var = new ShelterT[1];
		
		JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("data/SMIS_Daily_Occupancy_2018.json"));
            JSONArray jsonObject = (JSONArray) obj;
            JSONObject arr = (JSONObject) jsonObject.get(0);
            String arguments = (String) arr.get("SHELTER_NAME");
            System.out.println(arguments);

        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
		ShelterT[][] temp = new ShelterT[5][100];
		return temp;
	}
	
	public static void main(String[] args) {
		readShelterData();
	}
	
	
}
