Feature: Identify New Bikes and Used Cars in Chennai

  Scenario: New Honda Bikes under 4 Lakhs
    Given navigate to the new bikes in zigwheels
    When navigate to upcoming bikes
    When select Honda in manufacturers
    Then get the bikes under 4L

  Scenario: Used Popular Model Cars in Chennai
    Given navigate to used cars in chennai
    Then get the popular model cars

  Scenario: Invalid Login
    Given navigate to home page
    When click login
    Then enter invalid credentials
    And validate the error message
