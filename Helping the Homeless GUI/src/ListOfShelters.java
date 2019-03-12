import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import java.util.ArrayList;

import javax.swing.JScrollPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Text;

public class ListOfShelters {

	protected Shell shell;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ListOfShelters window = new ListOfShelters();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shell.setSize(668, 478);
		shell.setText("Best Shelter");
		shell.scroll(0, 0, 0, 0, 5, 5, true);
		shell.setLayout(null);
		
		Label lblHereAreYour = new Label(shell, SWT.NONE);
		lblHereAreYour.setBounds(10, 10, 630, 60);
		lblHereAreYour.setFont(SWTResourceManager.getFont("Times New Roman", 14, SWT.BOLD));
		lblHereAreYour.setAlignment(SWT.CENTER);
		lblHereAreYour.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblHereAreYour.setText("Here are your best shelters");
		
		text = new Text(shell, SWT.READ_ONLY | SWT.V_SCROLL);
		text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text.setBounds(10, 76, 630, 345);
		
		
		for (int i = 1; i < 100; i++) {
			int strnum = (int) (Math.sqrt(i*16)+Math.sqrt(i)+3*i);
			float dist = (float) (i*1.25/3.5);
			text.append("Shelter " + i + "\t\t\t\t\t" + dist + "km" + "\n" + strnum + " Fake St W\n\n");
		}

		


	}
}
