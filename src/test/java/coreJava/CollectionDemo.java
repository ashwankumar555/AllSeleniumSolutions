package coreJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.testng.annotations.Test;

@Test(groups = {"Regression"})
public class CollectionDemo {

    public void demoCollections() {
        // Using Collection interface with ArrayList implementation
        Collection<Integer> nums = new ArrayList<>();
        nums.add(6);
        nums.add(8);
        nums.add(6);
        nums.add(8);
        nums.add(10);
        nums.add(12);

        System.out.println("Collection elements: " + nums);

        System.out.println("Iterating through Collection:");
        for (int n : nums) {
            System.out.println(n);
        }

        // Using List with Stream API
        List<Integer> list = Arrays.asList(1, 3, 4, 5, 6, 7);
        System.out.println("Stream elements greater than 5:");
        list.stream()
            .filter(s -> s > 5)  // intermediate operation
            .forEach(System.out::println); // terminal operation
    }
}
