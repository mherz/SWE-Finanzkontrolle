Feature: Chose a category for costs and income
As a user
I want to choose categories
So that I can group my costs and income

Scenario: A category is chosen
Given one or more categories exists for an account
When a category is chosen
Then costs and income should assigned to this category

Scenario: No category is chosen
Given categories exists or not
When no category is chosen
Then a warning should be displayed