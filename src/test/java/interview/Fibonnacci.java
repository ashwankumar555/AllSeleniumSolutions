package interview;

public class Fibonnacci {

	public static void main(String[] args) {
		int a = 0; 
		int b = 1; 
		int counter = 10;
		System.out.print(a+" "+b);
		
		for(int i=2;i<counter;i++)
		{
			int next = a+b;
			System.out.print(" "+next);
			a = b;
			b = next;
		}

	}

}
