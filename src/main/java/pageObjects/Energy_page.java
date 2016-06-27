package pageObjects;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import support.URLs;

public class Energy_page {
	private static Logger log = LogManager.getLogger(Energy_page.class);
	private WebDriver driver;
	private WebDriverWait wait;
	private int timeout = 20;
	
	 /*
	 * 
	 * These are only visible if on "Your Supplier" page, "I've got my bill" is checked.
	 * 
	 */
	@FindBy (id = "electricity_tariff_additional_info_chosen")
    @CacheLookup
    private WebElement electricityTariff_dropdown;
	
	@FindBy (xpath = "//label[@for='economy-7-no']")
    @CacheLookup
    private WebElement noEconomy7_IHaveBill_radioButton;
	
	@FindBy (xpath = "//label[@for='economy-7-yes']")
    @CacheLookup
    private WebElement yesEconomy7_IHaveBill_radioButton;
	
	@FindBy (id = "electricity_payment_method_dropdown_link_chosen")
    @CacheLookup
    private WebElement electricityHowDoYouPay_dropdown;
	
	@FindBy (xpath = "//label[@for='electricity-main-heating-yes']")
    @CacheLookup
    private WebElement electricityMainSourceOfHeating_yes_radioButton;
	
	@FindBy (xpath = "//label[@for='electricity-main-heating-no']")
    @CacheLookup
    private WebElement electricityMainSourceOfHeating_no_radioButton;
	
	@FindBy (xpath = "//label[@for='kwhSpend']")
    @CacheLookup
    private WebElement kwh_radioButton;
	
	@FindBy (xpath = "//label[@for='poundSpend']")
    @CacheLookup
    private WebElement pound_radioButton;
	
	@FindBy (id = "electricity-usage")
    @CacheLookup
    private WebElement electricityUsageForKwh_textbox;
	
	@FindBy (id = "electricity_usage_dropdown_chosen")
    @CacheLookup
    private WebElement electricityUsageForKwh_dropdown;
	
	@FindBy (id = "electricity-spend")
    @CacheLookup
    private WebElement electricityUsageForPound_textbox;
	
	@FindBy (id = "electricity_spend_dropdown_chosen")
    @CacheLookup
    private WebElement electricityUsageForPound_dropdown;
	
	@FindBy (id = "electricity-bill-day")
    @CacheLookup
    private WebElement billDate_datepicker;
	
	/*
	 * These locators are only visible if "Do you have an economy 7 meter" is checked as "Yes".
	 * 
	 */
	@FindBy (id = "economy-7-day-usage")
    @CacheLookup
    private WebElement electricityUsedEconomy7KwhDAY_textbox;
	
	@FindBy (id = "economy-7-night-usage")
    @CacheLookup
    private WebElement electricityUsedEconomy7KwhNIGHT_textbox;
	
	@FindBy (id = "economy_7_day_usage_dropdown_chosen")
    @CacheLookup
    private WebElement electricityUsedEconomy7KwHDAY_dropdown;
	
	@FindBy (id = "economy_7_night_usage_dropdown_chosen")
    @CacheLookup
    private WebElement electricityUsedEconomy7KwhNIGHT_dropdown;	
	/*
	 * END
	 */
	
	 /*
	 * 
	 * These locators are only visible if on "Your Supplier" page, "I don't have my bill" is checked.
	 * 
	 */
	@FindBy (xpath = "//label[@for='prepayment-no']")
    @CacheLookup
    private WebElement noIDontUsePrepaymentMeter_radioButton;
	
	@FindBy (xpath = "//label[@for='prepayment-yes']")
    @CacheLookup
    private WebElement yesIUsePrepaymentMeter_radioButton;
	
	//Duplicate
	@FindBy (xpath = "//label[@for='economy-7-no']")
    @CacheLookup
    private WebElement noEconomy7_radioButton;

	//Duplicate
	@FindBy (xpath = "//label[@for='economy-7-yes']")
    @CacheLookup
    private WebElement yesEconomy7_radioButton;
	
	@FindBy (id = "electricity-current-spend")
    @CacheLookup
    private WebElement howMuchSpendOnElectricity_textbox;
	
	@FindBy (id = "electricity_current_spend_period_chosen")
    @CacheLookup
    private WebElement electricityPeriod_dropdown;
	
	@FindBy (id = "electricity-dont-know")
    @CacheLookup
    private WebElement iDontKnowElectricity_checkbox;
	
	@FindBy (id = "gas-current-spend")
    @CacheLookup
    private WebElement howMuchYouSpendOnGas_textbox;
	
	@FindBy (id = "gas_current_spend_period_chosen")
    @CacheLookup
    private WebElement gasPeriod_dropdown;
	
	@FindBy (xpath = "//label[@for='gas-dont-know']")
    @CacheLookup
    private WebElement iDontKnowGas_checkbox;
	
	/*
	 * END
	 */
	
	 /*
	 * 
	 * The locators for Gas screen (only visible if "I've Got My Bill" is selected)
	 * 
	 */
	
	@FindBy (id = "gas_tariff_additional_info_chosen")
    @CacheLookup
    private WebElement gasTariff_dropdown;
	
	@FindBy (id = "gas_payment_method_dropdown_link_chosen")
    @CacheLookup
    private WebElement howDoYouPayForGas_dropdown;
	
	@FindBy (xpath = "//label[@for='gas-main-heating-yes']")
    @CacheLookup
    private WebElement yesGasIsYourMainSourceOfHeating_radioButton;

	@FindBy (xpath = "//label[@for='gas-main-heating-no']")
    @CacheLookup
    private WebElement noGasIsNotMainSourceOfHeating_radioButton;

	@FindBy (xpath = "//label[@for='kwhSpendG']")
    @CacheLookup
    private WebElement currentGasUsagekWh_radioButton;

	@FindBy (xpath = "//label[@for='poundSpendG']")
    @CacheLookup
    private WebElement currentGasUsagePound_radioButton;
	
	@FindBy (id = "gas-usage")
    @CacheLookup
    private WebElement gasUsage_textbox;
	
	@FindBy (id = "type_of_Gas_bill_usage_dropdown_chosen")
    @CacheLookup
    private WebElement gasUsagePeriod_dropdown;
	
	@FindBy (id = "gas-spend")
    @CacheLookup
    private WebElement gasSpend_textbox;
	
	@FindBy (id = "type_of_Gas_bill_dropdown_chosen")
    @CacheLookup
    private WebElement gasSpendPeriod_dropdown;
	
	@FindBy (id = "gas-bill-day")
    @CacheLookup
    private WebElement gasDatePicker;
	
	/*
	 * END
	 */
		
	 /*
	 * 
	 * Generic locators - Next Button and Back Button
	 * 
	 */
	
	@FindBy (id = "goto-your-energy")
    @CacheLookup
    private WebElement next_button;
	
	@FindBy (id = "go-back")
    @CacheLookup
    private WebElement back_button;
	
	/*
	 * END
	 */
	
	/* *
	 * 
	 * Methods for "Your Energy" page, "I've got my bill" is checked.
	 * 
	 */
	
