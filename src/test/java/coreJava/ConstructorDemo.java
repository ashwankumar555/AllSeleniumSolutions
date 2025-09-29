package coreJava;

import org.junit.Test;

//A constructor is a special method used to initialize objects when they are created.
//It has the same name as the class. It does not have a return type (not even void)
//Called automatically when you create an object using new.
//Cannot be abstract, final, static
//Can be private.

/*Industry-Level Uses of Constructors
Object Initialization → Assign values at object creation.
Dependency Injection → In Spring framework, beans often initialized via constructors.
Immutability → With final fields and no setters.
Builder Pattern → Used with constructor overloading for flexible object creation.
Inheritance → Ensuring base class state is initialized properly.*/


class ANew
{
	int a=10;
	String name;
    int age;
    
 
	ANew()
	{
		System.out.println("Default constructor of parent class A: ");
		name = "akhi";
        age = 18;
        System.out.println("Name called from Default constructor "+name);
        System.out.println("Age called from Default constructor "+age);
	}
	
	ANew(int a)
	{
		this.a=a;
		System.out.println("Param constructor of parent class A: "+a);
	}
	
	ANew(String name, int age) {
        this.name = name;
        this.age = age;
        
        System.out.println("Name called from overloaded constructor "+name);
        System.out.println("Age called from overloaded constructor "+age);
}
}

class BNew extends ANew
{
	String str = "ashwin";
	private BNew()
	{
		super();
		System.out.println("Default constructor of child class B: ");
	}
	
	BNew(String str)
	{
		super(33);
		this.str=str;
		System.out.println("Param constructor of child class B: "+str);
	}
	
	BNew(String name, int age) {
        this.name = name;
        this.age = age;
        
        System.out.println("Name called from overloaded constructor of child class "+name);
        System.out.println("Age called from overloaded constructor of child class "+age);
	}
}

public class ConstructorDemo {

	public static void main(String[] args) {
		ANew obj = new BNew("ashwin",77);
	}
}
