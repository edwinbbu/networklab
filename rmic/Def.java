import java.rmi.*;
import java.rmi.server.*;

public class Def extends UnicastRemoteObject implements Interface
{
public Def() throws RemoteException{};

public String substr(String str,int a,int b) throws Exception
	{
	String sub=str.substring(a,b);
	return sub;
	}
}