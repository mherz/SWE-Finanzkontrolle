Feature: Insert costs into an account
As a user
I want to insert costs into one of my account
So that i can display it in different ways

Scenario: a single costs should be inserted into an <account>
Given an existing <account> is chosen
When I enter €100 single costs
Then €100 should removed from the <account>
And the transaction should stored in the database

Scenario: a regular costs should be inserted into an account
Given an existing <account> is chosen
When I enter €100 periodic costs
Then €100 should removed from <account> every period
And the transaction should stored in the database every period

Scenario: a negative income should be inserted into an <account>
Given an existing <account> is chosen
When I enter -€100 as costs
Then an error message should be displayed