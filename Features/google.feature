
Feature: This is to test Google Search

  Scenario: Google search Scenario
    Given user is entring https://www.google.co.in/
    And user is typing the search term "iphone"
    When Enter the return key
    Then user should see the search result
   

