/**
   Sort bankaccounts using the interface Comparable and 
   the classes ArrayList, Collections.
   Todo:
   In the BankAccount class you make BankAccount implement Comparable.
   The sorting here should be from small to large balances.
 */
import javax.swing.* ;
import java.util.* ;

public class BankAccountSorter
{
    public static void main(String[] args)
    {
    	ArrayList<BankAccount> list = new ArrayList<BankAccount>() ;
    	list.add(new BankAccount(1000)) ;
    	list.add(new BankAccount(500)) ;
    	list.add(new BankAccount(30)) ;
    	list.add(new BankAccount(600)) ;
    	list.add(new BankAccount(20)) ;
    	System.out.println(list) ;
    	Collections.sort(list) ;
    	System.out.println(list) ;
    }
}
/**
   A bankAccount object has a balance that can be changed by 
   deposits and withdrawals.

   Here the class is modified to implement Comparable<BankAccount>.  
   Sorting is from small balances to largest.
*/
//-----------Start below here. To do: approximate lines of code = 1
//-----------Start below here. To do: approximate lines of code = 1
// Write the "class BankAccount ... " part so that Comparable is implemented
class BankAccount implements Comparable
//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
{  
    //instance variables
    private double balance; //the money in the account

    /**
       Initializes balance instance variable to zero
    */
    public BankAccount()
    {   
	   balance = 0;
    }
    
    /**
       Initializes balance to given parameter
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
	    return "" + balance ;
    }
    /**
       Compares balances in the way required by the interface
       @return 1 if this balance is bigger than the other balance
               -1 if this balance is less
	       0 if they are the same.
     */    
    //-----------Start below here. To do: approximate lines of code = 4
    //-----------Start below here. To do: approximate lines of code = 4
    // 1. public signature ; 
    public int compareTo(Object x){
      BankAccount c = (BankAccount)x;
      if (this.getBalance()>c.getBalance()) {
        return 1;
      }
      else if (this.getBalance()<c.getBalance()) {
        return -1;
      }
      else{
        return 0;
      }

    }
    
	//2. code for the -1 case ; 
    
	//3. code for the 1 case ; 
    
	//4. code for the 0 case.
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
}



