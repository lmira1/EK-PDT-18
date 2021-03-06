package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{

	@Test(dataProvider =  "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact) {
		
	    //save old state
	    //List<ContactData> oldList = app.getContactHelper().getContacts();
		List<ContactData> oldList = app.getHibernateHelper().listContacts();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    //actions
	    app.getContactHelper().modifyContact(index, contact);
	    
		
		 //save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare states
	    assertEquals(newList.size(), oldList.size());
	    
	
	}
}
