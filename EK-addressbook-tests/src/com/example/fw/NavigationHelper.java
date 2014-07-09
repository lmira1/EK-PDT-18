package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends WebDriverHelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void mainPage() {
		if (! onMainPage()){
	  //  driver.get(manager.baseUrl + "/addressbookv4.1.4/");
	    click(By.linkText("home"));
	  }
	}
	
	private boolean onMainPage() {
		return driver.findElements(By.id("maintable")).size() > 0;
	}

	public void groupsPage() {
		if (! onGroupsPage()){
		click(By.linkText("groups"));
		}
	  }

	private boolean onGroupsPage() {
		if(driver.getCurrentUrl().contains("/group.php")
			&& driver.findElements(By.name("new")).size() > 0){
			return true;
		}	else {
			return false;
		}
	}
	
	public void gotoAddNewPage() {
		click(By.linkText("add new"));
	
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}
	
	
	public void homePage() {
		click(By.linkText("home"));
	}
}
