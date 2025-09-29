package interview;

public class InvertedHalfPyramid {

	public static void main(String[] args) {
		int count = 5;
		for(int i=count;i>=1;i--)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print("* ");
			}
			System.out.println();
			
		}

	}

}
