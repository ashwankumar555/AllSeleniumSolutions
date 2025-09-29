package coreJava;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StringBufferDemo {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("Ashwin");
		StringBuffer sb2 = new StringBuffer("Ashwin");
		System.out.println(sb.hashCode());
		//System.out.println(sb2.hashCode());
		sb.append(" Kumar");
		System.out.println(sb);
		System.out.println(sb.hashCode());
		

		String str7 = "My name is Ashwin";
		
		List<String> list = Arrays.asList(str7.split(" "));
		 for (int i = 0; i < list.size(); i++) {
	            System.out.print(list.get(i));
	            if (i < list.size() - 1) { // avoid trailing '-'
	                System.out.print("-");
	            }
	        }
		
		
		  System.out.println();
		  String str1 = "Abc"; 
		  System.out.println(str1.hashCode());
		  
		  str1=str1+" Kumar";
		  System.out.println(str1);
		  System.out.println(str1.hashCode());
		  
		  System.out.println(sb);
			System.out.println(sb.hashCode());
		  
		  String str2 = "Abc"; 
		  String str = "Akhira";
		 
		  System.out.println(sb); System.out.println(sb.capacity());
		  System.out.println(sb.length());
		  
		  str = str.concat(" Kumar"); System.out.println(str);
		 
		if(sb==sb2)
		{
			System.out.println("Passed");
		}else
		{
			System.out.println("Failed");
		}
		
		
		  if(str1==str2) { System.out.println("Strings Passed"); }else {
		  System.out.println("Strings Failed"); }
		}
	
}
