Feature: Calculator
 
Scenario Outline: Add two numbers
Given I have entered <First> into the calculator
And I press add
And I have entered <Second> into the calculator
When I press Equals
Then Result should be <Result> on the screen
Examples:
| First | Second | Result |
| 50    | 70     | 120    |