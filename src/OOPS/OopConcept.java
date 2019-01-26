package OOPS;

 abstract class A{

    public String name;
    public String color;

    public A(String name,String color)
    {
        this.name=name;
        this.color=color;
    }

    abstract public void printString();

    public void sum()
    {
        this.subract();
        System.out.println("sum of A");
    }

    public void subract()
    {
        System.out.println("subract of A");
    }

}

class B extends A{

     public B()
     {
         super("harsh","black");
         super.sum();

     }

    @Override
    public void printString() {
        System.out.println("B abstract method print");

    }
    @Override
    public void subract()
    {
        System.out.println("subract of B");


    }

    public void setAbstractClassInstanceVariable()
    {
        name="khushi";
        color="white";

    }

}

interface C{

      int val=2;
      int a=1;
      String b="harsh";

       void sum();

}

class D implements  C{


    @Override
    public void sum() {

    }
}




public class OopConcept {


    public static void main(String args[])
    {
        B ob=new B();

    }
}
