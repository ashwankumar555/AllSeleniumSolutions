package interview;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromString {

	 public static void main(String[] args) { 
	        String input = "aabbccde"; 
	        StringBuilder result = new StringBuilder(); 
	        Set<Character> seen = new HashSet<>();
	        char[] chars = input.toCharArray();
	        for (int i = 0; i < chars.length; i++) {
	            char c = chars[i];
	            if (!seen.contains(c)) {
	                seen.add(c);
	                result.append(c);
	            }
	        }
	 }
}
