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
@tag
Feature: Buy a Duel Fuel tariff
	In order to ensure I can purchase a duel fuel tariff (Gas & Electricity), 
	I want to run a cucumber test to compare Gas & Electricity combined prices and then I want to purchase it.
	This is a full end-to-end user journey from selecting, entering and purchasing a duel fuel tariff.

@tag1
Scenario: Title of your scenario
Given I am successfully on Your Supplier page
And my postcode is "PE2 6YS"
And I click on find postcode
And I do have my energy bill
And I want to compare Gas & Electricity prices
And I have different Gas & Electricity suppliers
##When I click on British Gas as my electricity supplier
##And I click on other supplier dropdown and select Spark Energy
##And I click Next to continue
##Then I should move successfully onto Your Energy page

