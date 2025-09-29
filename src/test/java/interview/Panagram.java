package interview;

import java.util.HashSet;
import java.util.Set;

public class Panagram {

	public static void main(String[] args) {
		String str1 = "qwertyuiopasdfghjklzxcvbnmasdfweqrtuo";
		String str2 = "ashwin";

		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		
		Set<Character> charset1 = new HashSet<>();
		Set<Character> charset2 = new HashSet<>();
		
		for(Character c: arr1)
		{
			if(c >= 'a' && c<= 'z')
			{
			charset1.add(c);
			}
		}
		System.out.println(charset1);
		
		for(Character c: arr2)
		{
			if(c >= 'a' && c<= 'z')
			{
			charset2.add(c);
			}
		}
		System.out.println(charset2);
		
		if(charset1.size()==26)
		{
			System.out.println(charset1+" : is Pangram");
		}else
		{
			System.out.println(charset1+" : is not a Pangram");
		}
		if(charset2.size()==26)
		{
			System.out.println(charset2+" : is Pangram");
		}else
		{
			System.out.println(charset2+" : is not a Pangram");
		}
	}

}
