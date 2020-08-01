/**
 * GradesTester -- to test the Grades class that you have to write.
 * Change nothing here.
 */
public class GradesTester 
{
	public static void main (String [] args)
	{
		Grades grades = new Grades();

		grades.add("Jeff", "A+");
		grades.add("Dan", "B+");
		grades.add("Mary", "A");
		grades.add("Bob", "C-");
		grades.remove("Bob");

		System.out.println(grades.toString());
	}

}
