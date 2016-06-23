package pageObjects;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	
	@FindBy (id = "39")
	@CacheLookup
	private WebElement britishGas_button;
/*	@FindBy (xpath = "//*[@id='same-supplier-no']/parent::label")
	@CacheLookup
	private WebElement NotFromSameSupplier_class;
*/

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
    		log.info("I Don't Have My Bill button is already selected. Skipping step.");
    	} else {
    	    iDontHaveMyBill_radioButton.click();
    	    log.info("I Don't Have My Bill clicked.");
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
    		log.info("I've Got My Bill button is already selected. Skipping step.");
    	} else {
    	    iveGotMyBill_radioButton.click();
    	    log.info("I've Got My Bill clicked.");
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
    		log.info("Gas & Electricity is already selected. Skipping step.");
    	} else {
    		gasAndElectricity_button.click();
    		log.info("Gas & Electricity button clicked.");
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
    		log.info("Electricity Only is already selected. Skipping step.");
    	} else {
    		electricityOnly_button.click();
    		log.info("Electricity Only clicked.");
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
    		log.info("Gas Only is already selected. Skipping step.");
    	} else {
    		gasOnly_button.click();
    		log.info("Gas Only clicked.");
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
	 * Click on British Gas button
	 * 
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickBritishGas(){
    	String isCheckedPresentInClass = britishGas_button.getAttribute("class");
    	if (isCheckedPresentInClass.contains("checked")) {
    		log.info("'British Gas' is already selected. Skipping step.");
    	} else {
			britishGas_button.click();
    		log.info("'British Gas' radio button clicked.");
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
