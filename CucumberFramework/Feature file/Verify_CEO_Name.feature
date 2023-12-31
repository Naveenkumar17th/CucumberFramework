@GetCEOName
Feature: This feature to get the CEO name from the OrangeHRM app
Scenario Outline: This test is to verify the CEO Name
Given the user is logged in successfully and is on Home Page
When the user clicks on the directory option from the menu bar
And the user selects the job title as "Chief Executive Officer" from the drop down
And clicks the search button
Then the user should see the CEO name as "<CEO_Name>"
Examples:
|CEO_Name|
|John Smith|