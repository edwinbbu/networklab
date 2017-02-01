import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class Server
{
	public static void main(String[] args) throws Exception
	{
		try
		{
			Def add=new Def();
			Naming.rebind("def",add);
			System.out.println("Object created");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}