    /**
	 * Click and set "What electricity tariff are you on?" dropdown box
	 * 
	 * Pre-requisite:  Only use if on Supplier Page, "Do you have your bill handy?" is set to "I've got my bill".
	 * 
	 * @param dropdownValue
	 * @return this Energy_page class instance.
	 */
	public Energy_page setElectricityTariffDropdown(String dropdownValue){
    	//Click on dropdown so it is in view.
		electricityTariff_dropdown.click();
    	
    	//Create a List for all of the <li> elements under <div id>. Which is where all of the other values are stored.
    	List<WebElement> listOfLi = driver.findElement(By.xpath("//*[@id='electricity_tariff_additional_info_chosen']/div/ul")).findElements(By.tagName("li"));

    	//Instantiate an Array to store all of the <li> elements (values) so we can refer to them later. Create an array of string that has the size of all of the <li> elements.
    	String[] liListArray = new String[listOfLi.size()];
    	
    	//Create a for loop to iterate through each <li> (values) and get the text value of it. Starting from 1.
    	for(int i=1; i<=listOfLi.size(); i++) {
    		
    		//Create a web element that points to specific <li> (values), add the 'i' into <li> so it can iterate to each one until i < all <li> (other suppliers) elements
    		WebElement liList = driver.findElement(By.xpath("//*[@id='electricity_tariff_additional_info_chosen']/div/ul/li[" + i + "]"));
    		
    		//Get all the values of the <li> (values) and store it into a string.
    		String eachValue = liList.getText();
    		
    		//Add each value of <li> (other suppliers) into an Array, starting from 0 (i-1 because i equals 1 due to <li> starts from 1 and array starts from 0).
    		liListArray[i-1] = eachValue;
    	}
    	
    	try {
        	//Pass the String parameter from Cucumber file and locate the index number of the string using our stored Array.
        	int conversionArray = Arrays.asList(liListArray).indexOf(dropdownValue);
        	
           	//If the array index that is returned is lower than 0 (which is true when a value that doesn't exist in the array is trying to be selected, it turns into -1). Then it is printed to tell the user to change the value from Cucumber.	
        	if (conversionArray < 0) {
        		log.info(dropdownValue + " is not found! Please write a value that exists!");
        	} else {
            	//Use the index number that has been located and give it to WebElement. Click the WebElement.
            	listOfLi.get(conversionArray).click();
            	log.info(dropdownValue + " has been selected.");
        	}
    	}
    	 catch (ArrayIndexOutOfBoundsException e) {
     		log.error(e);
     	}  	
		return this;
	}
	
    /**
	 * Click Yes for "Do you have an Economy 7 meter?"
	 *
	 * Pre-requisite:  Only use if on Supplier Page, "Do you have your bill handy?" is set to "I've got my bill".
	 *
	 * @return this Energy_page class instance.
	 */
	public Energy_page clickYesEconomy7Meter() {
		//check if element is visible
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(yesEconomy7_IHaveBill_radioButton));
		
		//Check if it has been clicked already. If so, do not click. If not, then click.
		String isCheckedPresentInClass = yesEconomy7_IHaveBill_radioButton.getAttribute("class");
  
