package StackPkg;

import java.util.Stack;

class StackQuestions
{
	
	 public int CalculateReversePolishNotation(String exp)
	 {
		 if(exp==null || exp.isEmpty())
		 {
			 return 0;
			 
		 }
	  String[]arr=	 exp.split(" ");
	  
	  Stack<Integer> stk=new Stack<Integer>();
	  
	  ///List<Integer>ls=  new   ();
	  
	  
	  for (String val : arr) 
	  {
		  try
		  {
			  if(val==" ")
			  {
				 continue; 
			  }
		   int a= Integer.parseInt(val);
		   stk.push(a);
		  }catch(Exception ex)
		  { //System.out.println( stk.elementAt(1));
			//System.out.println( stk.toString());
			  int f=stk.pop();
			  int s=stk.pop();
			 
			  int cal=0;
			  if(val.equals("+"))
			  {
				  cal=f+s;
				  
			  }
			  if(val.equals("-"))
			  {
				  cal=f-s;
				  
			  }
			  if(val.equals("*"))
			  {
				  cal=f*s;
				  
			  }
			  if(val.equals("/"))
			  {
				  cal=f/s;
				  
			  }
			  stk.push(cal);
		  }
		
		 
		
	  }
	  if(stk.size()==1)
	  {
		  return stk.pop();
		  
	  }
	  return 0;
	 }
}

public class StackPoblems {
	public StackPoblems()
	{
		StackQuestions obStackQuestions=new StackQuestions();
		System.out.println(obStackQuestions.CalculateReversePolishNotation("17 14 + "));
		System.out.println(obStackQuestions.CalculateReversePolishNotation("14 17 2 * - 13 +"));
	}
	
	
}
