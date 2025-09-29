package coreJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsDemo {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(22,34,11,7,14);
		//Piniting numbers in sorted order
		list.stream().sorted().forEach(s->System.out.println(s));
		
		//Find min and max values
		int maximum = list.stream().max(Integer::compare).get();
		int minimum = list.stream().min(Integer::compare).get();
		System.out.println("Maximum value is: "+maximum);
		System.out.println("Minimum value is: "+minimum);
		
		//Counting the repeated words from a list
		String text = "apple banana apple orange banana apple";
		List<String> wordslist = Arrays.asList(text.split(" "));
		Map<String, Long> wordCount = wordslist.stream().collect(Collectors.groupingBy(s->s,Collectors.counting()));

		System.out.println(wordCount);
		
		//Characters count
		String str2 = "swiss";
		char[] arrstr = str2.toCharArray();
		List<Character> charList = new ArrayList<>();
		for(char c : arrstr)
		{
			charList.add(c);
		}
		Map<Character, Long> charcount = charList.stream().collect(Collectors.groupingBy(s->s,Collectors.counting()));
		System.out.println(charcount);
		
		//Reversing string
		String temp ="";
		for(int i=arrstr.length-1;i>=0;i--)
		{
			temp =temp+str2.charAt(i);
		}
		System.out.println(temp);
		
		//Print names staring with "k"
		List<String> strlist = Arrays.asList("ashwin", "akhira", "johny", "swetha", "kushi");
		strlist.stream().filter(s->s.startsWith("k")).forEach(s->System.out.println(s));
		
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		Map<Boolean, List<Integer>> partition  = numbers.stream().collect(Collectors.partitioningBy(n->n%2==0));
		List<Integer> evenlist = partition.get(true);
		evenlist.stream().forEach(s->System.out.println(s*s));
		
		System.out.println("Even: " + partition.get(true));
		System.out.println("Odd: " + partition.get(false));
		
		//Find the longest word in a list
		List<String> words = Arrays.asList("Ashwinnn", "Akhira", "Johny", "Swetha", "Kushi");
		String longest = words.stream().max(Comparator.comparingInt(String::length)).get();

		System.out.println(longest);
		
		//Find 2nd big value from the list
		List<Integer> numbers5 = Arrays.asList(10, 30, 20, 50, 40);
		List<Integer> sortedlist = numbers5.stream().sorted().collect(Collectors.toList());
		
		System.out.println(sortedlist.get(1));
		
		
		//Find common elements between two lists
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8);
		List<Integer> common = list1.stream().filter(list2::contains).collect(Collectors.toList());
		System.out.println(common); // [4, 5]
		
		
		//Sort a list of strings by length
		List<String> allwords = Arrays.asList("Ashwin", "Jo", "Kumar", "Swethaa");
		List<String> sortedbylength = allwords.stream().sorted(Comparator.comparingInt(String::length))
				.collect(Collectors.toList());
		System.out.println(sortedbylength); // [Jo, Kumar, Ashwin, Swetha]


		
	}
}
