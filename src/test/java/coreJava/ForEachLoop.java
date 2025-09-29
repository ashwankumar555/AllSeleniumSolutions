package coreJava;

public class ForEachLoop {

	public static void main(String[] args) {
		int nums[] = new int[4];
		nums[0] = 4;
		nums[1] = 6;
		nums[2] = 8;
		nums[3] = 10;
		
		for(int n : nums)
		{
			System.out.println(n);
		}
	}

}
