import java.awt.Color ;
/**
   This is a tester code that constructs a Car object.
 */
public class CarTester
{
    public static void main(String[] args)
    {
	Car car = new Car(Color.BLUE, 555.5) ;
	System.out.println(car.toString()) ;
	System.out.println("Expect:") ;
	System.out.println("Car[color = java.awt.Color[r=0,g=0,b=255], kilometers = 555.5]") ;
    }
}
