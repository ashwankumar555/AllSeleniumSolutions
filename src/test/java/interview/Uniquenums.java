package interview;

public class Uniquenums {

    public static void main(String[] args) {
        int a[] = {4, 5, 5, 5, 4, 6, 6, 9, 4};

        for (int i = 0; i < a.length; i++) {
            boolean isUnique = true;

            for (int j = 0; j < a.length; j++) {
                if (i != j && a[i] == a[j]) {
                    isUnique = false;
                    break; // no need to check further
                }
            }

            if (isUnique) {
                System.out.println(a[i] + " is a unique number");
            }
        }
    }
}