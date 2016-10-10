import java.util.Scanner;
class Second
{
public static void main(String[] args)
	{
		System.out.print("Enter the size of the array:");
		Scanner obj=new Scanner(System.in);
		int n=obj.nextInt();
		int[] a=new int[n];
		int i;
		System.out.println("Enter the array:");
		for(i=0;i<n;i++)
		{
			a[i]=obj.nextInt();
		}
		System.out.println("Displaying the array:");
		int min,max;
		min=a[0];
		max=a[0];
		for(i=0;i<n;i++)
		{
			System.out.print(a[i]+" ");
			if(a[i]>max)
			{
				max=a[i];
			}
			if(a[i]<min)
			{
				min=a[i];
			}
		}
		System.out.println();
		int sec=min;
		for(i=0;i<n;i++)
		{
			if(a[i]>sec && a[i]!=max)
			{
				sec=a[i];
			}
		}
		System.out.println("Second Largest Element:"+sec);
	}
}