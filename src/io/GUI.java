package io;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import org.eclipse.wb.swt.SWTResourceManager;

public class GUI {

	protected Shell shell;
	private Text text;
	private boolean female;
	private boolean male;
	private boolean youth;
	private boolean family;
	private boolean neither;
	private boolean CoEd;
	private boolean noCoEd;
	
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GUI window = new GUI();
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
		text.setBounds(10, 189, 630, 232);
		
		Group group = new Group(shell, SWT.NONE);
		group.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		group.setBounds(10, 76, 188, 32);
		
		Button Female = new Button(group, SWT.RADIO);
		Female.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				female = true;
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
				female = false;
			}
		});
		Male.setBounds(0, 10, 57, 20);
		Male.setText("Male");
		
		Group group_1 = new Group(shell, SWT.NONE);
		group_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		group_1.setBounds(426, 76, 214, 33);
		
		Button btnNoCoed = new Button(group_1, SWT.RADIO);
		btnNoCoed.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CoEd = false;
				noCoEd = true;
			}
		});
		btnNoCoed.setBounds(122, 10, 89, 20);
		btnNoCoed.setText("No Co-ed");
		
		Button btnCoed = new Button(group_1, SWT.RADIO);
		btnCoed.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CoEd = true;
				noCoEd = false;
			}
		});
		btnCoed.setBounds(0, 10, 72, 20);
		btnCoed.setText("Co-ed");
		
		Group group_2 = new Group(shell, SWT.NONE);
		group_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		group_2.setBounds(210, 114, 242, 32);
		
		Button btnNeither = new Button(group_2, SWT.RADIO);
		btnNeither.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				youth = false;
				family = false;
				neither = true;
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
				neither = false;
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
				neither = false;
			}
		});
		btnYouth.setBounds(0, 10, 66, 20);
		btnYouth.setText("Youth");
		
		Button btnFindShelter = new Button(shell, SWT.NONE);
		btnFindShelter.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.append("Male: "+ male + " Female: " + female + "\nCo-Ed: " + CoEd + " no Co-Ed: " + noCoEd + "\nYouth: " + youth + " Family: " + family + " Neither: " + neither);

//				for (int i = 1; i < 100; i++) {
//					int strnum = (int) (Math.sqrt(i*16)+Math.sqrt(i)+3*i);
//					float dist = (float) (i*1.25/3.5);
//					//Name, address, dist, type, 
//					text.append("Shelter " + i + "\t\t\t\t\t" + dist + "km" + "\n" + strnum + " Fake St W\n\n");
//				}
			}
		});
		btnFindShelter.setBounds(10, 153, 630, 30);
		btnFindShelter.setText("Find Shelter");

		// male/female
		// co-ed/no co-ed
		// family/youth/nether
//		for (int i = 1; i < 100; i++) {
//			int strnum = (int) (Math.sqrt(i*16)+Math.sqrt(i)+3*i);
//			float dist = (float) (i*1.25/3.5);
//			//Name, address, dist, type, 
//			text.append("Shelter " + i + "\t\t\t\t\t" + dist + "km" + "\n" + strnum + " Fake St W\n\n");
//		}
	}
}
