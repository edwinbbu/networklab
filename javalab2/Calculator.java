import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Calculator extends Applet implements ActionListener
{
	double a=0,b=0,result=0;
	static int op=0;
	TextField t;
	int i;
	GridLayout g;
	Button bt[]=new Button[10];
	Button add,sub,mul,div,clear,eq;
	public void init()
	{
		t=new TextField(100);
		g=new GridLayout(6,6);
		setLayout(g);
		for(i=0;i<10;i++)
		{
			bt[i]=new Button(""+i);
			
		}
		
		add=new Button("+");
		sub=new Button("-");
		div=new Button("/");
		mul=new Button("*");
		clear=new Button("CLEAR");
		eq=new Button("=");
		add(t);
		t.addActionListener(this);
		for(i=0;i<10;i++)
		{
			add(bt[i]);
		}
		add(add);
		add(sub);
		add(mul);
		add(div);
		add(clear);
		add(eq);
		
		for(i=0;i<10;i++)
		{
			bt[i].addActionListener(this);
		}
		
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
			if(e.getSource()==bt[i])
			{
				t.setText(t.getText().concat(""+i));
			}
		}
		if(e.getSource()==add)
		{
			a=Double.parseDouble(t.getText());
			op=1;
			t.setText("");
		}
		if(e.getSource()==sub)
		{
			a=Double.parseDouble(t.getText());
			op=2;
			t.setText("");
		}
		if(e.getSource()==mul)
		{
			a=Double.parseDouble(t.getText());
			op=3;
			t.setText("");
		}
		if(e.getSource()==div)
		{
			a=Double.parseDouble(t.getText());
			op=4;
			t.setText("");
		}
		if(e.getSource()==eq)
		{
			b=Double.parseDouble(t.getText());
			switch(op)
			{
				case 1: result=a+b;
					break;
				case 2: result=a-b;
					break;
				case 3: result=a*b;
					break;
				case 4: result=a/b;
					break;
				default: result=0;
			}
			t.setText(""+result);
		}
		if(e.getSource()==clear)
		{
			t.setText("");
		}
		
	}
	
}

/* 
<applet code="Calculator" width=300 height=300>
</applet>
*/