package interview;

import java.util.LinkedList;

public class ReverseLinkedList {

	 public static void main(String[] args) { 
	        LinkedList<Integer> list = new LinkedList<>(); 
	        list.add(1); list.add(2); list.add(3); 
	        for (int i = list.size() - 1; i >= 0; i--) 
	            System.out.print(list.get(i) + " "); 
	    } 
}
