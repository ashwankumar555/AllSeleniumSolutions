package coreJava;

public class StringDemo {

	public static void main(String[] args) {
		
		String name = "Akhira";
		name = name + " Kumar";
		System.out.println(name);
		String name1 = new String("Akhira");
		if(name==name1)
		{
			System.out.println("Passed");
		}
		else {
			System.out.println("Failed");
		}
	}
}
