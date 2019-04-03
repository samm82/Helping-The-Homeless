package control;

import adt.AddressT;
import adt.CoolingCentreT;
import adt.ShelterT;
import adt.UserInputT;
import adt.UserT;

import algsstructs.*;
import io.MainWindow;
import io.Read;
import process.Weight;

// Control module which will control all of our functionality
public class Master {
	
	private static UserInputT info;
	private static UserT user;
	
	private static TST<AddressT> addresses;
	
	public static void main(String args[]) {	
		// creates a 2d array of all shelters
		ShelterT[][] masterArray = Read.readShelterData();
		// opens GUI
		try {
		MainWindow window = new MainWindow();
		info = window.open();
//		System.out.println(info);
		
		addresses = Read.readAddressData();
		
		String add = info.getAdd();
		user = new UserT(info.getType(), addresses.get(add).getLat(), addresses.get(add).getLon());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Shelters:");
		System.out.println();
		
		AddressT add;
		for (int i = 0; i < masterArray.length; i++) {
			int count = 0;
			for (ShelterT shel : masterArray[i]) {
				System.out.println(shel.getAddress());
				add = addresses.get(shel.getAddress());
				System.out.println(add);
				shel.setLat(add.getLat());
				shel.setLon(add.getLon());
				
				// sets score for each shelter
				shel.setScore(Weight.calcScore(shel, user));

				System.out.println(i + " " + count++ + " "  + shel);
				System.out.println("   " + shel.getScore());

			}
		}
		
		// creates a MaxPQ from each list of shelters by type
		MaxPQ<ShelterT> pq0 = new MaxPQ<ShelterT>(masterArray[0]);
		MaxPQ<ShelterT> pq1 = new MaxPQ<ShelterT>(masterArray[1]);
		MaxPQ<ShelterT> pq2 = new MaxPQ<ShelterT>(masterArray[2]);
		MaxPQ<ShelterT> pq3 = new MaxPQ<ShelterT>(masterArray[3]);
		MaxPQ<ShelterT> pq4 = new MaxPQ<ShelterT>(masterArray[4]);
		
		// creates a 1d array of all cooling centres
		CoolingCentreT[] cool = Read.readCoolingData();
		
		System.out.println();
		System.out.println("Cooling Centres:");
		System.out.println();
		
		for (int i = 0; i < cool.length; i++) {
			// sets score for each cooling centre
			cool[i].setScore(Weight.calcScore(cool[i], user));
			

//			System.out.println(i + " " + cool[i]);
//			System.out.println("   " + cool[i].getScore());
		}
		
		MaxPQ<CoolingCentreT> coolPQ = new MaxPQ<CoolingCentreT>(cool);
		
		System.out.println(pq0.delMax().getName());
		System.out.println(pq2.delMax().getName());
	}
}
