package coreJava;

@FunctionalInterface
interface Abc
{
	void show(int i);
}
public class InterfaceDemo {

	public static void main(String[] args) {
		Abc obj = i->System.out.println("In show: "+i);
		obj.show(10);
	}
}
