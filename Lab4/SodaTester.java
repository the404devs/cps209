
public class SodaTester 
{
	public static void main(String[] args)
	{
		Soda coke  = new Soda("Coke",35,355);
		Soda pepsi = new Soda("Pepsi",42,355);
		
		//Expected Output:
		//Pepsi is sweeter than Coke
		System.out.println(coke.compareSweetness(pepsi));
		//Expected Output:
		//Pepsi is sweeter than Coke
		System.out.println(pepsi.compareSweetness(coke));
		//Expected Output:
		// Coke has the same sweetness as Coke
		System.out.println(coke.compareSweetness(coke));
	}
}
