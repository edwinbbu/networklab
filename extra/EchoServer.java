import java.awt.*;          /*Package for awt components                                                            
                              subclasses: Button, TextField, TextArea etc 
                            */
                              
import java.awt.event.*;   /*  Package for event handlers
                               subclasses: ActionEvent, ItemEvent etc                                
                           */

import javax.swing.*;      /*  Package for swing components
                               subclasses: JButton, JTextArea, JTextField 
                           */  
                                                    
import java.net.*;         /* Package for networking classes 
                              subclasses: Socket, ServerSocket etc
                           */
 
import java.io.*;          /* Package for input output operations
                              subclasses: PrintWriter, BufferedReader
                           */ 

public class EchoServer extends JFrame
{
     JTextArea area;     //text area to show the message history 

     JScrollPane scroll; // to add scroll option to the text area

     JLabel heading;    //label to display program heading
	 
	 String revOutput;       //to store the reversed string

     //network components
 
     ServerSocket server;  //server socket to establish connection with the client 

     Socket client;        //socket for connecting with client 
	 
	 PrintWriter out;   //for sending messages to the server through the socket 

     BufferedReader in; //for receicving messages sent by the server

     String output;     //to store data read from server

     String data;      //to store data to be sent to the server 


     EchoServer()
     {
         setLayout(new FlowLayout()); //setting FlowLayout (components like buttons arranged in a single row) for the frame          

         heading = new JLabel("Echo Server");   //paramter passed to the JLabel constructor indicates the label content    

         area = new JTextArea(15,30);       // creating a textarea of 15 rows and 30 columns        

         scroll = new JScrollPane(area);    // adding scroll option to the text area, parameter passed is the textarea object   
		 
		 
         //adding the swing components to the frame 
         add(heading);
         add(scroll);

         setVisible(true);  //set the visibility of the frame to true
         pack();            //to set the frame size automatically to fit all the components inside it   

         area.setText("");   //initializing the textarea with empty string   
  
        try{
                 server = new ServerSocket(8001);     //Server Socket listening at port 8001 for client connections
                 client = server.accept();            //establishing socket connection with the client
                 out = new PrintWriter(client.getOutputStream(),true);   //to obtain output stream of socket using PrintWriter class to send data to the client
                 in = new BufferedReader(new InputStreamReader(client.getInputStream()));  // to obtain the input stream of the socket from which data is to read

                 while(true)              //repeat in infinite loop
                 {
			if((output=in.readLine())!=null)    //if buffer is not empty read the content using readLine method to the string variable output
                        {
								area.setText(area.getText()+"\n\tMessage from client:"+output);  // set the text area content as the content already exisiting in the text area plus the message received from client
                                revOutput = new StringBuilder(output).reverse().toString();  //reverse the string using reverse method of string builder class
                             
                                out.println(revOutput);    //send the reversed string to the client
                                out.flush();               //erase the data in out 


                                area.setText(area.getText()+"\nServer:"+revOutput);  // set the textarea content as the content already existing plus the data being sent

                                 
                        }         
                 }                                                  
  
          } 
          catch(Exception e)
          {
 

          }          
        
     }
     public static void main(String args[])
     {
        EchoServer ser = new EchoServer();    //create the EchoClient object

     } 
}