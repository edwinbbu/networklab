import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client
{
	MulticastSocket cs;
	DatagramPacket packet;
	int port=8888;
	InetAddress addr;
	byte[] buf;
	String msg;
	Client()
	{
		try
		{	
			addr=InetAddress.getByName("224.0.0.3");
			cs=new MulticastSocket(port);
			cs.joinGroup(addr);
			while(true)
			{
				buf=new byte[256];
				packet=new DatagramPacket(buf,buf.length);
				cs.receive(packet);
				msg=new String(buf,0,buf.length);
				System.out.println("Client:"+msg);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void main(String[] args)
	{
		Client c=new Client();
	}
}