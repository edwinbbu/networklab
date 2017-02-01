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

public class EchoClient extends JFrame implements ActionListener
{
     JButton btn;             //button to send message 

     JTextArea area;         //text area to display message history
 
     JTextField msg;           // text field to type the message
 
     JScrollPane scroll;      // scroll pane to have scroll option on text area 
  
     JLabel heading;         //label to display program name

     //network components

     Socket client;      //socket object for establishing socket connection
     
     PrintWriter out;   //for sending messages to the server through the socket 

     BufferedReader in; //for receicving messages sent by the server

     String output;     //to store data read from server

     String data;      //to store data to be sent to the server 
      

     EchoClient()  //constructor
     {
         setLayout(new FlowLayout());     // setting FlowLayout (components like buttons arranged in a single row) for the frame         

         heading = new JLabel("Echo Client"); //paramter passed to the JLabel constructor indicates the label content          

         btn = new JButton("SEND");       //button used for sending data  parameter passed is the string to be displayed inside the button

         area = new JTextArea(15,30);      // creating a textarea of 15 rows and 30 columns

         msg = new JTextField(15);         //creating a textfield of size 15         

         scroll = new JScrollPane(area);   // adding scroll option to the text area, parameter passed is the textarea object  
    
         btn.addActionListener(this);      // register the JButton object btn with the actionListener  

        //adding the swing components to the frame 
        
         add(heading);      
         add(scroll);
         add(msg);
         add(btn);

         setVisible(true);     //set the visibility of the frame to true

         pack();              //to set the frame size automatically to fit all the components inside it      

         area.setText("");   //initializing the textarea with empty string      
  
        try{
                 //client = new Socket("127.0.0.1",8001);
                 client = new Socket("localhost",8001);      //create the client socket for establishing connection with the server paramter passed is the hostname  of the server and the port to which the socket is listening

                 out = new PrintWriter(client.getOutputStream(),true); //to obtain output stream of socket using PrintWriter class to send data to the server

                 in = new BufferedReader(new InputStreamReader(client.getInputStream()));  // to obtain the input stream of the socket from which data is to read

                 while(true)    //repeat in infinite loop
                 {
			if((output=in.readLine())!=null)     //if buffer is not empty read the content using readLine method to the string variable output
                        {
				area.setText(area.getText()+"\n\tMessage from server:"+output); // set the text area content as the content already exisiting in the text area plus the message received from server
                                 
                        }         
                 }                                                  
  
          } 
          catch(Exception e)
          {
 

          }       
        
     }
     public void actionPerformed(ActionEvent ae)    //actionPerformed is funtion executed upon on the button click event 
     {

                data = msg.getText();               // get the text area content using getText() method and store it in  string variable data      

                out.println(data);                  //send data to the server 
                out.flush();                        //erase the data in out 

                area.setText(area.getText()+"\nClient:"+data); // set the textarea content as the content already existing plus the data being sent
                
                msg.setText("");  // set the text field content as empty    


     }
     public static void main(String args[])
     {
        EchoClient client = new EchoClient();   //create the EchoClient object

     } 
}