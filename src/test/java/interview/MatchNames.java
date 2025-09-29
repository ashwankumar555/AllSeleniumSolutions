package interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MatchNames {

	public static void main(String[] args) {
		List<String> list1 = Arrays.asList("John Doe", "Alice Smith", "Bob Brown", "John Doe");
        List<String> list2 = Arrays.asList("Charlie White", "Alice Smith", "David Black", "John Doe");
        Set<String> set1 = new HashSet<>(list1);
        Set<String> set2 = new HashSet<>(list2);
        System.out.println(set1);
        System.out.println(set2);
        
        for (String s1 : set1) {
            for (String s2 : set2) {
                	if (s1.equals(s2)) {
                    System.out.println("Match found: " + s1);
                }
            }
        }
	}
}
