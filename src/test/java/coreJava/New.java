package coreJava;

import java.util.HashMap;
import java.util.Map;

public class New
{
	public static void main(String[] args) {
		String str = "1234512345";
		char[] arr = str.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for(char c : arr)
		{
		    map.put(c, map.getOrDefault(c, 0)+1);
		}
		System.out.println(map);
	}
}