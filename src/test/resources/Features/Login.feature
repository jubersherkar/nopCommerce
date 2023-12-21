@smoke
Feature: Verify Login Functionality

Scenario Outline: Validate Login with valid username and valid password

Given User launch the browser
When User opens base url
And User enteres user id as "<email>"
And User enteres Password as "<password>"
When Click on login
Then User should be able to see dashboard 

Examples:

|email|password|
|admin@yourstore.com|admin|

Scenario Outline: Validate Login with valid username and invalid password

Given User launch the browser
When User opens base url
And User enteres user id as "<email>"
And User enteres Password as "<password>"
When Click on login
Then Error messege should be displayed

Examples:

|email|password|
|admin@yourstore.com|pass@123|

Scenario Outline: Validate Login with invalid username and valid password

Given User launch the browser
When User opens base url
And User enteres user id as "<email>"
And User enteres Password as "<password>"
When Click on login
Then Error messege should be displayed

Examples:
|email|password|
|abc@gmail.com|admin|

Scenario Outline: Validate Login with Invalid username and Invalid password

Given User launch the browser
When User opens base url
And User enteres user id as "<email>"
And User enteres Password as "<password>"
When Click on login
Then Error messege should be displayed as 
"""
Login was unsuccessful. Please correct the errors and try again. 
No customer account found
"""
															

Examples:
|email|password|
|abc@gmail.com|abc|
