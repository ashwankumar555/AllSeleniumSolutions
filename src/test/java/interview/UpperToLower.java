package interview;

public class UpperToLower {

	public static void main(String[] args) {
		String str = "ASHWIN AKHIRA";
		char[] arr = str.toCharArray();
		StringBuilder manualLower = new StringBuilder();
		for(Character ch : arr)
		{
			if (ch >= 'A' && ch <= 'Z') {
				
				manualLower.append((char) (ch + 32));
            } else {
                manualLower.append(ch);
            }
		}
		System.out.println("Manual conversion: " + manualLower.toString());
		
		//Upper To Lower
		String str1 = "kiss akhira";
        char[] arr1 = str1.toCharArray();
        StringBuilder manualUpper = new StringBuilder();

        for (Character ch : arr1) {
            if (ch >= 'a' && ch <= 'z') {
                // Convert lowercase to uppercase by subtracting 32
                manualUpper.append((char) (ch - 32));
            } else {
                manualUpper.append(ch); // Keep spaces or non-lowercase as is
            }
        }

        System.out.println("Manual conversion: " + manualUpper.toString());
    	}
	}

