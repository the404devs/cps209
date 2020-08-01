# CPS209 Assignment 2:

#

**Extended Car Dealership Simulator**

#

# Due Date: Fri., Apr. 12 11:59pm

#

#

#

You are to extend the Car Dealership Simulator program from assignment 1. This programming assignment will increase your knowledge of collections, file IO and exceptions, objects and classes, inheritance, and interfaces. **You must do this assignment alone – no groups. Do not attempt to find source code on the web for this assignment. It will not help you and you risk extremely serious consequences. Your program will be checked for plagiarism.** Begin designing and programming early! This assignment is worth 10 percent of your mark. **If there is some part of the assignment you do not understand, please see me (or email me) or ask me in the lecture as soon as possible and I will clarify the issue.**

### Program Functionality Requirements:

### Please look at the video included with this assignment. Below is a description of the classes for your assignment and in some cases, list of methods and variables. NOTE:I would like you to extend your assignment 1 (A1) and keep the classes as they were except for changes and additions specified below. I strongly suggest you build your program in pieces. Get one piece compiled and working before working on the next piece. Read the marking scheme below and use it as a guide. You are permitted to add other instance variables and other methods if you think they are necessary. In class, I will answer questions about the assignment – please speak up!

### NOTE: if you want to extend my solution to assignment 1, then I will post it by the middle of next week, once everyone has handed in their assignment 1.

### Complete!
1. 1.class _Vehicle:_ Class _Vehicle_ remains the same as in A1 with except for the following:
  1. a.add an instance variable _VIN_ (type int) which is the Vehicle Identification Number (all real cars and other vehicles have a VIN). In the constructor method, use a Random Number Generator to create a VIN between 100 and 499. The display method should add the VIN to the beginning of the string.

1. 2.class Car and Class ElectricCar: Remain the same as in A1

1. 3.class _CarDealership:_ Class _CarDealership_ has a few changes. It has additional instance variables and it has the same methods as before except some are modified.

### Complete
1.
  1. a.In addition to an ArrayList of Car objects, add a _SalesTeam_ object (see description 8 below) and an _AccountingSystem_ object (see description 7 below).
  2. b.public String buyCar(int VIN): this method now takes an int VIN as argument and does the following: searches through the array list of Car objects to find a Car object with a matching VIN. Once found, _removes_ the car object from the array list. Then, it retrieves a (random) sales person string from the _SalesTeam_ object. It also creates a random month and day and creates a _GregorianCalendar_ date object (using the year 2019).  See the example program posted with this assignment to demonstrate the use of the _GregorianCalendar_ class. Finally, it adds the car reference, date, sales person, and the price of the car to the AccountingSystem object (see class _AccountingSystem_) using the _add()_ method of this class. A transaction record (i.e. a receipt) of type String is returned by the _add()_method and this string is then returned by _buyCar()_. This method should check to make sure the VIN is valid or if the number of cars in the array list is not 0. If so, it should throw an exception.

1.
  1. c._public void returnCar(int transaction)_: this method now takes an integer transaction number as its argument. It uses the _getTransaction(int transaction)_ method of class _AccountingSystem_ which finds the _Transaction_ object associated with the previous BUY command. See class _Transaction_ below. It generates a new random date that is later in the same month as the BUY date. For example, if the BUY date was March 15, 2019 then a return date could be March 27,2019. It uses the information stored in the Transaction object and the new date and calls the _add()_ method of the AccountingSystem object – the _add()_ method will create a separate Transaction for the return of the Car object. It also adds the Car object back to the array list of Car objects.

