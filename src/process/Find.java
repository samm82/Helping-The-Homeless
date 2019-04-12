package process;

import java.util.ArrayList;
import java.util.Iterator;

import adt.*;
import adt.ShelterT.shelterResT;
import algsstructs.*;

/**
 * Module to search for specific shelters
 * @author Joshua
 *
 */
public class Find {

	/**
	 * 
	 * @param pq MaxPQ of shelters of type ShelterT
	 * @param type Shelter type
	 * @return An array of shelters of type ShelterT from the MaxPQ that match the shelter type
	 */
	public static ShelterT[] searchByType(MaxPQ pq, shelterResT type) {
		
		// Array list chosen because the final size is not known
		ArrayList<ShelterT> list_of_matching_shelters = new ArrayList<>();
		
		// Creates an iterator from the MaxPQ
		Iterator<ShelterT> all_shelters = pq.iterator();
		
		// Iterates through the shelters in the PQ adding it to an array list if the type matches
		while (all_shelters.hasNext()) {
			
			ShelterT current_shelter = all_shelters.next();
			
			if (current_shelter.getType() == type) {
				list_of_matching_shelters.add(current_shelter);
			}
		}
		
		// Converts the array list to an array
		return list_of_matching_shelters.toArray(new ShelterT[list_of_matching_shelters.size()]);
		
	}
	
	/*
	 * Only the first function is commented because all the other functions operate almost identical
	 */
	
	/**
	 * 
	 * @param pq MaxPQ of shelters of type ShelterT
	 * @param name Organization name
	 * @return An array of shelters from the MaxPQ that match the organization name
	 */
	public static ShelterT[] searchByOrgName(MaxPQ pq, String name) {
		
		ArrayList<ShelterT> list_of_matching_shelters = new ArrayList<>();
		
		Iterator<ShelterT> all_shelters = pq.iterator();
		
		while (all_shelters.hasNext()) {
			
			ShelterT current_shelter = all_shelters.next();
			
			if (current_shelter.getOrgName().toLowerCase().equals(name.toLowerCase())) {
				list_of_matching_shelters.add(current_shelter);
			}
		}
		
		return list_of_matching_shelters.toArray(new ShelterT[list_of_matching_shelters.size()]);
		
	}
	
	/**
	 * 
	 * @param pq MaxPQ of shelters of type ShelterT
	 * @param name Shelter name
	 * @return An array of shelters from the MaxPQ that match the shelter name
	 */
	public static ShelterT[] searchByShelterName(MaxPQ pq, String name) {
		
		ArrayList<ShelterT> list_of_matching_shelters = new ArrayList<>();
		
		Iterator<ShelterT> all_shelters = pq.iterator();
		
		while (all_shelters.hasNext()) {
			
			ShelterT current_shelter = all_shelters.next();
			
			if (current_shelter.getName().toLowerCase().equals(name.toLowerCase())) {
				list_of_matching_shelters.add(current_shelter);
			}
		}
		
		return list_of_matching_shelters.toArray(new ShelterT[list_of_matching_shelters.size()]);
		
	}
	
	/**
	 * 
	 * @param pq MaxPQ of shelters of type ShelterT
	 * @param name Facility name
	 * @return An array of shelters from the MaxPQ that match the facility name
	 */
	public static ShelterT[] searchByFacilityName(MaxPQ pq, String name) {
		
		ArrayList<ShelterT> list_of_matching_shelters = new ArrayList<>();
		
		Iterator<ShelterT> all_shelters = pq.iterator();
		
		while (all_shelters.hasNext()) {
			
			ShelterT current_shelter = all_shelters.next();
			
			if (current_shelter.getFacilityName().toLowerCase().equals(name.toLowerCase())) {
				list_of_matching_shelters.add(current_shelter);
			}
		}

		return list_of_matching_shelters.toArray(new ShelterT[list_of_matching_shelters.size()]);
		
	}
	
	
	/**
	 * 
	 * @param pq MaxPQ of shelters of type ShelterT
	 * @param name Program name
	 * @return An array of shelters from the MaxPQ that match the program name
	 */
	public static ShelterT[] searchByProgramName(MaxPQ pq, String name) {
		
		ArrayList<ShelterT> list_of_matching_shelters = new ArrayList<>();
		
		Iterator<ShelterT> all_shelters = pq.iterator();
		
		while (all_shelters.hasNext()) {
			
			ShelterT current_shelter = all_shelters.next();
			
			if (current_shelter.getProgName().toLowerCase().equals(name.toLowerCase())) {
				list_of_matching_shelters.add(current_shelter);
			}
		}
		
		return list_of_matching_shelters.toArray(new ShelterT[list_of_matching_shelters.size()]);
		
	}
	
}
