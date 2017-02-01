import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.*;
import java.util.Date;

public class EchoClient extends Thread implements ActionListener 
{
    JFrame frame;
    JButton b;
    JTextArea area;
    JTextField text;
    JScrollPane scroll;
    JLabel label;
    JPanel p1,p2;
    
    Socket clientsocket;
    BufferedReader cin,stdin;
    PrintWriter cout;
    String str;
    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    public void Gui()
    {
        frame=new JFrame("Client Program");
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p1=new JPanel();
        p1.setBounds(0,0,400,300);
        p1.setLayout(new FlowLayout());
        p2=new JPanel();
        p2.setBounds(0,300,400,100);
        p2.setLayout(new FlowLayout());
        frame.add(p1);
        frame.add(p2);
        area=new JTextArea(18,32);
        area.setEditable(false);
        p1.add(area);
        scroll=new JScrollPane(area);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        p1.add(scroll);
        label=new JLabel("Client:");
        p2.add(label);
        text=new JTextField("",20);
        p2.add(text);
        b=new JButton("Submit");
        b.addActionListener(this);
		p2.add(b);
		
		
    }
    public static void main(String[] args)
    {
	EchoClient ec=new EchoClient();
	ec.Gui();
	ec.start();
	}
    public void run()
	{
		try
	{
		System.out.println("Connecting to localhost on port 1000");
		clientsocket=new Socket("localhost",1000);
		System.out.println("Connected to "+clientsocket.getRemoteSocketAddress());
		cin=new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
		cout=new PrintWriter(clientsocket.getOutputStream(),true);	
		while(true)
		{         			                    
			str=cin.readLine();
            area.setText(area.getText()+dateFormat.format(new Date())+" Server: "+str+"\n");
		}
	}
	catch(IOException e)
	{
        	System.out.println(e);
	}
	}
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b)
        {
            str=text.getText();
            cout.println(str);
            area.setText(area.getText()+dateFormat.format(new Date())+" Client: "+str+"\n");
            
        }
		text.setText("");
    }
}