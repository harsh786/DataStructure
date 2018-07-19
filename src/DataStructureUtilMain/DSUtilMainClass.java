package DataStructureUtilMain;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ArrayPkg.ArrayOperation;
import ArrayPkg.Sorting;
import DP.DPQuestionProblems;
import Java8Pkg.Java8StreamsApi;
import JavaCollectionPkg.JavaCollectionProblems;
import JavaLangCommonOperation.*;
import LinkedListPkg.*;
import MultiThreading.ThreadPoolImplementation;
import StackPkg.StackPoblems;
import StringOperationPkg.*;
import TreePkg.TreeProblems;

/*
public class DSUtilMainClass {
    // Sleeps for 5 seconds
    private static void do_stuff() {
        try {
            Thread.sleep(5000);
        } catch(InterruptedException e) {}
    }
    public synchronized static void m1() {
        do_stuff();
    }
    public synchronized static void m2() {
        do_stuff();
    }
    public static void main(String[] args) {
        Thread t1 = new Thread() {
                public void run() {
                	DSUtilMainClass s = new DSUtilMainClass();
                    s.m1();
                }
            };
        Thread t2 = new Thread() {
                public void run() {
                	DSUtilMainClass s = new DSUtilMainClass();
                    s.m2();
                }
            };
        t1.start();
        t2.start();
        System.out.println("Done");
    }
}*/

/*class Printer
{
	boolean isodd=false;
	public synchronized void Printodd(int numb) 
	{
		while(isodd)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("odd:"+numb);
	}
	public synchronized void PrintEven(int numb)
	{
		while(!isodd)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("even:"+numb);
	}
	
}


 class ThreadOdd extends Thread
{
	 int n;
	 public ThreadOdd(Integer n)
	 {
		 this.n=n;
		 
	 }
	 
	 @Override
	public void run()
	{
		 Printer ob=new Printer();
		 int s=1;
		while(s<n)
		{
			ob.Printodd(s);
			s=s+2;
		}
	}
	
}

 class ThreadEven extends Thread
{
	 int n;
	 public ThreadEven(Integer n){
		 this.n=n;
	 }
	 
	 @Override 
	public void run()
	{
		 Printer ob=new Printer();
		 int s=2;
			while(s<n)
			{
				ob.PrintEven(s);
				s=s+2;
			}
	}
	
}*/

/* class TaskEvenOdd implements Runnable {
	    private int max;
	    private Printer print;
	    private boolean isEvenNumber;

	    TaskEvenOdd(Printer print, int max, boolean isEvenNumber){
	        this.print = print;
	        this.max = max;
	        this.isEvenNumber = isEvenNumber;
	    }

	    @Override
	    public void run() {
	        int number = isEvenNumber == true ? 2 : 1;
	        while(number<= max){
	            if(isEvenNumber){
	                print.printEven(number);
	            }   
	            else {
	                print.printOdd(number);
	            }
	            number+=2;
	        }
	        }
	}

	class Printer {
	    boolean isOdd= false;
	    synchronized void printEven(int number) {
	        while(isOdd == false){
	            try {
	                wait();
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	        System.out.println("Even:"+number);
	        isOdd = false;
	        notifyAll();
	    }
	    synchronized void printOdd(int number) {
	        while(isOdd == true){
	            try {
	                wait();
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	        System.out.println("Odd:"+number);
	        isOdd = true;
	        notifyAll();
	    }
	}*/
/*class A 
{
	protected void add() throws ArithmeticException  {
	}
}*/

public class DSUtilMainClass/* extends A*/ 
{
	
	/*protected void add() throws ArithmeticException	
	{
		
	}*/
 public static void main(String[]args)
 {
	 Calendar calendar = Calendar.getInstance();
	
	 Date date = new Date(); 
	 System.out.println(date.toString());
		date.setDate(12);
		System.out.println(date.getDate());
		
	System.out.println(date.getTime());
	 
	 String str="harbsh";
	 char[]arr=str.toCharArray();
	 int low=0,high=arr.length-1;
	 while(low<high)
	 {
		 char temp=arr[low];
		  arr[low]=arr[high];
		  arr[high]=temp;
		  low++;
		  high--;
		 
	 }
	
//	System.out.println(String.valueOf(arr));
	
	 
    /* Thread t1 = new Thread(new TaskEvenOdd(print, 10,  false));
     Thread t2 = new Thread(new TaskEvenOdd(print, 10, true));*/
	// Thread t1=new ThreadOdd(10);
	 //Thread t2=new ThreadEven(10);
    // t1.start();
    // t2.start();
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	/*// int a[]=new int[]{-3,-2,-1,5,6,7,9,11,12,13,15,16,17};
	 int array[]=new int[]{12,13,14,15};
	 int i=0;
	 String output="";
	 int n=array.length;
	
	
	while(i<n)
	{
		if(i+2<n && array[i]+2==array[i+2])
		{
			int j=i+2;
			while(j+1<n && array[j]+1==array[j+1])
			{
				j++;
			}
			output=output+array[i]+"-"+array[j]+",";
			i=j+1;
			
		}
		else
		{
			output=output+array[i]+",";
			i++;
		}
		
	}
	
	return output.substring(0, output.length()-1);*/
	 
	// String number="(123) 456-7890";
/*	 String number="123-456-7890";
	// String reg="((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}";
	 String reg="^\\D?(\\d{3})\\D?\\D?(\\d{3})\\D?(\\d{4})$";
	  
	 String[]arr=number.split(reg);
	 for(String token : arr) {
       
        	System.out.println(token);
        
      } 
	 */


/*String reg="((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}";
String input="XXX123-456-7890 (123) 456-7890";
Pattern pattern = Pattern.compile(reg);
Matcher matcher = pattern.matcher(input);
// Check all occurrences
boolean isfind=false;
while (matcher.find()) {
	isfind=true;
    System.out.println(matcher.group());
    break;
}
if(!isfind)
{
	   System.out.println("NONE");
}
//Integer i=3;
*///Matcher matcher = Pattern.compile(regex).matcher(number);
//if ( ( i != null && matcher.find(i) ) || matcher.find()) {
//	System.out.print("Start index: " + matcher.start());
//    System.out.print(" End index: " + matcher.end());
//}
//	
//	LinkedListOperation ObjLinkedListOperation=new LinkedListOperation();
	//StringOperation ObjStringOperation=new StringOperation();
	//ObjStringOperation.PerformOperation();
	// JavaLangCommonOperation ObjJavaLangCommonOperation=new JavaLangCommonOperation();
	//ObjLinkedListOperation.PerformOperation();
	
	//ObjJavaLangCommonOperation.PerformOperation();
	//ThreadPoolImplementation ObjThreadPoolImplementation=new ThreadPoolImplementation();
	//ArrayOperation ObjArrayOperation =new ArrayOperation();
	//StackPoblems ObjStackPoblems=new StackPoblems();
//	JavaCollectionProblems ObjJavaCollectionProblems=new JavaCollectionProblems();
//TreeProblems ObjTreeProblems=new TreeProblems();

	//DPQuestionProblems ObjDPQuestionProblems=new DPQuestionProblems();
	 //Java8StreamsApi ObjJava8StreamsApi=new Java8StreamsApi();
	// Sorting ObjSorting=new Sorting();
	
	
 }
}
