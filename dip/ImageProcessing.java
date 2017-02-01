import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ImageProcessing implements ActionListener
{
	JFrame frame;
	BufferedImage image=null;
	ImageIcon icon;
	Jlabel label;
	
	ImageProcessing()
	{
			frame=new JFrame("ImageProcessing");
			frame.setSize(400,400);
			image=ImageIO.read(new File(programmer.jpeg));
			icon=new ImageIcon(image);
			label=new Jlabel();
			label.setIcon(icon);
			frame.add(label);
	}
	public static void main(String args[])
	{
		ImageProcessing ip=new ImageProcessing();
		
	}
}