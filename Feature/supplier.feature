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
So that I can see which one is best for my needs

@compareGasElectric
Scenario: 1
Given I am successfully on Your Supplier page
And my postcode is "PE2 6YS"
And I click on find postcode 
And I do have my energy bill
And I want to compare Gas & Electricity prices
And I have different Gas & Electricity suppliers
And I click on British Gas as my electricity supplier
##And I click on the electricity other supplier dropdown and select "Avro Energy"
And I click on EDF Energy as my gas supplier
##And I click on the gas other supplier dropdown and select "Avro Energy"
When I click Next to continue
Then I should move successfully onto Your Energy page

@compareGasOnly

@compareElectricityOnly


