package interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MergeTwoArrays {

	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {4,5,6,7,8,9};
		int[] merged = new int[arr1.length+arr2.length];
		System.arraycopy(arr1, 0, merged, 0, arr1.length);
		System.arraycopy(arr2, 0, merged, arr1.length, arr2.length);
		System.out.println(Arrays.toString(merged));	
		//Removing the duplicates
		Set<Integer> arrayset = new HashSet<>();
		for(Integer n : merged)
		{
			arrayset.add(n);
		}
		System.out.println(arrayset);
	}
}
