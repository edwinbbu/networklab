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
        String status = ""; 
        PrintWriter p1,p2;//PrintWriter prints formatted representations of objects to a text-output stream. 
        int i;
	BufferedReader br1,br2; //BufferedReader class reads text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, arrays, and lines.
    String op1, op2, oper,data;
	float o1,o2,result;
	
	Server()
	{
		try{
				server = new ServerSocket(portNumber); //creating a ServerSocket object that listens to the specified port

                for(i=0;i<2;i++) //repeats 3 times for 3 client connections
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

                        for(int j=0;j<2;j++)   // reapeat i times for i clients
                        {
                    		
							if(Thread.currentThread()==t[j]) // for jth thread perform the follwing sreps
                      		{
										status = "";
                                        br1 = new BufferedReader(new InputStreamReader(client[j].getInputStream())); // get the input stream of the jth client
										
										data = br1.readLine();
										System.out.println("\nrequest from client "+j+"  "+data); 
										
										if(data.contains("+"))
										{
											String operands[] = data.split("[+]");
											o1 = Float.parseFloat(operands[0]);
											o2 = Float.parseFloat(operands[1]);
											result = o1 + o2;
										}
										else if(data.contains("-"))
										{
											String operands[] = data.split("-");
											o1 = Float.parseFloat(operands[0]);
											o2 = Float.parseFloat(operands[1]);
											result = o1 - o2;
										}
										else if(data.contains("*"))
										{
											String operands[] = data.split("[*]");
											o1 = Float.parseFloat(operands[0]);
											o2 = Float.parseFloat(operands[1]);
											result = o1 * o2;
										}
										else if(data.contains("/"))
										{
											String operands[] = data.split("/");
											o1 = Float.parseFloat(operands[0]);
											o2 = Float.parseFloat(operands[1]);
											result = o1 / o2;
										}
										else
										{
											result = 0;
											status = " Invalid operator";
										}

										// display the data in the server
										System.out.println("   Result:  "+result);
										p1 = new PrintWriter(client[j].getOutputStream(),true);
										p1.println("Response from Server:  result=  "+result);
										p1.flush();
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

				  
                  for(int z=0;z<2;z++) // repeat the steps for the 3 clients
                  {
                      serverObj.t[z] = new Thread(serverObj); //create an instance of serverobj thread for the zth client
                     // serverObj.t[z].setDaemon(true);
					  serverObj.t[z].start();                 // start excecuting the thread for the zth client   
                  }

              }
              catch(Exception e)
              {


              }   
       

        }        
}
  
                      