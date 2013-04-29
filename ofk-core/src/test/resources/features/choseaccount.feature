Feature: Chose an account for setting costs and income
As a user
I want to chose an account
So that i can costs and income for it

Scenario: Choose an for displaying/editing costs and income
Given one or more <account> exists
When an <account> is chosen 
Then costs and income should assigned to this account

Scenario: No <account> is chosen
Given <account> exists or not
When no <account> is chosen
Then a warning should be displayed 