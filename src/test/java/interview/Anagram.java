package interview;

import java.util.Arrays;
import java.util.List;

public class Anagram {

	public static void main(String[] args) {
		String str1 = "silent";
		String str2 = "listen";
		
		char[] chararr1 = str1.toCharArray();
		char[] chararr2 = str2.toCharArray();
		
		Arrays.sort(chararr1);	
		Arrays.sort(chararr2);	
		
		System.out.println(chararr1);
		System.out.println(chararr2);
		
		if (Arrays.equals(chararr1, chararr2)) {
            System.out.println("Strings are anagrams");
        } else {
            System.out.println("Strings are not anagrams");
        }
	}

}
