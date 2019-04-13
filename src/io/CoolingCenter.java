package io;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import adt.AddressT;
import adt.CoolingCentreT;
import adt.UserT;
import algsstructs.MaxPQ;
import algsstructs.TST;
import process.Weight;

import adt.LocationT;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Button;

/**
 * GUI module for finding closest Cooling Centre
 * @author Hassan and Sam
 *
 */
public class CoolingCenter {

	protected Shell shell;
	private Text address;
	private String _address_;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CoolingCenter window = new CoolingCenter();
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
		shell.setSize(511, 204);
		shell.setText("SWT Application");
		
		address = new Text(shell, SWT.BORDER);
		address.setBounds(86, 62, 393, 26);
		
		Label lblPleaseEnterYour = new Label(shell, SWT.NONE);
		lblPleaseEnterYour.setAlignment(SWT.CENTER);
		lblPleaseEnterYour.setFont(SWTResourceManager.getFont("Times New Roman", 14, SWT.BOLD));
		lblPleaseEnterYour.setBounds(86, 10, 393, 30);
		lblPleaseEnterYour.setText("Please Enter Your Current Address");
		
		Label lblAddress = new Label(shell, SWT.NONE);
		lblAddress.setBounds(10, 65, 70, 20);
		lblAddress.setText("Address:");
		
		Button btnFindNearestCooling = new Button(shell, SWT.NONE);
		btnFindNearestCooling.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				_address_ = address.getText();
		        if(_address_.equals("")) {
			        MessageBox dialog = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
					dialog.setText("ERROR");
					dialog.setMessage("Please enter a valid address");
					dialog.open();
		        }
		        else {
					Label lblSearching = new Label(shell, SWT.NONE);
					lblSearching.setBounds(10, 134, 469, 20);
					lblSearching.setText("Searching........");
					
		    		// creates TST of addresses
		        	TST<AddressT> addresses = Read.readAddressData();
					
					UserT user = new UserT(addresses.get(_address_).getLat(), addresses.get(_address_).getLon());
					
					// creates a 1d array of all cooling centres
					CoolingCentreT[] cool = Read.readCoolingData();
					
					for (int i = 0; i < cool.length; i++) {
						// sets score for each cooling centre
						cool[i].setScore(Weight.calcScore(cool[i], user));
					}
					
					MaxPQ<LocationT> coolPQ = new MaxPQ<LocationT>(cool);
					
			        shell.dispose();
					OutputWindow OutputWindow = new OutputWindow();
					OutputWindow.open(coolPQ, _address_);
		        }
			}
		});
		btnFindNearestCooling.setBounds(10, 103, 469, 30);
		btnFindNearestCooling.setText("Find Nearest Cooling Center");
		
		Button btnBack = new Button(shell, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				MainWindow MainWindow = new MainWindow();
				MainWindow.open();
			}
		});
		btnBack.setBounds(10, 10, 70, 30);
		btnBack.setText("Back");
		


	}
}
