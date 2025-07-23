Feature: Login - Saucedemo

  Scenario: Successful login
    Given I open the login page
    When I input username "standard_user"
    And I input password "secret_sauce"
    And I click the login button
    Then I should see the products page