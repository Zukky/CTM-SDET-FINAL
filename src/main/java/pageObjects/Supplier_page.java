package pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import support.Strings;

public class Supplier_page {

	private static Logger log = LogManager.getLogger(Supplier_page.class);
	private WebDriver driver;
	private WebDriverWait wait;
	private int timeout = 20;
	

    @FindBy(id = "your-postcode")
    @CacheLookup
    private WebElement whatIsYourPostcode_textbox;
    
	@FindBy(id = "find-postcode")
	@CacheLookup
	private WebElement findPostcode_button;
	
	@FindBy(id = "no-bill-label")
	@CacheLookup
	private WebElement iDontHaveMyBill_radioButton;
	
	@FindBy(id = "have-bill-label")
	@CacheLookup
	private WebElement iveGotMyBill_radioButton;
	
	@FindBy (id = "compare-both-label")
	@CacheLookup
	private WebElement gasAndElectricity_button;
	
	@FindBy (id = "compare-electricity-label")
	@CacheLookup
	private WebElement electricityOnly_button;
	
	@FindBy (id = "compare-gas-label")
	@CacheLookup
	private WebElement gasOnly_button;
	
	@FindBy (xpath = "//label[@for='same-supplier-yes']")
	@CacheLookup
	private WebElement yesTheyAreFromSameSupplier_radioButton;
	
	@FindBy (xpath = "//label[@for='same-supplier-no']")
	@CacheLookup
	private WebElement notFromSameSupplier_radioButton;
	
	@FindBy (xpath = "//label[@for='electricity-top-six-british-gas']")
	@CacheLookup
	private WebElement britishGas_electricity_button;
	
	@FindBy (xpath = "//label[@for='electricity-top-six-edf']")
	@CacheLookup
	private WebElement edfEnergy_electricity_button;
	
	@FindBy (xpath = "//label[@for='electricity-top-six-eon']")
	@CacheLookup
	private WebElement eon_electricity_button;
	
	@FindBy (xpath = "//label[@for='electricity-top-six-npower']")
	@CacheLookup
	private WebElement nPower_electricity_button;
	
	@FindBy (xpath = "//label[@for='electricity-top-six-scottish-power']")
	@CacheLookup
	private WebElement scottishPower_electricity_button;
	
	@FindBy (xpath = "//label[@for='electricity-top-six-sse']")
	@CacheLookup
	private WebElement sse_electricity_button;
	
/*	@FindBy (xpath = "//*[@id='same-supplier-no']/parent::label")
	@CacheLookup
	private WebElement NotFromSameSupplier_class;
*/
	@FindBy (id = "electricity-supplier-dropdown-control")
	@CacheLookup
	private WebElement dropDownElectricity;
	
	@FindBy (xpath = "//label[@for='gas-top-six-british-gas']")
	@CacheLookup
	private WebElement britishGas_gas_button;
	
	@FindBy (xpath = "//label[@for='gas-top-six-edf']")
	@CacheLookup
	private WebElement edfEnergy_gas_button;
	
	@FindBy (xpath = "//label[@for='gas-top-six-eon']")
	@CacheLookup
	private WebElement eon_gas_button;
	
	@FindBy (xpath = "//label[@for='gas-top-six-npower']")
	@CacheLookup
	private WebElement nPower_gas_button;
	
	@FindBy (xpath = "//label[@for='gas-top-six-scottish-power']")
	@CacheLookup
	private WebElement scottishPower_gas_button;
	
	@FindBy (xpath = "//label[@for='gas-top-six-sse']")
	@CacheLookup
	private WebElement sse_gas_button;
	
	@FindBy (id = "gas-supplier-dropdown-control")
	@CacheLookup
	private WebElement dropDownGas;
	
	@FindBy (id = "goto-your-supplier-details")
	@CacheLookup
	private WebElement next_button;



	/**
	 * Verify that the current URL matches with the expected URL (found in Strings.java)
	 * 
	 * @return this Supplier_page class instance.
	 */
	public Supplier_page verifyUserIsOnCorrectPage(){
		wait = new WebDriverWait(driver, timeout);
		if (wait.until(ExpectedConditions.urlToBe(Strings.expectedBaseURL)) == true){
			log.info("Page URL matches with expected Your Supplier URL. User is successfully on the Your Supplier page.");
		}
		return this;
		
	}
	
