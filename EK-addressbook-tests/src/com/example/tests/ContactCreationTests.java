package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromCSVFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXMLFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
//import java.util.Collections;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ContactCreationTests extends TestBase {

	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException {
		return wrapContactsForDataProvider(loadContactsFromXMLFile(new File("contacts.xml"))).iterator();
	}
	
  

@Test(dataProvider =  "contactsFromFile")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
    
    //save old state
    //List<ContactData> oldList = app.getContactHelper().getContacts();
    List<ContactData> oldList = app.getHibernateHelper().listContacts();
    
    //actions
    app.getContactHelper().createContact(contact);
    
    
    //save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    //List<ContactData> newList = app.getHibernateHelper().listContacts();
    
    //compare states
    assertEquals(newList.size(), oldList.size() + 1);
   
    
  	}
  }

 
