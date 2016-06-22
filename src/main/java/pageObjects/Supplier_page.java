package pageObjects;

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
	private int timeout = 20;

    @FindBy(id = "your-postcode")
    @CacheLookup
    private WebElement whatIsYourPostcode_textbox;
    
	@FindBy(id = "find-postcode")
	@CacheLookup
	private WebElement findPostcode_button;
	

	/**
	 * Verify that the current URL matches with the expected URL (found in Strings.java)
	 * 
	 * @return this Supplier_page class instance.
	 */
	public Supplier_page verifyUserIsOnCorrectPage(){
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		if (wait.until(ExpectedConditions.urlToBe(Strings.expectedEnergyURL)) == true){
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
		return this;
		
	}
	
	/**
	 * Click on Find Postcode Button.
	 * 
	 * @return this Supplier_page class instance.
	 */
	public Supplier_page clickFindPostcodeButton() {
		findPostcode_button.click();
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
