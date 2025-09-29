package interview;

public class DiamondPyramid {
    public static void main(String[] args) {
        int n = 5;
        // upper pyramid
        for(int i=1; i<=n; i++) {
            for(int j=i; j<n; j++) {
                System.out.print(" ");
            }
            for(int k=1; k<=(2*i-1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // lower pyramid
        for(int i=n-1; i>=1; i--) {
            for(int j=i; j<n; j++) {
                System.out.print(" ");
            }
            for(int k=1; k<=(2*i-1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
