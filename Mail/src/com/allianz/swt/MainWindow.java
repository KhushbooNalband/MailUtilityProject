package com.allianz.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import com.allianz.endpoints.Endpoint;

import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryStream.Filter;

import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;

public class MainWindow {
	public static final Logger logger = Logger.getLogger(MainWindow.class);
	protected Shell shell;
	com.allianz.filters.Filter filter = new com.allianz.filters.Filter();
	com.allianz.endpoints.Endpoint endpoint = new Endpoint();

	FileDialog fileDialogRecipient = null;
	FileDialog fileDialogContent = null;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			logger.error(e);
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
		shell.setSize(450, 300);
		shell.setText("SWT Application");

		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);

		MenuItem mntmCompose = new MenuItem(menu, SWT.CASCADE);
		mntmCompose.setText("Compose");

		MenuItem mntmView = new MenuItem(menu, SWT.CASCADE);
		mntmView.setText("View");

		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(10, 10, 197, 23);
		composite.setVisible(false);

		Label lblEndpoint = new Label(composite, SWT.NONE);
		lblEndpoint.setBounds(0, 3, 55, 15);
		lblEndpoint.setText("Endpoint");

		Combo combo = new Combo(composite, SWT.NONE);
		combo.setBounds(101, 0, 91, 23);
		combo.setItems(new String[] { "Enable", "Disable" });

		Composite composite_1 = new Composite(shell, SWT.NONE);
		composite_1.setBounds(10, 42, 199, 23);
		composite_1.setVisible(false);

		Label lblSelectEndpoint = new Label(composite_1, SWT.NONE);
		lblSelectEndpoint.setBounds(0, 3, 91, 15);
		lblSelectEndpoint.setText("Select Endpoint");

		Combo combo_1 = new Combo(composite_1, SWT.NONE);
		combo_1.setBounds(102, 0, 91, 23);
		combo_1.setItems(new String[] { "File", "Database" });

		Composite composite_2 = new Composite(shell, SWT.NONE);
		composite_2.setBounds(10, 71, 414, 160);

		Group group_1 = new Group(composite_2, SWT.NONE);
		group_1.setBounds(3, 10, 190, 43);
		group_1.setVisible(false);

		Label lblSendMail = new Label(group_1, SWT.NONE);
		lblSendMail.setBounds(3, 15, 55, 15);
		lblSendMail.setText("Send Mail");

		Button btnSend_1 = new Button(group_1, SWT.NONE);
		btnSend_1.setBounds(112, 15, 75, 25);
		btnSend_1.setText("Send Mail");

		Group group = new Group(composite_2, SWT.NONE);
		group.setBounds(3, 59, 240, 101);
		group.setVisible(false);

		Label lblAddRecipients = new Label(group, SWT.NONE);
		lblAddRecipients.setBounds(3, 20, 88, 15);
		lblAddRecipients.setText("Add Recipients");

		Button btnUploadRecipientFile = new Button(group, SWT.NONE);
		btnUploadRecipientFile.setBounds(108, 15, 129, 25);
		btnUploadRecipientFile.setText("Upload Recipient File");

		Label lblAddMessage = new Label(group, SWT.NONE);
		lblAddMessage.setBounds(3, 49, 88, 15);
		lblAddMessage.setText("Add Message");

		Button btnUploadMessageFile = new Button(group, SWT.NONE);
		btnUploadMessageFile.setBounds(108, 46, 129, 25);
		btnUploadMessageFile.setText("Upload Message File");

		Button btnSend = new Button(group, SWT.NONE);
		btnSend.setBounds(108, 73, 75, 25);
		btnSend.setText("Send");

		Group group_2 = new Group(composite_2, SWT.NONE);
		group_2.setBounds(29, 10, 199, 72);
		group_2.setVisible(false);

		Label lblRecipient = new Label(group, SWT.NONE);
		lblRecipient.setBounds(76, 33, 299, 15);
		lblRecipient.setVisible(false);

		Label lblContent = new Label(group, SWT.NONE);
		lblContent.setBounds(76, 33, 299, 15);
		lblContent.setVisible(false);

		Label lblSelectFilter = new Label(group_2, SWT.NONE);
		lblSelectFilter.setBounds(3, 18, 66, 15);
		lblSelectFilter.setText("Select Filter");

		Combo combo_2 = new Combo(group_2, SWT.NONE);
		combo_2.setBounds(75, 15, 121, 23);
		combo_2.setItems(new String[] { "By Domain Name", "By Subject", "By Month" });

		Button btnFilter = new Button(group_2, SWT.NONE);
		btnFilter.setBounds(75, 44, 75, 25);
		btnFilter.setText("Filter");

		Group group_3 = new Group(shell, SWT.NONE);
		group_3.setBounds(17, 16, 167, 41);
		group_3.setVisible(false);

		Label lblFilter = new Label(group_3, SWT.NONE);
		lblFilter.setBounds(3, 18, 64, 15);
		lblFilter.setText("Filter");

		Combo combo_3 = new Combo(group_3, SWT.NONE);
		combo_3.setBounds(73, 15, 91, 23);
		combo_3.setItems(new String[] { "Enable", "Disable" });

		combo.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {
				String option = combo.getItem(combo.getSelectionIndex());

				switch (option) {
				case "Enable":
					composite_1.setVisible(true);
					break;
				case "Disable":
					if (composite_1.getVisible() == true || group.getVisible() == true
							|| group_1.getVisible() == true) {
						composite_1.setVisible(false);
						group.setVisible(false);
						group_1.setVisible(false);
					}
				}
			}
		});
		mntmCompose.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (group_2.getVisible() == true || group_3.getVisible() == true) {
					group_2.setVisible(false);
					group_3.setVisible(false);
				}
				composite.setVisible(true);
			}
		});

		combo_1.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {
				String option = combo_1.getItem(combo_1.getSelectionIndex());

				switch (option) {
				case "File":
					if (group_1.getVisible() == true) {
						group_1.setVisible(false);
					}

					group.setVisible(true);

					break;
				case "Database":
					if (group.getVisible() == true) {
						group.setVisible(false);
					}
					group_1.setVisible(true);
				}

			}// modifyText

		});

		
		combo_2.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {
				String option = combo_2.getItem(combo_2.getSelectionIndex());

				switch (option) {
				case "By Domain Name":
					if (group_1.getVisible() == true||group.getVisible()==true) 
					{
						group_1.setVisible(false);
						group.setVisible(false);
						
					}

					group_3.setVisible(true);

					break;
				case "By Subject":
					if (group.getVisible() == true||group_1.getVisible()==true) 
					{
						group.setVisible(false);
						group_1.setVisible(false);
						
					}
					group_3.setVisible(true);
				
				case "By Month":
					if (group.getVisible() == true||group.getVisible()==true) {
						
						group.setVisible(false);
						
					group_1.setVisible(false);
				}
					group_3.setVisible(true);
			}// modifyText


			}
		});

		mntmView.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (composite.getVisible() == true || composite_1.getVisible() == true
						|| composite_2.getVisible() == true) {
					composite.setVisible(false);
					composite_1.setVisible(false);
					group.setVisible(false);
					group_1.setVisible(false);
				}
				group_3.setVisible(true);
			}
		});

		combo_3.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {
				String option = combo_3.getItem(combo_3.getSelectionIndex());

				switch (option) {
				case "Enable":
					group_2.setVisible(true);
					break;
				case "Disable":
					if (composite_1.getVisible() == true || group.getVisible() == true || group_1.getVisible() == true
							|| group_2.getVisible() == true) {
						composite_1.setVisible(false);
						group.setVisible(false);
						group_1.setVisible(false);
						group_2.setVisible(false);
					}
				}
			}
		});

		btnSend_1.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					System.out.println("Button pressed");
					endpoint.setEndpoint(true);
					try {
						endpoint.creatDbEndpoint(true);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				}
			}
		});

		btnUploadMessageFile.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				fileDialogContent = new FileDialog(shell, SWT.OPEN);
				fileDialogContent.setText("Select File");

				fileDialogContent.setFilterPath("C:/");
				fileDialogContent.setFilterExtensions(new String[] { ".txt", "." });

				String temp = fileDialogContent.open();
				System.out.println(temp);

				lblContent.setText(temp);
				lblContent.setVisible(true);
			}
		});

		btnUploadRecipientFile.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				fileDialogRecipient = new FileDialog(shell, SWT.OPEN);
				fileDialogRecipient.setText("Select File");

				fileDialogRecipient.setFilterPath("C:/Users/user/Desktop/");
				fileDialogRecipient.setFilterExtensions(new String[] { ".txt", "." });

				String temp = fileDialogRecipient.open();
			
				System.out.println(temp);

				lblRecipient.setText(temp);
				lblRecipient.setVisible(true);

			}

		});// selectionListner ends here

		btnSend.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					System.out.println("Button pressed");
					endpoint.setEndpoint(true);
					try {
						String filenameRecipient = lblRecipient.getText();
						String filenameContent = lblContent.getText();
						System.out.println(filenameRecipient);
						System.out.println(filenameContent);
						endpoint.createFileEndpoint(true, filenameRecipient, filenameContent);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				}
			}
		});
		
		btnFilter.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					
					String selected = combo_2.getItem(combo_2.getSelectionIndex());
					
					switch(selected)
					{
					case "By Domain Name" :
						filter.setFilters(true);
						try {
							filter.setDomainFilter(true);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
						
						}
						break;
					case "By Subject" :
						filter.setFilters(true);
						try {
							filter.setSubjectFilter(true);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							
						}
						break;
						
					case "By Month" :
						filter.setFilters(true);
						try {
							filter.setMonthFilter(true);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							
						}
						break;
					}
				}
			}
		});
		btnFilter.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Label lblFilter1 = new Label(shell, SWT.NONE);
				lblFilter1.setText("Filter Successful.Check your C drive");
			}

			});
	}// create
}// class
