package io;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import adt.ShelterT;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class OutputWindow {

	protected Shell shell;
	private Text Output;
	private String[] shelter_address;
	private Button btnBack;
	private Button btnNext;
	private static ShelterT [] Shelters = new ShelterT[5];

	/**
	 * Launch the application.
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		try {
			OutputWindow window = new OutputWindow();
			window.open(Shelters);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open(ShelterT [] s) {
		Display display = Display.getDefault();
		Shelters[0] = s[0];
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
		shell.setSize(478, 264);
		shell.setText("SWT Application");
		
		Output = new Text(shell, SWT.WRAP | SWT.MULTI);
		Output.setEnabled(false);
		Output.setEditable(false);
		Output.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		Output.setBounds(111, 10, 241, 157);
		System.out.print(Shelters[0].getName());
		Output.setText("\t\t\t" + Shelters[0].getName() + "\n");			
		Output.append("\t" + Shelters[0].getOrgName() + "\n\n");
		Output.append(Shelters[0].getAddress() + ", Toronto, ON\n");	
		Output.append("Historical Occupancy: 15" + Shelters[0].getOcc2018(0) + "\n");		
		Output.append("Capacity: 5" + Shelters[0].getCap2018(0) + "\n");					
		Output.append(Shelters[0].getTypeString());								

		
		Button btnOpenShelterIn = new Button(shell, SWT.NONE);
		btnOpenShelterIn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String temp = Output.getText();
				shelter_address = temp.split("\n");
				temp = shelter_address[3].replace(" ", "+");
				temp = temp.trim();
				System.out.println(shelter_address[2]);
				String url = "https://www.google.ca/maps/dir/" + "27+Kings+college+rd,+Toronto,+ON/" + temp + "/";

		        if(Desktop.isDesktopSupported()){
		            Desktop desktop = Desktop.getDesktop();
		            try {
		                desktop.browse(new URI(url));
		            } catch (IOException | URISyntaxException e1) {
		                // TODO Auto-generated catch block
		                e1.printStackTrace();
		            }
		        }else{
		            Runtime runtime = Runtime.getRuntime();
		            try {
		                runtime.exec("xdg-open " + url);
		            } catch (IOException e1) {
		                // TODO Auto-generated catch block
		                e1.printStackTrace();
		            }
		        }
			}
		});
		btnOpenShelterIn.setBounds(10, 177, 435, 30);
		btnOpenShelterIn.setText("Open Shelter In Google Maps");
		
		btnBack = new Button(shell, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				MainWindow MainWindow = new MainWindow();
				MainWindow.open();
				
			}
		});
		btnBack.setBounds(10, 10, 45, 157);
		btnBack.setText("Back");
		
		btnNext = new Button(shell, SWT.NONE);
		btnNext.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Output.setText("");
				Output.setText("\t  Covenant House Toronto" + "\n");	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
				Output.append("\tSocial services organization" + "\n\n");//////////////////////////////////////////////////////////////////////////////////////////////////////////////
				Output.append("20 Gerrard St E, Toronto, ON" + "\n");	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
				Output.append("Historical Occupancy: 75" + "\n");		//////////////////////////////////////////////////////////////////////////////////////////////////////////////
				Output.append("Capacity: 200" + "\n");					//////////////////////////////////////////////////////////////////////////////////////////////////////////////
				Output.append("Coed");									//////////////////////////////////////////////////////////////////////////////////////////////////////////////
			}
		});
		btnNext.setBounds(400, 10, 45, 157);
		btnNext.setText("Next");

	}

}
