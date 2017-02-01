import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server2
{
	public static void main(String args[])
	{
		DatagramSocket ss;
		DatagramPacket packet;
		int port=8888;
		InetAddress addr;
		String msg;
		Scanner obj=new Scanner(System.in);
		try
		{
			addr=InetAddress.getByName("224.0.0.3");
			ss=new DatagramSocket();
			System.out.println("Enter any text:");
			while(true)
			{
				msg=obj.nextLine();
				if(msg.equals("quit"))
				{
					break;
				}
				else
				{
					packet=new DatagramPacket(msg.getBytes(),msg.getBytes().length,addr,port);
					ss.send(packet);
					System.out.println("Server:"+msg);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}