Feature: Insert income into an account
As a user
I want to insert income into one of my account
So that i can display it in different ways

Scenario: a single income should be inserted into an <account>
Given an existing <account> is chosen
When I enter €100 single income
Then €100 should added to the <account>
And the transaction should stored in the database

Scenario: a regular income should be inserted into an <account>
Given an existing <account> is chosen
When I enter €100 periodic income
Then €100 should added to the account every period
And the transaction should stored in the database every period

Scenario: a negative income should be inserted into an <account>
Given an existing <account> is chosen
When I enter -€100 as income
Then an error message should be displayed