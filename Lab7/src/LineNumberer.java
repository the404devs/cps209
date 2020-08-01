/**
   LineNumberer is the first example program in Chapter 11.
   It reads a file and prepends each line with a line number.
   For example, if the following is the input file:

Mary had a little lamb
whose fleece was white as snow.
Every where that Mary went,
the lamb was sure to go.

   Then the following is the output file (ignoring the // comment symbols)
*/

//    /* 1 */ Mary had a little lamb
//    /* 2 */ whose fleece was white as snow.
//    /* 3 */ Every where that Mary went,
//    /* 4 */ the lamb was sure to go.
import java.io.File ;
import java.io.FileNotFoundException ;
import java.io.PrintWriter ;
import java.util.Scanner ;

public class LineNumberer
{
    //-----------Start below here. To do: approximate lines of code = 1
    // 1. public static void main( ... so that file IO is possible without catching a possible FileNotFoundException
    public static void main(String[] args) throws FileNotFoundException   
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    {
	File infile = null ;
	//-----------Start below here. To do: approximate lines of code = 1
	// 2. set infile to the file input1
	infile = new File("input1");
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	Scanner scanner = new Scanner(infile) ;
	PrintWriter pw = new PrintWriter("output1") ;
	int lineNumber = 1 ;
	//-----------Start below here. To do: approximate lines of code = 4
	// 3-6. Write the while loop that goes through the input file and prints the output file line by line with the commented line numbers.
	
	while (scanner.hasNextLine()) {
		pw.print("/* "+lineNumber+" */ "+scanner.nextLine());
		lineNumber++;
	}
	
	
	
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	long length1 = infile.length() ;
	pw.close() ;
	scanner.close() ;
	//This next part is just to show what is in the output file
	infile = new File("output1") ;
	scanner = new Scanner(infile) ;
	while (scanner.hasNextLine()) {
	    System.out.println(scanner.nextLine()) ;
	}
	long length2 = infile.length() ;
	if (length2 <= length1)
	    System.out.println("Error: You have to print to the given output file.") ;
    }
}
