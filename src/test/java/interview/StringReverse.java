package interview;

public class StringReverse {

	public static void main(String[] args) {
		String str = "madam";
		String temp = "";
		char[] arr = str.toCharArray();
		for(int i=str.length()-1;i>=0;i--)
		{
			temp = temp+str.charAt(i);
		}
		System.out.println(temp);
		if(temp.equalsIgnoreCase(str))
		{
			System.out.println("Strings are palindrome ");
		}else{
			System.out.println("Strings are not palindrome ");
		}
		
		//Using StringBuilder
		int i = str.length();
		StringBuilder sb = new StringBuilder();
		for(Character c : arr)
		{
			sb.append(arr[i-1]);
			i--;
		}
		System.out.println(sb.toString());
	}
}
