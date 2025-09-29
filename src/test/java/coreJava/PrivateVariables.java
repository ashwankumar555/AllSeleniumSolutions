package coreJava;

public class PrivateVariables {
	private String name;
	private Integer age;
	
	public PrivateVariables()
	{
		name = "Akhira";
		age = 3;
		System.out.println("I am constructor");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}
