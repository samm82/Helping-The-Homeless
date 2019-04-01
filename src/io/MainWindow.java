package io;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MainWindow {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
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
		shell.setSize(471, 245);
		shell.setText("SWT Application");
		
		Button btnFindShelter = new Button(shell, SWT.NONE);
		btnFindShelter.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				FindShelter FindShelter = new FindShelter();
				FindShelter.open();
			}
		});
		btnFindShelter.setBounds(10, 84, 200, 30);
		btnFindShelter.setText("Find Shelter");
		
		Button btnGetShelterInfo = new Button(shell, SWT.NONE);
		btnGetShelterInfo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				GetShelterInfo GetShelterInfo = new GetShelterInfo();
				GetShelterInfo.open();
			}
		});
		btnGetShelterInfo.setBounds(243, 84, 200, 30);
		btnGetShelterInfo.setText("Get Shelter Info");

	}
}
