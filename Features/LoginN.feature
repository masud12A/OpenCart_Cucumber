Feature: Login With Valid Credentials

  @sanity @regression
  Scenario: Successfull Login with Valid Credentials
  Given the User navigates to login Page
  When User enters email as "mahamed@gmail.com" and password as "test@123"
  And the User clicks on the Login button
  Then the User should redirected to the MyAccount Page
  #@regression
  #Scenario Outline: Login data Driven
    #Given the User navigates to login Page
    #When User enters email as "<email>" and password as "<password>"
    #And the User clicks on the Login button
    #Then the User should redirected to the MyAccount Page
#
    #Examples: 
      #| email         | password |
      #| abc@gmail.com | test@123 |
      #| xyz@gmail.com | test@123 |
