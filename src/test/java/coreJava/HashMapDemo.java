package coreJava;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class HashMapDemo {

	public static void main(String[] args) {
		String str = "aabbcccccdddffghi";
		char[] arr = str.toCharArray();
		Map<Character, Integer> freqcount = new HashMap<>();
		
		for(int i=0;i<arr.length;i++)
		{
			freqcount.put(arr[i], freqcount.getOrDefault(arr[i], 0)+1);
		}
		System.out.println(freqcount);
		
		for(Character c : freqcount.keySet())
		{
			System.out.println(c+" repeated for : "+freqcount.get(c));
		}
		
		Map<Integer,String> map = new TreeMap<>();
		map.put(20, "Akhira");
		map.put(10, "Ashwin");
		map.put(30, "Swetha");
		map.put(40, "Amyra");
		System.out.println(map);
		System.out.println(map.keySet());
		
		for(Integer key : map.keySet())
		{
			System.out.println(key+" : "+map.get(key));
		}
		
		List<Integer> nums = Arrays.asList(4,5,7,9);
        nums.stream().forEach(s->System.out.println(s));
		
	}
}
