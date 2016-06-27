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

import support.URLs;

public class Preferences_page {
	private static Logger log = LogManager.getLogger(Preferences_page.class);
	private WebDriver driver;
	private WebDriverWait wait;
	private int timeout = 20;
	

	@FindBy (xpath = "//label[@for='pre-select-fixed']")
    @CacheLookup
    private WebElement fixedTariff_button;
	
	@FindBy (xpath = "//label[@for='pre-select-variable']")
    @CacheLookup
    private WebElement variableTariff_button;
	
	@FindBy (xpath = "//label[@for='pre-select-all']")
    @CacheLookup
    private WebElement allTariff_button;
	
	@FindBy (xpath = "//label[@for='pre-select-payment-monthly']")
    @CacheLookup
    private WebElement monthlyDirectDebit_button;
	
	@FindBy (xpath = "//label[@for='pre-select-payment-quarterly']")
    @CacheLookup
    private WebElement quarterlyDirectDebit_button;
	
	@FindBy (xpath = "//label[@for='pre-select-payment-onbill']")
    @CacheLookup
    private WebElement payOnReceiptOfBill_button;
	
	@FindBy (xpath = "//label[@for='pre-select-payment-all']")
    @CacheLookup
    private WebElement allPaymentTypes_button;
	
	@FindBy (id = "Email")
    @CacheLookup
    private WebElement email_textbox;
	
	@FindBy (xpath = "//label[@for='marketingPreference']")
    @CacheLookup
    private WebElement marketingPreference_checkbox;
	
	@FindBy (id = "terms-label")
    @CacheLookup
    private WebElement termsAndConditions_checkbox;
	
	@FindBy (id = "email-submit")
    @CacheLookup
    private WebElement goToPrices_button;
	
	@FindBy (id = "go-back")
    @CacheLookup
    private WebElement back_button;
	
	
	/**
	 * Click on "Fixed Tariff" button for "What tariff are you interested in?"
	 * 
	 * @return this Preferences_page class instance.
	 */
    public Preferences_page clickFixedTariff(){
    	String isCheckedPresentInClass = fixedTariff_button.getAttribute("class");
    	if (isCheckedPresentInClass.contains("checked")) {
    		log.info("'Fixed Tariff' is already selected. Skipping step.");
    	} else {
    		fixedTariff_button.click();
    		log.info("'Fixed Tariff' radio button clicked.");
    	}

    	return this;
    }
	
	/**
	 * Click on "Variable Tariff" button for "What tariff are you interested in?"
	 * 
	 * @return this Preferences_page class instance.
	 */
    public Preferences_page clickVariableTariff(){
    	String isCheckedPresentInClass = variableTariff_button.getAttribute("class");
    	if (isCheckedPresentInClass.contains("checked")) {
    		log.info("'Variable Tariff' is already selected. Skipping step.");
    	} else {
    		variableTariff_button.click();
    		log.info("'Variable Tariff' radio button clicked.");
    	}

    	return this;
    }
	/**
	 * Click on "All Tariffs" button for "What tariff are you interested in?"
	 * 
	 * @return this Preferences_page class instance.
	 */
    public Preferences_page clickAllTariff(){
    	String isCheckedPresentInClass = allTariff_button.getAttribute("class");
    	if (isCheckedPresentInClass.contains("checked")) {
    		log.info("'All Tariffs' is already selected. Skipping step.");
    	} else {
    		allTariff_button.click();
    		log.info("'All Tariffs' radio button clicked.");
    	}

    	return this;
    }
    
	/**
	 * Click on "Monthly Direct Debit" button for "What payment type are you interested in?"
	 * 
	 * @return this Supplier_page class instance.
	 */
    public Preferences_page clickMonthlyDirectDebit(){
    	String isCheckedPresentInClass = monthlyDirectDebit_button.getAttribute("class");
    	if (isCheckedPresentInClass.contains("checked")) {
    		log.info("'Monthly Direct Debit' is already selected. Skipping step.");
    	} else {
    		monthlyDirectDebit_button.click();
    		log.info("'Monthly Direct Debit' radio button clicked.");
    	}

    	return this;
    }
    
	/**
	 * Click on "Quarterly Direct Debit" button for "What payment type are you interested in?"
	 * 
	 * @return this Preferences_page class instance.
	 */
    public Preferences_page clickQuarterlyDirectDebit(){
    	String isCheckedPresentInClass = quarterlyDirectDebit_button.getAttribute("class");
    	if (isCheckedPresentInClass.contains("checked")) {
    		log.info("'Quarterly Direct Debit' is already selected. Skipping step.");
    	} else {
    		quarterlyDirectDebit_button.click();
    		log.info("'Quarterly Direct Debit' radio button clicked.");
    	}

    	return this;
    }    
	
