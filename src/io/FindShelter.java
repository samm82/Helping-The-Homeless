package io;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import org.eclipse.wb.swt.SWTResourceManager;

import adt.UserInputT;
import adt.UserT.UserResT;

public class FindShelter {

	private UserInputT info;
	
	protected Shell shell;
	private boolean male;
	private boolean youth;
	private boolean family;
	private boolean CoEd;
	private Text address;
	private String add;
	private String _address_;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FindShelter window = new FindShelter();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public UserInputT open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		UserResT type = getUserType();
		String   add  = _address_;
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
			type = getUserType();
			add  = _address_;
		}
		info = new UserInputT(type, add);
		return info;
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shell.setSize(668, 301);
		shell.setText("Best Shelter");
		shell.scroll(0, 0, 0, 0, 5, 5, true);
		shell.setLayout(null);
		
		Label lblHereAreYour = new Label(shell, SWT.NONE);
		lblHereAreYour.setBounds(106, 11, 477, 33);
		lblHereAreYour.setFont(SWTResourceManager.getFont("Times New Roman", 14, SWT.BOLD));
		lblHereAreYour.setAlignment(SWT.CENTER);
		lblHereAreYour.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblHereAreYour.setText("Here are your best shelters");
		
		Group group = new Group(shell, SWT.NONE);
		group.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		group.setBounds(10, 108, 188, 32);
		
		Button Female = new Button(group, SWT.RADIO);
		Female.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				male = false;
			}
		});
		Female.setBounds(116, 10, 72, 20);
		Female.setText("Female");
		
		Button Male = new Button(group, SWT.RADIO);
		Male.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				male = true;
			}
		});
		Male.setBounds(0, 10, 57, 20);
		Male.setText("Male");
		
		Group group_1 = new Group(shell, SWT.NONE);
		group_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		group_1.setBounds(426, 108, 214, 33);
		
		Button btnNoCoed = new Button(group_1, SWT.RADIO);
		btnNoCoed.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CoEd = false;
			}
		});
		btnNoCoed.setBounds(122, 10, 89, 20);
		btnNoCoed.setText("No Co-ed");
		
		Button btnCoed = new Button(group_1, SWT.RADIO);
		btnCoed.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CoEd = true;
			}
		});
		btnCoed.setBounds(0, 10, 72, 20);
		btnCoed.setText("Co-ed");
		
		Group group_2 = new Group(shell, SWT.NONE);
		group_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		group_2.setBounds(210, 146, 242, 32);
		
		Button btnNeither = new Button(group_2, SWT.RADIO);
		btnNeither.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				youth = false;
				family = false;
			}
		});
		btnNeither.setBounds(170, 10, 72, 20);
		btnNeither.setText("Neither");
		
		Button btnFamily = new Button(group_2, SWT.RADIO);
		btnFamily.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				youth = false;
				family = true;
			}
		});
		btnFamily.setBounds(82, 10, 66, 20);
		btnFamily.setText("Family");
		
		Button btnYouth = new Button(group_2, SWT.RADIO);
		btnYouth.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				youth = true;
				family = false;
			}
		});
		btnYouth.setBounds(0, 10, 66, 20);
		btnYouth.setText("Youth");
		
		Button btnFindShelter = new Button(shell, SWT.NONE);
		btnFindShelter.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				_address_ = address.getText();
//				add = address.getText().replace(" ", "+");
//		        String url = "https://www.google.ca/maps/dir/" + add + "/Downtown+Toronto";
//
//		        if (Desktop.isDesktopSupported()) {
//		            Desktop desktop = Desktop.getDesktop();
//		            try {
//		                desktop.browse(new URI(url));
//		            } catch (IOException | URISyntaxException e1) {
//		                // TODO Auto-generated catch block
//		                e1.printStackTrace();
//		            }
//		        } else {
//		            Runtime runtime = Runtime.getRuntime();
//		            try {
//		                runtime.exec("xdg-open " + url);
//		            } catch (IOException e1) {
//		                // TODO Auto-generated catch block
//		                e1.printStackTrace();
//		            }
//		        }
		        if(address.getText().equals("")) {
			        MessageBox dialog = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
					dialog.setText("ERROR");
					dialog.setMessage("Please enter a valid address");
					dialog.open();
		        }
		        else {
			        shell.dispose();
					OutputWindow OutputWindow = new OutputWindow();
					OutputWindow.open();
		        }
			}
		});
		btnFindShelter.setBounds(10, 197, 630, 30);
		btnFindShelter.setText("Find Shelter");
		
		Label lblEnterYourCurrent = new Label(shell, SWT.NONE);
		lblEnterYourCurrent.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblEnterYourCurrent.setBounds(10, 50, 188, 20);
		lblEnterYourCurrent.setText("Enter Your Current Address");
		
		address = new Text(shell, SWT.BORDER);
		address.setBounds(10, 76, 630, 26);
		
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
	
	public UserResT getUserType() {		
		if      (youth)  return UserResT.YOUTH;
		else if (family) return UserResT.FAMILY;
		else if (CoEd) {
			if  (male)   return UserResT.MALE_COED;
			else         return UserResT.FEMALE_COED;
		} else {
			if  (male)   return UserResT.MALE_ONLY;
			else         return UserResT.FEMALE_ONLY;
		}
	}
	
	public String getAddress() {
		return address.getText();
	}
}
