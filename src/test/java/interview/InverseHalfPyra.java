package interview;

public class InverseHalfPyra {

	public static void main(String[] args) {
		int n = 5;
		
		for(int i=1;i<=n;i++)
		{
			for (int j = n; j >= i; j--)
			{
				System.out.print(j);
			}
			System.out.println();
		}
		
		System.out.println();
		
		int p = 5;
        for (int x = p; x >= 1; x--) {
            for (int y = 1; y <= x; y++) {
                System.out.print(y);
            }
            System.out.println();
        }

	}

}
