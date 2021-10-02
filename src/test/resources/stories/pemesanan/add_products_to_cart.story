Adding products to the shopping cart

Narrative:
In order to order multiple products at once
As a customer
I want to store selected products to a shopping cart
					 
Scenario: Adding a product to an empty cart
Given an empty cart
And a list of products name : Whopper Meal Medium, Paket Geprek Bensu, Paket McSpicy Smokey BBQ Medium
And the product's merchants in the same order are : Burger King, Geprek Bensu, McDonald's
When I add 2 of Whopper Meal Medium to the cart
Then there should be 2 of Whopper Meal Medium inside the cart

Scenario: Adding a product to a cart filled with products from the same merchant
Given a list of products name : Whopper Meal Medium, Paket Geprek Bensu, Paket McSpicy Smokey BBQ Medium, Fish Fillet
And the product's merchants in the same order are : Burger King, Geprek Bensu, McDonald's, Burger King 
And a cart filled with 2 of Whopper Meal Medium from Burger King
When I add 3 of Fish Fillet to the cart
Then there should be 2 of Whopper Meal Medium inside the cart
And there should be 3 of Fish Fillet inside the cart



