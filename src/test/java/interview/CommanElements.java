package interview;

import java.util.HashSet;
import java.util.Set;

public class CommanElements {

	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		int[] b = {3,4,5,6};
		Set<Integer> set = new HashSet<>();
		for(int num : a)
		{
			set.add(num);
		}
		
		for(int num : b)
		{
			if(set.contains(num))
			{
				System.out.println("Repeacted number is: "+num);
			}
		}
	}
}
