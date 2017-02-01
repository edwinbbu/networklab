import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;

public class Window implements ActionListener
{
	JFrame frame;
	JPanel p1,p2,p3;
	JTextArea area;
	JButton b1,b2;
	JScrollPane scroll;
	JLabel l1,l2,l3;
	JTextField f1,f2,f3;
	String str;
	Window()
	{
		frame= new JFrame("Sliding Window");
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p1=new JPanel();
		p1.setBounds(0,0,400,300);
		p1.setLayout(new FlowLayout());
		p2=new JPanel();
		p2.setBounds(0,300,400,100);
		p2.setLayout(new FlowLayout());
		p3=new JPanel();
		p3.setBounds(0,400,400,100);
		p3.setLayout(new FlowLayout());
		frame.add(p1);
		frame.add(p2);
		frame.add(p3);
		area=new JTextArea(18,32);
		area.setEditable(false);
		p1.add(area);
		l1=new JLabel("Message");
		p2.add(l1);
		f1=new JTextField("",20);
		p2.add(f1);
		b1=new JButton("Send");
		b1.addActionListener(this);
		p2.add(b1);
		l2=new JLabel("Recieved");
		p3.add(l2);
		f2=new JTextField("",20);
		p3.add(f2);
		b2=new JButton("ACK");
		b2.addActionListener(this);
		p3.add(b2);
	}
	public static void main(String[] args)
	{
		Window w=new Window();
	}
	
	int len;
	int awk=0;
	int i=0,j=0,sw=3,index=0;
	char c;
	String data;
	String ch=new String();
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			str=f1.getText();
			len=str.length();					
		}
		if(awk<len)
		{
			ch+=str.charAt(awk);
			awk++;
		}
		f2.setText(""+ch);
		if(e.getSource()==b2)
		{
			data=new String();
			while(i<sw)
			{
				data+=str.charAt(i);
				i++;
			}
			if(sw<len)
			{
				sw++;
			}
			j++;
			i=j;
			c=str.charAt(index);
			index++;
			area.setText(area.getText()+"\n"+"Sliding Window:"+data+"\nFrame:"+c+" Acknowledged");
		}
		
	}
}