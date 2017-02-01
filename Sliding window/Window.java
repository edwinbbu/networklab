import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;

public class Window implements ActionListener 
{
    JFrame frame;
    JButton b,b2;
    JTextArea area;
    JTextField text,text2;
    JScrollPane scroll;
    JLabel label,label2;
    JPanel p1,p2,p3;  
    String str;
	
    public void Gui()
    {
        frame=new JFrame("Sliding Window");
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
        scroll=new JScrollPane(area);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        p1.add(scroll);
        label=new JLabel("Message:");
        p2.add(label);
        text=new JTextField("",20);
        p2.add(text);
        b=new JButton("Submit");
        b.addActionListener(this);
		p2.add(b);
		label2=new JLabel("Recieved:");
		p3.add(label2);
		text2=new JTextField("",20);
		p3.add(text2);
		b2=new JButton("ACK");
		b2.addActionListener(this);
		p3.add(b2);
		
    }
    public static void main(String[] args)
    {
	Window ec=new Window();
	ec.Gui();
	}
   
	int awk=0,i,j;
	int sw=3;
	int index=0;
	char c;
	String ch=new String();
	String data;
	int len;
    public void actionPerformed(ActionEvent e)
    {
		
		
        if(e.getSource()==b)
        {	
			str=text.getText();
			len=str.length();
		}
		if(awk<len)
		{
		ch+=str.charAt(awk);
				awk++;
		}
				
		text2.setText(""+ch);
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
			area.setText(area.getText()+"\n"+"Sliding Window:"+data+"\n"+"Frame:"+c+" Acknowledged");
		}
    }
}
