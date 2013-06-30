Feature: Login into an user account
As a user
I want to login into my account
So that i can use OFK

Scenario: Login into an existing user account
Given <email> is correct
And <password> is correct
When I try to login
Then login should be successful
And user page should be displayed

Scenario: Login into an not existing user account
Given <email> isn't stored
When I try to login
Then login should not be successful
And a warning should be displayed

Scenario: Login with an incorrect <password>
Given <email> correct
And <password> incorrect
When I try to login
Then login should not be successful
And a warning should be displayed