package com.example.tests;

import static org.testng.Assert.assertEquals;

//import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;


public class ContactCreationTests extends TestBase {

	
  @Test(dataProvider =  "randomValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
    app.getNavigationHelper().openMainPage();
    
    //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    
    //actions
    app.getContactHelper().gotoAddNewPage();
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnToHomePage();
    
    //save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    
    //compare states
    assertEquals(newList.size(), oldList.size() + 1);
    
    //oldList.add(contact);
    //Collections.sort(oldList);
    //assertEquals(newList, oldList);
    
  	}
  }

 
