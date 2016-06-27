package pageObjects;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Results_page {
	private static Logger log = LogManager.getLogger(Results_page.class);
	private WebDriver driver;
	private WebDriverWait wait;
	private int timeout = 20;
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Constructor required for PageFactory with implicitWaits to poll DOM
	 * 
	 */
	public Results_page(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.driver = driver;
	}	
}
