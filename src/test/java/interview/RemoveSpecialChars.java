package interview;

public class RemoveSpecialChars {
    public static void main(String[] args) {
        String str = "He#ll@o1%23";
        StringBuilder sb = new StringBuilder();
        char[] arr = str.toCharArray();

        for (char ch : arr) {
            if (Character.isLetterOrDigit(ch)) {  // keep only letters & digits
                sb.append(ch);
            }
        }

        System.out.println(sb.toString());
    }
}
