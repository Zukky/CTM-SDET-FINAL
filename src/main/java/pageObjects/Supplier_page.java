package pageObjects;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert;
import urls.URLs;

/**
* <h1>Your Supplier Page</h1>
* This page holds all elements and methods to those elements for Your Supplier webpage.
* 
* <p>
* <b>Note:</b> This is a Page Object Model design using PageFactory. 
* It allows us to have objects that we can interact with in a clean, neat and maintainable way.
* Methods and logic are all applied here. 
* 
* <p>
* <b>How it works:</b> Each method corresponds to a element on the webpage. For instance,
* if you want to click on a button, the button id, xpath, css, className, tagName, linktext, partialLinkText
* have been mapped to. All you have todo is call the method for that particular webelement and it will interact with it. 
* Javadoc comments have been applied to all public methods, just in case you don't understand what a method does. Remember, some of them
* have pre-requisites, please read them to ensure that those pre-requisites are fulfilled before invoking that method.
*
* 
*
* @author  Zukky Baig
* @version 1.0
* @since   2016-06-27
*/


public class Supplier_page {

	//Initialising the Logging tool Log4J2.
	private static Logger log = LogManager.getLogger(Supplier_page.class);
	
	private WebDriver driver;
	private WebDriverWait wait;
	private int timeout = 20;
	URLs stringClass = new URLs();

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
	
	@FindBy (xpath = "//label[@for='dual-top-six-british-gas']")
	@CacheLookup
	private WebElement britishGas_duel_button;
	
	@FindBy (xpath = "//label[@for='dual-top-six-edf']")
	@CacheLookup
	private WebElement edfEnergy_duel_button;
	
	@FindBy (xpath = "//label[@for='dual-top-six-eon']")
	@CacheLookup
	private WebElement eon_duel_button;
	
	@FindBy (xpath = "//label[@for='dual-top-six-npower']")
	@CacheLookup
	private WebElement npower_duel_button;
	
	@FindBy (xpath = "//label[@for='dual-top-six-scottish-power']")
	@CacheLookup
	private WebElement scottishPower_duel_button;
	
	@FindBy (xpath = "//label[@for='dual-top-six-sse']")
	@CacheLookup
	private WebElement sse_duel_button;
	
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
	
	@FindBy (id = "goto-your-supplier-details")
	@CacheLookup
	private WebElement next_button;
	
	@FindBy (id = "sel2")
	@CacheLookup
	private WebElement otherSupplierDropdownForGas;
	
	@FindBy (id = "sel1")
	@CacheLookup
	private WebElement otherSupplierDropdownForElectricity;
	
	@FindBy (id = "sel")
	@CacheLookup
	private WebElement otherSupplierDropdownForEnergy;


	/**
	 * Verify that the current URL matches with the expected URL and the user is on Your Supplier page (URLs.java).
	 * 
	 * @return this Supplier_page class instance.
	 */
	public Supplier_page verifyUserIsOnYourSupplierPage(){
		wait = new WebDriverWait(driver, timeout);
		if (wait.until(ExpectedConditions.urlToBe(URLs.expectedBaseURL)) == true){
			log.info("Page URL matches with expected Your Supplier URL. User is successfully on the Your Supplier page.");
		}
		return this;
		
	}
	
	/**
	 * Set text to "What is your postcode?" textbox.
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
	 * Click on "Find Postcode" button.
	 * 
	 * @return this Supplier_page class instance.
	 */
	public Supplier_page clickFindPostcode() {
		findPostcode_button.click();
		log.info("Find Postcode button has been clicked.");
		
		log.info("Waiting for the next part of journey to populate...");
		wait = new WebDriverWait(driver, timeout);
		WebElement checkIfNextPartIsVisible = wait.until(ExpectedConditions.visibilityOf(yesTheyAreFromSameSupplier_radioButton));
		
		if (checkIfNextPartIsVisible.isDisplayed()) {
			log.info("Next set of questions are visible to user. Continuing test..");
		} 
		return this;
	}
	
