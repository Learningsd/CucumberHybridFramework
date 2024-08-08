Feature: Registration Functionality

  Scenario: User creates an Account  only with Mandatory Fields
    Given User Navigates to Register Account Page
    When User enters the details into below fields
      | firstname | ameer            |
      | Lastname  | syed             |
      | telephone |         85254669 |
      | password  | Abc@123          |
    And User select privacy policy
    And User clicks on continue button
    Then User Account should get created successfully

  Scenario: User creates an Account with All Fields
    Given User Navigates to Register Account Page
    When User enters the details into below fields
      | firstname | ameer            |
      | Lastname  | syed             |
      | telephone |         85254669 |
      | password  | Abc@123          |
    And User select Yes for Newsletter
    And User select privacy policy
    And User clicks on continue button
    Then User Account should get created successfully

  Scenario: User creates A Duplicate Account
    Given User Navigates to Register Account Page
    When User enters the details into below fields with SameEmail
      | firstname | ameer            |
      | Lastname  | syed             |
      | email     | syed33@gmail.com |
      | telephone |         85254669 |
      | password  | Abc@123          |
    And User select privacy policy
    And User clicks on continue button
    Then User should get proper Warning message About Duplicate email

  Scenario: User creates an Account  Without Filling Any Details
    Given User Navigates to Register Account Page
    When User  dont enter any details into fields
    And User clicks on continue button
    Then User should get proper Warning message for Every Mandetory Fields
