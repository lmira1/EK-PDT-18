package com.example.fw;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ApplicationManager {
	
	private static ApplicationManager singleton;
	
	//private WebDriverHelper webDriverHelper;
	private Properties properties;
	private HibernateHelper hibernateHelper;
	private AccountHelper accountHelper;
	private MailHelper mailHelper;
	private JamesHelper jamesHelper;
	private WebDriver driver;
	public String baseURL;
	
	
	public static ApplicationManager getInstance() {
		if (singleton == null){
			singleton = new ApplicationManager();
		}
		return singleton;
	}

	
	/*public void start () throws IOException {
		getProcessHelper().startAppUnderTest();
	}*/
	
	/*public void stop() {
		if(webDriverHelper != null) {
			webDriverHelper.stop();
	}*/
		public void stop() {
			driver.quit();   
		}
		
	
	/*public WebDriverHelper getWebDriverHelper(){
		if(webDriverHelper == null) {
			webDriverHelper = new WebDriverHelper (this);
		}
		return webDriverHelper;
	}*/
	
	public HibernateHelper getHibernateHelper() {
		if (hibernateHelper == null) {
			hibernateHelper = new HibernateHelper(this);
		}
		return hibernateHelper;
		
	}
	
	
	public void setProperties (Properties properties){
		this.properties = properties;
	}
	
	public String getProperty (String key){
		return properties.getProperty(key);
	}
	
	public String getProperty (String key, String defaultValue){
		return properties.getProperty(key, defaultValue);
	}

	public AccountHelper getAccountHelper() {
		if (accountHelper == null) {
			accountHelper = new AccountHelper(this);
		}
		return accountHelper;
	}

	public MailHelper getMailHelper() {
		if (mailHelper == null) {
			mailHelper = new MailHelper(this);
		}
		return mailHelper;
		
	}

	public JamesHelper getJamesHelper() {
		if (jamesHelper == null) {
			jamesHelper = new JamesHelper(this);
		}
		return jamesHelper;
	}

	public WebDriver getDriver() {
		String browser = properties.getProperty("browser");
		if (driver == null) {
			if ("firefox".equals(browser)){
				driver = new FirefoxDriver();
			}else if ("ie".equals(browser)){
				driver = new InternetExplorerDriver();
			}else {
				throw new Error("Unsupported browser:" + browser);
			}
		    baseURL = properties.getProperty("baseURL");
		    driver.get(baseURL);
		}
		return driver;
	}

}
