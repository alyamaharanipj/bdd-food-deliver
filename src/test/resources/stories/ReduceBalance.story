Find out result of reduce balance

Narrative:
In order to reduce the balance
As a customer
I want to know how much the actual balance
					 
Scenario: Balance is higher than amount with no promo
Given akbar gopay account with balance is 20000
When amount of order is 12000
And promo is 0
Then the rest of balance is 8000 and cash 0

Scenario: Balance is lower than amount with no promo
Given rendi gopay account with balance is 15000
When amount of order is 20000
Then the rest of balance is 0 and cash 5000

Scenario: Balance is higher than amount with promo
Given fahmi gopay account with balance is 50000
When amount of order is 20000
And promo is 10
Then the rest of balance is 32000 and cash 0

Scenario: Balance is lower than amount with promo
Given rezky gopay account with balance is 13000
When amount of order is 20000
And promo is 10
Then the rest of balance is 0 and cash 5000 

Scenario: Balance is equals with amount with no promo
Given fuad gopay account with balance is 10000
When amount of order is 10000
Then the rest of balance is 0 and cash 0