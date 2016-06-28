package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
* <h1>Your Results Page</h1>
* This page holds all elements and methods to those elements for Your Results webpage.
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
public class Results_page {
	private static Logger log = LogManager.getLogger(Results_page.class);
	private WebDriver driver;
	private WebDriverWait wait;
	private int timeout = 20;
	
	@FindBy (id = "price-page-results-view")
    @CacheLookup
    private WebElement results;
	
	@FindBy (id = "switch-now-button")
    @CacheLookup
    private WebElement switchNow_button;
	
	@FindBy (id = "mm_t61_f_switch")
    @CacheLookup
    private WebElement onlyShowTariffsWeCanHelpYouSwitchTo_checkbox;
	
	@FindBy (id = "price-page-results-view")
	@CacheLookup
	private WebElement allPricePageResults;
	
	@FindBy (xpath = "//*[@class='spinner']")
	@CacheLookup
	private WebElement loadSpinner;

	/**
	 * Wait for results to be populated
	 * 
	 * @return this Results_page class instance.
	 */
	public Results_page waitForResults() {
		
		// check if element is visible
		log.info("Waiting for results to populate...");
		wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(results));
		log.info("Results populated!");

		return this;
	}
	
	
	/**
	 * Click on 'More Details' button for the Supplier that has the highest saving amount
	 * <p>
	 * <p>There are 4 technical steps performed here:
	 * <p>1) Click on "Only show tariffs we can help you switch to" using JavascriptExecutor under Switching Support for Refine Results.
	 * <p>2) Iterate through each result row and store the saving amount into an int array.
	 * <p>3) In the array, iterate through and find the largest number (which is the highest saving amount).
	 * <p>4) Map the highest saving number to the correct row and click its "More details" button
	 * 
	 * @return this Results_page class instance.
	 */
	public Results_page clickMoreDetailsOnHighestSavingSupplier() {
		
		/**
		 * <b>How to read the Xpath:</b>
		 * 
		 * 	 * .//*[@id='price-page-results-view']/div (entire results)/ -> div [i] (gives us a single row of result) 
		 * -> div[2] (annual savings are stored here) -> div (no reason) 
		 * -> div [1] (save and price texts are here) -> div[2] (price is here) -> span[2] (price number)
		 * 
		 */
		
		/**
		 * PART 1: Click on "Only show tariffs we can help you switch to" checkbox
		 */
		
		//Initialise wait
		wait = new WebDriverWait(driver, timeout);
		
		//Creating the Javascript Executor interface object by type casting
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//Javascript Execution script - click on "only show tariffs we can help you switch to" checkbox button
		js.executeScript("document.getElementById('mm_t61_f_switch').click();");
		log.info("'Only show tariffs we can help you switch to' filter checkbox clicked.");
		
		//Wait for results page to reload (check if loading spinner has been set to invisible
		log.info("Waiting for page results to reload..");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='spinner']")));
		
		
		/**
		 * PART 2: Iterate through each result row and store the saving amount i.e. "£150" into an int array.
		 */
		
		log.info("Finding the highest saving amount...");
		//Store all results that are in div to List of webelements
		List<WebElement> allResults = driver.findElements(By.xpath(".//*[@id='price-page-results-view']/div/div"));
		
		//Create an array the size of allResults
		int[] listOfAllPrices = new int[allResults.size()];
		
		//Instantiate an int that has a minimum value (this is used for later)
		int largest = Integer.MIN_VALUE;
		
		//Iterate through each row of div's and find the Annual Saving amount, store each annual saving result in a String.
		for (int i=1; i<=allResults.size();i++){
			
			//Xpath is pointing to where the "Save" value exists.
			WebElement listOfPrices = driver.findElement(By
					.xpath(".//*[@id='price-page-results-view']/div/div[" + i + "]/div[2]/div/div[1]/div[2]/span[2]"));
			
			//check if listOfPrices are numbers. We don't want strings/nulls going into our Int Array and making it fail.
			boolean isEachPriceANumber = NumberUtils.isNumber(listOfPrices.getText());
		
			//If listOfPrices are numbers then attach the price to eachPrice int object.
			if (isEachPriceANumber == true) {
				
				//attaching eachPrice to the Save value
				int eachPrice = Integer.parseInt(listOfPrices.getText());
				
				//Store eachPrice inside the listOfAllPrices array
				listOfAllPrices[i-1] = eachPrice;
				
			} else if (isEachPriceANumber == false){
				//break once there are no more numbers.
				break;
				}
		}
		
		/**
		 * PART 3: In the array, iterate through and find the largest number (which is the highest saving amount).
		 */
		
		//IF listOfAllPrices[n] is greater than largest (= MIN_VALUE), then set largest to listOfAllPrices[n]. 
		//Carry on doing this until nothing is larger. Largest will be set to the highest array int value.
		for (int i2 = 0; i2 < listOfAllPrices.length; i2++) {
			if (listOfAllPrices[i2] > largest) {
				largest = listOfAllPrices[i2];
				break;
			}
		}
		log.info("Highest Saving is: £" + largest + "!");
		
		/**
		 * PART 4: Map the highest saving number to the correct row and click its "More details" button
		 */
		
		log.info("Matching Highest Saving Price with the correct More Details button...");
		
		//Using the highest saving number. Map this to the correct MORE DETAILS button. Click that button.
		for (int i3 = 1; i3 <= allResults.size(); i3++){
			
			//Xpath is pointing to where the Save number exists in all elements.
			WebElement listOfPrices = driver.findElement(By
					.xpath(".//*[@id='price-page-results-view']/div/div[" + i3 + "]/div[2]/div/div[1]/div[2]/span[2]"));
			
			//check if listOfPrices are numbers. We don't want strings/nulls going into our Int Array and making it fail.
			boolean isEachPriceANumber = NumberUtils.isNumber(listOfPrices.getText());
			
			//If listOfPrices are numbers AND IF Saving value on the webpage is the same as the int largest value THEN click its respective More Details button.
			if (isEachPriceANumber == true) {
				if (Integer.parseInt(listOfPrices.getText()) == largest){
					WebElement moreDetailsButton = driver
							.findElement(By.xpath(".//*[@id='price-page-results-view']/div/div[" + i3
									+ "]/div[7]/div/a[starts-with(@id, 'tariffSelection')]"));
					
					//Check if the More Details button is displayed
					if(moreDetailsButton.isDisplayed()){
						
						//click the More Details Button
						moreDetailsButton.click();
						
						// Supplier name locator
						WebElement supplierNameAttachedToMoreDetails = driver.findElement(By.xpath(".//div[4]//section[1]/h3"));
						
						// Get the supplier name
						String supplierName = supplierNameAttachedToMoreDetails.getText();
						
						//Print supplier name
						log.info("Clicked 'MORE DETAILS' button for: '" + supplierName + "'!");
					} else {
						//More Details is not present. Fail test.
						log.info("'More Details' button not found!");
						Assert.fail();
						break;
						
					}
				}
			} 	
		break;
		}
		return this;
	}

	/**
	 * Verify if "More Details" information modal for chosen tariff is displayed
	 * 
	 * @return this Results_page class instance.
	 */	
	public Results_page verifyMoreDetailsInformationIsDisplayed(){
		
		//check if element is visible
		wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(switchNow_button));
		
		if (switchNow_button.isDisplayed()){
			log.info("User can see More Detail information modal successfully.");
		} else {
			log.info("User cannot see More Detail information modal!");
			Assert.fail();
		}
		return this;
		
	}
	
	/**
	 * Validate if Switch Now button is displayed.
	 * 
	 * @return this Results_page class instance.
	 */	
	public Results_page validateSwitchNowButton() {
		
		//check if element is visible
		wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(switchNow_button));
		
		if (switchNow_button.isDisplayed()){
			log.info("Switch Now button is visible.");
		} else {
			log.info("Switch Now button is NOT visible.");
			Assert.fail();
		}
		return this;
	}
		
	/**
	 * Constructor required for PageFactory with implicitWaits to poll DOM
	 * 
	 */
	public Results_page(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.driver = driver;
	}	
}
