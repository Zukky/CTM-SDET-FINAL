package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.math.NumberUtils;
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
	
	
	
	
	/**
	 * Wait for results to be populated
	 * 
	 * @return this Results_page class instance.
	 */
	public Results_page waitForResults() {
		
		// check if element is visible
		log.info("Waiting for results to populate...");
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(results));
		log.info("Results populated!");

		return this;
	}
	
	/**
	 * Click on the Supplier that has the most savings
	 * 
	 * There are 3 steps:
	 * 1) Iterate through each result row and store the saving amount into an int array.
	 * 2) In the array, iterate through and find the largest number (which is the highest saving amount).
	 * 3) Map the highest saving number to the correct row and click its "More details" button
	 * 
	 * @return this Results_page class instance.
	 */
	public Results_page clickMoreDetailsOnHighestSavingSupplier() {
		
		/**
		 * How to read the Xpath:
		 * 
		 * 	 * .//*[@id='price-page-results-view']/div (entire results)/ -> div [i] (gives us a single row of result) 
		 * -> div[2] (annual savings are stored here) -> div (no reason) 
		 * -> div [1] (save and price texts are here) -> div[2] (price is here) -> span[2] (price number)
		 * 
		 */
		
		/**
		 * PART 1: Iterate through each result row and store the saving amount i.e. "£150" into an int array.
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
		 * PART 2: In the array, iterate through and find the largest number (which is the highest saving amount).
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
		 * PART 3: Map the highest saving number to the correct row and click its "More details" button
		 */
		
		//Using the highest saving number. Map this to the correct MORE DETAILS button. Click that button.
		for (int i3 = 1; i3 <= allResults.size(); i3++){
			
			//Xpath is pointing to where the Save number exists in all elements.
			WebElement listOfPrices = driver.findElement(By
					.xpath(".//*[@id='price-page-results-view']/div/div[" + i3 + "]/div[2]/div/div[1]/div[2]/span[2]"));
			
			//check if listOfPrices are numbers. We don't want strings/nulls going into our Int Array and making it fail.
			boolean isEachPriceANumber = NumberUtils.isNumber(listOfPrices.getText());
			
			//If listOfPrices are numbers AND IF Saving value on the webpage is the same as the int largest value THEN click its More Details button.
			if (isEachPriceANumber == true) {
				if (Integer.parseInt(listOfPrices.getText()) == largest) {
					WebElement moreDetailsButton = driver
							.findElement(By.xpath(".//*[@id='price-page-results-view']/div/div[" + i3
									+ "]/div[7]/div/a[starts-with(@id, 'tariffSelection')]"));

					if (moreDetailsButton.isDisplayed()) {
						//click the More Details button.
						moreDetailsButton.click();
						
						// Get the supplier name to output to log.
						WebElement supplierNameAttachedToMoreDetails = driver.findElement(By.xpath(".//div[4]//section[1]/h3"));
						String supplierName = supplierNameAttachedToMoreDetails.getText();
						log.info("Clicked 'MORE DETAILS' button for: " + supplierName + "!");
						break;
					}
				}
			} else {
				break;
			}
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
		wait = new WebDriverWait(driver, 10);
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
