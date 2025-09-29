package coreJava;

class ThisPractise
{
	String name;
	ThisPractise()
		{
			
		}
	public void display(String name)
	{
		this.name = name;
		System.out.println("Calling method in order to call this keyword from Parent: "+name);
	}
	
}

class ChildThisPractise extends ThisPractise
{
	ChildThisPractise()
	{
		super.display(name);
	}
	
	public void display(String name)
	{
		System.out.println("Calling child class method in order to call this keyword: "+name);
	}
}
public class ThisKeywordDemo {

	public static void main(String[] args) {
		
		ChildThisPractise obj = new ChildThisPractise();
		obj.display("Ashwin");
		
		
	}

}
