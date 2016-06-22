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
	
/*	@FindBy(xpath = "//*[@id='have-bill-label' and @class='checked']")
	@CacheLookup
	private WebElement isChecked;
	
	@FindBy(xpath = "//*[@id='have-bill-label' and @class='']")
	@CacheLookup
	private WebElement isNotChecked;
	*/
	
	
	
    
    public Supplier_page clickIDontHaveMyBillButton(){
    	//This is not a good implementation for a Radio Button. 
    	
    iDontHaveMyBill_radioButton.click();    
    return this;
    }
    
    public Supplier_page clickIveGotMyBillButton(){
    	//This is not a good implementation for a Radio Button. 
/*    WebElement isChecked = driver.findElement(By.xpath("//*[@id='no-bill-label' and @class='checked']"));
    WebElement isNotChecked = driver.findElement(By.xpath("//*[@id='no-bill-label' and @class='']"));*/
    	List<WebElement> elements = driver.findElements(By.xpath("//*[@id='have-bill-label' and @class='checked']"));
    		int el = elements.get(0).getSize();
    			if (elements != 0) {
    				
    			}
    	
    	
 /*   if (isChecked.isDisplayed()){
    	log.info("I've Got My Bill is already selected.");
    } else if (isNotChecked.isDisplayed()){
    	iveGotMyBill_radioButton.click(); 
    	log.info("I've Got My Bill has been clicked");
    	}*/
    return this;
    }

/*    public Supplier_page setIDontHaveMyBillRadioButtonField() {
        for (WebElement el : iDontHaveMyBill) {
            if (el.getAttribute("value").equals(iDontHaveMyBillValue)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }*/
	
/*	public Supplier_page clickIveGotMyBillRadioButton(){
		for (WebElement bills : bothBills) {
			if (bills.getAttribute("value").equals(iDontHaveMyBillValue)){
				bills.click();
			}
			break;
		}
		return this;
	}
	*/
	/*	
	 * setDefaultToIveGotMyBill - NOTREQUIRED
	 * 
	 * @return this Supplier_page class instance.
	 * 
	 public Supplier_page setDefaultToIveGotMyBillRadioButton(){
			for (WebElement bills : bothBills){
				if (bills.getAttribute("value").equals(iDontHaveMyBillValue)){
					if (!bills.isSelected()){
						bills.click();
					}
					break;
				}
			}
			return this;
		}*/
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
