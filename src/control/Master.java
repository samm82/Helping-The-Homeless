package control;

import io.MainWindow;

// Control module which will control all of our functionality
public class Master {
	
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
