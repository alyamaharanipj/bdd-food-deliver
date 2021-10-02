Save a history of each purchase

Narrative:
In order to See a list of purchase history
As a Customer
I want to Save my purchase history

Scenario:  Save order history
Given List of orders : Sate Markonah, Baso Dono, Martabak Jono
And the location : Sarijadi, Sariwangi, Cibabat
And the menu : 10 Tusuk sate, 1 porsi baso, 1 loyang keju coklat
When Order are : Complete, incomplete, Complete
Then Save information to order history : Sate Markonah Sarijadi 10 Tusuk sate, Martabak Jono Cibabat 1 loyang keju coklat