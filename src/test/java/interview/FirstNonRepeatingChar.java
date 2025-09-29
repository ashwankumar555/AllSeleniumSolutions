package interview;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {

	public static void main(String[] args) { 
        String input = "aabbcdeff"; 
       
        Map<Character, Integer> map = new LinkedHashMap<>(); 
        
        //Here we are converting string into character array and looping through character type variable
        for (char i : input.toCharArray()) { 
            map.put(i, map.getOrDefault(i, 0) + 1); 
        } 
        for (char i : map.keySet()) { 
            if (map.get(i) == 1) { 
                System.out.println("First non-repeating: " + i); 
                break; 
            } 
        } 
    } 
}
