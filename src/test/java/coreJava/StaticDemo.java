package coreJava;

public class StaticDemo {
	
	String brand;
	String price;
	static String type;
	
	public StaticDemo()
	{
		brand = "abc";
		price = "200";
		System.out.println("I am inside constructor");
	}
	
	static
	{
		type = "smart";
		System.out.println("I am inside static block");
	}
	public void show()
	{
		System.out.println(brand+" : "+price+" : "+type);
	}
	
	public static void show1(StaticDemo obj)
	{
		System.out.println(obj.brand+" : "+obj.price+" : "+type);
	}

	public static void main(String[] args) {
		StaticDemo obj = new StaticDemo();
		//obj.brand = "Apple";
		//obj.price = "2000";
		//StaticDemo.type = "Smart Phone";
		
		StaticDemo obj2 = new StaticDemo();
		//obj2.brand = "Sam";
		//obj2.price = "5000";
		
		obj.show();
		obj2.show();
		
		StaticDemo.show1(obj);
		StaticDemo.show1(obj2);
	}
}
