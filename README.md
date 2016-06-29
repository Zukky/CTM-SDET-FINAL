Welcome to Test Automation Framework for Compare The Market.
===================


Hey! 

This is an automation framework that has been created for the Compare The Market - energy comparison website. 

----------
Overview
-------------
The automation framework will complete three user journeys, testing whether or not an element is displayed and verifying if the user is on the correct part of the journey. The tests are designed to go through different options of the customer journey whilst outputting what it is doing on a low-level. The cucumber feature file has been written in a very abstract, business-readable and (hopefully!) user-friendly way. There were thoughts to include data tables or writing them as imperative statements that developers would appreciate. However, I have chosen to write them in the eyes of the user, without expressing intent on UI elements (as if there is no UI) so they are rememberable and act as simple/easily-understood specifications. 

The Selenium code has been hidden away from the StepDefinition file by storing the locators, business logic, logging into public methods. This follows a Page Object Model pattern, which aids in the maintenance and speed of the framework. 

This framework is not doing any non-functional/performance tests nor is it validating data.

Technologies Used
-------------

I have used the following technologies to build this automation framework:
1. Selenium for Java
2. Cucumber (with Gherkin) for Java
3. Maven
4. Log4J2

Framework Design
-------------

In order to ensure reliability, speed, maintainability of the framework. I have implemented the following design patterns:

1. Page Object Model with PageFactory for Selenium 
2. Log4J2 for low-level logging
3. Abstract Cucumber features

Java Classes
-------------

All classes and methods have been commented. Please read them to understand what each method does. They have pre-requisites that must be fulfilled if you want to invoke a certain method. 

Test Environment
-------------

The framework has been tested with the following setup:
1. Operating System: Windows 8 & 10 64-bit.
2. Browser: Google Chrome Version 51.0.2704.103 m (51.0 basically)
3. Libraries: Java JDK 1.8.65
4. IDE: Eclipse EE Mars.2 IDE

Please ensure you have the above present (minus 32-bit or 64-bit). Ensure they are all installed to their default installation paths. 

Please download the below:

1. Eclipse: Please goto "http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/mars2" and select your respective operating system and download it.

2. Java JDK:  http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html - this is for the updated Java JDK. The JDK I used, the link seems to not be available sadly. This JDK version should work.
3. Google chrome download: https://www.google.com/chrome/



How to setup the Automation Framework
-------------

Once you have the above downloaded and installed to their default paths (for eclipse, place extracted folder anywhere in C:\)

Steps:

Installing Cucumber into Eclipse IDE:

> 1. Open Eclipse Mars 2 (set workspace to anywhere you wish)
> 2. Goto Help -> Install New Software -> Click Add (on the right-hand side)
> 3. Type "Cucumber" in Name.
> 4. Type "http://cucumber.github.com/cucumber-eclipse/update-site" (without quotes) in Location.
> 5. Click OK.
> 6. In the plugin selection screen, tick the "Cucumber Eclipse Plugin".
> 7. Finish the installation (Next (agree to terms) -> finish -> follow prompts).


Once restarted and cucumber successfully installed into Eclipse. Please follow these steps to get this framework into your workspace:

> 1. Goto File -> Import 
> 2. Select Git -> Projects from Git
> 3. Select "Clone URI"
> 4. Enter: "https://github.com/ZukkyBaig/CTM-SDET-FINAL.git" into URI (without quotes) 
> 5. Press Next
> 6. Select 'master' branch
> 7.  Click next and keep going until you reach "Import Projects"
> 8. Select "energy" project
> 9. Click next/finish.

That will import the files into the Project explorer. It should be pretty straightforward, if it isn't please contact me.

How to run the Automation Framework
-------------

Once the "energy" project has successfully imported into Eclipse. You can run the tests via the TestRunner.java class:

> 1. Goto:  "Energy > src > test > java > TestRunner.java" 
> 2. Right-click it - Run As -> JUnit Test

Boom. It should start running.

