import java.net.*; // used for ServerSocket, Socket 
import java.awt.*; // GUI
import java.awt.event.*; // Event handling - ActionListener
import javax.swing.*; // Swing GUI components
import java.io.*; // IO Streams - BufferedReader,InputStreamReader, PrintWriter
import java.util.*; // Date 
import java.text.*; // DateFormat, SimpleDateFormat
/*
The class extends thread and overrides the run() method.
It also implements the ActionListener to handle Button events
*/
class Client extends Thread implements ActionListener{
	
	/* NOTE :These Variables are declared as instance variable as actionPerformed() needs to access it */
	
	JTextArea ta; 		// A multi-line user editable text input
	JTextField tf; 		// A single line user editable text input
	PrintWriter out; 	// used for output stream 
	JButton b1;	     	// Button for ACK
	
	boolean ack=false; // Whether ACK was sent
	boolean ready=false; // Whether READY was received

	//Date formatter - Used to convert an object of Class Date to String in the specifed format
	//DateFormat dFormat=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss ");   // Date and Time
	DateFormat dFormat=new SimpleDateFormat("hh:mm:ss "); 				// Time only

	// Constructor for the class initializes the GUI Components
	Client()
	{
		JFrame f=new JFrame("Client"); 		// JFrame - Used to make window based GUI - Client id the Title of Window
		f.setSize(300,300);					// Set the initial size of Frame	
		
		/*Setting the Layout of the Frame
		Box Layout is used to set a Linear layout 
			- Horizontal : Align all components in a line horizontally, Parameter BoxLayout.X_AXIS
			- Vertical : Align all components in a line vertically, Parameter BoxLayout.Y_AXIS
		
		Constructor format : BoxLayout(Panel,Orientation)
		*/
		f.setLayout(new BoxLayout(f.getContentPane(),BoxLayout.Y_AXIS));	
		
		ta=new JTextArea(20,30); 	// JTextArea(int rows,int cols) Sets initial no of rows and columns
		ta.setEditable(false); 		// Make the TextArea not editable by user
		
		/* Adding Scroll bar to a component
			-The component is given as parameter to the Constructor
			-The Scroll Pane is added to the frame
		*/
		JScrollPane scroll= new JScrollPane(ta);	// TextArea passed to ScrollPane
		f.add(scroll);								// Add the ScrollPane to Frame
		
		
		tf=new JTextField(20); // Text Field of size 20 
		f.add(tf);				 // Add the TextField to Frame
		
		JButton b= new JButton("Send"); // Declare Buttons for Send and ACK
		b1= new JButton("ACK");
		
		//Inorder to handle the Button click event - An ActionListener must be added to the button
		b.addActionListener(this); // This class itself implements the actionListener 
		b1.addActionListener(this);// "this" refers to the current object.ie Passing object of the current class as parameter
	
		//Adding Buttons to the Frame
		f.add(b);
		f.add(b1);
		
		//Action to perform on pressing the Close Button "X"
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // EXIT_ON_CLOSE closes the window 
		
		//Make the Frame Visible to User 
		f.setVisible(true); // NOTE : Nothing will be displayed unless this statement is executed !!
		
	}
	
	/*The run() method for Thread
	This method is called when the start() method is called/
	*/
	public void run()
	{
		String temp;
		try{
			/* Socket is used to establish Connection to the Server
			Constructor used : Socket(String host,int port);
				host is either the IP address or the hostname of the server - Here localhost (or the computer itself is the server)
				port is the port number to which the Server is listening to accept connections
			*/
			Socket s=new Socket("localhost",9876);
			
			/* Inorder to transfer data to and from the server, streams are used
				The getInputStream() and getOutputStream() methods of Socket class are used to retreive them
			*/
			//An InputStreamReader object is constructed from the getInputStream() method and passed to BufferedReader
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		

			/*PrintWriter is used as the output stream
				constructor used : PrintWriter(Stream,Boolean autoFlush)
				autoFlush is used to flush the buffer once a print operation is performed
					
				NOTE: It is important to mention the autoflush parameter, otherwise no data will be send unless flush() method is manually called !
			*/
			out= new PrintWriter(s.getOutputStream(),true);
			
			temp=in.readLine(); // read a line from the input stream
			
			while(!temp.equals("READY")){	 // Until a "READY" Command is received print error
				ta.setText(ta.getText()+"\nError - READY not Received ");
				temp=in.readLine();
			}
			// The "READY" Command was received, set flag to true
			ready=true;
			
			//Update the TextArea
			ta.setText(ta.getText()+"\nREADY Received ! Connection Initiated !");
			
			temp=in.readLine();
			while(!ack){  // Until a ACK Command is sent print error - check the ack flag
				ta.setText(ta.getText()+"\nError - ACK Not Sent");
				temp=in.readLine();
			}
			
			//ACK SENT - Start Communication
			
			while(true){ // execute indefintely
			
				/* format() method is used to convert Date object to String */
				ta.setText(ta.getText()+"\n"+dFormat.format(new Date())+"RCVD : "+temp); // display the line on the text area with current time
				temp=in.readLine(); // read a line from input stream
			}
		}
		catch(Exception e){  // Catches All Exceptions
			e.printStackTrace(); // Prints the cause of the Exception
		}
	}
	
	public static void main(String args[]) // The main method- Entry point of JVM
	{
		Client c =new Client(); // instantiate object of the Client Class (Constructor will be called)
		c.start();				 // Start the Thread ( call the run() method)
	}
	
	/* Event handler for the Buttons;
		Handles the click event on Buttons
		ActionEvent describes the Event happend
	*/
	public void actionPerformed(ActionEvent ae)
	{
		switch(ae.getActionCommand()) 
		{
			//If the button Pressed is Send
			case "Send" :out.println(tf.getText()); // Send the contents in the text field to output stream
						ta.setText(ta.getText()+"\n"+dFormat.format(new Date())+"SENT : "+tf.getText()); // Update the Text Area
						tf.setText(""); // Clear the Text field
						break;
			
			//If the Button Pressed is ACK
			case "ACK": out.println("ACK"); // Send "ACK" message to the Server
						if(ready) { // Disable the ACK Button only if the READY Message was received
							b1.setEnabled(false); // Disable the ACK button
							ack=true; // Set ACK sent flag to true
						}
					break;
		}
		
		
	}
}