#Author: Zukky Baig | Zukky@hotmail.co.uk

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



