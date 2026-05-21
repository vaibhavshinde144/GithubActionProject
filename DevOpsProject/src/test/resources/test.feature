Feature: Login Functionality
Background: Login Page

@SystemTesting

Scenario: User login with valid creadiantials
  Given the user is on Demo Web Shop login page
  When the user enters a valid creadiantials and clicks on the login button
  Then the user should be redirected to Home page
  
Scenario Outline:User login with invalid crediantials
  Given the user is on Demo Web Shop login page
  When the user enters a invalid "<userName>" and "<password>" clicks on the login button
  Then the user should see an error message
  
  Examples:
|userName|password|
|incorrectUser|Password123|
|student|incorrectPassword|