package interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
public class IteratorExample {
	public static void main(String[] args) {
		ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Date");
        Iterator<String> iterator = fruits.iterator();
        // Iterating and removing elements conditionally
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            if (fruit.startsWith("B")) {
                iterator.remove(); // Safe removal during iteration
            }
        }
        // Displaying the modified list
        System.out.println(fruits); // Output: [Apple, Cherry, Date]     
        // Creating a HashSet and adding elements
        HashSet<String> fruitsSet = new HashSet<>();
        fruitsSet.add("Apple");
        fruitsSet.add("Banana");
        fruitsSet.add("Cherry");
        fruitsSet.add("Date");
        // Obtaining an iterator
        Iterator<String> i = fruitsSet.iterator();
        // Iterating through the HashSet
        System.out.println("Iterating over HashSet using Iterator:");
        while (i.hasNext()) {
            System.out.println(i.next());
            }
	}
}