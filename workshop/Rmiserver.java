import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class Rmiserver
{
	public static void main(String[] args) throws Exception
	{
		try
		{
			Def add=new Def();
			Naming.rebind("obj",add);
			System.out.println("Object Registered");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}