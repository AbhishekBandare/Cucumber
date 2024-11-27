Feature: Pack & go page
 I want to login this page
 
 Background:
 Given Login to the Site with credentials given above
 
 Scenario: Pack & go login
 When  User must perform a new booking
 Then On successful booking, print the success message in the console 
 And close the driver
 
 