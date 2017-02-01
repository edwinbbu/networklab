import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Cl implements Runnable,ActionListener
{
	JFrame frame;
	JPanel p1,p2;
	JButton b;
	JTextArea area;
	JTextField f;
	Thread t;
	JLabel l;
	//ServerSocket ss;
	Socket cs;
	BufferedReader br;
	PrintWriter pw;
	String msg,str;
	Cl()
	{
		frame=new JFrame("Client");
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p1=new JPanel(new FlowLayout());
		p1.setBounds(0,0,400,400);
		frame.add(p1);
		
		p2=new JPanel(new FlowLayout());
		p2.setBounds(0,400,400,100);
		frame.add(p2);
		
		area=new JTextArea(18,32);
		area.setEditable(false);
		p1.add(area);
		
		l=new JLabel("Message:");
		p2.add(l);
		f=new JTextField("",20);
		p2.add(f);
		b=new JButton("Send");
		p2.add(b);
		b.addActionListener(this);
		
		
	}
	public static void main(String[] args)
	{
		Cl c= new Cl();
		c.t= new Thread(c);
		c.t.start();
		
	}
	public void run()
	{
		
		try
		{
			cs=new Socket("localhost",3000);
			br=new BufferedReader(new InputStreamReader(cs.getInputStream()));
			pw=new PrintWriter(cs.getOutputStream(),true);
			while(true)
			{
				str=br.readLine();
				area.setText(area.getText()+"\nServer:"+str);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		msg=f.getText();
		pw.println(msg);
		area.setText(area.getText()+"\nClient:"+msg);
		pw.flush();
		f.setText("");
	}
} 