	/**
	 * Set value to What Is Your Postcode text field.
	 * 
	 * @param whatIsYourPostcodeValue
	 * @return this Supplier_page class instance.
	 */
	public Supplier_page setWhatIsYourPostcode(String whatIsYourPostcodeValue) {
		whatIsYourPostcode_textbox.clear();
		whatIsYourPostcode_textbox.sendKeys(whatIsYourPostcodeValue);
		log.info("Postcode: " + whatIsYourPostcodeValue + " has successfully been entered into postcode textbox.");
		return this;
		
	}
	
	/**
	 * Click on Find Postcode Button.
	 * 
	 * @return this Supplier_page class instance.
	 */
	public Supplier_page clickFindPostcode() {
		findPostcode_button.click();
		log.info("Find Postcode button has been clicked.");
		
		wait = new WebDriverWait(driver, timeout);
		WebElement checkIfNextPartIsVisible = wait.until(ExpectedConditions.visibilityOf(yesTheyAreFromSameSupplier_radioButton));
		
		if (checkIfNextPartIsVisible.isDisplayed()) {
			log.info("Next set of questions are visible to user. Continuing tests.");
		} 
		return this;
	}
	
	/**
	 * Click on I Don't Have My Bill button
	 * 
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickIDontHaveMyBill(){
    	String isCheckedPresentInClass = iDontHaveMyBill_radioButton.getAttribute("class");
    	
    	if (isCheckedPresentInClass.equalsIgnoreCase("checked")) {
    		log.info("'I Don't Have My Bill' button is already selected. Skipping step.");
    	} else {
    	    iDontHaveMyBill_radioButton.click();
    	    log.info("'I Don't Have My Bill' clicked.");
    	}
    return this;
    }
    
	/**
	 * Click on I've Got My Bill button
	 * 
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickIveGotMyBill(){
    	String isCheckedPresentInClass = iveGotMyBill_radioButton.getAttribute("class");
    	
    	if (isCheckedPresentInClass.equalsIgnoreCase("checked")) {
    		log.info("'I've Got My Bill' button is already selected. Skipping step.");
    	} else {
    	    iveGotMyBill_radioButton.click();
    	    log.info("'I've Got My Bill' clicked.");
    	}
        return this;
        }
    
	/**
	 * Click on Gas & Electricity button
	 * 
	 * @return this Supplier_page class instance.
	 */	
    public Supplier_page clickGasAndElectricity(){
    	String isCheckedPresentInClass = gasAndElectricity_button.getAttribute("class");
    	
    	if (isCheckedPresentInClass.equalsIgnoreCase("checked")) {
    		log.info("'Gas & Electricity' is already selected. Skipping step.");
    	} else {
    		gasAndElectricity_button.click();
    		log.info("'Gas & Electricity' button clicked.");
    	}
    	return this;
    }
    
