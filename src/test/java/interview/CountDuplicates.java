package interview;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountDuplicates {

	public static void main(String[] args) {
		String text = "java has java key has key new word";
		String[] arr = text.split(" ");
		Map<String, Integer> wordcount = new LinkedHashMap<>();
		
		for(String word : arr)
		{
			wordcount.put(word, wordcount.getOrDefault(word, 0)+1);
		}
		System.out.println(wordcount);
		
		for(String key : wordcount.keySet())
		{
			
			System.out.println(key + " -> " + wordcount.get(key));
			if(wordcount.get(key)>1)
			{
				System.out.println(key + " -> " + wordcount.get(key));
				break;
			}
		}
	}
}
