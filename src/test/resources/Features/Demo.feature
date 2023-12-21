@Demo
Feature: Verify Home page

Scenario: Validate title of home page

Given User opens browser
When User enters URL
Then User should be able to see title as "Your store. Login"