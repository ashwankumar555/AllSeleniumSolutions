package coreJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.stream.Collectors;

public class ListsDemo {

	public static void main(String[] args) {
		//Dynamic Array list 
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		System.out.println(arr);
		

		LinkedList<Integer> linklist = new LinkedList<>();

		linklist.add(4);
		linklist.add(5);
		linklist.add(6);
		linklist.poll();
		linklist.pop();
		System.out.println(linklist);
		
		//Dynamic Array List using Interface Reference (best practice)
		List<String> list = new ArrayList<>();
		list.add("ashwin");
		list.add("akhira");
		list.add("amyra");
		
		//Retrieving the list varailable and reading them as Map. 
		Map<Integer, String> map = new HashMap<>();
		for(int i=0;i<list.size();i++)
		{
			map.put(i, list.get(i));
		}
		System.out.println(map);
		
		//LinkedList
		List<Integer> list2 = new LinkedList<>();
		
		//Anonymous Inner Class (double brace initialization)
		List<String> list3 = new ArrayList<String>() {{
		    add("Apple");
		    add("Banana");
		}};
		
		//Fixed size array list
		List<String> list4 = Arrays.asList("A", "B", "C");
		// list.add("D"); // UnsupportedOperationException
		System.out.println("List4 is "+list4);
	
		//Singleton list using Collections. It allows only one value.
		List<String> list5 = Collections.singletonList("Only one");
		System.out.println("Singleton list is "+list5);
		
		List<String> fruits = new ArrayList<>();
		// Add
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Mango");

		// Insert at index
		fruits.add(1, "Orange");

		// Get
		System.out.println(fruits.get(0)); // Apple

		// Update
		fruits.set(2, "Pineapple");

		// Remove
		fruits.remove("Banana");
		fruits.remove(1);

		// Size
		System.out.println(fruits.size());

		// Contains
		System.out.println(fruits.contains("Mango"));

		// Iterate
		for (String f : fruits) {
		    System.out.println(f);
		}

		//Iterator for forward 
		Iterator it = fruits.iterator();
		while(it.hasNext())
		{
			
			System.out.println(it.next());
		}
		
		//ListIterator for forward and backward
		ListIterator<String> lit = fruits.listIterator();
		while(lit.hasNext()) {
		    System.out.println(lit.next());
		}
		while(lit.hasPrevious()) {
		    System.out.println(lit.previous());
		}
		
		List<Integer> linkedList = new LinkedList<>();
		linkedList.add(10);
		linkedList.add(20);
		linkedList.add(0,35);
		linkedList.set(2, 1234);
		System.out.println(linkedList); // [5, 10, 20]


		
		//Print all values using streams
		list.stream().forEach(System.out::println);

		fruits.stream().filter(s->s.startsWith("P")).forEach(System.out::println);		
		fruits.parallelStream().filter(s->s.endsWith("e")).collect(Collectors.toList()).forEach(s->System.out.print(s+" "));
		
		List<Integer> intlist = Arrays.asList(1,2,3,4,5,6,7,8,9);
		intlist.stream().filter(s->(s%2==0)).collect(Collectors.toList()).forEach(s->System.out.println(s*s));
		
	}
}
