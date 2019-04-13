package io;

import java.util.ArrayList;

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

import adt.AddressT;
import adt.LocationT;
import adt.ShelterT;
import adt.UserT;
import adt.UserT.UserResT;
import algsstructs.MaxPQ;
import algsstructs.TST;
import process.Weight;

public class FindShelter {

	protected Shell shlUserInfo;
	private boolean male;
	private boolean youth;
	private boolean family;
	private boolean CoEd;
	private Text address;
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
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlUserInfo.open();
		shlUserInfo.layout();
		while (!shlUserInfo.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlUserInfo = new Shell();
		shlUserInfo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shlUserInfo.setSize(668, 303);
		shlUserInfo.setText("User Info");
		shlUserInfo.scroll(0, 0, 0, 0, 5, 5, true);
		shlUserInfo.setLayout(null);

		
		Label lblHereAreYour = new Label(shlUserInfo, SWT.NONE);
		lblHereAreYour.setBounds(106, 11, 477, 33);
		lblHereAreYour.setFont(SWTResourceManager.getFont("Times New Roman", 14, SWT.BOLD));
		lblHereAreYour.setAlignment(SWT.CENTER);
		lblHereAreYour.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblHereAreYour.setText("Please Enter Your Info");
		
		Group group = new Group(shlUserInfo, SWT.NONE);
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
		
		Group group_1 = new Group(shlUserInfo, SWT.NONE);
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
		
		Group group_2 = new Group(shlUserInfo, SWT.NONE);
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
		
		Button btnFindShelter = new Button(shlUserInfo, SWT.NONE);
		btnFindShelter.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				_address_ = address.getText();
		        if(_address_.equals("")) {
			        MessageBox dialog = new MessageBox(shlUserInfo, SWT.ICON_ERROR | SWT.OK);
					dialog.setText("ERROR");
					dialog.setMessage("Please enter a valid address");
					dialog.open();
		        }
		        else {
					Label lblLoading = new Label(shlUserInfo, SWT.NONE);
					lblLoading.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
					lblLoading.setBounds(10, 233, 188, 20);
					lblLoading.setText("Calculating Best Shelter...");
		        	UserResT type = getUserType();
		    		// creates a 2d array of all shelters
		    		ShelterT[][] masterArray = Read.readShelterData();
		    		
		    		// creates TST of addresses
		        	TST<AddressT> addresses = Read.readAddressData();
					
					UserT user = new UserT(type, addresses.get(_address_).getLat(), addresses.get(_address_).getLon());
		        						
					AddressT shelAdd;
					for (int i = 0; i < masterArray.length; i++) {
						for (ShelterT shel : masterArray[i]) {
							shelAdd = addresses.get(shel.getAddress());
							shel.setLat(shelAdd.getLat());
							shel.setLon(shelAdd.getLon());
							
							// sets score for each shelter
							shel.setScore(Weight.calcScore(shel, user));
						}
					}
					
					MaxPQ<LocationT> shelPQ;
					
					switch (user.getResType()) {		
					case MALE_ONLY:
						shelPQ = new MaxPQ<LocationT>(masterArray[0]);
						break;
					case MALE_COED:
						shelPQ = new MaxPQ<LocationT>(concatenate(masterArray[0], masterArray[2]));
						break;
					case FEMALE_ONLY:
						shelPQ = new MaxPQ<LocationT>(masterArray[1]);
						break;
					case FEMALE_COED:
						shelPQ = new MaxPQ<LocationT>(concatenate(masterArray[1], masterArray[2]));
						break;
					case FAMILY:
						shelPQ = new MaxPQ<LocationT>(masterArray[3]);
						break;
					case YOUTH:
						shelPQ = new MaxPQ<LocationT>(masterArray[4]);
						break;
					default:
						shelPQ = new MaxPQ<LocationT>(masterArray[0]);
						break;
					}
		        	
			        shlUserInfo.dispose();
					OutputWindow OutputWindow = new OutputWindow();
					OutputWindow.open(shelPQ, _address_);
		        }
			}
		});
		btnFindShelter.setBounds(10, 200, 630, 30);
		btnFindShelter.setText("Find Shelter");
		
		Label lblEnterYourCurrent = new Label(shlUserInfo, SWT.NONE);
		lblEnterYourCurrent.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblEnterYourCurrent.setBounds(10, 50, 188, 20);
		lblEnterYourCurrent.setText("Enter Your Current Address");
		
		address = new Text(shlUserInfo, SWT.BORDER);
		address.setBounds(10, 76, 630, 26);
		
		Button btnBack = new Button(shlUserInfo, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlUserInfo.dispose();
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
	
	private ShelterT[] concatenate(ShelterT[] a, ShelterT[] b) {	    
	    ArrayList<ShelterT> c = new ArrayList<ShelterT>();
	    
	    for (ShelterT s : a) c.add(s);
	    for (ShelterT s : b) c.add(s);
	    	    
	    ShelterT[] cArray = new ShelterT[c.size()];
	    cArray = c.toArray(cArray);
	    
	    return cArray;
	}
	
	public String getAddress() {
		return address.getText();
	}
}
