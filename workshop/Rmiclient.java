import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.Scanner;
public class Rmiclient
{
	public static void main(String[] args)
	{
		try
		{
			String url="rmi://localhost/obj";
			Scanner obj=new Scanner(System.in);
			System.out.println("Enter any sentence:");
			String str=obj.nextLine();
			System.out.println("Enter the starting position:");
			int a=obj.nextInt();
			System.out.println("Enter the ending position:");
			int b=obj.nextInt();
			Interface inter=(Interface)Naming.lookup(url);
			String sub=inter.substr(str,a,b);
			System.out.println("Substring:"+sub);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}