    	if (isCheckedPresentInClass.equalsIgnoreCase("checked")) {
    		log.info("'Yes' radio button is already selected. Skipping step.");
    	} else {
    		yesEconomy7_IHaveBill_radioButton.click();
    		log.info("'Yes' radio button clicked. User has Economy 7 meter.");
    	}
		return this;

	}
	
    /**
	 * Click No for "Do you have an Economy 7 meter?"
	 *
	 * Pre-requisite:  Only use if on Supplier Page, "Do you have your bill handy?" is set to "I've got my bill".
	 *
	 * @return this Energy_page class instance.
	 */	
	public Energy_page clickNoEconomy7Meter() {
		//check if element is visible
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(noEconomy7_IHaveBill_radioButton));
		
		//Check if it has been clicked already. If so, do not click. If not, then click.
		String isCheckedPresentInClass = noEconomy7_IHaveBill_radioButton.getAttribute("class");
  
    	if (isCheckedPresentInClass.equalsIgnoreCase("checked")) {
    		log.info("'No' radio button is already selected. Skipping step.");
    	} else {
    		noEconomy7_IHaveBill_radioButton.click();
    		log.info("'No' radio button clicked. User does not have Economy 7 meter.");
    	}
		return this;

	}
	
    /**
	 * Click and set "How do you pay for your electricity" dropdown box
	 * 
	 * Pre-requisite:  Only use if on Supplier Page, "Do you have your bill handy?" is set to "I've got my bill".
	 * 
	 * @param dropdownValue
	 * @return this Energy_page class instance.
	 */
	public Energy_page setHowDoYouPayForElectricity(String dropdownValue){
    	//Click on dropdown so it is in view.
		electricityHowDoYouPay_dropdown.click();
    	
    	//Create a List for all of the <li> elements under <div id>. Which is where all of the other values are stored.
    	List<WebElement> listOfLi = driver.findElement(By.xpath("//*[@id='electricity_payment_method_dropdown_link_chosen']/div/ul")).findElements(By.tagName("li"));

    	//Instantiate an Array to store all of the <li> elements (values) so we can refer to them later. Create an array of string that has the size of all of the <li> elements.
    	String[] liListArray = new String[listOfLi.size()];
    	
    	//Create a for loop to iterate through each <li> (values) and get the text value of it. Starting from 1.
    	for(int i=1; i<=listOfLi.size(); i++) {
    		
    		//Create a web element that points to specific <li> (values), add the 'i' into <li> so it can iterate to each one until i < all <li> (other suppliers) elements
    		WebElement liList = driver.findElement(By.xpath("//*[@id='electricity_payment_method_dropdown_link_chosen']/div/ul/li[" + i + "]"));
    		
    		//Get all the values of the <li> (values) and store it into a string.
    		String eachValue = liList.getText();
    		
    		//Add each value of <li> (other suppliers) into an Array, starting from 0 (i-1 because i equals 1 due to <li> starts from 1 and array starts from 0).
    		liListArray[i-1] = eachValue;
    	}
    	

    	try {
        	//Pass the String parameter from Cucumber file and locate the index number of the string using our stored Array.
    		int conversionArray = Arrays.asList(liListArray).indexOf(dropdownValue);
        	
           	//If the array index that is returned is lower than 0 (which is true when a value that doesn't exist in the array is trying to be selected, it turns into -1). Then it is printed to tell the user to change the value from Cucumber.
        	if (conversionArray == -1){
        		log.info(dropdownValue + " is not found! Please write a value that exists!");
        		Assert.fail();
        		
        	} else {
            	//Use the index number that has been located and give it to WebElement. Click the WebElement.
            	listOfLi.get(conversionArray).click();
            	log.info(dropdownValue + " has been selected."); 	
        	}
    	}
    	 catch (ArrayIndexOutOfBoundsException e) {
     		log.error(e);
     	}  	
		return this;
	}

    /**
	 * Click Yes for "Is electricity your main source of heating?"
	 * 
	 * Pre-requisite:  Only use if on Supplier Page, "Do you have your bill handy?" is set to "I've got my bill".
	 *
	 * @return this Energy_page class instance.
	 */	
	public Energy_page clickYesForElectricityMainSourceOfHeating() {
		//check if element is visible
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(electricityMainSourceOfHeating_yes_radioButton));
		
		//Check if it has been clicked already. If so, do not click. If not, then click.
		String isCheckedPresentInClass = electricityMainSourceOfHeating_yes_radioButton.getAttribute("class");
  
    	if (isCheckedPresentInClass.equalsIgnoreCase("checked")) {
    		log.info("'Yes' radio button is already selected. Skipping step.");
    	} else {
    		electricityMainSourceOfHeating_yes_radioButton.click();
    		log.info("'Yes' radio button clicked. User uses Electricity as main source of heating.");
    	}
		return this;

	}
	
    /**
	 * Click No for "Is electricity your main source of heating?"
	 * 
	 * Pre-requisite:  Only use if on Supplier Page, "Do you have your bill handy?" is set to "I've got my bill".
	 *
	 * @return this Energy_page class instance.
	 */	
	public Energy_page clickNoForElectricityMainSourceOfHeating() {
		//check if element is visible
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(electricityMainSourceOfHeating_no_radioButton));
		
		//Check if it has been clicked already. If so, do not click. If not, then click.
		String isCheckedPresentInClass = electricityMainSourceOfHeating_no_radioButton.getAttribute("class");
  
    	if (isCheckedPresentInClass.equalsIgnoreCase("checked")) {
    		log.info("'No' radio button is already selected. Skipping step.");
    	} else {
    		noEconomy7_IHaveBill_radioButton.click();
    		log.info("'No' radio button clicked. User does not use Electricity as main source of heating.");
    	}
		return this;

	}
	
    /**
	 * Click kWh for "What is your current electricity usage"?
	 * 
	 * Pre-requisite:  Only use if on Supplier Page, "Do you have your bill handy?" is set to "I've got my bill".
	 *
	 * @return this Energy_page class instance.
	 */	
	public Energy_page clickKwHForCurrentElectricityUsage() {
		//check if element is visible
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(kwh_radioButton));
		
		//Check if it has been clicked already. If so, do not click. If not, then click.
		String isCheckedPresentInClass = kwh_radioButton.getAttribute("class");
  
    	if (isCheckedPresentInClass.equalsIgnoreCase("checked")) {
    		log.info("'kWh' radio button is already selected. Skipping step.");
    	} else {
    		kwh_radioButton.click();
    		log.info("'kWh' radio button clicked. Users current electricity usage type is 'kWh'");
    		
    	}
		return this;

	}
	
    /**
	 * Click £ for "What is your current electricity usage"?
	 * 
	 * Pre-requisite:  Only use if on Supplier Page, "Do you have your bill handy?" is set to "I've got my bill".
	 *
	 * @return this Energy_page class instance.
	 */	
	public Energy_page click£ForCurrentElectricityUsage() {
		//check if element is visible
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(pound_radioButton));
		
		//Check if it has been clicked already. If so, do not click. If not, then click.
		String isCheckedPresentInClass = pound_radioButton.getAttribute("class");
  
    	if (isCheckedPresentInClass.equalsIgnoreCase("checked")) {
    		log.info("'£' radio button is already selected. Skipping step.");
    	} else {
    		pound_radioButton.click();
    		log.info("'£' radio button clicked. Users current electricity usage type is '£'");
    	}
		return this;

	}
	
    /**
	 * Set kWh text for "What is your current electricity usage?"
	 * (Economy 7 is NOT checked)
	 * 
	 * Pre-requisites: ONLY USE
	 * 1) If on Supplier Page, "Do you have your bill handy?" is set to "I've got my bill".
	 * 2) If on Energy Page, "Do you have an Economy 7 meter" is set to "No".
	 * 
	 * @return this Energy_page class instance.
	 */	
	public Energy_page setKwHText_Eco7NotClicked(int value) {
		//check if element is visible
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(electricityUsageForKwh_textbox));
		
		electricityUsageForKwh_textbox.clear();
		electricityUsageForKwh_textbox.sendKeys(""+value);
		log.info("kWh: " + value + " has successfully been entered into kWh textbox.");
		return this;

	}
	
    /**
	 * Click and set kWh dropdown box for "What is your current electricity usage?"
	 * (Economy 7 is NOT checked)
	 * 
	 * Pre-requisites: ONLY USE
	 * 1) If on Supplier Page, "Do you have your bill handy?" is set to "I've got my bill".
	 * 2) If on Energy Page, "Do you have an Economy 7 meter" is set to "No".
	 *
	 * @param dropdownValue
	 * @return this Energy_page class instance.
	 */	
	public Energy_page setKwhDropdown_Eco7NotChecked(String dropdownValue){
    	//Click on dropdown so it is in view.
		electricityUsageForKwh_dropdown.click();
    	
    	//Create a List for all of the <li> elements under <div id>. Which is where all of the other values are stored.
    	List<WebElement> listOfLi = driver.findElement(By.xpath("//*[@id='electricity_usage_dropdown_chosen']/div/ul")).findElements(By.tagName("li"));

    	//Instantiate an Array to store all of the <li> elements (values) so we can refer to them later. Create an array of string that has the size of all of the <li> elements.
    	String[] liListArray = new String[listOfLi.size()];
    	
    	//Create a for loop to iterate through each <li> (values) and get the text value of it. Starting from 1.
    	for(int i=1; i<=listOfLi.size(); i++) {
    		
    		//Create a web element that points to specific <li> (values), add the 'i' into <li> so it can iterate to each one until i < all <li> (other suppliers) elements
    		WebElement liList = driver.findElement(By.xpath("//*[@id='electricity_usage_dropdown_chosen']/div/ul/li[" + i + "]"));
    		
    		//Get all the values of the <li> (values) and store it into a string.
    		String eachValue = liList.getText();
    		
    		//Add each value of <li> (other suppliers) into an Array, starting from 0 (i-1 because i equals 1 due to <li> starts from 1 and array starts from 0).
    		liListArray[i-1] = eachValue;
    	}
    	

    	try {
        	//Pass the String parameter from Cucumber file and locate the index number of the string using our stored Array.
    		int conversionArray = Arrays.asList(liListArray).indexOf(dropdownValue);
        	
           	//If the array index that is returned is lower than 0 (which is true when a value that doesn't exist in the array is trying to be selected, it turns into -1). Then it is printed to tell the user to change the value from Cucumber.
        	if (conversionArray == -1){
        		log.info(dropdownValue + " is not found! Please write a value that exists!");
        		Assert.fail();
        		
        	} else {
            	//Use the index number that has been located and give it to WebElement. Click the WebElement.
            	listOfLi.get(conversionArray).click();
            	log.info(dropdownValue + " has been selected."); 	
        	}
    	}
    	 catch (ArrayIndexOutOfBoundsException e) {
     		log.error(e);
     	}  	
		return this;
	}
	
    /**
	 * Set £ text for "What is your current electricity usage?"
	 * (Economy 7 is NOT checked)
	 * 
	 * Pre-requisites: ONLY USE
	 * 1) If on Supplier Page, "Do you have your bill handy?" is set to "I've got my bill".
	 * 2) If on Energy Page, "Do you have an Economy 7 meter" is set to "No".
	 *
	 * @return this Energy_page class instance.
	 */	
	public Energy_page set£Text_Eco7NotClicked(int value) {
		//check if element is visible
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(electricityUsageForPound_textbox));

		electricityUsageForPound_textbox.clear();
		electricityUsageForPound_textbox.sendKeys(""+value);
	
		log.info("£: " + value + " has successfully been entered into £ textbox.");
		return this;

	}
	
    /**
	 * Click and set £ dropdown box for "What is your current electricity usage?"
	 * (Economy 7 is NOT checked)
	 * 
	 * Pre-requisites: ONLY USE
	 * 1) If on Supplier Page, "Do you have your bill handy?" is set to "I've got my bill".
	 * 2) If on Energy Page, "Do you have an Economy 7 meter" is set to "No".
	 *
	 * @param dropdownValue
	 * @return this Energy_page class instance.
	 */	
	public Energy_page set£Dropdown_Eco7NotChecked(String dropdownValue){
    	//Click on dropdown so it is in view.
		electricityUsageForPound_dropdown.click();
    	
    	//Create a List for all of the <li> elements under <div id>. Which is where all of the other values are stored.
    	List<WebElement> listOfLi = driver.findElement(By.xpath("//*[@id='electricity_spend_dropdown_chosen']/div/ul")).findElements(By.tagName("li"));
    	
    	//Instantiate an Array to store all of the <li> elements (values) so we can refer to them later. Create an array of string that has the size of all of the <li> elements.
    	String[] liListArray = new String[listOfLi.size()];
    	
    	//Create a for loop to iterate through each <li> (values) and get the text value of it. Starting from 1.
    	for(int i=1; i<=listOfLi.size(); i++) {
    		
    		//Create a web element that points to specific <li> (values), add the 'i' into <li> so it can iterate to each one until i < all <li> (other suppliers) elements
    		WebElement liList = driver.findElement(By.xpath("//*[@id='electricity_spend_dropdown_chosen']/div/ul/li[" + i + "]"));
    		
    		//Get all the values of the <li> (values) and store it into a string.
    		String eachValue = liList.getText();
    		
    		//Add each value of <li> (other suppliers) into an Array, starting from 0 (i-1 because i equals 1 due to <li> starts from 1 and array starts from 0).
    		liListArray[i-1] = eachValue;
    	}
    	
    	try {
    		
        	//Pass the String parameter from Cucumber file and locate the index number of the string using our stored Array.
    		int conversionArray = Arrays.asList(liListArray).indexOf(dropdownValue);
        	//log.info(conversionArray);
    		
           	//If the array index that is returned is lower than 0 (which is true when a value that doesn't exist in the array is trying to be selected, it turns into -1). Then it is printed to tell the user to change the value from Cucumber.
        	if (conversionArray < 0){
        		log.info(dropdownValue + " is not found! Please write a value that exists!");
        		Assert.fail();
        		
        	} else {
            	//Use the index number that has been located and give it to WebElement. Click the WebElement.
            	listOfLi.get(conversionArray).click();
            	log.info(dropdownValue + " has been selected."); 	
        	}
    	}
    	 catch (ArrayIndexOutOfBoundsException e) {
     		log.error(e);
     	}  	
		return this;
	}
	
	/**
	 *  Click Date picker and set day for bill date for Electricity (You can use this if kWh OR £ OR Economy 7 is selected, can be used for both).
	 * 
	 * Pre-requisites: ONLY USE
	 * 1) If on Supplier Page, "Do you have your bill handy?" is set to "I've got my bill".
	 * 2) If on Energy Page, dropdown boxes for "kWh" OR "£" OR "Economy 7" are NOT set to Annually
	 *
	 * @param dropdownValue
	 * @return this Energy_page class instance.
	 */	
	public Energy_page setDateForBillDate(String date){
		billDate_datepicker.click();
		List<WebElement> dates = driver.findElements(By.xpath("//*[@id='electricity-bill-day_table']/tbody//td"));
		
		int total_node = dates.size();
		
		for(int i=0; i<total_node;i++){
			String day = dates.get(i).getText();
			
			if(day.equals(date))
			{
				dates.get(i).click();
				break;
			}
			

		}
		billDate_datepicker.click();
		return this;

	}
	
	/*
	 * Methods for "Do you have an economy 7 meter" is checked as "Yes".
	 * 
	 */
	
    /**
	 * Set text to "Electricity used (Economy 7) day in kWh"
	 * 
	 * Pre-requisite: Only use if "Do you have an Economy 7 meter?" is checked to "Yes".
	 *
	 * @param value
	 * @return this Energy_page class instance.
	 */	
	public Energy_page setEconomy7DayInKwh(String value) {
		//check if element is visible
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(electricityUsedEconomy7KwhDAY_textbox));

		electricityUsedEconomy7KwhDAY_textbox.clear();
		electricityUsedEconomy7KwhDAY_textbox.sendKeys(value);
		log.info("Electricity used (Economy 7) day in kWh: " + value + " has successfully been entered into the textbox.");
		return this;

	}
	
    /**
	 * Set text to "Electricity used (Economy 7) night in kWh"
	 * 
	 * Pre-requisite: Only use if "Do you have an Economy 7 meter?" is checked to "Yes".
	 *
	 * @param value
	 * @return this Energy_page class instance.
	 */	
	public Energy_page setEconomy7NightInKwh(String value) {
		//check if element is visible
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(electricityUsedEconomy7KwhNIGHT_textbox));

		electricityUsedEconomy7KwhNIGHT_textbox.clear();
		electricityUsedEconomy7KwhNIGHT_textbox.sendKeys(value);
		log.info("Electricity used (Economy 7) night in kWh: " + value + " has successfully been entered into the textbox.");
		return this;

	}
	
	/**
	 * Click and set "electricity used (economy 7) day in kWh" dropdown box
	 * 
	 * Pre-requisite: Only use if "Do you have an Economy 7 meter?" is checked to "Yes".
	 *
	 * @param dropdownValue
	 * @return this Energy_page class instance.
	 */	
	public Energy_page setElectricityUsedIfEconomy7IsSelectedDropdown(String dropdownValue){
    	//Click on dropdown so it is in view.
		electricityUsedEconomy7KwHDAY_dropdown.click();
    	
    	//Create a List for all of the <li> elements under <div id>. Which is where all of the other values are stored.
    	List<WebElement> listOfLi = driver.findElement(By.xpath("//*[@id='economy_7_day_usage_dropdown_chosen']/div/ul")).findElements(By.tagName("li"));

    	//Instantiate an Array to store all of the <li> elements (values) so we can refer to them later. Create an array of string that has the size of all of the <li> elements.
    	String[] liListArray = new String[listOfLi.size()];
    	
    	//Create a for loop to iterate through each <li> (values) and get the text value of it. Starting from 1.
    	for(int i=1; i<=listOfLi.size(); i++) {
    		
    		//Create a web element that points to specific <li> (values), add the 'i' into <li> so it can iterate to each one until i < all <li> (other suppliers) elements
    		WebElement liList = driver.findElement(By.xpath("//*[@id='economy_7_day_usage_dropdown_chosen']/div/ul/li[" + i + "]"));
    		
    		//Get all the values of the <li> (values) and store it into a string.
    		String eachValue = liList.getText();
    		
    		//Add each value of <li> (other suppliers) into an Array, starting from 0 (i-1 because i equals 1 due to <li> starts from 1 and array starts from 0).
    		liListArray[i-1] = eachValue;
    	}
    	

    	try {
        	//Pass the String parameter from Cucumber file and locate the index number of the string using our stored Array.
    		int conversionArray = Arrays.asList(liListArray).indexOf(dropdownValue);
        	
           	//If the array index that is returned is lower than 0 (which is true when a value that doesn't exist in the array is trying to be selected, it turns into -1). Then it is printed to tell the user to change the value from Cucumber.
        	if (conversionArray == -1){
        		log.info(dropdownValue + " is not found! Please write a value that exists!");
        		Assert.fail();
        		
        	} else {
            	//Use the index number that has been located and give it to WebElement. Click the WebElement.
            	listOfLi.get(conversionArray).click();
            	log.info(dropdownValue + " has been selected."); 	
        	}
    	}
    	 catch (ArrayIndexOutOfBoundsException e) {
     		log.error(e);
     	}  	
		return this;
	}
	
    /*
    *
    * This is only visible if on "Your Supplier" page, "I don't have my bill" is checked.
    *
    */
    /**
	 * Click Yes for "Do you use a pre-payment meter?"
	 *
	 * Pre-requisite: Only use if on "Your Supplier" page for "Do you have your bill handy?" is set to "I don't have my bill checked".
	 *
	 * @return this Energy_page class instance.
	 */	
	public Energy_page clickYesForPrepaymentMeter() {
		//check if element is visible
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(yesIUsePrepaymentMeter_radioButton));
		
		//Check if it has been clicked already. If so, do not click. If not, then click.
		String isCheckedPresentInClass = yesIUsePrepaymentMeter_radioButton.getAttribute("class");
  
    	if (isCheckedPresentInClass.equalsIgnoreCase("checked")) {
    		log.info("'Yes' radio button is already selected. Skipping step.");
    	} else {
    		yesIUsePrepaymentMeter_radioButton.click();
    		log.info("'Yes' radio button clicked. User does use a prepayment meter.");
    	}
		return this;

	}
	
    /**
	 * Click No for "Do you use a pre-payment meter?"
	 * 
	 * Pre-requisite: Only use if on "Your Supplier" page for "Do you have your bill handy?" is set to "I don't have my bill checked".
	 *
	 * @return this Energy_page class instance.
	 */	
	public Energy_page clickNoForPrepaymentMeter() {
		//check if element is visible
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(noIDontUsePrepaymentMeter_radioButton));
		
		//Check if it has been clicked already. If so, do not click. If not, then click.
		String isCheckedPresentInClass = noIDontUsePrepaymentMeter_radioButton.getAttribute("class");
  
    	if (isCheckedPresentInClass.equalsIgnoreCase("checked")) {
    		log.info("'No' radio button is already selected. Skipping step.");
    	} else {
    		noIDontUsePrepaymentMeter_radioButton.click();
    		log.info("'No' radio button clicked. User does not use a prepayment meter.");
    	}
		return this;
	}
	
    /**
	 * Set text to "How much do you currently spend on electricity?"
	 * 
	 * Pre-requisite: Only use if on "Your Supplier" page for "Do you have your bill handy?" is set to "I don't have my bill checked".
	 *
	 * @param value
	 * @return this Energy_page class instance.
	 */	
	public Energy_page setHowMuchDoYouSpendOnElectricity(int value) {
		//check if element is visible
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(howMuchSpendOnElectricity_textbox));

		howMuchSpendOnElectricity_textbox.clear();
		howMuchSpendOnElectricity_textbox.sendKeys(""+value);
		log.info("How much do you currently spend on electricity: " + value + " has successfully been entered into the textbox.");
		return this;

	}
	
	/**
	 * Click and set "How much do you currently spend on electricity?" dropdown box
	 * 
	 * Pre-requisite: Only use if on "Your Supplier" page for "Do you have your bill handy?" is set to "I don't have my bill checked".
	 *
	 * @param dropdownValue
	 * @return this Energy_page class instance.
	 */	
	public Energy_page setHowMuchDoYouSpendOnElectricityDropdown(String dropdownValue){
    	//Click on dropdown so it is in view.
		electricityPeriod_dropdown.click();
    	
    	//Create a List for all of the <li> elements under <div id>. Which is where all of the other values are stored.
    	List<WebElement> listOfLi = driver.findElement(By.xpath("//*[@id='electricity_current_spend_period_chosen']/div/ul")).findElements(By.tagName("li"));

    	//Instantiate an Array to store all of the <li> elements (values) so we can refer to them later. Create an array of string that has the size of all of the <li> elements.
    	String[] liListArray = new String[listOfLi.size()];
    	
    	//Create a for loop to iterate through each <li> (values) and get the text value of it. Starting from 1.
    	for(int i=1; i<=listOfLi.size(); i++) {
    		
    		//Create a web element that points to specific <li> (values), add the 'i' into <li> so it can iterate to each one until i < all <li> (other suppliers) elements
    		WebElement liList = driver.findElement(By.xpath("//*[@id='electricity_current_spend_period_chosen']/div/ul/li[" + i + "]"));
    		
    		//Get all the values of the <li> (values) and store it into a string.
    		String eachValue = liList.getText();
    		
    		//Add each value of <li> (other suppliers) into an Array, starting from 0 (i-1 because i equals 1 due to <li> starts from 1 and array starts from 0).
    		liListArray[i-1] = eachValue;
    	}
    	

    	try {
        	//Pass the String parameter from Cucumber file and locate the index number of the string using our stored Array.
    		int conversionArray = Arrays.asList(liListArray).indexOf(dropdownValue);
        	
           	//If the array index that is returned is lower than 0 (which is true when a value that doesn't exist in the array is trying to be selected, it turns into -1). Then it is printed to tell the user to change the value from Cucumber.
        	if (conversionArray == -1){
        		log.info(dropdownValue + " is not found! Please write a value that exists!");
        		Assert.fail();
        		
        	} else {
            	//Use the index number that has been located and give it to WebElement. Click the WebElement.
            	listOfLi.get(conversionArray).click();
            	log.info(dropdownValue + " has been selected."); 	
        	}
    	}
    	 catch (ArrayIndexOutOfBoundsException e) {
     		log.error(e);
     	}  	
		return this;
	}
	
	/**
	 * Set text to "How much do you currently spend on gas?"
	 * 
	 * Pre-requisite: Only use if on "Your Supplier" page for "Do you have your bill handy?" is set to "I don't have my bill checked".
	 *
	 * @param value
	 * @return this Energy_page class instance.
	 */	
	public Energy_page setHowMuchDoYouSpendOnGas(int value) {
		//check if element is visible
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(howMuchYouSpendOnGas_textbox));

		howMuchYouSpendOnGas_textbox.clear();
		howMuchYouSpendOnGas_textbox.sendKeys(""+value);
		log.info("How much do you currently spend on gas: " + value + " has successfully been entered into the textbox.");
		return this;

	}
	
	/**
	 * Click and set "How much do you currently spend on gas?" dropdown box
	 * 
	 * Pre-requisite: Only use if on "Your Supplier" page for "Do you have your bill handy?" is set to "I don't have my bill checked".
	 *
	 * @param dropdownValue
	 * @return this Energy_page class instance.
	 */	
	public Energy_page setHowMuchDoYouSpendOnGasDropdown(String dropdownValue){
    	//Click on dropdown so it is in view.
		gasPeriod_dropdown.click();
    	
    	//Create a List for all of the <li> elements under <div id>. Which is where all of the other values are stored.
    	List<WebElement> listOfLi = driver.findElement(By.xpath("//*[@id='gas_current_spend_period_chosen']/div/ul")).findElements(By.tagName("li"));

    	//Instantiate an Array to store all of the <li> elements (values) so we can refer to them later. Create an array of string that has the size of all of the <li> elements.
    	String[] liListArray = new String[listOfLi.size()];
    	
    	//Create a for loop to iterate through each <li> (values) and get the text value of it. Starting from 1.
    	for(int i=1; i<=listOfLi.size(); i++) {
    		
    		//Create a web element that points to specific <li> (values), add the 'i' into <li> so it can iterate to each one until i < all <li> (other suppliers) elements
    		WebElement liList = driver.findElement(By.xpath("//*[@id='gas_current_spend_period_chosen']/div/ul/li[" + i + "]"));
    		
    		//Get all the values of the <li> (values) and store it into a string.
    		String eachValue = liList.getText();
    		
    		//Add each value of <li> (other suppliers) into an Array, starting from 0 (i-1 because i equals 1 due to <li> starts from 1 and array starts from 0).
    		liListArray[i-1] = eachValue;
    	}
    	

    	try {
        	//Pass the String parameter from Cucumber file and locate the index number of the string using our stored Array.
    		int conversionArray = Arrays.asList(liListArray).indexOf(dropdownValue);
        	
           	//If the array index that is returned is lower than 0 (which is true when a value that doesn't exist in the array is trying to be selected, it turns into -1). Then it is printed to tell the user to change the value from Cucumber.
        	if (conversionArray == -1){
        		log.info(dropdownValue + " is not found! Please write a value that exists!");
        		Assert.fail();
        		
        	} else {
            	//Use the index number that has been located and give it to WebElement. Click the WebElement.
            	listOfLi.get(conversionArray).click();
            	log.info(dropdownValue + " has been selected."); 	
        	}
    	}
    	 catch (ArrayIndexOutOfBoundsException e) {
     		log.error(e);
     	}  	
		return this;
	}
	
	/*
    *
    * Gas methods - when user is on Gas page (if "I've got my bill" selected in Your Supplier page)
    *
    */
	
	/**
	 * Click and set "What gas tariff are you on?" dropdown box
	 * 
	 * Pre-requisites: Only use if on "Your Supplier" page for "Do you have your bill handy?" is set to "I've got my bill".
	 *
	 * @param dropdownValue
	 * @return this Energy_page class instance.
	 */	
	public Energy_page setWhatGasTariffAreYouOnDropdown(String dropdownValue){
    	//Click on dropdown so it is in view.
		gasTariff_dropdown.click();
    	
    	//Create a List for all of the <li> elements under <div id>. Which is where all of the other values are stored.
    	List<WebElement> listOfLi = driver.findElement(By.xpath("//*[@id='gas_tariff_additional_info_chosen']/div/ul")).findElements(By.tagName("li"));

    	//Instantiate an Array to store all of the <li> elements (values) so we can refer to them later. Create an array of string that has the size of all of the <li> elements.
    	String[] liListArray = new String[listOfLi.size()];
    	
    	//Create a for loop to iterate through each <li> (values) and get the text value of it. Starting from 1.
    	for(int i=1; i<=listOfLi.size(); i++) {
    		
    		//Create a web element that points to specific <li> (values), add the 'i' into <li> so it can iterate to each one until i < all <li> (other suppliers) elements
    		WebElement liList = driver.findElement(By.xpath("//*[@id='gas_tariff_additional_info_chosen']/div/ul/li[" + i + "]"));
    		
    		//Get all the values of the <li> (values) and store it into a string.
    		String eachValue = liList.getText();
    		
    		//Add each value of <li> (other suppliers) into an Array, starting from 0 (i-1 because i equals 1 due to <li> starts from 1 and array starts from 0).
    		liListArray[i-1] = eachValue;
    	}
    	

    	try {
        	//Pass the String parameter from Cucumber file and locate the index number of the string using our stored Array.
    		int conversionArray = Arrays.asList(liListArray).indexOf(dropdownValue);
        	
           	//If the array index that is returned is lower than 0 (which is true when a value that doesn't exist in the array is trying to be selected, it turns into -1). Then it is printed to tell the user to change the value from Cucumber.
        	if (conversionArray == -1){
        		log.info(dropdownValue + " is not found! Please write a value that exists!");
        		Assert.fail();
        		
        	} else {
            	//Use the index number that has been located and give it to WebElement. Click the WebElement.
            	listOfLi.get(conversionArray).click();
            	log.info(dropdownValue + " has been selected."); 	
        	}
    	}
    	 catch (ArrayIndexOutOfBoundsException e) {
     		log.error(e);
     	}  	
		return this;
	}
	
	/**
	 * Click "How do you pay for your gas?" dropdown box
	 * 
	 * Pre-requisites: Only use if on "Your Supplier" page for "Do you have your bill handy?" is set to "I've got my bill".
	 *
	 * @param dropdownValue
	 * @return this Energy_page class instance.
	 */	
	public Energy_page setHowDoYouPayForYourGasDropdown(String dropdownValue){
    	//Click on dropdown so it is in view.
		howDoYouPayForGas_dropdown.click();
    	
    	//Create a List for all of the <li> elements under <div id>. Which is where all of the other values are stored.
    	List<WebElement> listOfLi = driver.findElement(By.xpath("//*[@id='gas_payment_method_dropdown_link_chosen']/div/ul")).findElements(By.tagName("li"));

    	//Instantiate an Array to store all of the <li> elements (values) so we can refer to them later. Create an array of string that has the size of all of the <li> elements.
    	String[] liListArray = new String[listOfLi.size()];
    	
    	//Create a for loop to iterate through each <li> (values) and get the text value of it. Starting from 1.
    	for(int i=1; i<=listOfLi.size(); i++) {
    		
    		//Create a web element that points to specific <li> (values), add the 'i' into <li> so it can iterate to each one until i < all <li> (other suppliers) elements
    		WebElement liList = driver.findElement(By.xpath("//*[@id='gas_payment_method_dropdown_link_chosen']/div/ul/li[" + i + "]"));
    		
    		//Get all the values of the <li> (values) and store it into a string.
    		String eachValue = liList.getText();
    		
    		//Add each value of <li> (other suppliers) into an Array, starting from 0 (i-1 because i equals 1 due to <li> starts from 1 and array starts from 0).
    		liListArray[i-1] = eachValue;
    	}
    	

    	try {
        	//Pass the String parameter from Cucumber file and locate the index number of the string using our stored Array.
    		int conversionArray = Arrays.asList(liListArray).indexOf(dropdownValue);
        	
           	//If the array index that is returned is lower than 0 (which is true when a value that doesn't exist in the array is trying to be selected, it turns into -1). Then it is printed to tell the user to change the value from Cucumber.
        	if (conversionArray == -1){
        		log.info(dropdownValue + " is not found! Please write a value that exists!");
        		Assert.fail();
        		
        	} else {
            	//Use the index number that has been located and give it to WebElement. Click the WebElement.
            	listOfLi.get(conversionArray).click();
            	log.info(dropdownValue + " has been selected."); 	
        	}
    	}
    	 catch (ArrayIndexOutOfBoundsException e) {
     		log.error(e);
     	}  	
		return this;
	}
	
	
	  /**
		 * Click Yes for "Is gas your main source of heating?"
		 * 
		 * Pre-requisites: Only use if on "Your Supplier" page for "Do you have your bill handy?" is set to "I've got my bill".
		 *
		 * @return this Energy_page class instance.
		 */	
		public Energy_page clickYesForGasMainSourceOfHeating() {
			//check if element is visible
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(yesGasIsYourMainSourceOfHeating_radioButton));
			
			//Check if it has been clicked already. If so, do not click. If not, then click.
			String isCheckedPresentInClass = yesGasIsYourMainSourceOfHeating_radioButton.getAttribute("class");
	  
	    	if (isCheckedPresentInClass.equalsIgnoreCase("checked")) {
	    		log.info("'Yes' radio button is already selected. Skipping step.");
	    	} else {
	    		yesGasIsYourMainSourceOfHeating_radioButton.click();
	    		log.info("'Yes' radio button clicked. User uses Gas as main source of heating.");
	    	}
			return this;

		}
		

	    /**
		 * Click No for "Is gas your main source of heating?"
		 * 
		 * Pre-requisites: Only use if on "Your Supplier" page for "Do you have your bill handy?" is set to "I've got my bill".
		 *
		 * @return this Energy_page class instance.
		 */	
		public Energy_page clickNoForGasMainSourceOfHeating() {
			//check if element is visible
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(noGasIsNotMainSourceOfHeating_radioButton));
			
			//Check if it has been clicked already. If so, do not click. If not, then click.
			String isCheckedPresentInClass = noGasIsNotMainSourceOfHeating_radioButton.getAttribute("class");
	  
	    	if (isCheckedPresentInClass.equalsIgnoreCase("checked")) {
	    		log.info("'No' radio button is already selected. Skipping step.");
	    	} else {
	    		noGasIsNotMainSourceOfHeating_radioButton.click();
	    		log.info("'No' radio button clicked. User does not use Gas as main source of heating.");
	    	}
			return this;

		}
		
		/**
		 * Click kWh for "What is your current gas usage?"
		 * 
		 * Pre-requisites: Only use if on "Your Supplier" page for "Do you have your bill handy?" is set to "I've got my bill".
		 *
		 * @return this Energy_page class instance.
		 */	
		public Energy_page clickKwHForCurrentGasUsage() {
			//check if element is visible
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(currentGasUsagekWh_radioButton));
			
			//Check if it has been clicked already. If so, do not click. If not, then click.
			String isCheckedPresentInClass = currentGasUsagekWh_radioButton.getAttribute("class");
	  
	    	if (isCheckedPresentInClass.equalsIgnoreCase("checked")) {
	    		log.info("'Gas' radio button is already selected. Skipping step.");
	    	} else {
	    		currentGasUsagekWh_radioButton.click();
	    		log.info("'kWh' radio button clicked. Users current Gas usage type is 'kWh'");
	    	}
			return this;

		}
		
	    /**
		 * Click £ for "What is your current gas usage?"
		 * 
		 * Pre-requisites: Only use if on "Your Supplier" page for "Do you have your bill handy?" is set to "I've got my bill".
		 *
		 * @return this Energy_page class instance.
		 */	
		public Energy_page click£ForCurrentGasUsage() {
			//check if element is visible
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(currentGasUsagePound_radioButton));
			
			//Check if it has been clicked already. If so, do not click. If not, then click.
			String isCheckedPresentInClass = currentGasUsagePound_radioButton.getAttribute("class");
	  
	    	if (isCheckedPresentInClass.equalsIgnoreCase("checked")) {
	    		log.info("'£' radio button is already selected. Skipping step.");
	    	} else {
	    		currentGasUsagePound_radioButton.click();
	    		log.info("'£' radio button clicked. Users current Gas usage type is '£'");
	    	}
			return this;

		}
		
	    /**
		 * Set text for "What is your current gas usage?" when kWh is clicked.
		 * 
		 * Pre-requisites: Only use if on "Your Supplier" page for "Do you have your bill handy?" is set to "I've got my bill".
		 *
		 * @return this Energy_page class instance.
		 */	
		public Energy_page setKwHTextForGas(int value) {
			//check if element is visible
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(gasUsage_textbox));
			
			gasUsage_textbox.clear();
			gasUsage_textbox.sendKeys(""+value);
			log.info("kWh: " + value + " has successfully been entered into kWh textbox.");
			return this;

		}
		
	    /**
		 * Click and set "What is your current gas usage?" dropdown box for kWh.
		 * 
		 * Pre-requisites: Only use if on "Your Supplier" page for "Do you have your bill handy?" is set to "I've got my bill".
		 *
		 * @param dropdownValue
		 * @return this Energy_page class instance.
		 */	
		public Energy_page setKwhForGasDropdown(String dropdownValue){
	    	//Click on dropdown so it is in view.
			gasUsagePeriod_dropdown.click();
	    	
	    	//Create a List for all of the <li> elements under <div id>. Which is where all of the other values are stored.
	    	List<WebElement> listOfLi = driver.findElement(By.xpath("//*[@id='type_of_Gas_bill_usage_dropdown_chosen']/div/ul")).findElements(By.tagName("li"));

	    	//Instantiate an Array to store all of the <li> elements (values) so we can refer to them later. Create an array of string that has the size of all of the <li> elements.
	    	String[] liListArray = new String[listOfLi.size()];
	    	
	    	//Create a for loop to iterate through each <li> (values) and get the text value of it. Starting from 1.
	    	for(int i=1; i<=listOfLi.size(); i++) {
	    		
	    		//Create a web element that points to specific <li> (values), add the 'i' into <li> so it can iterate to each one until i < all <li> (other suppliers) elements
	    		WebElement liList = driver.findElement(By.xpath("//*[@id='type_of_Gas_bill_usage_dropdown_chosen']/div/ul/li[" + i + "]"));
	    		
	    		//Get all the values of the <li> (values) and store it into a string.
	    		String eachValue = liList.getText();
	    		
	    		//Add each value of <li> (other suppliers) into an Array, starting from 0 (i-1 because i equals 1 due to <li> starts from 1 and array starts from 0).
	    		liListArray[i-1] = eachValue;
	    	}
	    	

	    	try {
	        	//Pass the String parameter from Cucumber file and locate the index number of the string using our stored Array.
	    		int conversionArray = Arrays.asList(liListArray).indexOf(dropdownValue);
	        	
	           	//If the array index that is returned is lower than 0 (which is true when a value that doesn't exist in the array is trying to be selected, it turns into -1). Then it is printed to tell the user to change the value from Cucumber.
	        	if (conversionArray == -1){
	        		log.info(dropdownValue + " is not found! Please write a value that exists!");
	        		Assert.fail();
	        		
	        	} else {
	            	//Use the index number that has been located and give it to WebElement. Click the WebElement.
	            	listOfLi.get(conversionArray).click();
	            	log.info(dropdownValue + " has been selected."); 	
	        	}
	    	}
	    	 catch (ArrayIndexOutOfBoundsException e) {
	     		log.error(e);
	     	}  	
			return this;
		}
		
		 /**
		 * Set text for "What is your current gas usage?" when £ is clicked.
		 *
		 * @return this Energy_page class instance.
		 */	
		public Energy_page set£TextForGas(int value) {
			//check if element is visible
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(gasSpend_textbox));

			gasSpend_textbox.clear();
			gasSpend_textbox.sendKeys(""+value);
			gasSpend_textbox.click();
			log.info("£: " + value + " has successfully been entered into £ textbox.");
			return this;

		}
		
		/**
		 * Click and set "What is your current gas usage?" dropdown box for £
		 * 
		 * Pre-requisites: Only use if on "Your Supplier" page for "Do you have your bill handy?" is set to "I've got my bill".
		 *
		 * @param dropdownValue
		 * @return this Energy_page class instance.
		 */	
		public Energy_page set£ForGasDropdown(String dropdownValue){
	    	//Click on dropdown so it is in view.
			gasSpendPeriod_dropdown.click();
	    	
	    	//Create a List for all of the <li> elements under <div id>. Which is where all of the other values are stored.
	    	List<WebElement> listOfLi = driver.findElement(By.xpath("//*[@id='type_of_Gas_bill_dropdown_chosen']/div/ul")).findElements(By.tagName("li"));

	    	//Instantiate an Array to store all of the <li> elements (values) so we can refer to them later. Create an array of string that has the size of all of the <li> elements.
	    	String[] liListArray = new String[listOfLi.size()];
	    	
	    	//Create a for loop to iterate through each <li> (values) and get the text value of it. Starting from 1.
	    	for(int i=1; i<=listOfLi.size(); i++) {
	    		
	    		//Create a web element that points to specific <li> (values), add the 'i' into <li> so it can iterate to each one until i < all <li> (other suppliers) elements
	    		WebElement liList = driver.findElement(By.xpath("//*[@id='type_of_Gas_bill_dropdown_chosen']/div/ul/li[" + i + "]"));
	    		
	    		//Get all the values of the <li> (values) and store it into a string.
	    		String eachValue = liList.getText();
	    		
	    		//Add each value of <li> (other suppliers) into an Array, starting from 0 (i-1 because i equals 1 due to <li> starts from 1 and array starts from 0).
	    		liListArray[i-1] = eachValue;
	    	}
	    	

	    	try {
	        	//Pass the String parameter from Cucumber file and locate the index number of the string using our stored Array.
	    		int conversionArray = Arrays.asList(liListArray).indexOf(dropdownValue);
	        	
	           	//If the array index that is returned is lower than 0 (which is true when a value that doesn't exist in the array is trying to be selected, it turns into -1). Then it is printed to tell the user to change the value from Cucumber.
	        	if (conversionArray == -1){
	        		log.info(dropdownValue + " is not found! Please write a value that exists!");
	        		Assert.fail();
	        		
	        	} else {
	            	//Use the index number that has been located and give it to WebElement. Click the WebElement.
	            	listOfLi.get(conversionArray).click();
	            	log.info(dropdownValue + " has been selected."); 	
	        	}
	    	}
	    	 catch (ArrayIndexOutOfBoundsException e) {
	     		log.error(e);
	     	}  	
			return this;
		}
		
		/**
		 * Click Date picker and set day for bill date for Gas (if kWh or £ is selected, can be used for both).
		 * 
		 * Pre-requisites: Only use if on "Your Supplier" page for "Do you have your bill handy?" is set to "I've got my bill".
		 *
		 * @param dropdownValue
		 * @return this Energy_page class instance.
		 */	
		public Energy_page setDateForBillDateForGas(String date){
			gasDatePicker.click();
			List<WebElement> dates = driver.findElements(By.xpath(".//*[@id='gas-bill-day_table']/tbody//td"));
			
			int total_node = dates.size();
			
			for(int i=0; i<total_node;i++){
				String day = dates.get(i).getText();
				
				if(day.equals(date))
				{
					dates.get(i).click();
					break;
				}
				

			}
			
			return this;
		}	
		
	/* *
	 * 
	 * Generic methods - Next button or Back button
	 * 
	 */

    /**
	 * Click Next Button
	 *
	 * @return this Energy_page class instance.
	 */	
	public Energy_page clickNextButton() {
		//check if element is visible
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(next_button));
		//click button
		next_button.click();
		log.info("Next button has been clicked.");
		return this;

	}
	
    /**
	 * Click Back Button
	 *
	 * @return this Energy_page class instance.
	 */	
	public Energy_page clickBackButton() {
		//check if element is visible
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(back_button));
		//click button
		back_button.click();
		log.info("Back button has been clicked.");
		return this;

	}
	
	/**
	 * Verify user is on the Gas page
	 * 
	 * @return this Supplier_page class instance.
	 */
	public Energy_page verifyUserIsOnGasPage(){
		wait = new WebDriverWait(driver, timeout);
		
		WebElement gasH2Value = driver.findElement(By.xpath("//h2[text() = 'Gas']"));
		
		log.info("Verifying if user is on the Gas page...");
		wait.until(ExpectedConditions.visibilityOf(gasH2Value)); 
		log.info("Success! User is on the Gas page.");
		return this;
	}
	
	/**
	 * Verify user is on the correct next page (Your Energy page -> Your Preferences page)
	 * 
	 * @return this Supplier_page class instance.
	 */
	public Energy_page verifyUserIsOnYourPreferencesPage(){
		wait = new WebDriverWait(driver, timeout);
 
		log.info("Verifying if user is on Your Preferences page...");
		wait.until(ExpectedConditions.urlToBe(URLs.yourPreferencesURL)); 
		log.info("Page URL expected: " + URLs.yourPreferencesURL + "\nActual: " + driver.getCurrentUrl() + "\nSuccess! User is successfully on the correct Your Preferences page.");
		return this;
	}
/*	public Energy_page fillElectricityDetails_ifEco7IsNotClicked(String electricityTariff, String howDoYouPayForYourElectricity, String electricityUsage, String setDayForBillDate){
		
		
		return this;
	}
	*/
    /**
	 * Constructor required for PageFactory with implicitWaits to poll DOM
	 * 
	 */
	public Energy_page (WebDriver driver){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.driver = driver;
	}

}

