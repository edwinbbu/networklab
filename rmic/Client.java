import java.util.Scanner;
import java.rmi.*;
public class Client
{
public static void main(String args[])
	{
	try
		{
		String url="rmi://localhost/def";
		
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter any sentence:");
		String str=obj.nextLine();
		System.out.print("Enter the start position:");
		int a=obj.nextInt();
		System.out.print("Enter the end position:");
		int b=obj.nextInt();
		
		Interface st=(Interface)Naming.lookup(url);
		String sub=st.substr(str,a,b);
		System.out.println("Substring: "+sub);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}	
}