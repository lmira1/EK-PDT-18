package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;


public class ContactHelper extends WebDriverHelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	private List<ContactData> cachedContacts;
	
	public List<ContactData> getContacts() {
		if(cachedContacts == null){
		rebuildCache();	
		}
		return cachedContacts;
	}
	
	public void rebuildCache(){
		cachedContacts = new ArrayList<ContactData>();
		
		manager.navigateTo().mainPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title =  checkbox.getAttribute("title");
			String firstName = title.substring("select (".length(), title.length() - ")".length());
			cachedContacts.add(new ContactData().withFirstName(firstName));
		}
	}
	
	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().gotoAddNewPage();
	    fillContactForm(contact);
	     //.fillContactForm(contact, ContactHelper.CREATION)
	    submitContactCreation();
	    manager.navigateTo().returnToHomePage();
	    rebuildCache();
		return this;
	}
	
	public ContactHelper removeContact(int index) {
		selectContactByIndex(index);
	    deleteContact();
		manager.navigateTo().returnToHomePage();
		rebuildCache();
		return this;
	}

	public ContactHelper modifyContact(int index, ContactData contact) {
		selectContactByIndex(index);
		fillContactForm(contact);
	    updateContact();
		manager.navigateTo().returnToHomePage();
		rebuildCache();
		return this;
	}

	
	
	//--------------------------------------------------------------
	

	//public ContactHelper fillContactForm(ContactData contact, boolean formType)
	public ContactHelper fillContactForm(ContactData contact) {
	    type(By.name("firstname"), contact.getFirstName());
	    type(By.name("lastname"), contact.getLastName());
	    type(By.name("address"), contact.getAddress());
	    type(By.name("home"), contact.getHome());
	    type(By.name("mobile"), contact.getMobile());
	    type(By.name("work"), contact.getWork());
	    type(By.name("email"), contact.getEmail());
	    type(By.name("email2"), contact.getEmail2());
	    selectByText(By.name("bday"), contact.getBirthDay());
	    selectByText(By.name("bmonth"), contact.getBirthMonth());
	    type(By.name("byear"), contact.getBirthYear());
	    //if (formType == CREATION) {
	    	//selectByText(By.name("new_group"), "group 1");
	    //} else
	    
	    type(By.name("address2"), contact.getAddress2());
	    type(By.name("phone2"), contact.getPhone2());
	    return this;
	}

	

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		return this;
	}
	
	

	public ContactHelper selectContactByIndex(int index) {
		click(By.xpath("(//img[@alt='Edit'])[" + index + "]"));	
		return this;
	}
	
	
	public ContactHelper deleteContact() {
		click(By.xpath("(//input[@name='update'])[2]"));
		return this;
	}
	
	public ContactHelper updateContact() {
		click(By.xpath("(//form)[1]//input[@name='update']"));
		return this;
	}

	
	
}	
