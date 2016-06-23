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
	driver.get(Strings.baseURL);
	supplierPage = PageFactory.initElements(driver, Supplier_page.class);
}

@After
public void tearDown(){
	
}
@Given("^I am successfully on Your Supplier page$")
public void i_am_on_your_supplier_page() throws Throwable {
	supplierPage.verifyUserIsOnCorrectPage();
}


@Given("^my postcode is \"([^\"]*)\"$")
public void my_postcode_is(String postcode) throws Throwable {
  supplierPage.setWhatIsYourPostcode(postcode);
}

@Given("^I click on find postcode$")
public void i_click_on_find_postcode() throws Throwable {
   supplierPage.clickFindPostcode();
}

@Given("^I do have my energy bill$")
public void i_do_have_my_energy_bill() throws Throwable {
	supplierPage.clickIveGotMyBill();
}
@Given("^I want to compare Gas & Electricity prices$")
public void i_want_to_compare_Gas_and_Electricity_prices() throws Throwable {
	//Thread.sleep(5000);
    supplierPage.clickGasAndElectricity();
}
@Given("^I have different Gas & Electricity suppliers$")
public void i_have_different_gas_and_electricity_suppliers() throws Throwable {
    supplierPage.clickNoForGasAndElectricitySuppliers();
}

@Given("^I click on British Gas as my electricity supplier$")
public void i_click_on_British_Gas_as_my_electricity_supplier() throws Throwable {
	supplierPage.clickBritishGas();
}
}

