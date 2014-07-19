package com.example.fw;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class AccountHelper extends HelperWithWebDriverBase{

	public AccountHelper(ApplicationManager applicationManager) {
		super(applicationManager);
		
	}

	public void singup(User user) {
		openURL("/");
		click(By.cssSelector("span.bracket-link"));
		type(By.name("username"), user.login);
		type(By.name("email"), user.email);
		click(By.cssSelector("input.button"));
		
		WebElement errorMessage = findElement(By.cssSelector("table.width50 tbody tr td p"));
		if (errorMessage != null){
			throw new RuntimeException(errorMessage.getText());
		}
		
		pause(3000);
		String msg = manager.getMailHelper().getNewMail(user.login, user.password);
		String confirmationLink = getConfirmationLink(msg);
		openAbsoluteURL(confirmationLink);
		
		type(By.name("password"), user.password);
		type(By.name("password_confirm"), user.password);
		click(By.cssSelector("input.button"));
	}

	public String getConfirmationLink(String text) {
		Pattern regex = Pattern.compile("http\\S*");
		Matcher matcher = regex.matcher(text);
		if (matcher.find()) {
			return matcher.group();
		} else {
			return "";
		}
	}
	
	public void login(User user) {
		openURL("/");
		type(By.name("username"), user.login);
		type(By.name("password"), user.password);
		click(By.cssSelector("input.button"));
		
	}

	public String whoIsLogged() {
		WebElement element = findElement(By.cssSelector("td.login-info-left span"));
		return element.getText();
	}


}
