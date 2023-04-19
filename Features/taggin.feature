
@TaggedHooks
Feature: Test tagged hooks
  @First
  Scenario: This is first scenario
    Given First in First step
    And second in first step
    When Third in first step
   @second
    Scenario: This is second scenario
    Given First in second step
    And second in second step
    When Third in second step

 