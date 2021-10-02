Order food

Narrative:
In order to get food that i want
As a customer
I want to order food
					 
Scenario:  Choose food
Given a list of restaurant : McDonalds, Richeese, Xing Fu Tang
And the menus are : BigMac, Ayam Hitam, Brown Sugar Boba
And the price : 20000, 23000, 25000
When i choose BigMac
Then the order details like restaurant's name : McDonalds and menu's name : BigMac and price : 20000 and quantity : 1 added to cart

Scenario: Add quantity of food
Given an order details in cart like restaurant : McDonalds and menu : BigMac and price : 20000 and quantity : 1
When i add 1 more the BigMac
Then the quantity of BigMac will be change into 2	

Scenario: Reduce quantitiy of food 
Given an order details in cart restaurant :  McDonalds and menu : BigMac and price : 20000 and quantity : 2
When i reduce 1 quantity of the BigMac
Then BigMac quantity will be changed into 1

Scenario: Remove order
Given an order details in cart : McDonalds and menu : BigMac and price : 20000 and quantity : 0
When i remove BigMac
Then my cart is empty

Scenario: Choose address
Given a list of address : Ciwaruga No 21, Sarijadi No 15, Gegerkalong No 5 
When i pick address : Ciwaruga No 21
Then Ciwaruga No 21 added to location

Scenario: add notes for address
Given a blank address notes
When I write my details address : sarjad
Then address notes contain sarjad

Scenario:  add notes product
Given a blank product notes
When I write details request : gak pake cuka mang
Then product notes contain gak pake cuka mang

Scenario: Total Price
Given i've food in my cart with details restaurant's name : McDonalds and menu's name : BigMac and price : 20000 and quantity : 2
When i want to know total price of BigMac that i buy
Then the total price of BigMac that i buy is 40000

Scenario: Discount Voucher
Given I have list of discount voucher : 30, 35, 50 in %
And my cart with details restaurant's name : McDonalds and menu's name : BigMac and price : 20000 and quantity : 5
When I use voucher for 50 % discount for BigMac
Then total price of BigMac will change into 50000