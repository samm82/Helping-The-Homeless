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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class OutputWindow {

	protected Shell shell;
	private Text Output;
	private String shelter_address;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			OutputWindow window = new OutputWindow();
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
		shell.setSize(606, 385);
		shell.setText("SWT Application");
		
		Output = new Text(shell, SWT.BORDER);
		Output.setEnabled(false);
		Output.setEditable(false);
		Output.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		Output.setBounds(10, 10, 568, 286);
		Output.setText("32 Springbrook gdns, Toronto, ON");//////////////////////////////////////////////////////////////////////////////////////////////////////
		
		Button btnOpenShelterIn = new Button(shell, SWT.NONE);
		btnOpenShelterIn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shelter_address = Output.getText();
				shelter_address = shelter_address.replace(" ", "+");
				String url = "https://www.google.ca/maps/dir/" + "Downtown+Toronto/" + shelter_address;

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
		btnOpenShelterIn.setBounds(10, 302, 568, 30);
		btnOpenShelterIn.setText("Open Shelter In Google Maps");

	}

}
