package io;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import adt.ShelterT;
import algsstructs.MaxPQ;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class OutputWindow {

	protected Shell shell;
	private Text Output;
	private String[] shelter_address;
	private Button btnBack;
	private Button btnNext;
	private static MaxPQ<ShelterT> Shelters;
	private static String address;

	/**
	 * Launch the application.
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		try {
			OutputWindow window = new OutputWindow();
			window.open(Shelters, address);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open(MaxPQ<ShelterT> shelPQ, String add) {
		Display display = Display.getDefault();
		Shelters = shelPQ;
		address = add;
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
		
		Calendar calendar = Calendar.getInstance();
		int dayIndex = calendar.get(Calendar.DAY_OF_YEAR) - 1;
		
		ShelterT best = Shelters.delMax();
		System.out.println(best.getName());
		Output.setText(best.getName() + "\n");			
		Output.append(best.getOrgName() + "\n\n");
		Output.append(best.getAddress() + ", Toronto, ON\n");	
		Output.append("Historical Occupancy: " + best.getOcc2018(dayIndex) + "\n");		
		Output.append("Capacity: " + best.getCap2018(dayIndex) + "\n");					
		Output.append(best.getTypeString());								

		
		Button btnOpenShelterIn = new Button(shell, SWT.NONE);
		btnOpenShelterIn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String temp = Output.getText();
				shelter_address = temp.split("\n");
				temp = shelter_address[3].replace(" ", "+");
				temp = temp.trim();
				
				address = address.replace(" ", "+");
				address = address.trim();

//				System.out.println(shelter_address[2]);
				
				String url = "https://www.google.ca/maps/dir/" + address + "+Toronto,+ON/" + temp + "/";

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
				ShelterT best = Shelters.delMax();
				System.out.println(best.getName());
				Output.setText(best.getName() + "\n");			
				Output.append(best.getOrgName() + "\n\n");
				Output.append(best.getAddress() + ", Toronto, ON\n");	
				Output.append("Historical Occupancy: " + best.getOcc2018(dayIndex) + "\n");		
				Output.append("Capacity: " + best.getCap2018(dayIndex) + "\n");					
				Output.append(best.getTypeString());
			}
		});
		btnNext.setBounds(400, 10, 45, 157);
		btnNext.setText("Next");

	}

}
