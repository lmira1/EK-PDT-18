package com.example.tests;

import org.testng.annotations.Test;


public class ContactCreationTests extends TestBase {

  @Test
  public void testNonEmptyContactCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getContactHelper().gotoAddNewPage();
    ContactData contact = new ContactData();
    contact.firstName = "Svetlana";
	contact.lastName = "Last name 1";
	contact.address = "address 1";
	contact.home = "home 1";
	contact.mobile = "mobile 1";
	contact.work = "work 1";
	contact.email = "email 1";
	contact.email2 = "email 2";
	contact.birthday = "1";
	contact.birthmonth = "January";
	contact.birthyear = "1111";
	contact.address2 = "address 2";
	contact.phone2 = "phone 2";
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getContactHelper().gotoAddNewPage();
    ContactData contact = new ContactData();
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    }
  }

 
