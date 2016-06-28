#Author: Zukky Baig | Zukky@hotmail.co.uk

Feature: CTM Energy User Journey for Duel Tariff and Single Tariff
As a user of Compare The Market Energy website
I want to compare prices for gas and electricity
So that I can see which one is best for my needs


@GreenPath 
Scenario: Comparing Gas & Electricity prices with a bill
Given Kiwi wants to compare Gas and Electricity prices and she does have her bill
When Kiwi enters her supplier, energy, preferences for both suppliers
Then Kiwi will be shown a list of tariff results
And Kiwi chooses cheapest tariff to view

@GreenPath 
Scenario: Comparing only Gas prices without a bill
Given Kiwi wants to compare only Gas prices and she doesn't have her bill
When Kiwi enters her supplier, energy, preferences for her gas supplier
Then Kiwi will be shown a list of tariff results
And Kiwi chooses cheapest tariff to view

@GreenPath 
Scenario: Comparing only Electricity prices with a bill
Given Kiwi wants to compare only Electricity prices and she does have her bill
When Kiwi enters her supplier, energy, preferences for her electricity supplier
Then Kiwi will be shown a list of tariff results
And Kiwi chooses cheapest tariff to view

