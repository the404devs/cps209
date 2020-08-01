# CPS209 Assignment 1:

**Car Dealership Simulator**

# Due Date: Tues., Mar. 20 11:59pm

You are to write a Car Dealership Simulator program. This programming assignment will increase your knowledge of array lists, objects and classes, inheritance, and interfaces. **You must do this assignment alone – no groups. Do not attempt to find source code on the web for this assignment. It will not help you and you risk extremely serious consequences. Your program will be checked for plagiarism.** Begin designing and programming early! This assignment is worth 10 percent of your mark. **If there is some part of the assignment you do not understand, please see me (or email me) or ask me in the lecture as soon as possible and I will clarify the issue.**

**NOTE: some parts of the assignment are using java concepts we have not yet studied (e.g. interface Comparable and interface Comparator, the use of the super keyword). These topics will be covered in detail the two weeks after the break. You may want to wait until these topics are covered before writing the code that uses them. I suggest you start with a basic class Vehicle and Car and also the class CarDealership and CarDealershipSimulator – see grading scheme below.**

### Program Functionality Requirements:

### Please look at the video included with this assignment. Below is a description of the classes for your assignment and list of methods and variables. NOTE:I would like you to follow the description closely for this assignment (use the same class names and variable names etc). I strongly suggest you build your program in pieces. Get one piece compiled and working before working on the next piece. Read the marking scheme below and use it as a guide. You are permitted to add other instance variables and other methods if you think they are necessary. In class, I will answer questions about the assignment – please speak up!

1. 1.Create a class _Vehicle_. Class _Vehicle_ should contain instance variables _mfr_ (abbreviation for manufacturer) of type String, _color_ (type String), _power_ (type int), _numWheels_ (type int). Also create public integer constants like _ELECTRIC\_MOTOR, GAS\_ENGINE_ etc_. that are set to 0, 1, etc._ and are used as the values for the variablepower_._ Here are the required methods for class Vehicle (you may add more methods if you deem them necessary):
  1. a.A constructor method with parameters to initializes the instance variables.
  2. b._Get_ and _Set_ methods for the instance variables
  3. c.A method _public boolean equals(Object other)_. This method should compare the _this_ Vehicle object and the _other_ Vehicle object for equality. NOTE: you must cast _other_ to a Vehicle reference first. Vehicle objects are equal if their _mfg_ and _power_ and _numWheels_ are equal. The signature of the method must be exactly as indicated – you are overriding the method inherited from superclass _Object_.
  4. d.A method _public String display()_. This method returns a string containing the manufacturer name and color, separated by a space.

1. 2.Create a class Car. Class _Car_extends class Vehicle. Class _Car_ also implements the _Comparable_ interface. Class Car adds new instance variables _model_ (type String), _maxRange_ (type int), _safetyRating_ (type double), _AWD_ (type boolean - abbrev. for AllWheelDrive) and _price_ (type double). Also create constants of type String called SEDAN, SUV, SPORTS, MINIVAN. These are used as the values of the _model_ variable. Here are methods that must be implemented:
  1. a.A contructor method that has parameters to initialize the class _Car_ instance variables as well as the inherited variables from class _Vehicle_. Use the call to the _super()_ method appropriately.
  2. b.A method _public String display()_. This method will override the inherited method from class Vehicle. You must call the display method in superclass Vehicle first which will return a string as specified above in class Vehicle containing the values of the inherited instance variables and then append the values of the instance variables in a _Car_ object and return the string.
  3. c.A method public boolean equals(Object other). This method should compare the _this_ Car object and the _other_ Car object for equality. NOTE: you must cast _other_ to a Car reference first. Car objects are equal if their _mfg_ and _power_ and _numWheels_ are equal and if their _model_ and _AWD_ variables are equal. Call the superclass Vehicle equals method first and if it returns true, then test for _model_ and _AWD_ equality. The signature of the method must be exactly as indicated – you are overriding the method inherited from superclass _Vehicle_.
  4. d.A method _public int compareTo(Car other)_. The signature must be exactly as indicted – you are implementing the Comparable\&lt;Car\&gt; interface with this method. Compare the _this_ Car object with the given Car object _other_ using the _price_ of the two Car objects. We will be learning about the Comparable and Comparator interfaces in an upcoming lecture.

1. 3.Create a class _ElectricCar_. Class _ElectricCar_ extends _Car_. Class _ElectricCar_ adds new instance variables _rechargeTime_ (type int) which holds the recharge time (in minutes) and _batteryType_ (String). Here are methods that must be implemented:
  1. a.A constructor method that has parameters to initialize the class _ElectricCar_ instance variables as well as the inherited variables from class _Vehicle_ and from class _Car_. Use the call to the _super()_ method appropriately.
  2. b.Add public methods to get and set the new instance variables.
  3. c.A method _public String display()_. This method will override the inherited method from class _Car_. You must call the display method in superclass _Car_ first which will return a string as specified above in class Car and then append the values of the instance variables in an _ElectricCar_ object and return the string.

