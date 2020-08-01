World's Worst Car Dealership™
--------------------------
Owen Goodwin (500909196)
For CPS209
04/12/19
--------------------------
You might wanna do a quick ctrl+f for "PHASE 2", that'll quickly show you the new stuff I've added in each file.
Completely new classes:
	- AccountingSystem
	- SalesRep
	- SalesTeam
	- Transaction
Modified classes:
	- CarDealership
	- CarDealershipSimulator
	- Vehicle
Stuff unchanged since last time:
	- Car
	- ElectricCar
	- RangeComparator
	- SafetyComparator

Again, just make sure you've got cars.txt as well as art.txt in your working dir and you're good to go!

After a transaction, a receipt is shown, such as:
#19: 2019/09/30 (Bob3, BUY, $35040.0) [372 ZipZip pink MOTORBIKE 780 8.2 35040.0 false]
The first value (19) is the transaction ID, which you'll use to return that car.