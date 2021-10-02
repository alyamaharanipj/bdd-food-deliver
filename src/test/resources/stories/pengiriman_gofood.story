Finding nearest driver based on merchant's location

Narrative:
In order to get optimal delivery time
As a customer
I want to find the nearest driver from merchant's location

Scenario:  Find the nearest driver
Given a list of drivers : Jono, Kasino, Dono
When The distances between these drivers and the merchant location are : 1.5, 2, 0.5
Then The sistem should pick : Dono

Scenario:  Find driver with highest rating
Given drivers list : Jono, Kasino, Dono
When The rating of each driver : 4.9, 4.5, 4
Then The sistem should choose : Jono

Scenario:  Find the best driver based on distance and rating
Given list of driver : Jono, Kasino, Dono
When The score from rating and distance of each driver : 10.1, 15.5, 1
Then The sistem should choose the best name : Dono