	/**
	 * Click on Electricity Only button
	 * 
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickElectricityOnly(){
    	String isCheckedPresentInClass = electricityOnly_button.getAttribute("class");
    	
    	if (isCheckedPresentInClass.equalsIgnoreCase("checked")) {
    		log.info("'Electricity Only' is already selected. Skipping step.");
    	} else {
    		electricityOnly_button.click();
    		log.info("'Electricity Only' clicked.");
    	}
    	return this;
    }
    
	/**
	 * Click on Gas Only button
	 * 
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickGasOnly(){
    	String isCheckedPresentInClass = gasOnly_button.getAttribute("class");
    	
    	if (isCheckedPresentInClass.equalsIgnoreCase("checked")) {
    		log.info("'Gas Only' is already selected. Skipping step.");
    	} else {
    		gasOnly_button.click();
    		log.info("'Gas Only' clicked.");
    	}
    	return this;
    }
    
	/**
	 * Click on Yes they are from the same supplier checkbox
	 * 
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickYesForGasAndElectricitySuppliers(){
    	String isCheckedPresentInClass = yesTheyAreFromSameSupplier_radioButton.getAttribute("class");
    	log.info(isCheckedPresentInClass);
    	if (isCheckedPresentInClass.equalsIgnoreCase("checked")) {
    		log.info("'Yes' radio button is already selected. Skipping step.");
    	} else {
    		yesTheyAreFromSameSupplier_radioButton.click();
    		log.info("'Yes' radio button clicked. User has the same supplier for Gas and Electricity.");
    	}
    	return this;
    }
    
	/**
	 * Click on No they are not from the same supplier checkbox
	 * 
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickNoForGasAndElectricitySuppliers(){
    	String isCheckedPresentInClass = notFromSameSupplier_radioButton.getAttribute("class");
    	if (isCheckedPresentInClass.equalsIgnoreCase("checked")) {
    		log.info("'No' radio button is already selected. Skipping step.");
    	} else {
			notFromSameSupplier_radioButton.click();
    		log.info("'No' radio button clicked. User has different suppliers for Gas and Electricity.");
    	}

    	return this;
    }
    
	/**
	 * Click on British Gas button for Electricity
	 * 
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickBritishGasForElectricity(){
    	String isCheckedPresentInClass = britishGas_electricity_button.getAttribute("class");
    	if (isCheckedPresentInClass.contains("checked")) {
    		log.info("'British Gas' is already selected. Skipping step.");
    	} else {
			britishGas_electricity_button.click();
    		log.info("'British Gas' radio button clicked.");
    	}

    	return this;
    }
    
	/**
	 * Click on EDF Energy button for Electricity
	 * 
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickEDFEnergyForElectricity(){
    	String isCheckedPresentInClass = edfEnergy_electricity_button.getAttribute("class");
    	if (isCheckedPresentInClass.contains("checked")) {
    		log.info("'EDF Energy' is already selected. Skipping step.");
    	} else {
			edfEnergy_electricity_button.click();
    		log.info("'EDF Energy' radio button clicked.");
    	}

    	return this;
    }
    
	/**
	 * Click on E-ON button for Electricity.
	 * 
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickEONForElectricity(){
    	String isCheckedPresentInClass = eon_electricity_button.getAttribute("class");
    	if (isCheckedPresentInClass.contains("checked")) {
    		log.info("'E-ON' is already selected. Skipping step.");
    	} else {
			eon_electricity_button.click();
    		log.info("'E-ON' radio button clicked.");
    	}

    	return this;
    }
    
	/**
	 * Click on NPOWER button for Electricity
	 * 
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickNPOWERForElectricity(){
    	String isCheckedPresentInClass = nPower_electricity_button.getAttribute("class");
    	if (isCheckedPresentInClass.contains("checked")) {
    		log.info("'NPOWER' is already selected. Skipping step.");
    	} else {
			nPower_electricity_button.click();
    		log.info("'NPOWER' radio button clicked.");
    	}

    	return this;
    }
    
	/**
	 * Click on Scottish Power button for Electricity
	 * 
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickScottishPowerForElectricity(){
    	String isCheckedPresentInClass = scottishPower_electricity_button.getAttribute("class");
    	if (isCheckedPresentInClass.contains("checked")) {
    		log.info("'Scottish Power' is already selected. Skipping step.");
    	} else {
			scottishPower_electricity_button.click();
    		log.info("'Scottish Power' radio button clicked.");
    	}

    	return this;
    }
    
	/**
	 * Click on SSE button for Electricity
	 * 
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickSSEForElectricity(){
    	String isCheckedPresentInClass = sse_electricity_button.getAttribute("class");
    	if (isCheckedPresentInClass.contains("checked")) {
    		log.info("'SSE' is already selected. Skipping step.");
    	} else {
			sse_electricity_button.click();
    		log.info("'SSE' radio button clicked.");
    	}

    	return this;
    }
    
	/**
	 * Click and select set user value for electricity Other Supplier dropdown
	 * 
	 * @param otherSupplierValue
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page setElectricityOtherSupplierDropdown(String otherSupplierValue){
    	
    	//Click on electricity Other Supplier dropdown so it is in view.
    	dropDownElectricity.click();
    	
    	//Create a List for all of the <li> elements under <div id = sel1_chosen>. Which is where all of the other suppliers are stored.
    	List<WebElement> listOfLi = driver.findElement(By.xpath("//*[@id='sel1_chosen']/div/ul")).findElements(By.tagName("li"));

    	//Instantiate an Array to store all of the <li> elements (other suppliers) so we can refer to them later.
    	String[] liListArray = new String[50];
    	
    	//Create a for loop to iterate through each <li> (other suppliers) and get the text value of it. Starting from 1.
    	for(int i=1; i<listOfLi.size(); i++) {
    		
    		//Create a web element that points to specific <li> (other supplier), add the 'i' into <li> so it can iterate to each one until i < all <li> (other suppliers) elements
    		WebElement liList = driver.findElement(By.xpath("//*[@id='sel1_chosen']/div/ul/li[" + i + "]"));
    		
    		//Get all the values of the <li> (other supplier i.e. Affect Energy etc..) and store it into a string.
    		String eachSupplier = liList.getText();
    		
    		//Add each value of <li> (other suppliers) into an Array, starting from 0 (i-1 because i equals 1 due to <li> starts from 1 and array starts from 0).
    		liListArray[i-1] = eachSupplier;
    	}
    	
    	try {
        	//Pass the String parameter from Cucumber file and locate the index number of the string using our stored Array.
        	int conversionArray = Arrays.asList(liListArray).indexOf(otherSupplierValue);
        	
        	//If the array index that is returned is lower than 0 (which is true when a value that doesn't exist in the array is trying to be selected, it turns into -1). Then it is printed to tell the user to change the value from Cucumber.
        	if (conversionArray < 0) {
        		log.info(otherSupplierValue + " is not found! Please write a value that exists!");
        	} else {
            	//Use the index number that has been located and give it to WebElement. Click the WebElement.
            	listOfLi.get(conversionArray).click();
            	log.info(otherSupplierValue + " has been selected.");
        	}
    	}
    	 catch (ArrayIndexOutOfBoundsException e) {
     		log.error(e);
     	}  	
    	return this;
    }
    
	/**
	 * Click on British Gas button for Gas
	 * 
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickBritishGasForGas(){
    	String isCheckedPresentInClass = britishGas_gas_button.getAttribute("class");
    	if (isCheckedPresentInClass.contains("checked")) {
    		log.info("'British Gas' is already selected. Skipping step.");
    	} else {
			britishGas_gas_button.click();
    		log.info("'British Gas' radio button clicked.");
    	}

    	return this;
    }
    
	/**
	 * Click on EDF Energy button for Gas
	 * 
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickEDFEnergyForGas(){
    	String isCheckedPresentInClass = edfEnergy_gas_button.getAttribute("class");
    	if (isCheckedPresentInClass.contains("checked")) {
    		log.info("'EDF Energy' is already selected. Skipping step.");
    	} else {
			edfEnergy_gas_button.click();
    		log.info("'EDF Energy' radio button clicked.");
    	}

    	return this;
    }
    
	/**
	 * Click on E-ON button for Gas
	 * 
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickEONForGas(){
    	String isCheckedPresentInClass = eon_gas_button.getAttribute("class");
    	if (isCheckedPresentInClass.contains("checked")) {
    		log.info("'E-ON' is already selected. Skipping step.");
    	} else {
			eon_gas_button.click();
    		log.info("'E-ON' radio button clicked.");
    	}

    	return this;
    }
    
	/**
	 * Click on NPOWER button for Gas
	 * 
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickNPOWERForGas(){
    	String isCheckedPresentInClass = nPower_gas_button.getAttribute("class");
    	if (isCheckedPresentInClass.contains("checked")) {
    		log.info("'NPOWER' is already selected. Skipping step.");
    	} else {
			nPower_gas_button.click();
    		log.info("'NPOWER' radio button clicked.");
    	}

    	return this;
    }
    
	/**
	 * Click on Scottish Power button for Gas
	 * 
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickScottishPowerForGas(){
    	String isCheckedPresentInClass = scottishPower_gas_button.getAttribute("class");
    	if (isCheckedPresentInClass.contains("checked")) {
    		log.info("'Scottish Power' is already selected. Skipping step.");
    	} else {
			scottishPower_gas_button.click();
    		log.info("'Scottish Power' radio button clicked.");
    	}

    	return this;
    }
    
	/**
	 * Click on SSE button for Gas
	 * 
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickSSEForGas(){
    	String isCheckedPresentInClass = sse_gas_button.getAttribute("class");
    	if (isCheckedPresentInClass.contains("checked")) {
    		log.info("'SSE' is already selected. Skipping step.");
    	} else {
			sse_gas_button.click();
    		log.info("'SSE' radio button clicked.");
    	}

    	return this;
    }
    
	/**
	 * Click and select set user value for gas Other Supplier dropdown
	 * 
	 * @param otherSupplierValue
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page setGasOtherSupplierDropdown(String otherSupplierValue){
    	
    	//Click on gas Other Supplier dropdown so it is in view.
    	dropDownGas.click();
    	
    	//Create a List for all of the <li> elements under <div id = sel1_chosen>. Which is where all of the other suppliers are stored.
    	List<WebElement> listOfLi = driver.findElement(By.xpath("//*[@id='sel2_chosen']/div/ul")).findElements(By.tagName("li"));

    	//Instantiate an Array to store all of the <li> elements (other suppliers) so we can refer to them later.
    	String[] liListArray = new String[50];
    	
    	//Create a for loop to iterate through each <li> (other suppliers) and get the text value of it. Starting from 1.
    	for(int i=1; i<listOfLi.size(); i++) {
    		
    		//Create a web element that points to specific <li> (other supplier), add the 'i' into <li> so it can iterate to each one until i < all <li> (other suppliers) elements
    		WebElement liList = driver.findElement(By.xpath("//*[@id='sel2_chosen']/div/ul/li[" + i + "]"));
    		
    		//Get all the values of the <li> (other supplier i.e. Affect Energy etc..) and store it into a string.
    		String eachSupplier = liList.getText();
    		
    		//Add each value of <li> (other suppliers) into an Array, starting from 0 (i-1 because i equals 1 due to <li> starts from 1 and array starts from 0).
    		liListArray[i-1] = eachSupplier;
    	}
    	

    	try {
        	//Pass the String parameter from Cucumber file and locate the index number of the string using our stored Array.
        	int conversionArray = Arrays.asList(liListArray).indexOf(otherSupplierValue);
        	
           	//If the array index that is returned is lower than 0 (which is true when a value that doesn't exist in the array is trying to be selected, it turns into -1). Then it is printed to tell the user to change the value from Cucumber.
        	if (conversionArray < 0) {
        		log.info(otherSupplierValue + " is not found! Please write a value that exists!");
        	} else {
            	//Use the index number that has been located and give it to WebElement. Click the WebElement.
            	listOfLi.get(conversionArray).click();
            	log.info(otherSupplierValue + " has been selected.");
        	}
    	}
    	 catch (ArrayIndexOutOfBoundsException e) {
     		log.error(e);
     	}  	
    	return this;
    }
    
	/**
	 * Click on Next Button.
	 * 
	 * @return this Supplier_page class instance.
	 */
	public Supplier_page clickNextButton() {
		next_button.click();
		log.info("Next button has been clicked.");
		return this;
	}
	
	/**
	 * Verify that the current URL matches with the expected URL (found in Strings.java)
	 * 
	 * @return this Supplier_page class instance.
	 */
	public Supplier_page verifyUserIsOnYourEnergyPage(){
		wait = new WebDriverWait(driver, timeout);
		if (wait.until(ExpectedConditions.urlToBe(Strings.yourEnergyURL)) == true){
			log.info("Page URL matches with expected Your Energy URL. User is successfully on the Your Energy page.");
		}
		return this;
		
	}
	
    

	/**
	 * Constructor required for PageFactory with implicitWaits to poll DOM
	 * 
	 */
	public Supplier_page (WebDriver driver){
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		this.driver = driver;
	}

	
}
