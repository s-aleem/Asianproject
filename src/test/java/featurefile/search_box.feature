@search
Feature: Search Box functionality


Background: 
Given User navigate to contractor page 
@search
Scenario Outline: User should be able to search contractos list with valid zipcod
When User enters valid zipcode "<validZipcode>"
Then User click on search icon 
Then User should able to see contractors list

	Examples:
		| validZipcode | 
		| 500075			 |
@search		
Scenario Outline: User should not be able to see contractos list with invalid zipcod
When User enters invalid zipcode "<invalidZipcode>"
Then User click on search icon 
Then User should get messasge "Enter a valid 6 digit Zip Code"

  Examples:
		| invalidZipcode | 
		| 575			       |
@search				
Scenario Outline: User should be able to search contractos list with valid city name
When User enters valid city name "<validCity>"
Then User can select city from dropdownlist 
Then User click on the ssearch icon 
Then User should able to see the "Asian Paints Trained Contractors"

 Examples:
		| validCity    | 
		| Hyderabad	   |
 @search 				
Scenario Outline: User should not be able to see contractos list with invalid city name
When User enters invalid city name "<invalidCity>"
Then User click on search button
Then User should get the message "Select City from Suggestion List" 

  Examples:
		| invalidCity      | 
		| incorrectcity		 |
  

  

					
					
				