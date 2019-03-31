package control;

import java.util.ArrayList;

import algsstructs.*;
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
		/*
		ArrayList<ShelterT> male   = new ArrayList<>();
		ArrayList<ShelterT> female = new ArrayList<>();
		ArrayList<ShelterT> coed   = new ArrayList<>();
		ArrayList<ShelterT> family = new ArrayList<>();
		ArrayList<ShelterT> youth  = new ArrayList<>();
		
		ShelterT alpha   = new ShelterT(shelterResT.MALE,   "Alpha Inc.",   "Program", "Alpha Shelter",   "123 Test Avenue");
		ShelterT beta    = new ShelterT(shelterResT.FEMALE, "Beta Inc.",    "Program", "Beta Shelter",    "234 Fake Street");
		ShelterT gamma   = new ShelterT(shelterResT.MALE,   "Gamma Inc.",   "Program", "Gamma Shelter",   "123 Test Cresent");
		ShelterT delta   = new ShelterT(shelterResT.YOUTH,  "Delta Inc.",   "Program", "Delta Shelter",   "420 Blaze Drive");
		ShelterT epsilon = new ShelterT(shelterResT.COED,   "Epsilon Inc.", "Program", "Epsilon Shelter", "314 Nerd Street");
		ShelterT zeta    = new ShelterT(shelterResT.FAMILY, "Zeta Inc.",    "Program", "Zeta Shelter",    "270 Time Street");
		ShelterT eta     = new ShelterT(shelterResT.YOUTH,  "Eta Inc.",     "Program", "Eta Shelter",     "357 Hassan Street");
		ShelterT theta   = new ShelterT(shelterResT.MALE,   "Theta Inc.",   "Program", "Theta Shelter",   "314 Jason Street");
		
		alpha.setScore(0.24);
		beta.setScore(0.49);
		gamma.setScore(0.39);
		delta.setScore(0.61);
		epsilon.setScore(0.72);
		zeta.setScore(0.70);
		eta.setScore(0.01);
		theta.setScore(0.81);
		
		male.add(alpha);
		female.add(beta);
		male.add(gamma);
		youth.add(delta);
		coed.add(epsilon);
		family.add(zeta);
		youth.add(eta);
		male.add(theta);
		
		ShelterT[] maleArray   = male.toArray(new ShelterT[male.size()]);
		ShelterT[] femaleArray = female.toArray(new ShelterT[female.size()]);
		ShelterT[] coedArray   = coed.toArray(new ShelterT[coed.size()]);
		ShelterT[] familyArray = family.toArray(new ShelterT[family.size()]);
		ShelterT[] youthArray  = youth.toArray(new ShelterT[youth.size()]);
		
		ShelterT[][] masterArray = { maleArray, femaleArray, coedArray, familyArray, youthArray };
		*/
		
		System.out.println("Start");
		ShelterT[][] masterArray = Read.readShelterData();
		System.out.println("Done");
		System.out.println(masterArray[1][7].getAddress());
		
		//System.out.println(Weight.calcScore(masterArray[0][4], new UserT(UserResT.MALE_ONLY, 43.239487, -73.109472)));
		
		MaxPQ<ShelterT> pq = new MaxPQ<ShelterT>(masterArray[1]);
		
		
		// Prints all program names, scores, and total number of shelters
//		int counter = 0;
//		
		for (int i = 0; i < masterArray.length; i++) {
			for (int j = 0; j < masterArray[i].length; j++) {
				System.out.println(i + " " + j + " "  + masterArray[i][j].getProgName());
				System.out.println("   " + Weight.calcScore(masterArray[i][j], new UserT(UserResT.MALE_ONLY, 43.239487, -73.109472)));
//				counter ++;
			}
		}
//		
//		System.out.println(counter);
		
		CoolingCentreT[] cool = Read.readCoolingData();
		
	}

}
