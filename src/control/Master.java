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
		window.open();

		
		addresses = Read.readAddressData();
		
		String add = info.getAdd();
		user = new UserT(info.getType(), addresses.get(add).getLat(), addresses.get(add).getLon());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		AddressT add;
		for (int i = 0; i < masterArray.length; i++) {
			for (ShelterT shel : masterArray[i]) {
				add = addresses.get(shel.getAddress());
				shel.setLat(add.getLat());
				shel.setLon(add.getLon());
				
				// sets score for each shelter
				shel.setScore(Weight.calcScore(shel, user));
			}
		}
		
		// creates a MaxPQ from each list of shelters by type
		MaxPQ<ShelterT> mlPQ = new MaxPQ<ShelterT>(masterArray[0]);
		MaxPQ<ShelterT> fePQ = new MaxPQ<ShelterT>(masterArray[1]);
		MaxPQ<ShelterT> cdPQ = new MaxPQ<ShelterT>(masterArray[2]);
		MaxPQ<ShelterT> faPQ = new MaxPQ<ShelterT>(masterArray[3]);
		MaxPQ<ShelterT> yoPQ = new MaxPQ<ShelterT>(masterArray[4]);
		
		// creates a 1d array of all cooling centres
		CoolingCentreT[] cool = Read.readCoolingData();
		
		for (int i = 0; i < cool.length; i++) {
			// sets score for each cooling centre
			cool[i].setScore(Weight.calcScore(cool[i], user));
		}
		
		MaxPQ<CoolingCentreT> coolPQ = new MaxPQ<CoolingCentreT>(cool);
		
		System.out.print("The best shelter is: ");
		
		switch (user.getResType()) {		
		case MALE_ONLY:
			System.out.println(printBestShel(mlPQ));
			break;
		case MALE_COED:
			System.out.println(printBestShel(mlPQ, cdPQ));
			break;
		case FEMALE_ONLY:
			System.out.println(printBestShel(fePQ));
			break;
		case FEMALE_COED:
			System.out.println(printBestShel(fePQ, cdPQ));
			break;
		case FAMILY:
			System.out.println(printBestShel(faPQ));
			break;
		case YOUTH:
			System.out.println(printBestShel(yoPQ));
			break;
		}
		
		
		
		
		System.out.print("The best cooling centre is: ");
		System.out.println(coolPQ.delMax().getName());
		
	}
	
	private static String printBestShel(MaxPQ<ShelterT> pq) { 
		return pq.delMax().getName(); 
		}
	
	private static String printBestShel(MaxPQ<ShelterT> pq1, MaxPQ<ShelterT> pq2) {
		if (pq1.max().getScore() > pq2.max().getScore()) return pq1.delMax().getName(); 
		else                                             return pq2.delMax().getName(); 
	}
}
