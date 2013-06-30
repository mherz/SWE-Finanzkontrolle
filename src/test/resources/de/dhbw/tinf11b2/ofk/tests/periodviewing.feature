Feature: Period viewing
As a User
I want to see a period viewing
So that I get an overview for costs and income about a period

Scenario: Period viewing for income with default values 
Given I'm at the page Übersicht
And a category must be selected
When I click on Einnahmen Übersicht
Then the period viewing for income should be displayed

Scenario: Period viewing for costs with default values 
And a category must be selected
Given I'm at the page Übersicht
When I click on Ausgaben Übersicht
Then the period viewing for costs should be displayed