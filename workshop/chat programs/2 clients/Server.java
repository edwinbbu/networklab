//chat between 2 clients through server
// Here server receives all the incoming messages and sends them to the appropriate client
// clients communicate with each other through the server
import java.net.*; //Provides the classes for implementing networking applications eg ServerSocket, Socket.
import java.io.*;  //Provides for system input and output through data streams eg PrintWriter, BufferedReader.
public class Server implements Runnable //The Runnable interface should be implemented by any class whose instances are intended to be executed by a thread.
{
	int portNumber = 3000; //port no to which server listens
	ServerSocket server;   //server socket waits for requests to come in over the network.
	Socket client1,client2; //This class implements client sockets. A socket is an endpoint for communication between two machines.
	Thread t1,t2; //Thread class provide constructors and methods to create and perform operations on a thread.   
	String msg1,msg2; 
    PrintWriter p1,p2; //PrintWriter prints formatted representations of objects to a text-output stream. 

	BufferedReader br1,br2; //BufferedReader class reads text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, arrays, and lines.

	Server()
	{

		try{                                        //server socket class might produce exceptions, So should be put inside try-catch  

			server = new ServerSocket(portNumber); //creating a ServerSocket object that listens to the specified port
			client1 = server.accept();  //accept method of server socket waits for incoming client connections and returns a Socket Object 
			client2 = server.accept();

			br1 = new BufferedReader(new InputStreamReader(client1.getInputStream())); //gets the inputStream from which the data sent by the client1 can be read 
			br2 = new BufferedReader(new InputStreamReader(client2.getInputStream())); ////gets the inputStream from which the data sent by the client1 can be read 

			p1 = new PrintWriter(client1.getOutputStream(),true); //gets the outputStream to which data can be sent to client1.			
			p2 = new PrintWriter(client2.getOutputStream(),true); // gets the outputStream to which data can be sent to client2.
					
		    }
        catch(Exception e)
		{
			System.out.println(e);
		}
	        
    }
        public void run()  //Implementation of the method run of the runnable interface
        {
			    try{		
		
					  if(Thread.currentThread()==t1)  //if currently exceuting thread is the one for client1 
                      {
                         while(true) //repeat in infinite loop
                         {
                           msg1 = br1.readLine(); //read data sent by the client1 
                           System.out.println("\nMessage from client1:"+msg1); //display the data in the server
		                   p2.println("Client1:"+msg1); // send the data to the client2 through its outputstream 
                           p2.flush();  //to sent the data through the network immediately
                         }
                      }
                      else   //if currently excecuting thread is for client 2
		             {
                         while(true)  //repeat in infinite loop
                         {
							msg2 = br2.readLine(); //read data sent by client 2  
							System.out.println("\nMessage from Client2:"+msg2); // display the data in the server
							p1.println("Client2:"+msg2); //send the data to client1 through its outputStream  
                          p1.flush();
                         }
                      }
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
        }
        public static void main(String args[])
        {
              try
              {
             
                  Server serverObj = new Server();          //creat an object for the server class
                  serverObj.t1 = new Thread(serverObj);     //create a thread of serverObject for client1
                  serverObj.t2 = new Thread(serverObj);     // create a thread of serverObject for client2
                  serverObj.t1.start();                     // start thread t1
                  serverObj.t2.start();                     //start thread t2


              }
              catch(Exception e)
              {


              }   
       

        }        
}
  
                      