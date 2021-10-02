Find out which products are on sale

Narrative:
In order to get the best deals available
As a customer
I want to know which products are on sale
	
Scenario: Find products on sale
Given a list of products : Whopper Meal Medium, Paket Geprek Bensu, Paket McSpicy Smokey BBQ Medium
When these products are discounted in the same order: 20%, 0%, 40%
Then I should be told about the products : Whopper Meal Medium, Paket McSpicy Smokey BBQ Medium

Scenario: Sort products on sale from the closest distance to the furthest
Given a list of products on sale : Whopper Meal Medium, Paket Geprek Bensu, Paket McSpicy Smokey BBQ Medium
When the distances between the product and the customer in the same order are : 0.4, 1.9, 0.8 in kilometers
Then I should be told about the products from the closest distance to the furthest : Whopper Meal Medium, Paket McSpicy Smokey BBQ Medium, Paket Geprek Bensu

Scenario: Sort products on sale with the same distance from the highest rate
Given a list of products on sale with the same distance : Whopper Meal Medium, Paket Geprek Bensu, Paket McSpicy Smokey BBQ Medium
When the rates of the products are : 4, 3.9, 4.5 in stars
Then I should be told about the products in order from the highest rating to the lowest : Paket McSpicy Smokey BBQ Medium, Whopper Meal Medium, Paket Geprek Bensu
 
Scenario: Sort products on sale by category if distance and rating are the same
Given a list of products on sale with the same distance and rating : Bubble Gum Fizz, Big Mac, Fanta McFloat
When the category of products are : Drink, Food, Drink
Then I should be told about the products in order from foods to drinks : Big Mac, Bubble Gum Fizz, Fanta McFloat