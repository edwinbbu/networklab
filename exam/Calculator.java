import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Calculator extends Applet implements ActionListener
{
	Button b[]=new Button[10];
	GridLayout g;
	TextField t,t2,t3;
	int a,a2,c,r,i,op=0;
	Button add,sub,div,mul,eq,clear;
	public void init()
	{
		g=new GridLayout(7,3);
		setLayout(g);
		t=new TextField(100);
		add(t);
		t2=new TextField(100);
		add(t2);
		t3=new TextField(100);
		add(t3);
		for(i=0;i<10;i++)
		{
			b[i]=new Button(""+i);
			add(b[i]);
			b[i].addActionListener(this);
		}
		add=new Button("+");
		sub=new Button("-");
		mul=new Button("*");
		div=new Button("/");
		clear=new Button("Clear");
		eq=new Button("=");
		add(add);
		add(sub);
		add(mul);
		add(div);
		add(clear);
		add(eq);
		
		add.addActionListener(this);
		sub.addActionListener(this);
		mul.addActionListener(this);
		div.addActionListener(this);
		clear.addActionListener(this);
		eq.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		for(i=0;i<10;i++)
		{
			if(e.getSource()==b[i])
			{
				t.setText(t.getText()+i);
			}
		}
		if(e.getSource()==add)
		{
			a=Integer.parseInt(t.getText());
			op=1;
			t.setText("");
		}
		if(e.getSource()==sub)
		{
			a=Integer.parseInt(t.getText());
			op=2;
			t.setText("");
		}
		if(e.getSource()==mul)
		{
			a=Integer.parseInt(t.getText());
			op=3;
			t.setText("");
		}
		if(e.getSource()==div)
		{
			a=Integer.parseInt(t.getText());
			op=4;
			t.setText("");
		}
		if(e.getSource()==clear)
		{
			t.setText("");
		}
		if(e.getSource()==eq)
		{
			a2=Integer.parseInt(t.getText());
			switch(op)
			{
				case 1: r=a+a2;
				break;
				case 2: r=a-a2;
				break;
				case 3: r=a*a2;
				break;
				case 4: r=a/a2;
				break;
				default: r=0;
			}
			t.setText(""+r);
		}
		
	}
}
/*
<applet code="Calculator" width=300 height=300>
</applet>
*/