import java.util.StringTokenizer ;
import java.util.Scanner ;
import java.io.File ;
import java.io.FileNotFoundException ;
/**
   A question based on Big Java exercise P11.2.
   The main point is to use a try-catch pair which allows
   handling exceptions effectively.
   The readFiles method prints the number of lines, number of words, and 
   number of characters for each file in an array of files
Expected output:
------------------
52 341 2158 cat.txt
9 89 501 dog.txt
7 69 388 mouse.txt
WordCountSeveral: horse.txt: No such file
68 499 3047 total
------------------
52 341 2158 cat.txt
WordCountSeveral: giraffe: No such file
52 341 2158 total
------------------
9 89 501 dog.txt
9 89 501 total
------------------
*/
public class WordCountSeveral
{
    public static void main(String[] args) throws FileNotFoundException
    {
		String[] filenames = new String[]{"cat.txt", "dog.txt", "mouse.txt",
						  "horse.txt"} ;
		System.out.println("------------------") ;
		readFiles(filenames) ;
		filenames[1] = "giraffe" ;
		System.out.println("------------------") ;
		readFiles(filenames) ;
		System.out.println("------------------") ;
		filenames = new String[]{"dog.txt"} ;
		readFiles(filenames) ;
		System.out.println("------------------") ;
    }
   /**
   This program prints the number of characters, words, 
   and lines in several files.  When it encounters a file that does not
   exist, the program prints the total counts of lines, words and 
   characters in all processed files and exits.

   It produces output similar to the wc command in unix.

   You can assume that the files end with a newline character.
   When you catch the exception for no file,
   print a message as shown below (except generalize "horse.txt" to 
   filename).  
   The following is the expected output for one example run of this method
   (between the dashed lines):
   -------------------
   52 341 2158 cat.txt
   9   89  501 dog.txt
   7   69  388 mouse.txt
   WordCountSeveral: horse.txt: No such file
   68  499 3047 total
   -------------------
*/
    public static void readFiles(String[] files)
    {
		int totalLines = 0, totalWords = 0, totalCharacters = 0 ;
		for (String filename : files) {
		    //-----------Start below here. To do: approximate lines of code = 7
		    // 1. try; 
		    try{
				Scanner scanner = new Scanner(new File(filename)) ; //
				int lines = 0, words = 0, characters = 0 ; //
				while (scanner.hasNextLine()) { //
				    String line = scanner.nextLine() ; //
				    //2. update lines
			    	lines++;
				    //3. update characters
			    	characters += line.length()+1;
				    StringTokenizer st = new StringTokenizer(line) ; //
				    //4. update words
				    // System.out.println(line.length()+" - "+line);
				    words+=st.countTokens();
			    }
			    
				System.out.println(lines + " " + words + " " + characters + " " + filename) ; //
				//5. update totals; 
				totalLines += lines ; //
				totalWords += words ; //
				totalCharacters += characters ; //
		    }
		    //5. catch clause
		    catch(FileNotFoundException e){
		    	System.out.println("WordCountSeveral: "+filename+": No such file");
		    	break;
		    }
			//6. print WordCountSeveral: filename: No such file
		    
			//7. stop the loop
		    
		}
		    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	
		System.out.println(totalLines + " " + totalWords  + " " + totalCharacters + " total") ; //
    }
}
