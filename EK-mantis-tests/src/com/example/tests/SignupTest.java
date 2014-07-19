package com.example.tests;

import static org.testng.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.example.fw.JamesHelper;
import com.example.fw.User;

public class SignupTest extends TestBase {
	
	public User user = new User().setLogin("testuser1").setPassword("123").setEmail("testuser1@localhost");
	
	
	@BeforeClass
	public void createMailUser(){
		if(!app.getJamesHelper().doesUserExist(user.login)){
			app.getJamesHelper().createUser(user.login, user.password);
		}
	}
	@AfterClass
	public void deleteMailUser(){
		if(app.getJamesHelper().doesUserExist(user.login)){
			app.getJamesHelper().deleteUser(user.login);
		}
	}
	
	@Test
	public void newUserShouldSignup() {
		app.getAccountHelper().singup(user);
		app.getAccountHelper().login(user);
		assertThat (app.getAccountHelper().whoIsLogged().equalTo(user.login));
	}
	
	@Test
	public void existingUserShouldNotSignup() {
		try{
			app.getAccountHelper().singup(user);
		} catch (Exception e) {
			assertThat(e.getMessage(), containsString("That username is already being used"));
			return;
		} 
		fail("Exception expected");
	}	
}
