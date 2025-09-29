package interview;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedHashSet;
import java.util.Set;
public class RemoveDuplicateCharacters {
	public static void main(String[] args) {
		
		//Removing duplicate characters from String
		String text = "aabbccddeefgh";
		char[] arr = text.toCharArray();
		Set<Character> newset = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for(Character c : arr)
		{
			if(!newset.contains(c))
			{
				newset.add(c);
				sb.append(c);
			}
		}
		System.out.println(sb);
		
		//Removing duplicates from integer array
		int[] intarr = {1,1,2,3,2,3,3,4,4};
		Set<Integer> intset = new LinkedHashSet<>();
		
		for(int n : intarr)
		{
			intset.add(n);
		}
		
		System.out.println("Array after removing duplicates "+intset);
	}
}
