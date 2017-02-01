import java.util.Scanner;
class Box
{
	int width,height,depth,v;
	void getData(int w, int h , int d)
	{
		width=w;
		height=h;
		depth=d;
	}
	int volume()
	{
		v=width*depth*height;
		return v;
	}
	void showData()
	{
		System.out.println("Width of the box="+width);
		System.out.println("Height of the box="+height);
		System.out.println("Depth of the box="+depth);
		System.out.println("Volume of the box="+v);
		
	}
	public static void main(String[] args)
	{
		Box b1=new Box();
		Box b2=new Box();
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the width,height and depth of box 1:");
		int w,h,d;
		w=obj.nextInt();
		h=obj.nextInt();
		d=obj.nextInt();
		b1.getData(w,h,d);
		System.out.println("Enter the width,height and depth of box 2:");
		w=obj.nextInt();
		h=obj.nextInt();
		d=obj.nextInt();
		b2.getData(w,h,d);
		int v1=b1.volume();
		System.out.println("Volume of Box 1:"+v1);
		int v2=b2.volume();
		System.out.println("Volume of Box 2:"+v2);
		if(v1>v2)
		{
			System.out.println("Box 1 Details-----");
			b1.showData();
		}
		else if(v2>v1)
		{
			System.out.println("Box 2 Details-----");
			b2.showData();
		}
		else 
		{
			System.out.println("Both box have same volume");
		}
	
	}
}