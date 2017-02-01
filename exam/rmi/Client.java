import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.Scanner;

public class Client
{
	public static void main(String[] args)
	{
		Scanner obj=new Scanner(System.in);
		String url="rmi://localhost/def";
		try
		{
			System.out.println("Enter any sentence:");
			String str=obj.nextLine();
			System.out.println("Enter a:");
			int a=obj.nextInt();
			System.out.println("Enter b:");
			int b=obj.nextInt();
			Interface st=(Interface)Naming.lookup(url);
			String sub=st.substr(str,a,b);
			System.out.println("Sub:"+sub);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
