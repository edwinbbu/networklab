import java.io.*;
import java.net.*;

public class Se implements Runnable
{
	ServerSocket ss;
	Socket cs,cs2;
	Thread t,t2;
	BufferedReader br,br2;
	PrintWriter pw,pw2;
	String str;
	Se()
	{
		try
		{
			
		ss=new ServerSocket(3000);
		cs=ss.accept();
		cs2=ss.accept();
		
	
	/*	t=new Thread(this);
		t.setDaemon(false);
		t.start();
		
		t2=new Thread(this);
		t2.setDaemon(false);
		t2.start();
		*/
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String[] args)
	{
		Se s=new Se();
		try
		{
			s.t=new Thread(s);
			s.t.start();
			s.t2=new Thread(s);
			s.t2.start();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	public void run()
	{
		try
		{
			br=new BufferedReader(new InputStreamReader(cs.getInputStream()));
			pw=new PrintWriter(cs.getOutputStream(),true);
			br2=new BufferedReader(new InputStreamReader(cs2.getInputStream()));
			pw2=new PrintWriter(cs2.getOutputStream(),true);
			while(true)
			{
				if(Thread.currentThread()==t)
				{
				
						str=br.readLine();
						System.out.println("Client1:"+str);
						pw2.println(str);
						pw2.flush();
				}
				else
				{
				
						str=br2.readLine();
						System.out.println("Client2:"+str);
						pw.println(str);
						pw.flush();
				}
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}