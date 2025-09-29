package interview;

public class InverseHalfPyramid {

	public static void main(String[] args) {
		int k = 5;
		
		for(int i=1;i<=5;i++)
		{
			for(int j=k;j<=i;j--)
			{
				System.out.print(j);
			}
			System.out.println();
		}

	}

}
