import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server implements Runnable
{
	Thread t;
	ServerSocket ss;
	Socket cs;
	String msg,str;
	BufferedReader b;
	PrintWriter p;
	Server()
	{
		try
		{
			t=new Thread(this);
			t.setDaemon(true);
			t.start();
			
		//	b=new BufferedReader(new InputStreamReader(cs.getInputStream()));
		//	p=new PrintWriter(cs.getOutputStream(),true);
			Scanner obj=new Scanner(System.in);
			while(true)
			{
				str=obj.nextLine();
				p.println(str);
				p.flush();
				System.out.println("Send:"+str);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public static void main(String[] args)
	{
		Server server=new Server();
	}
	
	public void run()
	{
		try
		{
			ss=new ServerSocket(3000);
			cs=ss.accept();
			b=new BufferedReader(new InputStreamReader(cs.getInputStream()));
			p=new PrintWriter(cs.getOutputStream(),true);
			while(true)
			{
				msg=b.readLine();
				System.out.println("Recieved:"+msg);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}