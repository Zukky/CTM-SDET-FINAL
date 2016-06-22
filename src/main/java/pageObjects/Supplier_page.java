package pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import support.Strings;

public class Supplier_page {

	private static Logger log = LogManager.getLogger(Supplier_page.class);
	private WebDriver driver;
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
	
	@FindBy (id = "same-supplier-yes")
	@CacheLookup
	private WebElement gasAndElectricity_YesTheyAreFromSameSupplier;
	
	/*@FindBy (xpath = "//*[@id='same-supplier-question']/div/div/label[2]")*/
	@FindBy (xpath = "//*[@label='same-supplier-no']")
	@CacheLookup
	private WebElement gasAndElectricity_NotFromSameSupplier;
	


	/**
	 * Verify that the current URL matches with the expected URL (found in Strings.java)
	 * 
	 * @return this Supplier_page class instance.
	 */
	public Supplier_page verifyUserIsOnCorrectPage(){
		WebDriverWait wait = new WebDriverWait(driver, timeout);
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
		whatIsYourPostcode_textbox.sendKeys(whatIsYourPostcodeValue);
		log.info("Postcode: " + whatIsYourPostcodeValue + " has successfully been entered into postcode textbox.");
		return this;
		
	}
	
	/**
	 * Click on Find Postcode Button.
	 * 
	 * @return this Supplier_page class instance.
	 */
	public Supplier_page clickFindPostcodeButton() {
		findPostcode_button.click();
		log.info("Find Postcode button has been clicked.");
		return this;
	}
	
	/**
	 * Click on I Don't Have My Bill button
	 * 
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickIDontHaveMyBillButton(){
    	//This is not the best implementation for a radioButton (usually FOR loop)
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
    public Supplier_page clickIveGotMyBillButton(){
    	//This is not a good implementation for a Radio Button. 
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
    public Supplier_page clickGasAndElectricityButton(){
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
    public Supplier_page clickElectricityOnlyButton(){
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
    public Supplier_page clickGasOnlyButton(){
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
    public Supplier_page clickYesForGasAndElectricitySuppliersCheckbox(){
    	String isCheckedPresentInClass = gasAndElectricity_YesTheyAreFromSameSupplier.getAttribute("class");
    	log.info(isCheckedPresentInClass);
    	if (isCheckedPresentInClass.equalsIgnoreCase("checked")) {
    		log.info("Yes checkbox is already selected. Skipping step.");
    	} else {
    		gasAndElectricity_YesTheyAreFromSameSupplier.click();
    		log.info("Yes checkbox clicked. User has the same supplier.");
    	}
    	return this;
    }
    
	/**
	 * Click on No they are not from the same supplier checkbox
	 * 
	 * @return this Supplier_page class instance.
	 */
    public Supplier_page clickNoForGasAndElectricitySuppliersCheckbox(){
    	String isCheckedPresentInClass = gasAndElectricity_NotFromSameSupplier.getAttribute("class");
    	log.info(isCheckedPresentInClass);
    	if (isCheckedPresentInClass.equalsIgnoreCase("checked")) {
    		log.info("No checkbox is already selected. Skipping step.");
    	} else {
    		gasAndElectricity_NotFromSameSupplier.click();
    		log.info("No checkbox clicked. User does not have the same supplier.");
    	}
    	return this;
    }
	
	/**
	 * Constructor required for PageFactory
	 * 
	 */
	public Supplier_page (WebDriver driver){
		this.driver = driver;
	}

	
}
