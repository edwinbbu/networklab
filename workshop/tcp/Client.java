import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client implements Runnable extends Thread
{
	Thread t;
	Socket cs;
	String msg,str;
	BufferedReader b;
	PrintWriter p;
	Client()
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
			cs=new Socket("localhost",3000);
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