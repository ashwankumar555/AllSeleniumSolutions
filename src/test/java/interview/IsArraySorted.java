package interview;

public class IsArraySorted {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,3};
		boolean sorted = true;
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]<arr[i-1])
			{
				sorted = false;
				break;
			}
		}
		System.out.println("Is sorted: "+sorted);
	}
}
