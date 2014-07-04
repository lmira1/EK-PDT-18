package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.example.fw.ApplicationManager;


public class TestBase {
	
	protected static ApplicationManager app;

	
	@BeforeClass
	@Parameters({"configFile"})
	public void setUp() throws Exception {
		String configFile = System.getProperty("configFile", "application.properties");
		Properties props = new Properties();
		props.load(new FileReader(configFile));
		
		//props.load(new FileReader(new File(configFile)));
		/*app = new ApplicationManager(properties);
		app.setProperties(props);
		*/
		app = ApplicationManager.getInstance(props);
		
		
	  }
	
	//@AfterTest
	public void tearDown() throws Exception {
		ApplicationManager.getInstance(null).stop();
	    
	}
}
	
	
  
 
