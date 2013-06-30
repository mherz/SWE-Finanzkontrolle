Feature: Moment viewing
As a user
I want to see a moment viewing
So that I can get an overview for income and costs at the moment

Scenario: Moment viewing for overall costs and income
Given I'm at the page Übersicht
And a category must be selected
When I select Pie Chart from Chart Art 
Then the moment viewing should be displayed