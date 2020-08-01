/* CPS209 Assignment #2
*  Owen Goodwin
*  500909196
*  04/10/19 */

/*Import the Comparator interface. Trust me, we need it.*/
import java.util.Comparator;

/* Class SafetyComparator implements the Comparator interface.
It provides us with a way to sort Cars based on their safety rating. */
public class SafetyComparator implements Comparator<Car>
{
	/*Compare method
	Overrides: Comparator.compare()
	Params: Two Cars, which we will compare.
	Returns: an integer (-1,0,1)*/
	public int compare(Car a, Car b)
	{
		if (a.getSafetyRating()>b.getSafetyRating()) {
			return 1;//If Car a has a higher safety rating, return -1
		}
		else if (b.getSafetyRating()>a.getSafetyRating()) {
			return -1;//If Car b has a higher safety rating, return 1.
		}
		return 	0;//If the cars have the same safety rating, return 0.
	}
}