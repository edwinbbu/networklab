import javax.swing.*;// for swing components like JButton, JTextField etc
import java.awt.*; // for awt components like Button, Label etc
import java.awt.event.*; //Provides interfaces and classes for dealing with different types of events fired by AWT components.
import java.net.*;//Provides for system input and output through data streams eg PrintWriter, BufferedReader.
import java.io.*; //Provides the classes for implementing networking applications eg ServerSocket, Socket.

public class Client1 implements ActionListener //The listener interface for receiving action events. The class that is interested in processing an action event implements this interface, and the object created with that class is registered with a component, using the component's addActionListener method.
{

	JTextField mssg; //Text field for typing the message 
	JButton send;   //button for sending the message
	JTextArea area; //text area to display chat history 
	JFrame frame;   // frame to hold the swing components
        JScrollPane scroll; // to add scroll option to the text area
        String data;  //to hold the data contained in the textfield

	PrintWriter out;  //PrintWriter prints formatted representations of objects to a text-output stream.
	String hostName = "127.0.0.1"; //ip address for localhost 
	int portNumber = 3000; // port to which the client is connected
	String output;   
	String inputLine;
    Socket socket;     ///This class implements client sockets. A socket is an endpoint for communication between two machines.
	BufferedReader in,stdIn; //BufferedReader class reads text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, arrays, and lines.

	Client1()
	{

		frame = new JFrame();
   		frame.setLayout(new FlowLayout()); // set the  desired layout for the frame  
		
		mssg = new JTextField(15); //create textfield of size 15
		send = new JButton("SEND"); // create send button
		area = new JTextArea(15,30); // create text area of 15 rows and 30 columns 
        scroll = new JScrollPane(area); // add scroll option to the text area    

		send.addActionListener(this); // register the button with the ActionListener		

		frame.add(mssg);  // add the gui components to the frame
		frame.add(send);
		frame.add(scroll);

		frame.setVisible(true); // set the visiblity of the frame to true
		frame.pack(); //The pack method sizes the frame so that all its contents are at or above their preferred sizes

		
			try{
				socket = new Socket(hostName,portNumber); // request for a socket connection to the specified host and port no
				out = new PrintWriter(socket.getOutputStream(),true); // get the output stream to which data is to be sent
				in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // get the input stream through which data is to be recevied
		

					while(true)
					{
						if((output = in.readLine())!=null)  // buffer is not empty 
						{
							area.setText(area.getText()+"\n\n\t"+output); // add the data received to the text area
						}	     					
					
					}	
			   }
			catch(Exception e)
			{
				System.out.println(e);
			} 

	
	}	 
	public void actionPerformed(ActionEvent ae) //action to performed when the button is clicked
        {
		  data = mssg.getText();   // get the content of text field
		  area.setText(area.getText()+"\n"+data); // add the content to the text area
		  mssg.setText(""); // clear the text field

		  out.println(data); //send the data throught the outputStream to the server
		
        }
	public static void main(String args[])
	{
		Client1 c1 = new Client1();
	}
}

	 