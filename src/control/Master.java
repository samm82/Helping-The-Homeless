package control;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import adt.AddressT;
import adt.CoolingCentreT;
import adt.ShelterT;
import adt.UserInputT;
import adt.UserT;
import algsstructs.MaxPQ;
import algsstructs.TST;
import io.MainWindow;
import io.Read;
import process.Weight;

// Control module which will control all of our functionality
public class Master {
	
	private static UserInputT info;
	private static UserT user;
	
	public static void main(String args[]) {	
		// creates a 2d array of all shelters
		ShelterT[][] masterArray = Read.readShelterData();
		
		Master main = new Master();
		main.loadJar(args);
		
		// opens GUI
		try {
		MainWindow window = new MainWindow();
		info = window.open();
		System.out.println(info);
		
		TST<AddressT> addresses = Read.readAddressData();
		
		String add = info.getAdd();
		user = new UserT(info.getType(), addresses.get(add).getLat(), addresses.get(add).getLon());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Shelters:");
		System.out.println();
		
		for (int i = 0; i < masterArray.length; i++) {
			for (int j = 0; j < masterArray[i].length; j++) {
				// sets score for each shelter
				masterArray[i][j].setScore(Weight.calcScore(masterArray[i][j], user));

				System.out.println(i + " " + j + " "  + masterArray[i][j]);
//				System.out.println("   " + masterArray[i][j].getScore());

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
			

			System.out.println(i + " " + cool[i]);
//			System.out.println("   " + cool[i].getScore());
		}
		
		MaxPQ<CoolingCentreT> coolPQ = new MaxPQ<CoolingCentreT>(cool);
		
		System.out.println(pq0.delMax().getName());
		System.out.println(pq2.delMax().getName());
	}
	
	private void loadJar(String[] args) {
		try {
            Class.forName("org.eclipse.swt.widgets.Shell");
            // Already on classpath
            return;
        } catch (ClassNotFoundException e) {
            // Add the JAR
        }
		
		String osName = System.getProperty("os.name");
		osName = osName.toLowerCase();
		File swtVersion;
		
		if(osName.contains("win")) {
			swtVersion = new File("lib/swt_win.jar");
		}
		else if(osName.contains("nix")) {
			swtVersion = new File("lib/swt_linux.jar");
		}
		else {
			throw new RuntimeException("Unknown OS");
		}
		
		try {
			
			URLClassLoader classLoader = (URLClassLoader) getClass().getClassLoader();
            Method addUrlMethod = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
            addUrlMethod.setAccessible (true);

            URL swtFileUrl = swtVersion.toURI ().toURL ();
            addUrlMethod.invoke (classLoader, swtFileUrl);
            
   		 	URLClassLoader cl = (URLClassLoader) getClass().getClassLoader(); //NOPMD
	        Class<?> c = cl.loadClass ("de.pdark.epen.editor.EPenEditor");
	        Class<?> shellClass = cl.loadClass ("org.eclipse.swt.widgets.Shell");

	        Constructor<?> ctor = c.getConstructor (shellClass);
	        Object obj = ctor.newInstance (new Object[] { null });
	        Method run = c.getMethod ("run", args.getClass ()); //$NON-NLS-1$
	        run.invoke (obj, new Object[] { args });
			
		} catch (Exception e) {
		}
		

		
	}
	
}
