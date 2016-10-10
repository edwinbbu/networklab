import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 
public class ImageConversion implements ActionListener{
	JFrame frame;
	FlowLayout f;
	JLabel label,imageLabel;
	ImageIcon image;
	JButton b;

	public void Gui()
	{
		frame = new JFrame("Image Conversion");
 		frame.setSize(800, 800);
		f= new FlowLayout();
		frame.setLayout(f);
 		label = new JLabel("Internet of Things");
 		image = new ImageIcon("iot.jpg");
 		imageLabel = new JLabel(image);
 		frame.add(imageLabel);
		frame.add(label);
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		frame.setVisible(true);
		b=new JButton("Convert");
		b.addActionListener(this);
		frame.add(b);
		
	}
	public static void main(String[] args) {
	
 		ImageConversion ic=new ImageConversion();
		ic.Gui();
	}
	public void ActionPerformed(ActionEvent e)
	{
		if(e.getSource()==b)
		{
		//	System.out.println();
		}
	}

}