	/**
	 * Click on "I Don't Have My Bill" button for "Do you have your bill handy?". 
	 * 
	 * <p>
	 * <i>Sets URLchecker string value in URLs.java to "https:/~/v2/yourEnergyNoBill"</i> 
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickIDontHaveMyBill(){
    	String isCheckedPresentInClass = iDontHaveMyBill_radioButton.getAttribute("class");
    	
    	if (isCheckedPresentInClass.equalsIgnoreCase("checked")) {
    		log.info("'I Don't Have My Bill' button is already selected. Skipping step.");
    		
    	    stringClass.setURLtoYourEnergyNoBill();
    	    log.info("URL has been set to check for " + stringClass.URLcheck);
    	} else {
    	    iDontHaveMyBill_radioButton.click();
    	    log.info("'I Don't Have My Bill' clicked.");
    	    
    	    stringClass.setURLtoYourEnergyNoBill();
    	    log.info("URL has been set to check for " + stringClass.URLcheck);
    	}
    return this;
    }
    
	/**
	 * Click on "I've Got My Bill" button for "Do you have your bill handy?".
	 * 
	 * <p>
	 * <i>Sets URLchecker string value in URLs.java to "https:/~/v2/yourEnergy"</i>
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickIveGotMyBill(){
    	String isCheckedPresentInClass = iveGotMyBill_radioButton.getAttribute("class");
    	
    	if (isCheckedPresentInClass.equalsIgnoreCase("checked")) {
    		log.info("'I've Got My Bill' button is already selected. Skipping step.");
    		
    	    stringClass.setURLtoYourEnergyWithBill();
    	    log.info("URL has been set to check for " + stringClass.URLcheck);
    	} else {
    	    iveGotMyBill_radioButton.click();
    	    log.info("'I've Got My Bill' clicked.");
    	    
    	    stringClass.setURLtoYourEnergyWithBill();
    	    log.info("URL has been set to check for " + stringClass.URLcheck);
    	}
    	
        return this;
        }
    
	/**
	 * Click on "Gas & Electricity" button for "What do you want to compare?"
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
	 * Click on "Electricity Only" button for "What do you want to compare?"
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
	 * Click on "Gas Only" button for "What do you want to compare?"
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
	 * Click Yes for "Is your gas & electricity from the same supplier?"
	 * <p>
	 * <b>Pre-requisite:</b> "I've got my bill" must be checked to use this method.
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickYesForGasAndElectricitySuppliers(){
    	String isCheckedPresentInClass = yesTheyAreFromSameSupplier_radioButton.getAttribute("class");
    	if (isCheckedPresentInClass.equalsIgnoreCase("checked")) {
    		log.info("'Yes' radio button is already selected. Skipping step.");
    	} else {
    		yesTheyAreFromSameSupplier_radioButton.click();
    		log.info("'Yes' radio button clicked. User has the same supplier for Gas and Electricity.");
    	}
    	return this;
    }
    
	/**
	 * Click No for "Is your gas & electricity from the same supplier?"
	 * <p>
	 * <b>Pre-requisite:</b> "I've got my bill" must be checked to use this method.
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
    
    /*
     * If "Is your gas & electricity from the same supplier" is clicked as "No" then use these methods 
     * for next steps of journey.
     */
	/**
	 * Click on "British Gas" button for "Who supplies your electricity?"
	 * <p>
	 * <b>Pre-requisite:</b> Only use if "Is your gas & electricity from the same supplier" is clicked as "No".
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
	 * Click on "EDF Energy" button for "Who supplies your electricity?"
	 * <p>
	 * <b>Pre-requisite:</b> Only use if "Is your gas & electricity from the same supplier" is clicked as "No".
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
	 * Click on "E-ON" button for "Who supplies your electricity?"
	 * <p>
	 * <b>Pre-requisite:</b> Only use if "Is your gas & electricity from the same supplier" is clicked as "No".
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
	 * Click on "NPOWER" button for "Who supplies your electricity?"
	 * <p>
	 * <b>Pre-requisite:</b> Only use if "Is your gas & electricity from the same supplier" is clicked as "No".
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
	 * Click on "Scottish Power" button for "Who supplies your electricity?"
	 * <p>
	 * <b>Pre-requisite:</b> Only use <b>Pre-requisite:</b>s & electricity from the same supplier" is clicked as "No".
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
	 * Click on "SSE" button for "Who supplies your electricity?"
	 * <p>
	 * <b>Pre-requisite:</b> Only use if "Is your gas & electricity from the same supplier" is clicked as "No".
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
	 * Set "Who supplies your electricity?" dropdown box
	 * <p>
	 * <b>Pre-requisite:</b> Only use if "Is your gas & electricity from the same supplier" is clicked as "No".
	 * 
	 * @param dropdownValue
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page setElectricityOtherSupplierDropdown(String dropdownValue){
    	
    	//Initialise Select and point to the appropriate Select ID
    	Select select = new Select(otherSupplierDropdownForElectricity);
    	
    	//Creating the Javascript Executor interface object by type casting
    	JavascriptExecutor executor = (JavascriptExecutor)driver;
    	
    	//Find the Select ID and set it to visible
    	executor.executeScript("document.getElementById('sel1').style.display='block';");
    	
    	//Goto the Select ID and find the text associated to an option. Set it with user parameter.
    	try {
    	select.selectByVisibleText(dropdownValue);
    	
    	//log output.
    	log.info("'" + dropdownValue + "' drop down value has been selected.");
    	}
    	//If user enters in a wrong value. Then output to console and fail test.
    	catch (NoSuchElementException e) {
    		
    	log.info("'" + dropdownValue + "' does not exist! Please use a value that exists.");
    	Assert.fail();
    	}
    	return this;
    }
    
	/**
	 * Click on "British Gas" button for "Who supplies your gas?"
	 * <p>
	 * <b>Pre-requisite:</b> Only use if "Is your gas & electricity from the same supplier" is clicked as "No".
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
	 * Click on "EDF Energy" button for "Who supplies your gas?"
	 * <p>
	 * <b>Pre-requisite:</b> Only use if "Is your gas & electricity from the same supplier" is clicked as "No".
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
	 * Click on "E-ON" button for "Who supplies your gas?"
	 * <p>
	 * <b>Pre-requisite:</b> Only use if "Is your gas & electricity from the same supplier" is clicked as "No".
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
	 * Click on "NPOWER" button for "Who supplies your gas?"
	 * <p>
	 * <b>Pre-requisite:</b> Only use if "Is your gas & electricity from the same supplier" is clicked as "No".
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
	 * Click on "Scottish Power" button for "Who supplies your gas?"
	 * <p>
	 * <b>Pre-requisite:</b> Only use if "Is your gas & electricity from the same supplier" is clicked as "No".
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
	 * Click on "SSE" button for "Who supplies your gas?"
	 * <p>
	 * <b>Pre-requisite:</b> Only use if "Is your gas & electricity from the same supplier" is clicked as "No".
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
	 * Set "Who supplies your gas?" dropdown box
	 * <p>
	 * <b>Pre-requisite:</b> Only use if "Is your gas & electricity from the same supplier" is clicked as "No".
	 * 
	 * @param dropdownValue
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page setGasOtherSupplierDropdown(String dropdownValue){
    	
    	//Initialise Select and point to the appropriate Select ID
    	Select select = new Select(otherSupplierDropdownForGas);
    	
    	//Creating the Javascript Executor interface object by type casting
    	JavascriptExecutor executor = (JavascriptExecutor)driver;
    	
    	//Find the Select ID and set it to visible
    	executor.executeScript("document.getElementById('sel2').style.display='block';");
    	
    	//Goto the Select ID and find the text associated to an option. Set it with user parameter.
    	try {
    	select.selectByVisibleText(dropdownValue);
    	
    	//log output.
    	log.info("'" + dropdownValue + "' drop down value has been selected.");
    	}
    	//If user enters in a wrong value. Then output to console and fail test.
    	catch (NoSuchElementException e) {
    		
    	log.info("'" + dropdownValue + "' does not exist! Please use a value that exists.");
    	Assert.fail();
    	}
    	return this;
    }
    
    /**
	 * Click on "British Gas" button for "Who supplies your energy?"
	 * <p>
	 * <b>Pre-requisite:</b> Only use if "Is your gas & electricity from the same supplier" is clicked as "Yes".
	 * 
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickBritishGasForEnergy(){
    	String isCheckedPresentInClass = britishGas_duel_button.getAttribute("class");
    	if (isCheckedPresentInClass.contains("checked")) {
    		log.info("'British Gas' is already selected. Skipping step.");
    	} else {
    		britishGas_duel_button.click();
    		log.info("'British Gas' radio button clicked.");
    	}

    	return this;
    }
    
    /**
	 * Click on "EDF Energy" button for "Who supplies your energy?"
	 * <p>
	 * <b>Pre-requisite:</b> Only use if "Is your gas & electricity from the same supplier" is clicked as "Yes".
	 * 
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickEDFEnergyForEnergy(){
    	String isCheckedPresentInClass = edfEnergy_duel_button.getAttribute("class");
    	if (isCheckedPresentInClass.contains("checked")) {
    		log.info("'EDF Energy' is already selected. Skipping step.");
    	} else {
    		edfEnergy_duel_button.click();
    		log.info("'EDF Energy' radio button clicked.");
    	}

    	return this;
    }
    
    /**
	 * Click on "E-ON" button for "Who supplies your energy?"
	 * <p>
	 * <b>Pre-requisite:</b> Only use if "Is your gas & electricity from the same supplier" is clicked as "Yes".
	 * 
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickEONForEnergy(){
    	String isCheckedPresentInClass = eon_duel_button.getAttribute("class");
    	if (isCheckedPresentInClass.contains("checked")) {
    		log.info("'E-ON' is already selected. Skipping step.");
    	} else {
    		britishGas_duel_button.click();
    		log.info("'E-ON' radio button clicked.");
    	}

    	return this;
    }
    /**
	 * Click on "NPOWER" button for "Who supplies your energy?"
	 * <p>
	 * <b>Pre-requisite:</b> Only use if "Is your gas & electricity from the same supplier" is clicked as "Yes".
	 * 
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickNPowerForEnergy(){
    	String isCheckedPresentInClass = npower_duel_button.getAttribute("class");
    	if (isCheckedPresentInClass.contains("checked")) {
    		log.info("'NPOWER' is already selected. Skipping step.");
    	} else {
    		npower_duel_button.click();
    		log.info("'NPOWER' radio button clicked.");
    	}

    	return this;
    }
    /**
	 * Click on "Scottish Power" button for "Who supplies your energy?"
	 * <p>
	 * <b>Pre-requisite:</b> Only use if "Is your gas & electricity from the same supplier" is clicked as "Yes".
	 * 
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickScottishPowerForEnergy(){
    	String isCheckedPresentInClass = scottishPower_duel_button.getAttribute("class");
    	if (isCheckedPresentInClass.contains("checked")) {
    		log.info("'Scottish Power' is already selected. Skipping step.");
    	} else {
    		scottishPower_duel_button.click();
    		log.info("'Scottish Power' radio button clicked.");
    	}

    	return this;
    }
    
    /**
	 * Click on "SSE" button for "Who supplies your energy?"
	 * 
	 * <b>Pre-requisite:</b> Only use if "Is your gas & electricity from the same supplier" is clicked as "Yes".
	 * 
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickSSEForEnergy(){
    	String isCheckedPresentInClass = sse_duel_button.getAttribute("class");
    	if (isCheckedPresentInClass.contains("checked")) {
    		log.info("'SSE' is already selected. Skipping step.");
    	} else {
    		sse_duel_button.click();
    		log.info("'SSE' radio button clicked.");
    	}

    	return this;
    }
    
	/**
	 * Set "Who supplies your energy?" dropdown box
	 * <p>
	 * <b>Pre-requisite:</b> Only use if "Is your gas & electricity from the same supplier" is clicked as "Yes".
	 * 
	 * @param dropdownValue
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page setEnergyOtherSupplierDropdown(String dropdownValue){
    	
    	//Initialise Select and point to the appropriate Select ID
    	Select select = new Select(otherSupplierDropdownForEnergy);
    	
    	//Creating the Javascript Executor interface object by type casting
    	JavascriptExecutor executor = (JavascriptExecutor)driver;
    	
    	//Find the Select ID and set it to visible
    	executor.executeScript("document.getElementById('sel').style.display='block';");
    	
    	//Goto the Select ID and find the text associated to an option. Set it with user parameter.
    	try {
    	select.selectByVisibleText(dropdownValue);
    	
    	//log output.
    	log.info("'" + dropdownValue + "' drop down value has been selected.");
    	}
    	//If user enters in a wrong value. Then output to console and fail test.
    	catch (NoSuchElementException e) {
    		
    	log.info("'" + dropdownValue + "' does not exist! Please use a value that exists.");
    	Assert.fail();
    	}
    	return this;
    }
    
	/**
	 * Set values to all methods to create customer profiles
	 * 
	 * @return this Supplier_page class instance.
	 */
	public Supplier_page setCustomerSupplierDetails() {
		
		
		return this;
	}
    