You can also run this via building it through Maven. To do this goto "pom.xml" which can be found in the Energy root directory. Right-click the "pom.xml" and do this in order:

	a.  Run As -> Maven clean 
	b.  Run As -> Maven test

Logs
----

Low-level logging with Log4j2:

There is a lot of low-level logging done on the methods that are invoked. Please look into the "Console" tab, which tells you what the framework is doing at what point i.e. "Waiting for page...", "Verifying user is on correct page", "Setting "(param)" here...". I have done this so that you know at which point a test case will fail. So you can have very abstract features but you can still debug low-level problems easier.

If you want to see each step that is being run, click on the "JUnit" view.

Cucumber HTML logs:

Cucumber sends an HTML output log to your target folder, here: C:\workspace\CTEM-SDET-FINAL\target\cucumber-html-report\index.html". Replace "C:\workspace\" with your path directory. Click on it to see the test result.


Optimisations and Design Choices
----

I found it challenging to get the dropdown values from the `<select> </select>` tags, in order to do it, I iterated the `<li>` tag and stored it into a String[] array. Then validated if the user String parameter matched with a value inside the array, if it did then set the dropdown value to it. This code was good but it was cumbersome, so I chose another way to do it. This new way managed to reduce ~2seconds in end-to-end time, which was good news.

