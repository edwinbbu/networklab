import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;

public class ImageConversion implements ActionListener
{
	BufferedImage bm;
	JFrame frame;
	JButton b,b2,b3;
	Image m;
	ImageIcon icon;
	JLabel l;
	ImageConversion()
	{
		frame =new JFrame("Image Processing");
		frame.setVisible(true);
		frame.setSize(800,800);
		frame.setLayout(new FlowLayout());
		try
		{
			bm=ImageIO.read(new File("iot.jpg"));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		icon=new ImageIcon(bm);
		l=new JLabel(icon);
		frame.add(l);
		b=new JButton("Grayscale");
		b.addActionListener(this);
		frame.add(b);
		b2=new JButton("Brightness");
		b3=new JButton("Invert");
		
	}
	public static void main(String[] args)
	{
		ImageConversion i=new ImageConversion();
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b)
		{
			GrayScale g=new GrayScale();
			m=frame.createImage(new FilteredImageSource(bm.getSource(),g));
			l.setIcon(new ImageIcon(m));
		}
	}
}
class GrayScale extends RGBImageFilter
{
	public GrayScale()
	{
		canFilterIndexColorModel=true;
	}
	public int filterRGB(int x,int y,int rgb)
	{
		int a=(rgb>>24)&0xff;
		int r=(rgb>>16)&0xff;
		int g=(rgb>>8)&0xff;
		int b=rgb&0xff;
		int avg=(r+g+b)/3;
		rgb=(a<<24)|(avg<<16)|(avg<<8)|avg;
		return rgb;
	}
}