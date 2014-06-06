package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase{

	@Test
	public void deleteSomeContact() {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().goToHomePage();
	    
	  //save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    app.getContactHelper().selectContactByIndex(index);
	    app.getContactHelper().deleteContact();
		app.getNavigationHelper().returnToHomePage();
		
		//save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	
	    //compare states
	    assertEquals(newList.size(), oldList.size() - 1);
	}
}
