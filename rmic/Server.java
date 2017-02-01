import java.rmi.*;
import java.rmi.registry.*;
public class Server{
public static void main(String args[]) throws Exception
{
	try
		{
		Def add=new Def();
		Naming.rebind("def",add);	
		//addService object is hosted with name def. 
		System.out.println("Object registered");
		}
	catch(Exception e)
		{
		System.out.println(e);
		}
	}
}