package coreJava;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsExample {

	public static void main(String[] args) {
		List<String>  list = Arrays.asList("Akhira","Sravan","Kushi","Karthi","Arjun","Akhi");
		list.stream().filter(s->s.length()==4).collect(Collectors.toList()).forEach(s->System.out.println(s));
		
		 Map<Character, List<String>> map = new HashMap<>();
		 map.put('i', list.stream().filter(s->s.endsWith("i")).toList());
		 map.put('a', list.stream().filter(s->s.endsWith("a")).toList());
		 map.put('n', list.stream().filter(s->s.endsWith("a")).toList());
		 System.out.println(map);
		 System.out.println(map.keySet());
		 Long abc = map.keySet().stream().collect(Collectors.counting());
		 System.out.println(abc);
		 
		 //Find Duplicate Elements in a List
		 String str = "12345677891234";
		 List<Character> charList = str.chars().mapToObj(c->(char)c).collect(Collectors.toList());
		 Map<Character, Long> map7 = charList.stream().collect(Collectors.groupingBy(n->n, Collectors.counting()));
		 map7.entrySet().stream().filter(n->n.getValue()>1).forEach(n-> System.out.println("Key: " + n.getKey() + " -> repeated times value: " + n.getValue()));
	
		
		 List<Integer> nums = Arrays.asList(1, 2, 1, 1, 3, 4, 2, 2, 5, 3, 6, 1);
		 Map<Integer, Long> map5 = nums.stream().collect(Collectors.groupingBy(n->n, Collectors.counting()));
		 map5.entrySet().stream().filter(n->n.getValue()>1).forEach(n->System.out.println("Key: " + n.getKey() + " -> repeated times value: " + n.getValue()));
	
		 //Find duplicate words from two different lists and print them
		 List<String> run1 = Arrays.asList("Login", "Checkout", "Search");
		 List<String> run2 = Arrays.asList("Login", "Search", "Profile");
		 List<String> common = run1.stream()
		     .filter(run2::contains)
		     .collect(Collectors.toList());
		 System.out.println("Common Failed Tests: " + common); // [Login, Search]

		 
	}
}
