package JavaLangCommonOperation;

import java.io.IOException;

class CustomException extends Exception
{
	CustomException(String Msg)
	{
		super(Msg);
	}
}
class CommonOperation 
{
	public void callmethod() throws CustomException,Exception
	{
		// new  CustomException("Divde by zero");
		int a=10/0;
		//new IOException("IO Exception occur");
	}
	void Divide() throws CustomException,Exception
	{
		callmethod();		
		throw new IOException("IO Exception");
		
	}
}

class OuterClass
{
	private int data=1;
	//member inner class
	class InnerClass
	{
		void method()
		{
			System.out.println("Data is:"+data);
		}	
	}	
	void OuterClassMethod()
	{
		class OuterMethodInnerClass
		{
			void Method()
			{
				System.out.println("OuterClassMethod is:"+data);
			}
		
		}
		OuterMethodInnerClass ObjOuterMethodInnerClass=new OuterMethodInnerClass();
		ObjOuterMethodInnerClass.Method();
	}
}

abstract class TestOuterClass
{
	abstract void method();
}



class TestExtentableOuterClass extends TestOuterClass
{
	@Override
	void method() {
		// TODO Auto-generated method stub
		
	}
	
}


interface TestInterface
{
	int a=40;//final static
	 void Add();//abstarct public 
	void Subract();
}



 class Test2
{
	int a=10,b=20;
	int c=a*b;
	void Multiply()
	{
		System.out.println("Multiply Data is:"+c);
	}
}
 
 class Test1 extends Test2  implements TestInterface
 {

 	@Override
 	public void Add() {
 		int c=10+20;
 		System.out.println("Add Data is:"+TestInterface.a);
 		System.out.println("Add Data is:"+c);
 		
 	}

 	@Override
 	public void Subract() {
 		int c=10-20;
 		System.out.println("Subract Data is:"+TestInterface.a);
 		System.out.println("Subract Data is:"+c);
 		
 	}
 	
 	void Multiply()
 	{
 		super.Multiply();
 		int d=50;
 		System.out.println("Multiply Data is:"+d);
 	}
 	
 }


public class JavaLangCommonOperation {
   
	public void PerformOperation()
	{
		CommonOperation ObjCommonOperation=new CommonOperation();
		try{
			ObjCommonOperation.Divide();
		}catch(Exception e)
		{
			System.out.println("Exception is:"+e.toString());
		}
		
		NestedClassOps();
		InterFaceOps();
		
	}

	private void InterFaceOps() {
		TestInterface ObTestInterface=new Test1();
		ObTestInterface.Add();
		ObTestInterface.Subract();
		System.out.println("InterFaceOps is:"+TestInterface.a);
		Test1 ObjTest1=new Test1();
		ObjTest1.Multiply();
		//TestOuterClass ObjTestOuterClass=new TestOuterClass();
		new TestOuterClass()
		{
			void method()
			{
				
			}
		};
		
	
		TestInterface obj11=	new TestInterface()
		{
			@Override
		 	public void Add() {
		 		int c=10+20;
		 		System.out.println("Add Data is:"+TestInterface.a);
		 		System.out.println("Add Data is:"+c);
		 		
		 	}

		 	@Override
		 	public void Subract() {
		 		int c=10-20;
		 		System.out.println("Subract Data is:"+TestInterface.a);
		 		System.out.println("Subract Data is:"+c);
		 		
		 	}
		};
		

		
		
	}

	private void NestedClassOps() {
		//member inner class
		OuterClass ObjOuterClass=new OuterClass();
		OuterClass.InnerClass ObjInnerClass=ObjOuterClass.new InnerClass();
		ObjInnerClass.method();
		
		//annnymous object
		TestExtentableOuterClass ObjTestExtentableOuterClass=new TestExtentableOuterClass();
		//method inner class
		ObjOuterClass.OuterClassMethod();
	}
}
//downcasting
//upcasting
//annonymous class
//annonymous object
//adapter class
//wrapper class
