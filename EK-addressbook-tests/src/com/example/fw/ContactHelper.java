package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
		
	}

	public void gotoAddNewPage() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contact) {
	    type(By.name("firstname"), contact.firstName);
	    type(By.name("lastname"), contact.lastName);
	    type(By.name("address"), contact.address);
	    type(By.name("home"), contact.home);
	    type(By.name("mobile"), contact.mobile);
	    type(By.name("work"), contact.work);
	    type(By.name("email"), contact.email);
	    type(By.name("email2"), contact.email2);
	    //type(By.name("bday"), contact.birthday);
	    selectByText(By.name("bday"), contact.birthday);
	    //type(By.name("bmonth"), contact.birthmonth);
	    selectByText(By.name("bmonth"), contact.birthmonth);
	    type(By.name("byear"), contact.birthyear);
	    //selectByText(By.name("new_group"), "group 1");
	    type(By.name("address2"), contact.address2);
	    type(By.name("phone2"), contact.phone2);
	}

	

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void selectContactByIndex(int index) {
		click(By.xpath("(//img[@alt='Edit'])[" + index + "]"));	
	}
	
	
	public void deleteContact() {
		click(By.xpath("(//input[@name='update'])[2]"));
	}
	
	public void updateContact() {
		click(By.xpath("(//form)[1]//input[@name='update']"));
	}
}
