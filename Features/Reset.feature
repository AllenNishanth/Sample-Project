
Feature: Verifying the functional part of functional application
 
  Scenario: Verification of Reset Button in Hotel Page
    Given User giving valid username and Password
    And user click the login Button
    And the user verify the search hotel is verify or not with the reset Button
    Then the user enter the valid details in the given field
    Then User click on the reset button 
    And the entered values change to default value
    

 