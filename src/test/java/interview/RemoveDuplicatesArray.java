package interview;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesArray {

	public static void main(String[] args) {
		int[] arr = {1,2,3,2,4,5,3,4,6};
		Set<Integer> set = new LinkedHashSet<>();
		for(int i=0;i<arr.length;i++)
		{
			set.add(arr[i]);
		}
		System.out.println(set);
	}
}
