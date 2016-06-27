package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.Energy_page;
import pageObjects.Preferences_page;
import pageObjects.Results_page;
import pageObjects.Supplier_page;
import support.URLs;


public class StepDefinitions {
	
	private WebDriver driver;
	private Supplier_page supplierPage;
	private Energy_page energyPage;
	private Preferences_page preferencesPage;
	private Results_page resultsPage;
@Before
public void Setup() throws InterruptedException{
	
	System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
	//System.setProperty("webdriver.ie.driver","Drivers\\IEDriverServer.exe");
	driver = new ChromeDriver();
	//driver = new FirefoxDriver();
	
	//driver.manage().window().maximize();
	//driver.manage().deleteAllCookies();
	driver.get(URLs.baseURL);
	supplierPage = PageFactory.initElements(driver, Supplier_page.class);
	energyPage = PageFactory.initElements(driver, Energy_page.class);
	preferencesPage = PageFactory.initElements(driver,Preferences_page.class);
	resultsPage = PageFactory.initElements(driver, Results_page.class);
}

@After
public void tearDown(){
}




}


