public class BankAccount32Tester
{
    public static void main(String[] args)
    {
	BankAccount32 momsSavings = new BankAccount32(1000) ;
	momsSavings.addInterest(10) ;
	System.out.printf("%.2f\n", momsSavings.getBalance()) ;
	System.out.println("Expected:") ;
	System.out.println("1100.00") ;
	System.out.println("Here is what it is after more interest additions:") ;
	momsSavings.addInterest(10) ;
	momsSavings.addInterest(5) ;
	momsSavings.addInterest(20) ;
	momsSavings.addInterest(30) ;
	momsSavings.addInterest(15) ;
	momsSavings.addInterest(2) ;
	System.out.printf("%.2f\n", momsSavings.getBalance()) ;
    }
}
