Feature: Create an account for storing costs and income
As a user
I want to create one or more accounts
So that i can store my costs and income

Scenario: Create a new account for storing costs and income
Given a user account exists
When I enter a <name> for the new account
Then the new account should stored in the database

Scenario: Create a new account with already existing name
Given a user account already exists
When I enter a <name> for the new account which is already in use
Then an error should displayed

