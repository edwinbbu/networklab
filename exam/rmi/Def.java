import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class Def extends UnicastRemoteObject implements Interface
{
	public Def() throws Exception
	{};
	
	public String substr(String str,int a,int b)
	{
		String sub=str.substring(a,b);
		return sub;
	}
}