1. 4.class _CarDealershipSimulator_. This class has a few more commands and also must now use FileIO to read the information in _cars.txt_ into an array list of Car objects – which is then given to the CarDealership object via the addCars() method as before in A1. All exceptions thrown anywhere in the program should be caught and dealt with in themain() method. In addition to altering the BUY and RET command to fit with the new interface of the buyCar() and returnCar() methods, here are additional commands you must implement:
  1. a.&quot;SALES&quot;: prints all transactions for the year (2019)
  2. b.&quot;SALES TEAM&quot;: prints the names of all the sales persons
  3. c.&quot;SALES TOPSP&quot;: prints the sales person who sold the most number of cars for the year. If there is a tie, print both. Print the name and number of cars sold
  4. d.&quot;SALES _m_&quot;: _m_ is a month number (e.g. 0 is January, Feb = 1 etc). Prints all transactions for a month
  5. e._&quot;__SALES STATS&quot;_: prints the total sales ($ value) for the year, the average sales ($ value) per month, the total number of cars sold, the highest sales month (in terms of #cars), the total car returns.
2. 5.Please add approximately 20 cars to cars.txt for a total of 25-30 cars. Make up new cars as you please (e.g. Bentley SEDAN …).

1. 6.class _Transaction:_ Objects of this class store information about a the buying of a car or the returning of a car. The information should be the transaction id (int), the date of the transaction (use GregorianCalendar), a reference to the Car object, the name of the sales person, the type of transaction (&quot;BUY&quot; or &quot;RETURN&quot;) and the sale price. The sale price is also stored in the Car object but this transaction sale price could be different (not in this assignment but in general it could be). The class should have a constructor method and a _display()_ method that returns a String. Use the _SimpleDateFormat_ class to display the date (see the example program posted with the assignment).

1. 7.class _AccountingSystem:_ holds an array list of _Transaction_ objects.  Should have at least the following public methods (feel free to add helper methods):

1.
  1. a._String add(Calendar date, Car car, String salesPerson, String type, double salePrice)_ : this method takes in information about a type of transaction (&quot;BUY&quot; or &quot;RET&quot;), generates a random transaction id (an integer between 1 and 99), creates a new Transaction object and adds it to the array list. It returns a String by calling the display method of the Transaction object.
  2. b._public Transaction getTransaction(int id)_: takes in a transaction id and searches through all the Transaction objects to find one with a matching id. If it is found, return a reference to it. If not, return null.
  3. c.Add other appropriate public methods to support the SALES commands listed in the simulator class above.
2. 8.class _SalesTeam:_ this class has a _LinkedList_ of _Strings._ You must use Java&#39;s LinkedList class (even though an array list may be more suitable). Create a constructor method that creates a new LinkedList object and then adds 5 or 6 sales person names (i.e. Strings) to the LinkedList.  Add public methods to: 1) return a sales person String. Use a random number generator to randomly choose a sales person from the linked list. 2) display all the sales person names in a string. You must use a _ListIterator_ to iterate through the linked list and create a string. Add other public methods as you see fit: for example, return the number of sales persons on the team, get the _ith_ sales person in the list etc.

1. 9._BONUS_: instead of an array list of Transaction objects in the _AccountingSystem_ class, use a java map (_HashMap_ or _TreeMap_) that maps an integer transaction number to a Transaction object. All the methods must in class _AccountingSystem_ must work with the map.

### Grading (Out of 10 marks)

### Highest Grade Possible: 11

| File IO and Exceptions working | 3 marks |
| --- | --- |
| **buyCar** method working with VIN – no Transactions or Accounting System | 1 marks |
| class **Transaction** , **AccountingSystem** , **SalesTeam** correctly working with commands in simulator and CarDealership | 6 marks |
| Bonus: correct use of Map | 1 mark |
| Penalty for insufficient comments or bad program structure | Up to -1 marks |

### Submitting Your Assignment: READ CAREFULLY!!

- .Use D2L to submit your assignment.
- .Inside each of your &quot;.java&quot; files have your name and student id as comments at the top of the file. Make sure your files can be compiled as is without any further modification!!
- .Include a README.txt file that describes what aspects of your program works and what doesn&#39;t work (or partially works). If your program does not compile, state this!! You will still get part marks. The TA will use this file as a guide and make fewer marking mistakes.
- .Place all your &quot;.java&quot; file(s) and README.txt file into an archive (zip or rar archiving format only).
- .Open your archive and make sure your all your files are there.
- . **Do not include &quot;.class&quot; files!!!!**
- .Do not use any Package keyword in your java files!!!
- .Once everything is ready, submit it.