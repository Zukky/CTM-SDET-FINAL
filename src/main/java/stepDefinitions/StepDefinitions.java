package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.Supplier_page;
import support.Strings;


public class StepDefinitions {
	
	private WebDriver driver;
	private Supplier_page supplierPage;
@Before
public void Setup(){
	//remember to externalise these into a strings class
	System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	//driver.manage().window().maximize();
	driver.get(Strings.baseURL);
	supplierPage = PageFactory.initElements(driver, Supplier_page.class);
}

@After
public void tearDown(){
	
}
@Given("^I am successfully on Your Supplier page$")
public void i_am_on_your_supplier_page() {
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
    supplierPage.clickGasAndElectricity();
}
@Given("^I have different Gas & Electricity suppliers$")
public void i_have_different_gas_and_electricity_suppliers() throws Throwable {
    supplierPage.clickNoForGasAndElectricitySuppliers();
}

@Given("^I click on British Gas as my electricity supplier$")
public void i_click_on_British_Gas_as_my_electricity_supplier() throws Throwable {
	supplierPage.clickBritishGasForElectricity();

}
@Given("^I click on the electricity other supplier dropdown and select \"([^\"]*)\"$")
public void i_click_on_the_electricity_other_supplier_dropdown_and_select(String otherSupplierValue) throws Throwable {
	supplierPage.setElectricityOtherSupplierDropdown(otherSupplierValue);
}
@Given("^I click on EDF Energy as my gas supplier$")
public void i_click_on_EDF_Energy_as_my_gas_supplier() throws Throwable {
	supplierPage.clickEDFEnergyForGas();
}
@Given("^I click on the gas other supplier dropdown and select \"([^\"]*)\"$")
public void i_click_on_the_gas_other_supplier_dropdown_and_select(String otherSupplierValue) throws Throwable {
	supplierPage.setGasOtherSupplierDropdown(otherSupplierValue);
}
@When("^I click Next to continue$")
public void i_click_Next_to_continue() throws Throwable {
supplierPage.clickNextButton();
}

@Then("^I should move successfully onto Your Energy page")
public void i_should_move_successfully_onto_Your_Energy_page() throws Throwable {
	supplierPage.verifyUserIsOnYourEnergyPage();
}



}

