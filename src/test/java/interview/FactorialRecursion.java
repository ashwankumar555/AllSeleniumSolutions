package interview;

public class FactorialRecursion {

    // Recursive method
    public static long factorial(int n) {
        if (n == 0 || n == 1) { // base case
            return 1;
        }
        return n * factorial(n - 1); // recursive call
    }

    public static void main(String[] args) {
        int number = 5;
        System.out.println("Factorial of " + number + " = " + factorial(number));
    }
}

