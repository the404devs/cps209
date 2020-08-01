import java.io.FileNotFoundException ;
import java.io.IOException ;
import java.io.File ;
import java.util.Scanner ;

/**
   This exercise is based on an example in BigJava, Case Study 11.8

   The program reads a file containing numbers and analyzes the data.
   The first number in the data file indicates the number of integers
   that follow.  For example,
   4
   10 20 15 2
   The program puts the values in an array and then adds them up.
   In this case it would print 47 (the sum of 10 20 15 2)
   
   The point of the program is to show where one should throw exceptions
   and where one should catch them.

   The following file names will be used:
 
   data1.txt is okay:
3
10
70
20
   data2.txt is wrongly formatted data:
two
99
14
   data3.txt is wrongly formatted data:
3 
99 
cat
14
   data4.txt is wrongly formatted data (too many values):
3 
99 
22
14
66
   data5.txt does not exist.

See DataSetReader, below, for the todo regions.
   
 */
public class ExceptionTester4
{
    public static void main(String[] args)
    {
    	String[] filenames = new String[] {"data1.txt", "data2.txt", 
    					   "data3.txt", "data4.txt",
    					   "data5.txt"} ;
    	for (String filename : filenames) {
    	    DataSetReader dsr = new DataSetReader() ;
    	    System.out.println("------------- " + filename + " ------------") ;
    	    try {
        		int[] data = dsr.getData(filename) ;
        		int sum = 0 ;
        		for (int value : data) sum += value ;
        		System.out.println("The sum is " + sum) ;
    	    }
    	    catch (FileNotFoundException e) {
    		    System.out.println("FileNotFoundException: " + filename) ;
    	    }
    	    catch (BadDataException e) {
    		    System.out.println("BadDataException: " + e.getMessage()) ;
    	    }
    	    catch (IOException e) {
    		    e.printStackTrace() ;
    	    }
    	}
    }
}
/**
   DataSetReader.java  (an example in Big Java, Case Study 11.8
   Reads a set of data from a given file.  The file format must be

   numberOfValues
   value1
   value2
   ...
   value_numberOfValues

   The only public method is getData, which returns an array of integers
   from the given file.

   Your work is in the "todo" regions, as usual.
 */
class DataSetReader
{
    private int[] data ;
    /**
       Reads the data from the file called filename and returns the 
       array of integers.
       @param filename the name of the file from which to read.
       @return the array of integers
     */
    public int[] getData(String filename) throws IOException
    {
    	Scanner scanner = new Scanner(new File(filename)) ;
    	try {
    	    readData(scanner) ;
    	    return data ;
    	}
    	finally {
    	    System.out.println("Finally closing the scanner.") ;
    	    scanner.close() ;
    	}
    }
    /**
       Reads all data.
       @param scanner the scanner that scans the data
     */
    private void readData(Scanner scanner) throws BadDataException
    {
    	String message = "The first token has to be a number indicating the number of values to be read." ;
    	//-----------Start below here. To do: approximate lines of code = 1
    	// 1. if there is not an integer coming up, throw a BadDataException with the above message.
    	if (!scanner.hasNextInt()) {
        throw new BadDataException(message);
      }
    	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    	int numberOfValues = scanner.nextInt() ;
    	data = new int[numberOfValues] ;
    	for (int i = 0 ; i < numberOfValues ; i++) {
    	    readValue(scanner, i) ;
    	}
    	message = "End of file expected, but there are more values." ;
    	//-----------Start below here. To do: approximate lines of code = 1
    	// 2. if there is another token in the input stream, throw a BadDataException with the above message.
    	if (scanner.hasNextInt()) {
        // System.out.println(data.length+"-"+numberOfValues);
        throw new BadDataException(message);
      }
    	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
    /**
       Reads one data value
       @param scanner the scanner that scans the data
       @param i the position in the array for the next value
     */
    private void readValue(Scanner scanner, int i) throws BadDataException
    {
    	String message = "Data value expected, but find no integer." ;
    	//-----------Start below here. To do: approximate lines of code = 2
    	// 3. if there is no integer next in the file, throw a BadDataException with the message above; 
    	if (!scanner.hasNextInt()) {
        throw new BadDataException(message);
      }
      else{
        data[i] = scanner.nextInt();
      }
            //4. read the next integer into the array called data.
    	
    	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
}
/**
   This class reports bad input data.
 */
class BadDataException extends IOException
{
    public BadDataException() {}
    public BadDataException(String message) 
    {
	     super(message) ;
    }
}
