@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Validate whether customer is able to generate id
    Given user navigate guru page and clicks add customer
    When user fill required fields and clicks submit button
      | fname  | lname | email          | address | mobno      |
      | venkat | sm    | vena@gmail.com | jbhcgh  | 9876548542 |
      | ram    | ve    | a@gmail.com    | theni   | 9636548542 |
    Then check whether customer id is generated
