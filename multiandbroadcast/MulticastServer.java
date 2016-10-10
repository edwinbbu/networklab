import java.io.*;
import java.net.*;
import java.util.Scanner;
/**
 *
 * @author Edwin Babu
 */
public class MulticastServer {

    public static void main(String[] args) {
        // TODO code application logic here
        DatagramSocket serversocket;
        DatagramPacket packet;
        int port=8888;
        InetAddress addr;
        Scanner obj=new Scanner(System.in);
        try{
            addr=InetAddress.getByName("224.0.0.9");
            serversocket=new DatagramSocket();
            String msg;
            System.out.println("Enter any text to send:");           
            while(true)
            {
                msg=obj.nextLine();
                packet=new DatagramPacket(msg.getBytes(),msg.getBytes().length,addr,port);
                serversocket.send(packet);
                System.out.println("Server: "+ packet);
            }
                
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}