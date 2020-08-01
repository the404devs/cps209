/**
   Tests the NumberToGrade class
 */
public class CourseGradeTester
{
    public static void main(String[] args)
    {
	  CourseGrade gradeInCourse = new CourseGrade(2.8) ;
	  System.out.println(gradeInCourse + " " + gradeInCourse.getLetterGrade()) ;
	  System.out.println("Expected: 2.8 B-") ;
	  gradeInCourse = new CourseGrade(2.85) ;
	  System.out.println(gradeInCourse + " " + gradeInCourse.getLetterGrade()) ;
	  System.out.println("Expected: 2.85 B") ;
	  //Add a little more than .05 because of rounding error.
	  //otherwise what looks like 2.85 is less than 2.85
	  for (double x = 0 ; x <= 4.5 ; x = x + 0.0500001) {
	    gradeInCourse = new CourseGrade(x) ;
	    System.out.printf("%4.2f %s\n", x, gradeInCourse.getLetterGrade()) ;
	  }
    }
}