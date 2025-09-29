package interview;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateCharactersFromString {

	public static void main(String[] args) {
		String input = "aabbccddeeigh";
		StringBuilder sb = new StringBuilder();
		char[] arr = input.toCharArray();
		Set<Character> newset = new HashSet<>();
		for(char c : arr)
		{
			if(!newset.contains(c))
			{
			newset.add(c);
			sb.append(c);
			}
		}
		System.out.println(newset);
		System.out.println(sb);
			}

}
