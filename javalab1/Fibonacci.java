import java.util.Scanner;

class Fibonacci
{
	public static void main(String[] args)
	{
		System.out.println("Fibonacci Series");
		System.out.println("Enter the limit:");
		Scanner obj=new Scanner(System.in);
		int n=obj.nextInt();
		int a=0;
		int b=1;
		int c;
		System.out.println("Fibonacci series:");
		System.out.println(a);
		System.out.println(b);
		int i=0;
		for(i=2;i<n;i++)
		{
			c=a+b;
			System.out.println(c);
			a=b;
			b=c;
			
		}
	}
}