1. 4.Create a class _CarDealership_. Class _CarDealership_ has an instance variable that is a reference to an _ArrayList_ of _Car_ objects. Name it whatever you like (I call it _cars_). NOTE: a _CarDealership_ object will be created in the _CarDealershipSimulator_ class described in 5). Here are the methods that must be implemented for CarDealership:
  1. a.A constructor method that creates an empty _ArrayList_ of _Car_ objects and sets the instance variable to refer to it.
  2. b.public void addCars(ArrayList\&lt;Car\&gt; newCars): this method takes a reference to an array list of Car objects (_newCars_) as parameter and adds the car objects on this list to the instance variable array list in the CarDealership object.
  3. c.public Car buyCar(int index): this method _removes_ the _index_ car object from the array list and returns a reference to it. For example, if index is set to 5 then it removes the Car object at index 5 of the array list in the CarDealership object. This method should check to make sure the index is valid. If it is out of range then a _null_ reference should be returned.
  4. d._public void returnCar(Car car)_: this method takes the reference to the Car object and adds it back to the array list. The method should make sure the reference is not null.
  5. e._public void displayInventory()_: this method prints information about cars in the array list based on a set of filter values. See the filter methods below. If no filters are set, it prints information for all the car objects in the array list. It uses the _display()_ method of class _Car_ to print the information for each Car object on a single line. Before printing a car&#39;s information, it prints the index number of the car object in the array list. There are 3 filters – AWD, electric, and price. Boolean instance variables should be created for each filter. If the price filter is set, then the min and max price values (see the filter methods below) should be used and only cars between the min and max price should be displayed. If electric is set, then only electric cars are printed. Similarly for the AWD filter. The filters are _ANDED_ together. That is, if all filters are set then only cars that are electric, have AWD and are within the min and max price should be printed. If electric and AWD filters are both set, then only electric cars with AWD are printed etc. etc.
  6. f._public void filterByElectric(),public void filterByAWD(), public void filterByPrice(double minPrice, double maxPrice), public void FiltersClear()_: these methods set Boolean filters for use in _displayInventory()_ above. _filtersClear()_ sets all Boolean filter variables to false. _filterByPrice()_ as you see has 2 parameters. You should create instance variables to hold these values.
  7. g._public void sortByPrice(), public void sortBySafetyRating(), public void sortByMaxRange()_: these three methods sort the array list of car objects based on different attributes. See the class _Car_ description above. Class _Car_ implements the _Comparable_ interface and therefore has a _compareTo_ method that compares two Car objects based on price. Therefore, you can use _Collections.sort()_ to sort the car objects in the array list. For the other 2 sort methods, you will have to create inner classes that implement the _Comparator_ interface – this will be discussed this week and next in lectures.

1. 5.Create a class _CarDealershipSimulator_. This class has the main() method and is the user interaction part. Some skeleton code has been provided for you with some comments. In the main() method, you will begin by creating a _CarDealership_ object. You will then create an _ArrayList_ of _Car_ objects using the list of Car attributes provided in the file _cars.txt_. That is, write code to create new Car objects with the specified attributes and add each Car object to the array list. _NOTE: this array list is different than the one stored in the CarDealership object!!_ In a _while loop_, you will use a scanner to read a line of input from the user. The input lines contain words (Strings). Most input lines contain a single word that represents a command. Some lines contain a command word and some parameters. Here are the commands you must implement:
  1. a.&quot;L&quot; : call the dealership object&#39;s _displayInventory()_ method.
  2. b.&quot;Q&quot; : quit out of the program (hint: use the return statement)
  3. c.&quot;BUY&quot; : reads an integer from the current input line that represents an index of a car the user wants to buy. Use this number and call the dealership object&#39;s _buyCar()_ method (see the description of buyCar() above). If the buyCar() method returns a reference to a Car object, use the class Car _display()_ method to print the Car information.
  4. d.&quot;RET&quot; : returns the last car that was bought. See class CarDealership _returnCar()_ method. Make sure you update the last car bought reference variable to null.
  5. e.&quot;ADD&quot; : use class CarDealership&#39;s _addCars()_ method to add the array list of car objects you created to the dealership object&#39;s array list.
  6. f.&quot;SPR&quot; , &quot;SSR&quot; , &quot;SMR&quot; : these 3 commands are used to call the sort methods in class CarDealership. SPR: sort by price, SSR: sort by safety rating, SMR: sort by max range.
  7. g.&quot;FPR&quot;, &quot;FEL&quot;, &quot;FAW&quot;, &quot;FCL&quot; : these commands are used to call the filter methods of class CarDealership. &quot;FCL&quot; calls the _filtersClear()_ method of the dealership object. The other commands should be obvious. For _&quot;FPR&quot;_ you must also read from the input line 2 double values representing the min and max price range.
  8. h.Make sure your code handles commands that are not recognized or the null string or a null reference etc.

1. 6.Make sure you comment your code. I strongly urge you to use JavaDoc.

1. 7._BONUS_: use File I/O and exceptions. In class _CarDealershipSimulator_, add code (I suggest you create a method) to read the list of cars from the file cars and create the array list of car objects. Add appropriate exception handling for the file I/O. In class CarDealership, _throw_ an exception for at least 2 of the methods if their parameters are invalid or out of range. In class CarDealershipSimulator, _catch_ these exceptions and print a message to the user.

### Grading (Out of 10 marks)

### Highest Grade Possible: 11

| **Basic** : class **Car** , **CarDealership** , **CarDealershipSimulator** , proper array list of Car objects in class CarDealership, basic commands &quot;L&quot;, &quot;Q&quot;, &quot;ADD&quot;, &quot;BUY&quot; and &quot;RET&quot;. Creation of x Car objects from **cars.txt** file and correct addition to CarDealership array list via &quot;ADD&quot; command. | 4 marks |
| --- | --- |
| Class **Vehicle** and **ElectricCar** and proper use of inheritance in constructor methods and **display()** methods and **equals()** methods ( **Basic** must also be implemented) | 2 marks |
| 3 sort commands working correctly, proper use of **Comparable** and **Comparator** interfaces | 2 marks |
| 4 filter commands working correctly   | 2 marks |
| File I/O and Exceptions as specified above (NOTE: everything above must be done before you are eligible for the bonus) | 1 mark |
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