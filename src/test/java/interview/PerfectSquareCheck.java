package interview;

public class PerfectSquareCheck {

	public static void main(String[] args) {
		int n = 64;
		int i =1;
		while(i*i<=n)
		{
			
			if(i*i==n)
			{
				System.out.println("Perfect square");
				return;
			}
			i++;
		}
		System.out.println("Not a perfet square");
	}

}
