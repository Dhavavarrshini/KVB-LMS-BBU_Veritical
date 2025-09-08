Feature: Assigned Leads management

  Background:
    Given user navigates to the login page
    When the user enters valid username and password
    Then the user should be logged in successfully

  @LeadCreationByFillingAllTheFields
  Scenario: Create a new Lead by filling all the fields
    Given user navigates to the Assigned Leads page
    When the user creates a new Lead by filling in all the fields
    Then the new Lead should be created successfully and displayed in the Assigned Leads list
