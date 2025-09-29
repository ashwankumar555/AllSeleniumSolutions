package interview;

import java.util.Arrays;

public class MoveAllZerosToEnd {

	public static void main(String[] args) {
		int[] arr = {1,0,3,4,5,0,7,0,9};
		int index = 0;
		for(int num : arr)
		{
			if(num!=0)
			{
				arr[index] = num;
				index++;
			}
		}
		
		while(index<arr.length)
		{
			arr[index] =0;
			index++;
		}
		System.out.println(Arrays.toString(arr));
	}

}
