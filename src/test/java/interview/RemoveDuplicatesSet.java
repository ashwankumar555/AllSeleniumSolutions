package interview;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesSet {

	public static void main(String[] args) {
		int[] arr = {1,1,2,3,4,5,6,7,6,7,8};
		Set<Integer> uniquenumbers = new HashSet<>();
		for(Integer a : arr)
		{
			uniquenumbers.add(a);
		}
		System.out.println(uniquenumbers);
		
		String str = "aabbccddee";
		String temp = "";
		char[] chararr = str.toCharArray();
		Set<Character> uniquechars = new HashSet<>();
		for(Character c : chararr)
		{
			uniquechars.add(c);
			temp=temp;
		}
		System.out.println(uniquechars);
		System.out.println(temp);
	}
}
