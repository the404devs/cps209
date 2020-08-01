import java.util.Stack ;
/**
    Practices using the Stack from the Java API.
 */
public class StackApiTester
{
    public static void main(String[] args)
    {
	Stack<String> stack = new Stack<String>() ;
	stack.push("horse") ;
	stack.push("cat") ;
	stack.push("dog") ;
	stack.push("cow") ;
	stack.push("mouse") ;
	System.out.println(stack.pop()) ;
	System.out.println(stack.pop()) ;
	System.out.println(stack.pop()) ;
	System.out.println(stack.peek()) ;
	System.out.println("stack is empty? " + stack.isEmpty()) ;
	System.out.println(stack.pop()) ;
	System.out.println("stack is empty? " + stack.isEmpty()) ;
	System.out.println(stack.pop()) ;
	System.out.println("stack is empty? " + stack.isEmpty()) ;
	//-----------Start below here. To do: approximate lines of code = 8
	// 1. make a stack that holds integers ; 
	Stack<Integer> stackOverflow = new Stack<Integer>();
	//2. push in the integers from 1 to 100 that are divisible by 3 ; 
	int x = 1;
	while(x<101){
		if (x%3==0) {
			stackOverflow.add(x);
		}
		x++;
	}
	System.out.println(stackOverflow.size());
	while(!stackOverflow.isEmpty()){
		int val = stackOverflow.pop();
		if (val%9==0) {
			System.out.println(val+"");
		}
	}
	
	//3. print the size ; 
	
	//4. while stack not empty ; 
	
	    //5. let value hold pop ; 
	
	    //6. if value divisible by 9 then print it.
	
	
	
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
}
