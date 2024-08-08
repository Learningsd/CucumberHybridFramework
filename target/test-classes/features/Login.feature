Feature: Login Functionality

  Scenario Outline: Login With Valid Credentials
    Given User has Navigated to Login Page
    When User has entered Valid email address <username> into email field
    And User has entered Valid Password <Password> into password filed
    And User clicks on Login button
    Then user Should got successfully login in
    Examples:
    |username               |Password|
    |syed33@gmail.com       |Abc@123 |
    |amotooricap1@gmail.com |12345   |
    |amotooricap2@gmail.com |12345   |
    |amotooricap3@gmail.com |12345   |
    

  Scenario: Login With Invalid Credentials
    Given User has Navigated to Login Page
    When User has entered InValid email address into email field
    And User has entered InValid Password "1533663" into password filed
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch

  Scenario: Login With valid Email Address and Invalid Password
    Given User has Navigated to Login Page
    When User has entered valid email address "syed33@gmail.com" into email field
    And User has entered InValid Password "1533663" into password filed
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch

  Scenario: Login With Invalid Email Address and Valid Password
    Given User has Navigated to Login Page
    When User has entered InValid email address into email field
    And User has entered valid Password "154633663" into password filed
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch

  Scenario: Login Without Credentials
    Given User has Navigated to Login Page
    When User dont enter  email address into email field
    And User dont enter Password into password filed
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch
