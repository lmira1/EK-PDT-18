package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{

	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().goToHomePage();
	    app.getContactHelper().selectContactByIndex(2);
	    ContactData contact = new ContactData();
		contact.firstName = "Alex";
		contact.email = "new mail";
		app.getContactHelper().fillContactForm(contact);
	    app.getContactHelper().updateContact();
		app.getNavigationHelper().returnToHomePage();
			
	}
}
