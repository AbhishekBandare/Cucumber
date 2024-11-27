Feature: same scenario for two times

  #Scenario Outline technique is used to run the same scenario for two or more sets of test data.
  Scenario Outline: passing set of user on  Pack & go login website
    Given Login to the Site
    When user enter the username "<username>" and password "<password>"
    Then Check the status of the login & close the broswer

    Examples: 
      | username | password  |
      | pgGru    | freezeray |
      | pgAlmac  | freezeray |