	/**
	 * Click on "Pay On Receipt Of Bill" button for "What payment type are you interested in?"
	 * 
	 * @return this Preferences_page class instance.
	 */
    public Preferences_page clickPayOnReceiptOfBill(){
    	String isCheckedPresentInClass = payOnReceiptOfBill_button.getAttribute("class");
    	if (isCheckedPresentInClass.contains("checked")) {
    		log.info("'Pay On Receipt Of Bill' is already selected. Skipping step.");
    	} else {
    		payOnReceiptOfBill_button.click();
    		log.info("'Pay On Receipt Of Bill' radio button clicked.");
    	}

    	return this;
    }
    
	/**
	 * Click on "All Payment Types" button for "What payment type are you interested in?"
	 * 
	 * @return this Preferences_page class instance.
	 */
    public Preferences_page clickAllPaymentTypes(){
    	String isCheckedPresentInClass = allPaymentTypes_button.getAttribute("class");
    	if (isCheckedPresentInClass.contains("checked")) {
    		log.info("'All Payment Types' is already selected. Skipping step.");
    	} else {
    		allPaymentTypes_button.click();
    		log.info("'All Payment Types' radio button clicked.");
    	}
    	return this;
    }
	
	/**
	 * Set text to "What is your email address?" textbox.
	 * 
	 * @param emailValue
	 * @return this Preferences_page class instance.
	 */
	public Preferences_page setEmailAddress(String emailValue) {
		email_textbox.clear();
		email_textbox.sendKeys(emailValue);
		log.info("Email: " + emailValue + " has successfully been entered into email textbox.");
		return this;
		
	}
	
    /**
	 * Click "I agree to receiving product and marketing information" checkbox.
	 *
	 * @return this Preferences_page class instance.
	 */	
	public Preferences_page clickMarketingInformationCheckbox() {
		//check if element is visible
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(marketingPreference_checkbox));
		
		//Check if it has been clicked already. If so, do not click. If not, then click.
		String isCheckedPresentInClass = marketingPreference_checkbox.getAttribute("class");
  
    	if (isCheckedPresentInClass.equalsIgnoreCase("checked")) {
    		log.info("'Check' checkbox is already selected. Skipping step.");
    	} else {
    		marketingPreference_checkbox.click();
    		log.info("'Check' checkbox clicked for receiving marketing information");
    	}
		return this;

	}
	
    /**
	 * Click "Please tick this box to confirm you have read the Terms & Conditions" checkbox.
	 *
	 * @return this Preferences_page class instance.
	 */	
	public Preferences_page clickTermsAndConditionsCheckbox() {
		//check if element is visible
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(termsAndConditions_checkbox));
		
		//Check if it has been clicked already. If so, do not click. If not, then click.
		String isCheckedPresentInClass = termsAndConditions_checkbox.getAttribute("class");
  
    	if (isCheckedPresentInClass.equalsIgnoreCase("checked")) {
    		log.info("'Check' checkbox is already selected. Skipping step.");
    	} else {
    		termsAndConditions_checkbox.click();
    		log.info("'Check' checkbox clicked for confirming that user has read terms and conditions");
    	}
		return this;

	}
	
    /**
	 * Click "Go To Prices" button.
	 *
	 * @return this Preferences_page class instance.
	 */	
	public Preferences_page clickGotoPricesButton() {
		//check if element is visible
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(goToPrices_button));
		//click button
		goToPrices_button.click();
		log.info("'Go to prices' button has been clicked.");
		return this;

	}
	
    /**
	 * Click Back button
	 *
	 * @return this Preferences_page class instance.
	 */	
	public Preferences_page clickBackButton() {
		//check if element is visible
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(back_button));
		//click button
		back_button.click();
		log.info("'back' button has been clicked.");
		return this;

	}
	
	/**
	 * Verify user is on the correct next page (Your Preferences page -> Your Results page)
	 * 
	 * @return this Supplier_page class instance.
	 */
	public Preferences_page verifyUserIsOnYourResultsPage(){
		wait = new WebDriverWait(driver, timeout);
 
		log.info("Verifying if user is on Your Results page...");
		wait.until(ExpectedConditions.urlToBe(URLs.yourResultsURL)); 
		log.info("Page URL expected: " + URLs.yourResultsURL + "\nActual: " + driver.getCurrentUrl() + "\nSuccess! User is successfully on the correct Your Results page.");
		return this;
	}
	
	
	/**
	 * Constructor required for PageFactory with implicitWaits to poll DOM
	 * 
	 */
	public Preferences_page (WebDriver driver){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.driver = driver;
	}	
}
