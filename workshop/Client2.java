import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client2
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
			addr=InetAddress.getByName("224.0.0.3");
			cs=new MulticastSocket(port);
			cs.joinGroup(addr);
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