package io;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class GetShelterInfo {

	protected Shell shell;
	private Text ShelterName;
	private Text ShelterAddress;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GetShelterInfo window = new GetShelterInfo();
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
		shell.setSize(440, 288);
		shell.setText("SWT Application");
		
		ShelterName = new Text(shell, SWT.BORDER);
		ShelterName.setBounds(10, 75, 400, 26);
		
		Label lblEnterShelterName = new Label(shell, SWT.NONE);
		lblEnterShelterName.setBounds(10, 49, 400, 20);
		lblEnterShelterName.setText("Enter Shelter Name:");
		
		Label lblOr = new Label(shell, SWT.NONE);
		lblOr.setAlignment(SWT.CENTER);
		lblOr.setBounds(10, 107, 400, 20);
		lblOr.setText("Or");
		
		Label lblEnterShelterAddress = new Label(shell, SWT.NONE);
		lblEnterShelterAddress.setBounds(10, 133, 400, 20);
		lblEnterShelterAddress.setText("Enter Shelter Address:");
		
		ShelterAddress = new Text(shell, SWT.BORDER);
		ShelterAddress.setBounds(10, 159, 400, 26);
		
		Button btnGetShelterInfo = new Button(shell, SWT.NONE);
		btnGetShelterInfo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(ShelterName.getText().equals("") && ShelterAddress.getText().equals("")) {
					MessageBox dialog = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
					dialog.setText("ERROR");
					dialog.setMessage("Please enter one of the fields");
					dialog.open();
				}
				else if(ShelterAddress.getText().equals("")) {
					// Use Shelter Name Value
//					shell.dispose();
//					OutputWindow OutputWindow = new OutputWindow();
//					OutputWindow.open();
//					OutputWindow.shell.setText(ShelterName.getText());
				}
				else if(ShelterName.getText().equals("")) {
					// Use Shelter Address Value
				}
			}
		});
		btnGetShelterInfo.setBounds(10, 201, 400, 30);
		btnGetShelterInfo.setText("Get Shelter Info");
		
		Button btnBack = new Button(shell, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				MainWindow MainWindow = new MainWindow();
				MainWindow.open();
			}
		});
		btnBack.setBounds(10, 10, 90, 30);
		btnBack.setText("Back");

	}
}
