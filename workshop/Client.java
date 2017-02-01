import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client
{
	public static void main(String[] args)
	{
		MulticastSocket cs;
		DatagramPacket packet;
		InetAddress addr;
		byte[] buf;
		int port=8888;
		String msg;
		try
		{
			cs=new MulticastSocket(port);
			while(true)
			{
				buf=new byte[256];
				packet=new DatagramPacket(buf,buf.length);
				cs.receive(packet);
				msg=new String(buf,0,buf.length);
				System.out.println("From:"+packet.getAddress()+"\tRecieved:"+msg);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}