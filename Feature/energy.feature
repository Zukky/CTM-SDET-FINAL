#Author: Zukky Baig | Zukky@hotmail.co.uk
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)

#Sample Feature Definition Template



Feature: CTM Energy User Journey for Duel Tariff Purchase
As a user of Compare The Market Energy website
I want to compare prices for gas and electricity
So that I can purchase the best one for my needs

Background: CTM Energy website is available
Given Compare The Market Energy website is available
And Your Supplier page is loaded

@compareGasElectric
Scenario:
Given I am on the Your Supplier website
When I enter my postcode in as ""
And I fill in my Supplier details
And I fill in my Electricity and Gas details
And I fill in my Preferences and Contact details
Then I should see My Results page
When I choose a tariff
And I fill in my Personal and Bank details
Then I should successfully see my Reference Number 







Scenario: Your Supplier Page e2e
Given User is on Your Supplier page
And my postcode is "PE2 6YS"
And I click on find postcode
And I do have my energy bill
And I want to compare Gas & Electricity prices
And I have different Gas & Electricity suppliers
When I click on British Gas as my electricity supplier
But I click on the electricity other supplier dropdown and select "E"
And I click on EDF Energy as my gas supplier
But I click on the gas other supplier dropdown and select "NEG"
And I click Next to continue
Then I should move successfully onto Your Energy page



@tag
Feature: 




Buy a Duel Fuel tariff
	In order to ensure I can purchase a duel fuel tariff (Gas & Electricity), 
	I want to run a cucumber test to compare Gas & Electricity combined prices and then I want to purchase it.
	This is a full end-to-end user journey from selecting, entering and purchasing a duel fuel tariff.

@tag1
Scenario: Your Supplier Page e2e
Given User is on Your Supplier page
And my postcode is "PE2 6YS"
And I click on find postcode
And I do have my energy bill
And I want to compare Gas & Electricity prices
And I have different Gas & Electricity suppliers
When I click on British Gas as my electricity supplier
But I click on the electricity other supplier dropdown and select "E"
And I click on EDF Energy as my gas supplier
But I click on the gas other supplier dropdown and select "NEG"
And I click Next to continue
Then I should move successfully onto Your Energy page

