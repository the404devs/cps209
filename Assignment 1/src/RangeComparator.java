/* CPS209 Assignment #1
*  Owen Goodwin
*  500909196
*  03/17/19 */

/*Import the Comparator interface. Trust me, we need it.*/
import java.util.Comparator;

/* Class RangeComparator implements the Comparator interface.
It provides us with a way to sort Cars based on their max range. */
public class RangeComparator implements Comparator<Car>
{
	/*Compare method
	Overrides: Comparator.compare()
	Params: Two Cars, which we will compare.
	Returns: an integer (-1,0,1)*/
	public int compare(Car a, Car b)
	{
		if (a.getMaxRange()>b.getMaxRange()) {
			return -1;//If Car a has a higher range, return -1.
		}
		else if (b.getMaxRange()>a.getMaxRange()) {
			return 1;//If Car b has a higher range, return 1.
		}
		return 	0;//If the cars have the same range, return 0.
	}
}