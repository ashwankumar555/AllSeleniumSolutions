package interview;

public class ReverseEachWordInSentence {

	public static void main(String[] args) {
		String text = "I love my India";
		String[] arr = text.split(" ");
		String temp = "";
		int arrlength = arr.length-1;
		StringBuilder sb = new StringBuilder();
		for(String str : arr)
		{
			//temp = temp+arr[arrlength]+" ";
			//arrlength--;
			sb = sb.append(arr[arrlength]).append(" ");
			arrlength--;
		}
		//System.out.println(temp);
		System.out.println(sb);
	}

}
