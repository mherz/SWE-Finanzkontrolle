Feature: Create a new user account
As a visitor
I will be able to register
So that i can use OFK

Scenario: A visitor want to create a new user Account
Given a user account for <email> does not exist
When I submit the registration form
Then a new user account should be created
And stored in the database

Scenario: A visitor want to create a new user Account with an already stored <email>
Given the used <email> does already exist
When I submit the registration form
Then a warning should be displayed