#Author: a.sarancha@tcs.com
Feature: Use the website to find restaurants
  So that I can order food 
  As a hungry customer
  I want to be able to find restaurants in my area

  @First
  Scenario: Search for restaurants in an area
    Given I want food in "AR51 1AA"
    When I search for restaurants
    Then I should see some restaurants in "AR51 1AA"

  @Second
  Scenario: Search for restaurants in an area and picking a specific brand
    Given I want food from KFC in "AR51 2AA"
    When I search for KFC restaurants
    Then I should see some restaurants in "AR51 2AA"

  @Third
  Scenario: Search for restaurants in an area and picking a specific cuisine
    Given I want indian food in "AR51 3AA"
    When I search for indian restaurants
    Then I should see some restaurants in "AR51 3AA"
