package com.example.fw;

public class ContactHelper extends HelpersBase{

	public ContactHelper(ApplicationManager applicationManager) {
		super(applicationManager);
		}

	public void createContact(Contact contact) {
		initContactCreation();
		fillContactForm(contact);
		confirmContactCreation();
	}

	private void confirmContactCreation() {
		manager.getAutoITHelper()
			.click("Save")
			.winWaitAndActivate("AddressBook Portable", "", 5000);
	}

	private void fillContactForm(Contact contact) {
		manager.getAutoITHelper()
			.send("TDBEdit12", contact.firstname)
			.send("TDBEdit11", contact.lastname);
	}

	private void initContactCreation() {
		manager.getAutoITHelper()
			.winWaitAndActivate("AddressBook Portable", "", 5000)
			.click("Add").winWaitAndActivate("Add Contact", "", 5000);
	}

	public Contact getFirstContact() {
		manager.getAutoITHelper()
			.winWaitAndActivate("AddressBook Portable", "", 5000)
			.focus("TListView1")
			.send("{DOWN}{SPACE}")
			.click("Edit")
			.winWaitAndActivate("Update Contact", "", 5000);
		Contact contact = new Contact()
			.setFirstName(manager.getAutoITHelper().getText("TDBEdit12"))
			.setLastName(manager.getAutoITHelper().getText("TDBEdit11"));
		manager.getAutoITHelper()
			.click("Cancel")
			.winWaitAndActivate("AddressBook Portable", "", 5000);
		return contact;
	}
	
	
	
}
