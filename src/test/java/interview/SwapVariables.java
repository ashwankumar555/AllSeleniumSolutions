package interview;

public class SwapVariables {

	public static void main(String[] args) {
		int a=4;
		int b=5;
		int temp;
		temp=a;
		a=b;
		b=temp;
		System.out.println(a);
		System.out.println(b);
		
		//Swap the numbers without using temp variables
		a=a+b;		//a=9
		b=a-b;		//b=5
		a=a-b;		//a=4
		System.out.println(a);
		System.out.println(b);
	}
}
