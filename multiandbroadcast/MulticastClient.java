import java.io.*;
import java.net.*;

public class MulticastClient {

   public static void main(String[] args) {
        
        InetAddress addr;
        MulticastSocket clientsocket;
        DatagramPacket packet;
        byte[] buf;
        int port=8888;
        String msg;
        try
        {
            
            addr=InetAddress.getByName("224.0.0.9");
            clientsocket=new MulticastSocket(port);
            clientsocket.joinGroup(addr);
            while(true)
            {
				buf=new byte[256];
                packet=new DatagramPacket(buf,buf.length);
                clientsocket.receive(packet);
                msg=new String(buf,0,buf.length);
                System.out.println("From"+packet.getAddress()+" Received:"+msg);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
