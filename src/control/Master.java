package control;

import io.MainWindow;

/**
 * Control module which will launch the application
 * @author Sam
 *
 */
public class Master {
	
	/**
	 * main function which will open up the GUI
	 * @param args
	 */
	public static void main(String args[]) {	
		// opens GUI
		try {
		MainWindow window = new MainWindow();
		window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}	
}
