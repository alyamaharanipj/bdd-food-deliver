Find out the best payment method

Narrative:
In order to pay for order
As a customer
I want to choose the best payment method

Scenario: Recommend payment method if balance enough
Given rhio has balance 1000
When amount is 500
Then system should recommend gopay payment method

Scenario: Recommend payment method if balance not enough
Given adjie has balance 10000
When amount is 15000000
Then system should recommend gopay+cash payment method

Scenario: Recommend payment method if balance is same amount
Given bian has balance 10000
When amount is 10000
Then system should recommend gopay payment method

Scenario: Recommend payment method if balance is zero
Given icwhan has balance 0
When amount is 10000
Then system should recommend cash payment method
