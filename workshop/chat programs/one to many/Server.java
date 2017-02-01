//chat from one client to all the clients
//message sent by a client should be forwarded to all connected clients by the server
import java.net.*; //Provides the classes for implementing networking applications eg ServerSocket, Socket.
import java.io.*;  //Provides for system input and output through data streams eg PrintWriter, BufferedReader.

public class Server implements Runnable //The Runnable interface should be implemented by any class whose instances are intended to be executed by a thread.
{
	int portNumber = 3000; //port no to which server listens
	ServerSocket server;   //server socket waits for requests to come in over the network.
	Socket client[] = new Socket[10]; //This class implements client sockets. A socket is an endpoint for communication between two machines.
	Thread t[] = new Thread[10]; //Thread class provide constructors and methods to create and perform operations on a thread.  
        String msg; 
        PrintWriter p1,p2;//PrintWriter prints formatted representations of objects to a text-output stream. 
        int i;
	BufferedReader br1,br2; //BufferedReader class reads text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, arrays, and lines.

	Server()
	{
		try{
				server = new ServerSocket(portNumber); //creating a ServerSocket object that listens to the specified port

                for(i=0;i<3;i++) //repeats 3 times for 3 client connections
                {                           
                    client[i] = server.accept(); //waits for  client connections
                }
					
		    }
          catch(Exception e)
		 {
			System.out.println(e);
		 }
	        
    }
        public void run() //implement the run method of the runnable interface
        {
               int k=0,l=0;                

		try{			
		    while(true)  //repeat in infinite loop 
                    {

                        for(int j=0;j<i;j++)   // reapeat i times for i clients
                        {
                    		
							if(Thread.currentThread()==t[j]) // for jth thread perform the follwing sreps
                      		{
                         
                                        br1 = new BufferedReader(new InputStreamReader(client[j].getInputStream())); // get the input stream of the jth client
										msg = br1.readLine(); //read the data sent by the jth client, if any
										System.out.println("\nMessage from client "+j+"  "+msg); // display the data in the server
                                        k=j; // save the index of current client                          
                      		}
                        }
                        for(int p=0;p<i;p++)
                        {
                            if(p!=k) // forward the message sent by the kth client to all the remaining clients
                            {
                                   p1 = new PrintWriter(client[p].getOutputStream(),true); //get the output stream of pth client
                                   p1.println("Client"+k+":"+msg); //forward the data sent by the kth client to pth client 
                                   p1.flush();     //flush the data  
                              

                            }
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
                  
                  Server serverObj = new Server(); //create the server object

                  for(int z=0;z<3;z++) // repeat the steps for the 3 clients
                  {
                      serverObj.t[z] = new Thread(serverObj); //create an instance of serverobj thread for the zth client
                      serverObj.t[z].start();                 // start excecuting the thread for the zth client   
                  }

              }
              catch(Exception e)
              {


              }   
       

        }        
}
  
                      