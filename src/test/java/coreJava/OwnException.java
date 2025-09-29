package coreJava;

public class OwnException {

	public static void main(String[] args) {
		try {
			int a = 5;
			int b = 0;
			int c = a/b;
			System.out.println(c);
		} catch(Exception e)
		{
			System.out.println("Divided by zero exception");
		} finally
		{
			System.out.println("Exception handled successfully");
		}
	}
}
