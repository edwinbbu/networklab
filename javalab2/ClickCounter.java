import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class ClickCounter extends Applet implements ActionListener
{
	Button b;
//	Label l;
	TextField t;
	int counter=0;
	public void init()
	{
		b=new Button("Click me");
		add(b);
		b.addActionListener(this);
	//	l=new Label("  0");
		t=new TextField("  0");
		add(t);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b)
		{
			counter++;
			t.setText("  "+counter);
		}
	}
	public void paint(Graphics g)
	{
		//setBackground(Color.gray);
	}
	
}
/*<applet code="ClickCounter.class" width="400" height="400">
</applet>*/