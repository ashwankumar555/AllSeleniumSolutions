package interview;

public class SwapStrings {

	public static void main(String[] args) {
		String s1 ="Ashwin";
		String s2 ="Akhira";
		s1 = s1 + s2; 

        // Step 2: Extract original s1 into s2
        s2 = s1.substring(0, s1.length() - s2.length()); // s2 = Hello

        // Step 3: Extract original s2 into s1
        s1 = s1.substring(s2.length()); // s1 = World

        System.out.println("\nAfter Swap:");
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

	}

}
