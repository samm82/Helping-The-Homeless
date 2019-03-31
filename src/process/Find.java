package process;

import java.util.ArrayList;
import java.util.Iterator;

import adt.*;
import adt.ShelterT.shelterResT;
import algsstructs.*;

// Module to search for specific shelters
public class Find {

	// Takes in a PQ and a shelter type and returns an array of shelters that match
	public static ShelterT[] searchByType(MaxPQ pq, shelterResT type) {
		
		ArrayList<ShelterT> list_of_matching_shelters = new ArrayList<>();
		
		Iterator<ShelterT> all_shelters = pq.iterator();
		
		while (all_shelters.hasNext()) {
			
			ShelterT current_shelter = all_shelters.next();
			
			if (current_shelter.getType() == type) {
				list_of_matching_shelters.add(current_shelter);
			}
		}
		
		return list_of_matching_shelters.toArray(new ShelterT[list_of_matching_shelters.size()]);
		
	}
	
	// Takes in a PQ and an org name and returns an array of shelters that match
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
	
	// Takes in a PQ and a shelter name and returns an array of shelters that match
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
	
	// Takes in a PQ and a facility name and returns an array of shelters that match
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
	
	
	// Takes in a PQ and a program name and returns an array of shelters that match
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
