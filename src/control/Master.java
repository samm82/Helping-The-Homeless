package control;

import java.util.ArrayList;

import algsstructs.*;
import adt.AddressT;
import adt.CoolingCentreT;
import adt.ShelterT;
import adt.UserT;
import adt.ShelterT.shelterResT;
import adt.UserT.UserResT;
import io.Read;
import process.Weight;

// Control module which will control all of our functionality
public class Master {
	
	public static void main(String args[]) {		
		System.out.println("Start");
		ShelterT[][] masterArray = Read.readShelterData();
		System.out.println("Done");
		//System.out.println(masterArray[1][7].getAddress());
		
		//System.out.println(Weight.calcScore(masterArray[0][4], new UserT(UserResT.MALE_ONLY, 43.239487, -73.109472)));
		
			
		
		// Prints all program names, scores, and total number of shelters
//		int counter = 0;
//		
		
		UserT user = new UserT(UserResT.MALE_ONLY, 43.239487, -73.109472);
		
		for (int i = 0; i < masterArray.length; i++) {
			for (int j = 0; j < masterArray[i].length; j++) {
				System.out.println(i + " " + j + " "  + masterArray[i][j].getProgName());
				System.out.println("   " + Weight.calcScore(masterArray[i][j], user));
				masterArray[i][j].setScore(Weight.calcScore(masterArray[i][j], user));
//				counter ++;
			}
		}
		
		MaxPQ<ShelterT> pq0 = new MaxPQ<ShelterT>(masterArray[0]);
		MaxPQ<ShelterT> pq1 = new MaxPQ<ShelterT>(masterArray[1]);
		MaxPQ<ShelterT> pq2 = new MaxPQ<ShelterT>(masterArray[2]);
		MaxPQ<ShelterT> pq3 = new MaxPQ<ShelterT>(masterArray[3]);
		MaxPQ<ShelterT> pq4 = new MaxPQ<ShelterT>(masterArray[4]);
//		
//		System.out.println(counter);
		
		CoolingCentreT[] cool = Read.readCoolingData();
		
		for (int i = 0; i < cool.length; i++) {
			cool[i].setScore(Weight.calcScore(cool[i], user));
		}
		
		MaxPQ<CoolingCentreT> coolPQ = new MaxPQ<CoolingCentreT>(cool);
		
		TST<AddressT> addresses = Read.readAddressData();
		
	}

}