Previous `<select>` dropdown value coding logic:

    //click the drop down first to make it visible.
     dropDownForElectricity.click();
     
    //Create a List for all of the <li> elements under <div id = sel1_chosen>. Which is where all of the other suppliers are stored.
      List<WebElement> listOfLi = driver.findElement(By.xpath("//*[@id='sel2_chosen']/div/ ul")).findElements(By.tagName("li"));

      //Instantiate an Array to store all of the <li> elements (other suppliers) so we can refer to them later. Create an array of string that has the size of all of the <li> elements.
      String[] liListArray = new String[listOfLi.size()];
      
      //Create a for loop to iterate through each <li> (other suppliers) and get the text value of it. Starting from 1.
      for( int i=1; i<=listOfLi.size(); i++) {
            
            //Create a web element that points to specific <li> (other supplier), add the 'i' into <li> so it can iterate to each one until i < all <li> (other suppliers) elements
            WebElement liList = driver.findElement(By.xpath("//*[@id='sel2_chosen']/div/ ul/li[" + i + "]"));
            
            //Get all the values of the <li> (other supplier i.e. Affect Energy etc..) and store it into a string.
            String eachSupplier = liList.getText();
            
            //Add each value of <li> (other suppliers) into an Array, starting from 0 (i-1 because i equals 1 due to <li> starts from 1 and array starts from 0).
            liListArray[i-1] = eachSupplier;
      }
      
      try {
            //Pass the String parameter from Cucumber file and locate the index number of the string using our stored Array.
             int conversionArray = Arrays.asList(liListArray).indexOf(dropdownValue);
            
            //If the array index that is returned is lower than 0 (which is true when a value that doesn't exist in the array is trying to be selected, it turns into -1). Then it is printed to tell the user to change the value from Cucumber.     
            if (conversionArray < 0) {
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


New `<Select>` logic:

		 	//Initialise Select and point to the appropriate Select ID
	    	Select select = new Select(gasSpendPeriod_dropdown);
	    	
	    	//Creating the Javascript Executor interface object by type casting
	    	JavascriptExecutor executor = (JavascriptExecutor)driver;
	    	
	    	//Find the Select ID and set it to visible
	    	executor.executeScript("document.getElementById('type-of-Gas-bill-dropdown').style.display='block';");
	    	
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

You'll notice, the new logic is a lot more cleaner and simpler. There are a few things to note:

1. JavascriptExecutor is used which executes a javascript at runtime, this script forces the `<select>` to become visible via setting the css display attribute from 'none' to 'block'. In reality I would've asked a BA/PO/Stakholder if this is something they are comfortable with. It doesn't affect the end-user in anyway other than another dropdown box is shown momentarily whilst the test is running. Again, this can be replaced with my previous logic which didn't use "select" selenium libraries. However, this new logic, when applied to all methods that are using it, shaved ~2seconds e2e test time. Which is great! If this is part of a continuous integration environment and 100 developers are using it, then that is a 200 second saving or 3 minutes.

2. The new logic is less brittle than the previous logic, the previous logic had locators embedded into the code, so for-loops could run through them. The new logic doesn't do this, the only "hardcode" is the executescript with the locator inside.

Data tables were attempted, however it made it difficult for me as a user to remember what was going on, so I removed it. This was the code:

    @GreenPath
    Scenario: Comparing Gas and Electricity prices with a bill
    Given Kiwi successfully reaches the start of her journey
    And enters her supplier details as
    
    | Postcode | DoYouHaveYourBill | WhatDoYouWantToCompare | DoYouHaveTheSameSupplierForGasAndElectricity | Electricity Supplier | Gas Supplier |
    | PE2 6YS | Yes                                 | Gas and Electricity     | No                                                                                     | Scottish Power | Daligas |
    
    And her Electricity details as
    | Electricity Tariff | Economy 7 meter | How do you pay | Main source of heating | Usage Type | Usage amount | Usage period | Bill day |
    | Fixed Price Energy June 2016 | No | Quarterly Direct Debit | Yes | kWh | 500 | Annually | |
    
    And her Gas details as
    | Gas Tariff | How do you pay | Main source of heating | Usage Type | Usage amount | Usage period | Bill day |
    | Daligas One | Monthly Direct Debit | No | £ | 500 | Quarterly | 15 |
    
    And her preferences and contact details as
    | Tariff type interested | Payment type interested in | Email Address | Marketing Information | Agree To Terms & Condition |
    | Fixed tariff | All payment types | CTM_SDET@ctm.com | Yes | Yes |
    
    Then Kiwi will be shown a list of tariff results
    When Kiwi chooses the cheapest tariff that compare the market supports
    Then Kiwi can choose to switch to it and her journey ends
    
    
    
    
    
    /**
     * ---------------------------------
     * DATATABLES STEPS
     * ---------------------------------
     */
    
    @Given("^Kiwi successfully reaches the start of her journey$" )
    public void kiwi_successfully_reaches_the_start_of_her_journey() {
        supplierPage.verifyUserIsOnYourSupplierPage();
    
    }
    
    @Given("^enters her supplier details as$" )
    public void enters_her_supplier_details_as(DataTable yourSupplier)  {
    
           //Handle data table
          List<List<String>> data = yourSupplier .raw();
          
           /**
           * Set "What is your postcode?" and click "Find Postcode" button
           * Valid inputs: a valid postcode
           */
           supplierPage.setWhatIsYourPostcode(data .get(1).get(0));
           supplierPage.clickFindPostcode();
          
           /**
           * Set "Do you have your bill handy?"
           * Valid inputs: 'Yes' or 'No'
           */
           if((data .get(1).get(1)).equals("Yes")){
           supplierPage.clickIveGotMyBill();
          } else if ((data.get(1).get(1)).equals( "No")){
           supplierPage.clickIDontHaveMyBill();
          }
          
           /**
           * Set "What do you want to compare?"
           * Valid inputs: "Gas and Electricity" or "Electricity only" or "Gas only"
           */
           if((data .get(1).get(2)).equals("Gas and Electricity")){
                 supplierPage.clickGasAndElectricity();
                } else if ((data.get(1).get(2)).equals( "Electricity only")){
                 supplierPage.clickElectricityOnly();
                } else if ((data.get(1).get(2)).equals( "Gas only")) {
                       supplierPage.clickGasOnly();
                }
          
           /**
           * Set "Do you have the same Gas and Electricity supplier?"
           * Valid inputs: "Yes" or "No"
           * Pre- requisites:
           * 1) "I've got my bill" must be checked to use this method.
           * 2) "Gas & Electricity" must be checked to use this method.
           */
           if((data .get(1).get(3)).equals("Yes")){
                 supplierPage.clickYesForGasAndElectricitySuppliers();
                } else if ((data.get(1).get(3)).equals( "No")){
                 supplierPage.clickNoForGasAndElectricitySuppliers();
                }
          
           /**
           * Set "Who supplies your electricity?"
           * Valid inputs: "British Gas" or "EDF Energy" or "EON" or "NPOWER" or "Scottish Power" or "SSE" or enter a dropdown value.
           * Pre- requisites:
           * 1) "What do you want to compare?" set as "Gas and Electricity" OR "Electricity only".
           * 2) For "Gas and Electricity" -> "No" must be checked for "Do you have the same supplier for Gas and Electricity?"
           */
           if((data .get(1).get(4)).equals("British Gas")){
                 supplierPage.clickBritishGasForElectricity();
                } else if ((data.get(1).get(4)).equals( "EDF Energy")){
                 supplierPage.clickEDFEnergyForElectricity();
                } else if ((data.get(1).get(4)).equals( "EON")){
                       supplierPage.clickEONForElectricity();
                      } else if ((data.get(1).get(4)).equals( "NPOWER")){
                             supplierPage.clickNPOWERForElectricity();
                      } else if ((data.get(1).get(4)).equals( "Scottish Power")){
                             supplierPage.clickScottishPowerForElectricity();
                      } else if ((data.get(1).get(4)).equals( "SSE")){
                             supplierPage.clickSSEForElectricity();
                      } else {
                             supplierPage.setElectricityOtherSupplierDropdown(data.get(1).get(4));
                      }
          
           /**
           * Set "Who supplies your Gas?"
           * Valid inputs: "British Gas" or "EDF Energy" or "EON" or "NPOWER" or "Scottish Power" or "SSE" or enter a dropdown value.
           * Pre- requisites:
           * 1) "What do you want to compare?" set as "Gas and Electricity" OR "Gas only".
           * 2) For "Gas and Electricity" -> "No" must be checked for "Do you have the same supplier for Gas and Electricity?"
           */
           if((data .get(1).get(5)).equals("British Gas")){
                 supplierPage.clickBritishGasForGas();
                } else if ((data.get(1).get(5)).equals( "EDF Energy")){
                 supplierPage.clickEDFEnergyForGas();
                } else if ((data.get(1).get(5)).equals( "EON")){
                       supplierPage.clickEONForGas();
                      } else if ((data.get(1).get(5)).equals( "NPOWER")){
                             supplierPage.clickNPOWERForGas();
                      } else if ((data.get(1).get(5)).equals( "Scottish Power")){
                             supplierPage.clickScottishPowerForGas();
                      } else if ((data.get(1).get(5)).equals( "SSE")){
                             supplierPage.clickSSEForGas();
                      } else {
                             supplierPage.setGasOtherSupplierDropdown((data .get(1).get(5)));
                      }
          
    
           /**
           * Click next button and verify they are on the correct next page.
           */
           supplierPage.clickNextButton();
           supplierPage.verifyUserIsOnCorrectYourEnergyPage();
          }
    
    @Given("^her Electricity details as$" )
    public void her_electricity_details_as(DataTable yourElectricity)  {
    
           //Handle data table
          List<List<String>> data = yourElectricity .raw();
    
           /**
           * Set "What Electricity tariff are you on?"
           * Valid inputs: enter a dropdown value, validations are done by Page Objects.
           */
           energyPage.setElectricityTariffDropdown(data .get(1).get(0));
          
           /**
           * Set "Do you have an Economy 7 meter?"
           * Valid inputs: "Yes" or "No"
           */
           if((data .get(1).get(1)).equals("No")){
           energyPage.clickNoForEconomy7Meter();
          } else if (((data.get(1).get(1)).equals( "Yes"))) {
           energyPage.clickYesForEconomy7Meter();
          }
          
           /**
           * Set "How do you pay for your electricity?"
           * Valid inputs: enter a dropdown value, validations are done by Page Objects.
           */
           energyPage.setHowDoYouPayForElectricity(data .get(1).get(2));
          
           /**
           * Set "Is electricity your main source of heating?"
           * Valid inputs: "Yes" or "No"
           */
           if((data .get(1).get(3)).equals("Yes")){
           energyPage.clickYesForElectricityMainSourceOfHeating();
          } else if (((data.get(1).get(3)).equals( "No"))) {
           energyPage.clickNoForElectricityMainSourceOfHeating();
          }
          
           /**
           * Set "What is your current electricity usage?"
           * Valid inputs: "kWh" or "£"
           *
           * Set kWh or £ text
           * Valid inputs: only numbers
           *
           * Set usage period
           * Valid inputs: enter a dropdown value, validations are done by Page Objects.
           *
           */
           if((data .get(1).get(4)).equals("kWh")){
           energyPage.clickKwHForCurrentElectricityUsage();
           energyPage.setKwhTextForElectricity(Integer.parseInt(( data.get(1).get(5))));
           energyPage.setKwhForElectricityDropdown(data .get(1).get(6));
           if (!(data .get(1).get(6)).equals("Annually")){
                 energyPage.setDayForBillDateViaDatePickerForElectricity(Integer.parseInt ((data .get(1).get(7))));
          }
          
          } else if (((data.get(1).get(4)).equals( "£"))) {
           energyPage.click£ForCurrentElectricityUsage();
           energyPage.set£TextForElectricity(Integer.parseInt(( data.get(1).get(5))));
           energyPage.set£DropdownForElectricity(data .get(1).get(6));
                 if (!(data .get(1).get(6)).equals("Annually")){
                 energyPage.setDayForBillDateViaDatePickerForElectricity(Integer.parseInt ((data .get(1).get(7))));
          }
          }
           /**
           * Click next button and verify if user is on gas page.
           */
           energyPage.clickNextButton();
           energyPage.verifyUserIsOnGasPage();
    }
    
    @Given("^her Gas details as$" )
    public void her_gas_details_as(DataTable yourGas) {
           //Handle data table
          List<List<String>> data = yourGas .raw();
          
           /**
           * Set "What Gas tariff are you on?"
           * Valid inputs: enter a dropdown value, validations are done by Page Objects.
           */
           energyPage.setWhatGasTariffAreYouOnDropdown((data .get(1).get(0)));
          
           /**
           * Set "How do you pay for your gas?"
           * Valid inputs: enter a dropdown value, validations are done by Page Objects.
           */
           energyPage.setHowDoYouPayForYourGasDropdown((data .get(1).get(1)));
          
           /**
           * Set "Is gas your main source of heating?"
           * Valid inputs: "Yes" or "No"
           */
           if((data .get(1).get(3)).equals("Yes")){
           energyPage.clickYesForGasMainSourceOfHeating();
          } else if (((data.get(1).get(3)).equals( "No"))) {
           energyPage.clickNoForGasMainSourceOfHeating();
          }
          
           /**
           * Set "What is your current gas usage?"
           * Valid inputs: "kWh" or "£"
           *
           * Set kWh or £ text
           * Valid inputs: only numbers
           *
           * Set usage period
           * Valid inputs: enter a dropdown value, validations are done by Page Objects.
           *
           */
           if((data .get(1).get(3)).equals("kWh")){
           energyPage.clickKwHForCurrentGasUsage();
           energyPage.setKwhTextForGas(Integer.parseInt(( data.get(1).get(4))));
           energyPage.setKwhForGasDropdown(data .get(1).get(5));
           if (!(data .get(1).get(5)).equals("Annually")){
                 energyPage.setDayForBillDateViaDatePickerForGas(Integer.parseInt ((data .get(1).get(6))));
          }
          
          } else if (((data.get(1).get(3)).equals( "£"))) {
           energyPage.click£ForCurrentGasUsage();
           energyPage.set£TextForGas(Integer.parseInt(( data.get(1).get(4))));
           energyPage.set£ForGasDropdown(data .get(1).get(5));
                 if (!(data .get(1).get(5)).equals("Annually")){
                 energyPage.setDayForBillDateViaDatePickerForGas(Integer.parseInt ((data .get(1).get(6))));
          }
    }
           /**
           * Click next button and verify if user is on preferences page.
           */
           energyPage.clickNextButton();
           energyPage.verifyUserIsOnYourPreferencesPage();
    }
    @Given("^her preferences and contact details as$" )
    public void her_preferences_and_contact_details_as(DataTable yourPreferences){
           //Handle data table
          List<List<String>> data = yourPreferences .raw();
          
           /**
           * Set "What tariff are you interested in?"
           * Valid inputs: "Fixed tariff" or "Variable tariff" or "All tariffs"
           */
           if((data .get(1).get(0)).equals("Fixed tariff")){
           preferencesPage.clickFixedTariff();
          } else if (((data.get(1).get(0)).equals( "Variable tariff"))) {
           preferencesPage.clickVariableTariff();
          } else if (((data.get(1).get(0)).equals( "All tariffs"))) {
                 preferencesPage.clickAllTariff();
                }
          
           /**
           * Set "What payment type are you interested in?"
           * Valid inputs: "Monthly direct debit" or "Quarterly direct debit" or "Pay on receipt of bill" or "All payment types"
           */
           if((data .get(1).get(1)).equals("Monthly direct debit")){
           preferencesPage.clickMonthlyDirectDebit();
          } else if (((data.get(1).get(1)).equals( "Quarterly direct debit"))) {
           preferencesPage.clickQuarterlyDirectDebit();
          } else if (((data.get(1).get(1)).equals( "Pay on receipt of bill"))) {
                 preferencesPage.clickPayOnReceiptOfBill();
                } else if (((data.get(1).get(1)).equals( "All payment types"))) {
                       preferencesPage.clickAllPaymentTypes();
                      }
          
           /**
           * Set "Email Address"
           * Valid inputs: add a valid email address in.
           */
           preferencesPage.setEmailAddress(data .get(1).get(2));
          
           /**
           * Set "Marketing Information" checkbox
           * Valid inputs: "Yes" or "No"
           */
           if ((data .get(1).get(3)).equals("Yes")) {
                 preferencesPage.clickMarketingInformationCheckbox();
          } else if ((data.get(1).get(3)).equals( "No")) {
                 //do nothing
          }
          
           /**
           * Set "Terms & Conditions" checkbox
           * Valid inputs: "Yes" or "No"
           */
           if ((data .get(1).get(4)).equals("Yes")) {
                 preferencesPage.clickTermsAndConditionsCheckbox();
          } else if ((data.get(1).get(4)).equals( "No")) {
                 //do nothing
          }
           /**
           * Click Goto Your Prices and verify if the results page is shown.
           */
           preferencesPage.clickGotoPricesButton();
           preferencesPage.verifyUserIsOnYourResultsPage();
    }
    
    @Then("^Kiwi will be shown a list of tariff results$" )
    public void kiwi_will_be_shown_a_list_of_tariff_results()  {
        resultsPage.waitForResults();
    }
    @When("^Kiwi chooses the cheapest tariff that compare the market supports$")
    public void Kiwi_chooses_the_cheapest_tariff_that_compare_the_market_supports(){
        resultsPage.clickMoreDetailsOnHighestSavingSupplier();
    
    }
    @Then("^Kiwi can choose to switch to it and her journey ends$" )
    public void kiwi_chooses_the_cheapest_tariff_that_compare_the_market_supports()  {
           resultsPage.verifyMoreDetailsInformationIsDisplayed();
           resultsPage.validateSwitchNowButton();
    }

The above works fine, however, in order to utilise it cleanly, I would have to externalise it into another class and call it into the Step Definition file -> whilst passing the parameters across. In order to this, it would take quite a bit of time to implement so I removed it.


Improvements
----

1. The StepDefinition file has each step of the user journey, all of these methods can be grouped in to a single method i.e. "public void fillSupplierPage()".  
2. The code can be made a lot cleaner, there are locators inside methods, which can cause the framework to become brittle.
3. Use of BrowserFactory and implementing with Selenium Grid. It was tested with IE and Firefox. Firefox seemed to work fine in the e2e test run but IE couldn't locate a couple of ID's (test with complete 1.0 not checked).
4. A lot more can be done to improve it! 
