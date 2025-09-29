package interview;
public class CountVowels {
	public static void main(String[] args) {
		String text = "Hello World";
		char[] arr = text.toLowerCase().toCharArray();
		int vowelscount = 0;
		int conscount = 0;
		for(Character c : arr)
		{
			if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' )
			{
				vowelscount++;
			}else
			{
				conscount++;
			}
			
		}
		System.out.println("Vowels count is: "+vowelscount);
		System.out.println("Consonants count is: "+conscount);
	}
}
