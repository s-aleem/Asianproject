@contractor
Feature: Features of Contractor page should work properly 


Background: 
Given User navigates to contractors list page
@contractor
Scenario Outline: User should able to select radio buttons in CATEGORY
When User search with ZipCode "<zipcode>"
Then User should click on search button
And User can able to select one of radio buttons in CATEGORY
Then User wants to see appropriate contractors list

Examples: 

		| zipcode | 
		| 500075	|
@contractor
Scenario Outline: User should able to select radio buttons in RATING AND REVIEW 
When User search with ZipCode "<zipcode>"
Then User should click on search button
And User can able to select contractor by Rating and Review 
Then User wants to see appropriate contractors list

Examples: 

		| zipcode | 
		| 500075	|
@contractor
Scenario Outline: User should able to click on call back button  

When User search with ZipCode "<zipcode>"
Then User should click on search button 
Then User shoule able to see Call back button option 
And User should click on CALL ME BACK BUTTON without entering phone number
Then User should get message required field 

Examples: 

		| zipcode | 
		| 500075	|
@contractor
Scenario Outline: User can enter valid mobile number to take call backs successfully
When User search with ZipCode "<zipcode>"
Then User should click on search button
Then User should click on edit button 
And User should able to enter valid mobile number "<validMobileNumber>"
And User should click on CALL ME BACK button
Then User can see successfull submision  

Examples: 

		| zipcode | validMobileNumber | 
		| 500075	| 6302680674        |
@contractor
Scenario Outline: User can enter invalid mobile number but he/she should not take call backs 
When User search with ZipCode "<zipcode>"
Then User should click on search button
Then User should click on edit button 
And User should able to enter invalid mobile number "<invalidMobileNumber>"
And User can click on CALL ME BACK button 
Then User should see invalid mobile number 

Examples: 

		| zipcode | invalidMobileNumber|
		| 500075	| 630268067          |



