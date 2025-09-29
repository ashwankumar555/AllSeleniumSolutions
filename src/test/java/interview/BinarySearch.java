package interview;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {1,2,4,5,6,7,9};
		int target = 7;
		int left = 0;
		int right = arr.length-1;
		while(left<=right)
		{
			int mid=left+(right-left)/2;
			if(arr[mid]==target)
			{
				System.out.println("Found at index :"+mid);
				return;
			}else if(arr[mid]<target)
			{
				left=mid+1;
			}else if(arr[mid]>target){
				right=mid-1;
			}
		}
		System.out.println("Not found ");
	}
}
