package control;

import io.MainWindow;

/**
 * Control module which will launch the application
 * @author Sam
 *
 */
public class Master {
	
	/**
	 * The main function that opens the GUI.
	 * @param args
	 */
	public static void main(String args[]) {	
		// opens GUI
		try {
		MainWindow window = new MainWindow();
		window.open();
		} 
		catch (java.lang.UnsatisfiedLinkError e) {
			System.out.println("The GUI was unable to open");
			System.out.println("This could be due to a variety of reasons,");
			System.out.println("but the primary reason may be due to the SWT jar reference");
			System.out.println("In order to fix this follow these steps (This was aproved by Andy, our TA):");
			System.out.println("1. Double click on 'Referenced Libraries' in the Package Explorer");
			System.out.println("2. Ensure the version of the jar file matches your operating system");
			System.out.println("win = windows, linux = linux, mac = osx");
			System.out.println("3. If the jar does not match your operating system follow these steps:");
			System.out.println("3A. Right click on the jar in 'Referenced Libraries'");
			System.out.println("3B. Under the 'Build Path' tab click on 'Remove from build path'");
			System.out.println("3C. In the 'lib' folder in the package explorer right click on the jar for your operating system");
			System.out.println("3D. Under the 'Build Path' tab click on 'add to build path'");
			System.out.println("4. Once the above steps have been completed, run the program again.");
			System.out.println("Thank you for taking the time to follow these steps!");
			System.out.println("SWT requires different jar files for each operating system\nso this solution is the best we can do to try and have the gui work for everyone at the moment since \ndynamically loading the jars at runtime did not work.");
		}	
		catch (java.lang.Error e) {
			System.out.println("The GUI was unable to open");
			System.out.println("This could be due to a variety of reasons,");
			System.out.println("but the primary reason may be due to the SWT jar reference.");
			System.out.println("In order to fix this follow these steps (This was aproved by Andy, our TA):");
			System.out.println("1. Double click on 'Referenced Libraries' in the Package Explorer");
			System.out.println("2. Ensure the version of the jar file matches your operating system");
			System.out.println("win = windows, linux = linux, mac = osx");
			System.out.println("3. If the jar does not match your operating system follow these steps:");
			System.out.println("3A. Right click on the jar in 'Referenced Libraries'");
			System.out.println("3B. Under the 'Build Path' tab click on 'Remove from build path'");
			System.out.println("3C. In the 'lib' folder in the package explorer right click on the jar for your operating system");
			System.out.println("3D. Under the 'Build Path' tab click on 'add to build path'");
			System.out.println("4. Once the above steps have been completed, run the program again.");
			System.out.println("Thank you for taking the time to follow these steps!");
			System.out.println("SWT requires different jar files for each operating system\nso this solution is the best we can do to try and have the gui work for everyone at the moment since \ndynamically loading the jars at runtime did not work.");
		}	
		catch (Exception e) {
			System.out.println("There was an error, please try again");
		}
	}
}
