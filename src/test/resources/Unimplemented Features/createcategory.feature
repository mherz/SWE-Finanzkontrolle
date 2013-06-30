Feature: Create categories
As a user 
I want to create categories
So that I can group costs and income

Scenario: Creating a new category
Given a category with <name> does not exist already
When I enter a <name> and click on create
Then a new category should be created
And stored in the database

Scenario: Creating a new category with already existing <name>
Given a category with <name> does already exist for the account
When I enter a <name> and click on create
Then a warning should be displayed