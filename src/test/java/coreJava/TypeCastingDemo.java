package coreJava;

class Calc
{
	
}
public class TypeCastingDemo {

	public static void main(String[] args) {
		byte b = 127;
		int a= 259;
		a = (byte) b;
		
		System.out.println(a);
		
		float f = 5.6f;
		int t= (int) f;
		System.out.println(t);
		
		double d = 4.5;
		int p = (int) d;
		System.out.println(p);
		
		Integer num1 = new Integer(8);
		Integer num2 = 10;
		System.out.println(num1);
		System.out.println(num2);
		
		
		
		int num5 = 9;
		Integer num6 = num5;    //Autoboxing
		
		//int num7 = num6.intValue();   //Unboxing
		int num7 = num6;
		
		System.out.println(num7);
		
		String str55 = "12";
		int num8 = Integer.parseInt(str55);
		System.out.println(num8*10);
	}
}
