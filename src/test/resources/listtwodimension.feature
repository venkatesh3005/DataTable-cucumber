
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario:  Validate whether customer is able to generate id
     Given user in guru page and clicks add customer
    When user fills all fields and clicks submit button
    |venkatesh|sm|venkat@gmail.com|theni|1234567892|
    |venkat|sm|test@gmail.com|madurai|9586123485|
     Then validate customer id is generated

