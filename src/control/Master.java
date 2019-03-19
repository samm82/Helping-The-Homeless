package control;

import java.util.ArrayList;

import algsstructs.*;

import adt.ShelterT;
import adt.ShelterT.shelterResT;

// Control module which will control all of our functionality
public class Master {
	
	public static void main(String args[]) {
		ArrayList<ShelterT> male   = new ArrayList<>();
		ArrayList<ShelterT> female = new ArrayList<>();
		ArrayList<ShelterT> coed   = new ArrayList<>();
		ArrayList<ShelterT> family = new ArrayList<>();
		ArrayList<ShelterT> youth  = new ArrayList<>();
		
		ShelterT alpha   = new ShelterT(shelterResT.MALE,   "Alpha Shelter",   "123 Test Avenue",   43.653224, -79.383236);
		ShelterT beta    = new ShelterT(shelterResT.FEMALE, "Beta Shelter",    "234 Fake Street",   43.846996, -79.179432);
		ShelterT gamma   = new ShelterT(shelterResT.MALE,   "Gamma Shelter",   "123 Test Cresent",  43.747874, -79.633992);
		ShelterT delta   = new ShelterT(shelterResT.YOUTH,  "Delta Shelter",   "420 Blaze Drive",   43.235242, -79.982736);
		ShelterT epsilon = new ShelterT(shelterResT.COED,   "Epsilon Shelter", "314 Nerd Street",   43.874298, -79.379202);
		ShelterT zeta    = new ShelterT(shelterResT.FAMILY, "Zeta Shelter",    "270 Time Street",   43.723905, -79.298421);
		ShelterT eta     = new ShelterT(shelterResT.YOUTH,  "Eta Shelter",     "357 Hassan Street", 43.357357, -79.357357);
		ShelterT theta   = new ShelterT(shelterResT.MALE,   "Theta Shelter",   "314 Jason Street",  43.123479, -79.239472);
		
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
		
	}

}
