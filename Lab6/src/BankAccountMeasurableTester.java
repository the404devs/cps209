import java.util.* ;
/**
   Program to test the BankAccount class, 
   where the BankAccount class is
   the usual BankAccount class but changed so that it is measurable.
   There are two "todo" regions in the BankAccount class -- both are 
   necessary for making BankAccount implement Measurable.  Fill them in.

   There is nothing to do in this tester class, so do not change it.
*/
public class BankAccountMeasurableTester
{
    public static void main(String[] args)
    {
    	DataSet dataSet = new DataSet() ;
    	dataSet.add(new BankAccount(1000)) ;
    	dataSet.add(new BankAccount(3000)) ;
    	dataSet.add(new BankAccount(5000)) ;
    	dataSet.add(new BankAccount(7000)) ;
    	System.out.printf("The average bankAccount balance is %.1f\n",
    			  dataSet.getAverage()) ;
    	System.out.println("Expected:\nThe average bankAccount balance is 4000.0") ;
    	System.out.println("---------------") ;
    	BankAccount maxBankAccount = null ;
    	//-----------Start below here. To do: approximate lines of code = 1
    	//-----------Start below here. To do: approximate lines of code = 1
    	// assign the maximum bankAccount to a maxBankAccount 
    	maxBankAccount = (BankAccount)dataSet.getMax();
    	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    	System.out.println("The maximum bankAccount is: " + maxBankAccount) ;
    	System.out.println("Expected:\nThe maximum bankAccount is: BankAccount[balance = 7000.0]") ;
    	System.out.println("---------------") ;
    	//An output without giving the "Expected"
    	dataSet.add(new BankAccount(20000)) ;
    	System.out.printf("The average bankAccount balance is %.1f\n", dataSet.getAverage()) ;
    	System.out.println("Expected not shown.") ;
    	System.out.println("---------------") ;
    }
}
/**
   This BankAccount class is the same as the usual BankAccount class,
   except that it implements Measurable.
   A bank account has a balance that can be changed by 
   deposits and withdrawals. This version does not have an accountNumber variable
*/
//-----------Start below here. To do: approximate lines of code = 1
//-----------Start below here. To do: approximate lines of code = 1
// Write the "public class ... " part so that Measurable is implemented, but do not say public, since only one class can be public in a file
class BankAccount implements Measurable
//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
{  
    //instance variables
    private double balance; //the money in the account
    /**
       Deafult contstructor method to initialize to zero balance
    */
    public BankAccount()
    {   
	   balance = 0;
    }
    /**
       Constructor method initializes balance with given parameter aBalance
       @param aBalance the initial balance
    */
    public BankAccount(double aBalance)
    {   
	   balance = aBalance;
    }
    /**
       Deposits money into the bank account.
       @param amount the amount to deposit
    */
    public void deposit(double amount)
    {  
    	double newBalance = balance + amount;
    	balance = newBalance;
    }
    /**
       Withdraws money from the bank account.
       @param amount the amount to withdraw
    */
    public void withdraw(double amount)
    {   
    	double newBalance = balance - amount;
    	balance = newBalance;
    }
    /**
       Gets the current balance of the bank account.
       @return the current balance
    */
    public double getBalance()
    {   
	   return balance;
    }
    /**
       Gives a string representation of the bankaccount,
       but in this case the string is just the balance.
       @return the balance as a string
    */
    public String toString()
    {   
    	return "BankAccount[balance = " + balance + "]" ;
    }
    /**
       Gets the measure in the way required by the interface
       @return the balance as a measure of the bank account
     */    
    //-----------Start below here. To do: approximate lines of code = 2
    //-----------Start below here. To do: approximate lines of code = 2
    // 1. public signature 
    public double getMeasure(){
      return balance;
    }
    
	//2. return the measure
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
}
/**
   DataSet example from Chap. 6 of Horstmann, Big Java
   modified in 9.1 to use Measurable interface
 */
class DataSet
{
    private double sum ;
    private int count ;
    private Measurable max ;
    /**
       Constructs DataSet object empty.
     */
    public DataSet()
    {
    	sum = 0 ;
    	count = 0 ;
    	max = null ;
    }
    /**
       Adds an element to the dataset
       @param x the thing to add
     */
    public void add(Measurable x)
    {
    	sum += x.getMeasure() ;
    	if (count == 0 || max.getMeasure() < x.getMeasure())
    	    max = x ;
    	count ++ ;
    }
    /**
       Returns the maximum or null if none
       @return the max
     */
    public Measurable getMax()
    {
	     return max ;
    }
    /**
       Returns the average
       @return the average or zero if none
     */
    public double getAverage()
    {
    	if (count == 0)
    	    return 0 ;
    	else
    	    return sum / count ;
    }
}
/**
   An interface used as an example in Big Java.
   A class that implements this interface has a way to measure it,
   namely the getMeasure method.
 */
interface Measurable
{
    double getMeasure() ;
}
