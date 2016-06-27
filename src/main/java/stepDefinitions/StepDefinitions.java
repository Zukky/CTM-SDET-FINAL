package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
public void Setup(){
	//remember to externalise these into a strings class
	System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	//driver.manage().window().maximize();
	driver.get(URLs.baseURL);
	supplierPage = PageFactory.initElements(driver, Supplier_page.class);
	energyPage = PageFactory.initElements(driver, Energy_page.class);
	preferencesPage = PageFactory.initElements(driver,Preferences_page.class);
	resultsPage = PageFactory.initElements(driver, Results_page.class);
}

@After
public void tearDown(){

	/*
	 * Supplier Page stepdefinitions
	 * 
	 */
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
	supplierPage.clickEDFEnergyForElectricity();

}
@Given("^I click on the electricity other supplier dropdown and select \"([^\"]*)\"$")
public void i_click_on_the_electricity_other_supplier_dropdown_and_select(String otherSupplierValue) throws Throwable {
	supplierPage.setElectricityOtherSupplierDropdown(otherSupplierValue);
}
@Given("^I click on EDF Energy as my gas supplier$")
public void i_click_on_EDF_Energy_as_my_gas_supplier() throws Throwable {
	supplierPage.clickNPOWERForGas();
}
@Given("^I click on the gas other supplier dropdown and select \"([^\"]*)\"$")
public void i_click_on_the_gas_other_supplier_dropdown_and_select(String otherSupplierValue) throws Throwable {
	supplierPage.setGasOtherSupplierDropdown(otherSupplierValue);
}
@When("^I click Next to continue$")
public void i_click_Next_to_continue() throws Throwable {
supplierPage.clickNextButton();
}

@Then("^I should move successfully onto Your Energy page$")
public void i_should_move_successfully_onto_Your_Energy_page() throws Throwable {
    supplierPage.verifyUserIsOnCorrectYourEnergyPage();
    
    energyPage.setElectricityTariff("Blue+Fixed Price January 2017" );
//energyPage.clickYesEconomy7Meter();
energyPage .clickNoEconomy7Meter();
energyPage .setHowDoYouPayForElectricity("Monthly Direct Debit");
energyPage .clickYesForElectricityMainSourceOfHeating();
energyPage .clickNoForElectricityMainSourceOfHeating();
//energyPage.clickKwHForCurrentElectricityUsage();
energyPage .click£ForCurrentElectricityUsage();
//energyPage.setKwHText_Eco7NotClicked(59);
energyPage .set£Text_Eco7NotClicked(5);
//energyPage.setKwhDropdown_Eco7NotChecked("Quarterly");
energyPage .set£Dropdown_Eco7NotChecked("Six monthly");
energyPage .setDateForBillDate("5");
energyPage .clickNextButton();
energyPage.verifyUserIsOnGasPage();
energyPage.setWhatGasTariffAreYouOnDropdown("Standard");
energyPage.setHowDoYouPayForYourGasDropdown("Monthly Direct Debit");
energyPage.clickNoForGasMainSourceOfHeating();
energyPage.clickKwHForCurrentGasUsage();
energyPage.setKwHTextForGas(100);
energyPage.setKwhForGasDropdown("Monthly");
energyPage.setDateForBillDateForGas("16");
energyPage.clickNextButton();
energyPage.verifyUserIsOnCorrectYourPreferencesPage();

preferencesPage.clickFixedTariff();
preferencesPage.clickVariableTariff();
preferencesPage.clickAllTariff();
preferencesPage.clickMonthlyDirectDebit();
preferencesPage.clickQuarterlyDirectDebit();
preferencesPage.clickPayOnReceiptOfBill();
preferencesPage.clickAllPaymentTypes();
preferencesPage.setEmailAddress("ctm_sdet@hotmail.com");
preferencesPage.clickMarketingInformationCheckbox();
preferencesPage.clickTermsAndConditionsCheckbox();
preferencesPage.clickGotoPricesButton();

}


}