	/**
	 * Click on Next Button.
	 * 
	 * @return this Supplier_page class instance.
	 */
	public Supplier_page clickNextButton() {
		wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(next_button));
		next_button.click();
		log.info("Next button has been clicked.");
		return this;
	}
	
	/**
	 * Verify user is on the correct next "Your Energy" page 
	 * <p>
	 * <b>Conditional Statements: </b>
	 * <p>1) IF user selected on "Do you have your bill handy?" as "I've got my bill" THEN verify if they are on the YourEnergyWithBillURL.
	 * <p>OR
	 * <p>2) IF user selected on "Do you have your bill handy?" as "I don't have my bill" THEN verify if they are on the YourEnergyNoBillURL.
	 * 
	 * @return this Supplier_page class instance.
	 */
	public Supplier_page verifyUserIsOnCorrectYourEnergyPage(){
		wait = new WebDriverWait(driver, timeout);
 
		log.info("Verifying if user is on the correct Energy page...");
		wait.until(ExpectedConditions.urlToBe(stringClass.URLcheck)); 
		log.info("Page URL expected: " + stringClass.URLcheck + "\nActual: " + driver.getCurrentUrl() + "\nSuccess! User is successfully on the correct Your Energy page.");
		return this;
	}
	/**
	 * Set customer user profile for Your Supplier
	 * 
	 * @return this Supplier_page class instance.
	 */
	
	public Supplier_page setCustomerProfileForYourSupplierPage(String postcode){
		setWhatIsYourPostcode(postcode);
		
		
		return this;
		
	}
	
	
	
	/**
	 * Constructor required for PageFactory with implicitWaits to poll DOM
	 * 
	 */
	public Supplier_page (WebDriver driver){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		this.driver = driver;
	}	
}
