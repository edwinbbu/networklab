import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server
{
	DatagramSocket ss;
	DatagramPacket packet;
	int port=8888;
	InetAddress addr;
	byte[] buf;
	String msg;
	Server()
	{
		try
		{	
			addr=InetAddress.getByName("224.0.0.3");
			ss=new DatagramSocket();
			Scanner obj=new Scanner(System.in);
			while(true)
			{
				msg=obj.nextLine();
				packet=new DatagramPacket(msg.getBytes(),msg.getBytes().length,addr,port);
				ss.send(packet);
				System.out.println("Server:"+msg);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void main(String[] args)
	{
		Server s=new Server();
	}
}