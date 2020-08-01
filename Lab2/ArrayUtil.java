import java.util.Random ;
/**
   Contains some useful methods for arrays.
 */
public class ArrayUtil
{
    /**
       Creates an array filled with random values.
       @param length the length of the array
       @param n the number of possible random values
       @return an array filled with length random numbers 
       between 0 and n - 1
     */
    public static int[] randomIntArray(int length, int n)
    {
	int[] a = new int[length] ;
	Random random = new Random() ;
	for (int i = 0 ; i < length ; i++) {
	    a[i] = random.nextInt(n) ;
	}
	return a ;
    }
    /**
       Returns a string representation of the array
       @param array the array to make a string from
       @return a string like [a1, a2, ..., a_n]
     */
    public static String toString(int[] array)
    {
	String result = "[" ;
	for (int i = 0 ; i < array.length - 1; i++) {
	    result += array[i] + ", " ;
	}
	result += array[array.length - 1] + "]" ;
	return result ;
    }
}
