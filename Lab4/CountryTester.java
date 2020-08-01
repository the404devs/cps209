
public class CountryTester 
{
   public static void main(String[] args)
   {
      Country canada = new Country("Canada",35000000,9985000);
      Country france = new Country("France",66000000,643800);
		
      // Expected Output:
      // Name: Canada Population 35000000 Area 9985000.0 Density 3.5052578868302455
      // Name: France Population 66000000 Area 643800.0 Density 102.51630941286113

      System.out.println("" + canada.getCountryStats() + " Density " + canada.getPopulationDensity());
      System.out.println("" + france.getCountryStats() + " Density " + france.getPopulationDensity());
   }
}
