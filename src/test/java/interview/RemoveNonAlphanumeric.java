package interview;

public class RemoveNonAlphanumeric {

	public static void main(String[] args) {
		 String s = "He@#llo! 123"; 
	        s = s.replaceAll("[^a-zA-Z0-9]", ""); 
	        System.out.println(s); 
	        
	       
	}
}
