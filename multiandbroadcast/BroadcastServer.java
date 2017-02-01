import java.io.*;
import java.net.*;
import java.util.Scanner;
public class BroadcastServer {

    public static void main(String[] args) {
       
        DatagramSocket serversocket;
        DatagramPacket packet;
        int port=8888;
        InetAddress addr;
        Scanner obj=new Scanner(System.in);
        try{
            addr=InetAddress.getByName("255.255.255.255");
            serversocket=new DatagramSocket();
            String msg;
            System.out.println("Enter any text to send:");           
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
					serversocket.send(packet);
					System.out.println("Server: "+ msg);
				}
                
            }
                
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}