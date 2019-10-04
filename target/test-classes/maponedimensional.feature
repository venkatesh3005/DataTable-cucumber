@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Validate whether customer is able to generate id
    Given user navigates guru page and clicks add customer
    When user fill all fields and clicks submit button
      | fname   | venkat         |
      | lname   | sm             |
      | email   | vena@gmail.com |
      | address | jbhcgh         |
      | mobno   |     9876548542 |
    Then validate whether customer id is generated
