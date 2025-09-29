package coreJava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayAssignment {

	public static void main(String[] args) {
		int[] arr = {10,50,70,40};
		//System.out.println(arr[2]);
		
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i]<arr[i+1])
			{
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1]=temp;
			}
		}
		int j = arr.length-1;
		System.out.println(arr[j]);
		
		Arrays.stream(arr).boxed().collect(Collectors.toList()).stream().sorted().forEach(s->System.out.println(s));
	
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		list.stream().sorted().forEach(s->System.out.println(s));
	}
}
