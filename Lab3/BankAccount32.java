/**
   P3.2.  	
   Adding a method

   public void addInterest(double rate)

   to the BankAccount32 class which adds interest at the given rate. 
 */
public class BankAccount32
{
    //instance variable
    private double balance ;

    /**
       Constructor: initializes balance to zero
     */
    public BankAccount32()
    {
	     balance = 0 ;
    }
    /**
       Constructor: initializes balance to given initialBalance paramter
       @param initialBalance
     */
    public BankAccount32(double initialBalance)
    {
	     balance = initialBalance ;
    }
    /**
       Adds interest to the BankAccount balance at the given rate
       @param rate the percent of interest to add
	   HINT: don't forget to convert percent to fraction first!
     */
    //-----------Start below here. To do: approximate lines of code = 2
    // Write the addInterest method
    
    public void addInterest (double rate){
      balance += balance*(rate/100);

    }
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    
    /**
       Returns the balance
       @return the balance
     */
    public double getBalance()
    {
	     return balance ;
    }
    
    /**
       Deposits amount of money to the account
       @param amount the amount of money to put in
     */
    public void deposit(double amount)
    {
	     balance = balance + amount ;
    }
    
    /**
       Withdraws amount of money to the account
       @param amount the amount of money to take out
     */
    public void withdraw(double amount)
    {
      	double newBalance = balance - amount ;
      	balance = newBalance ;
    }
    
    /**
       Returns a string representation of the account
       @return the string representation
     */
    public String toString()
    {
	     return "BankAccount[balance = " + balance + "]" ;
    }
    
}
