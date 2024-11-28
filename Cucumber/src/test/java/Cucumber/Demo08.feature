#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@dragDrop
Feature: demo of drag and drop

  Scenario: darg and drop
    Given user open the demQA website
    When user perfrom action of drag and drop
    Then clsoe the browser

  @Testing
  Scenario Outline: pack and go
    Given user open the pact and go website in chrome
    When user logged in "<username>" and password "<pass>"
    Then close chrome

    Examples: 
      | username | pass      |
      | pgGru    | freezeray |
