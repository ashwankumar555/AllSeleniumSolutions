package coreJava;
class BaseApi {
    String baseUri = "https://api.default.com";
    String str = "Ashwin";
    public void show(String str)
    {
    	this.str = str;
    	System.out.println("Show from Parent "+str);
    }
}

class UserApi extends BaseApi {
    String baseUri = "https://api.users.com";
    String str = "Akhira";
    public void show(String str)
    {
    	super.show(str);
    	this.str = str;
    	System.out.println("Show from Child "+str);
    }

    public void printUris() {
        System.out.println(baseUri);       // child variable
        System.out.println(super.baseUri); // parent variable
    }
}

public class SuperKeyword {

	public static void main(String[] args) {
		
		UserApi  obj = new UserApi();
		obj.printUris();
		obj.show("New");
	}
}
