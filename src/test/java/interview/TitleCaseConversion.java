package interview;

public class TitleCaseConversion {

	public static void main(String[] args) {
		String sentence = "java is fun to learn";
		String[] words = sentence.split(" ");
		StringBuilder sb = new StringBuilder();
		for(String word : words)
		{
			sb.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
			
		}
		System.out.println(sb.toString().trim());
	}

}
