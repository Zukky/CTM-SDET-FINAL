package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import pageObjects.Supplier_page;
import support.Strings;

public class StepDefinitions {
	
	private WebDriver driver;
	private Supplier_page supplierPage;
@Before
public void Setup(){
	//remember to externalise these into a constants class
	System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(Strings.energyURL);
	supplierPage = PageFactory.initElements(driver, Supplier_page.class);
}

@After
public void tearDown(){
	
}
@Given("^I am successfully on Your Supplier page$")
public void i_am_on_your_supplier_page() throws Throwable {
	//supplierPage.verifyUserIsOnCorrectPage();
}


@Given("^my postcode is \"([^\"]*)\"$")
public void my_postcode_is(String postcode) throws Throwable {
 //  supplierPage.setWhatIsYourPostcode(postcode);
}

@Given("^I click on find postcode$")
public void i_click_on_find_postcode() throws Throwable {
 //   supplierPage.clickFindPostcodeButton();
}

@Given("^I do have my energy bill$")
public void i_do_have_my_energy_bill() throws Throwable {
    //supplierPage.clickIveGotMyBillRadioButton();
	supplierPage.clickIDontHaveMyBillButton();
	supplierPage.clickIveGotMyBillButton();
}
}
