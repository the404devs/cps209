/**
   This is a basic driver that constructs and tests a NoParking object.
 */
public class NoParkingTester
{
    public static void main(String[] args)
    {
	NoParking noParking = new NoParking() ;
	System.out.println(noParking) ;
	System.out.println("Expect: No Parking between 0:00 and 23:59") ;

	noParking.setStartTime("4 PM") ;
	noParking.setEndTime("7 PM") ;
	System.out.println(noParking) ;
	System.out.println("Expect: No Parking between 4 PM and 7 PM") ;
	noParking.setStartTime("11 PM") ;
	noParking.setEndTime("5 AM") ;
	noParking.reverse() ;
	System.out.println(noParking) ;
	System.out.println("Expect: No Parking between 5 AM and 11 PM") ;
    }
}
