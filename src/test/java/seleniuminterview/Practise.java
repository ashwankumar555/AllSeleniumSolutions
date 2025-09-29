package seleniuminterview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Practise {

	public static void main(String[] args) {
		String str = "abcbefaaddffee";
		char[] a = str.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for(Character c : a)
		{
			map.put(c, map.getOrDefault(c,0)+1);
		}
		System.out.println(map);
		
		Set<Character> seen = new HashSet<>();
		Character firstDuplicate = null;
		
		for(Character c : a)
		{
			if(seen.contains(c))
			{
				firstDuplicate = c;
				break;
			}
			seen.add(c);
		}
		
		if (firstDuplicate != null) {
            System.out.println("First duplicate character: " + firstDuplicate);
        } else {
            System.out.println("No duplicates found");
        }
	}
}
