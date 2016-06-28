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
import urls.URLs;


public class StepDefinitions {
	
	private WebDriver driver;
	private Supplier_page supplierPage;
	private Energy_page energyPage;
	private Preferences_page preferencesPage;
	private Results_page resultsPage;
	
@Before
public void Setup() throws InterruptedException{
	
	//Create a WebDriver for Chrome
	System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	
	//Maximise the window
	driver.manage().window().maximize();
	
	//Set browser to CTM URL
	driver.get(URLs.baseURL);
	
	//Initialise PageFactory pages
	supplierPage = PageFactory.initElements(driver, Supplier_page.class);
	energyPage = PageFactory.initElements(driver, Energy_page.class);
	preferencesPage = PageFactory.initElements(driver,Preferences_page.class);
	resultsPage = PageFactory.initElements(driver, Results_page.class);
}

@After
public void tearDown(){
	//Once finished, close window and quit the driver.
	driver.close();
	driver.quit();
}

/**
 * ---------------------------------
 * DECLARATIVE BUSINESS-READABLE-STYLE TESTS
 * ---------------------------------
 */

@Given("^Kiwi wants to compare Gas and Electricity prices and she does have her bill$")
public void kiwi_wants_to_compare_gas_and_electricity_prices_and_she_does_have_her_bill() {
	supplierPage.verifyUserIsOnYourSupplierPage();
    supplierPage.setWhatIsYourPostcode("PE2 6YS");
    supplierPage.clickFindPostcode();
    supplierPage.clickIveGotMyBill();
	supplierPage.clickGasAndElectricity();
    
}



@Given("^Kiwi enters her supplier, energy, preferences for both suppliers$")
public void kiwi_enters_her_supplier_energy_preferences_for_both_suppliers() {
	supplierPage.clickNoForGasAndElectricitySuppliers();
	supplierPage.clickEONForElectricity();
	supplierPage.clickScottishPowerForGas();
	supplierPage.clickNextButton();
	supplierPage.verifyUserIsOnCorrectYourEnergyPage();
	
	energyPage.setElectricityTariffDropdown("Fixed 2 Year");
	energyPage.clickYesForEconomy7Meter();
	energyPage.setHowDoYouPayForElectricity("Pay On Receipt Of Bill");
	energyPage.clickYesForElectricityMainSourceOfHeating();
	energyPage.clickKwHForCurrentElectricityUsage();
	energyPage.setEconomy7DayInKwh("500");
	energyPage.setElectricityUsedIfEconomy7IsSelectedDropdown("Annually");
	energyPage.setEconomy7NightInKwh("500");
	energyPage.clickNextButton();
	energyPage.verifyUserIsOnGasPage();
	
	energyPage.setWhatGasTariffAreYouOnDropdown("Fixed Price Energy June 2016");
	energyPage.setHowDoYouPayForYourGasDropdown("Monthly Direct Debit");
	energyPage.clickYesForGasMainSourceOfHeating();
	energyPage.click£ForCurrentGasUsage();
	energyPage.set£TextForGas(350);
	energyPage.set£ForGasDropdown("Annually");
	energyPage.clickNextButton();
	energyPage.verifyUserIsOnYourPreferencesPage();
	
	preferencesPage.clickVariableTariff();
	preferencesPage.clickQuarterlyDirectDebit();
	preferencesPage.setEmailAddress("CTM@ctm.com");
	preferencesPage.clickMarketingInformationCheckbox();
	preferencesPage.clickTermsAndConditionsCheckbox();
	preferencesPage.clickGotoPricesButton();
    
}

@Given("^Kiwi wants to compare only Gas prices and she doesn't have her bill$")
public void kiwi_wants_to_compare_only_Gas_prices_and_she_doesnt_have_her_bill() {
	supplierPage.verifyUserIsOnYourSupplierPage();
    supplierPage.setWhatIsYourPostcode("PE2 6YS");
    supplierPage.clickFindPostcode();
    supplierPage.clickIDontHaveMyBill();
    supplierPage.clickGasOnly();
    
}

@When("^Kiwi enters her supplier, energy, preferences for her gas supplier$")
public void kiwi_enters_her_supplier_energy_preferences_for_her_gas_supplier() {
    supplierPage.clickNPOWERForGas();
    supplierPage.clickNextButton();
    supplierPage.verifyUserIsOnCorrectYourEnergyPage();
    energyPage.clickYesForPrepaymentMeter();
    energyPage.setHowMuchDoYouSpendOnGas(500);
    energyPage.setHowMuchDoYouSpendOnGasDropdown("Quarterly");
    energyPage.clickNextButton();
    energyPage.verifyUserIsOnYourPreferencesPage();
    preferencesPage.clickAllTariff();
    preferencesPage.setEmailAddress("CTM@ctm.com");
    preferencesPage.clickMarketingInformationCheckbox();
    preferencesPage.clickTermsAndConditionsCheckbox();
    preferencesPage.clickGotoPricesButton();
}

@Given("^Kiwi wants to compare only Electricity prices and she does have her bill$")
public void kiwi_wants_to_compare_only_electricity_prices_and_she_does_have_her_bill() {
	supplierPage.verifyUserIsOnYourSupplierPage();
    supplierPage.setWhatIsYourPostcode("PE2 6YS");
    supplierPage.clickFindPostcode();
    supplierPage.clickIveGotMyBill();
    supplierPage.clickElectricityOnly();
    
}

@When("^Kiwi enters her supplier, energy, preferences for her electricity supplier$")
public void kiwi_enters_her_supplier_energy_preferences_for_her_electricity_supplier() {
    supplierPage.clickBritishGasForElectricity();
    supplierPage.clickNextButton();
    supplierPage.verifyUserIsOnCorrectYourEnergyPage();
    
    energyPage.setElectricityTariffDropdown("Fixed Price July 2018");
    energyPage.clickNoForEconomy7Meter();
    energyPage.setHowDoYouPayForElectricity("Prepayment Meter");
    energyPage.clickNoForElectricityMainSourceOfHeating();
    energyPage.click£ForCurrentElectricityUsage();
    energyPage.set£TextForElectricity(680);
    energyPage.set£DropdownForElectricity("Annually");
    energyPage.clickNextButton();
    energyPage.verifyUserIsOnYourPreferencesPage();
    
    preferencesPage.clickFixedTariff();
    preferencesPage.setEmailAddress("CTM@ctm.com");
    preferencesPage.clickTermsAndConditionsCheckbox();
    preferencesPage.clickGotoPricesButton();
	
}

@Then("^Kiwi will be shown a list of tariff results$")
public void kiwi_will_be_shown_a_list_of_tariff_results()  {
    preferencesPage.verifyUserIsOnYourResultsPage();
	resultsPage.waitForResults();

}

@Given("^Kiwi chooses cheapest tariff to view")
public void kiwi_chooses_cheapest_tariff_to_view(){
	resultsPage.clickMoreDetailsOnHighestSavingSupplier();
	resultsPage.verifyMoreDetailsInformationIsDisplayed();
	resultsPage.validateSwitchNowButton();
}
}

