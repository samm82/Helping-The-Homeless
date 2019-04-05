package control;

//import adt.AddressT;
//import adt.CoolingCentreT;
//import adt.ShelterT;
//import adt.UserInputT;
//import adt.UserT;
//
//import algsstructs.*;
import io.MainWindow;
//import io.Read;
//import process.Weight;

// Control module which will control all of our functionality
public class Master {
	
//	private static UserInputT info;
//	private static UserT user;
//	
//	private static TST<AddressT> addresses;
	
	public static void main(String args[]) {	
		// opens GUI
		try {
		MainWindow window = new MainWindow();
		window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
//	private static String printBestShel(MaxPQ<ShelterT> pq) { 
//		return pq.delMax().getName(); 
//		}
	
}
