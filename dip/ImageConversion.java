import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
 
public class ImageConversion implements ActionListener {
	JFrame frame;
	FlowLayout f;
	JLabel label,imageLabel;
	ImageIcon m;
	JButton b,b2,b3,b4,b5;
	BufferedImage image;
	Image img;
	public void Gui()
	{
		frame = new JFrame("Image Conversion");
 		frame.setSize(800, 700);
		f= new FlowLayout();
		frame.setLayout(f);
 		label = new JLabel("Internet of Things");
		try
		{
			image=ImageIO.read(new File("iot.jpg"));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		m = new ImageIcon(image);
 		imageLabel = new JLabel(m);
 		frame.add(imageLabel);
		frame.add(label);
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		frame.setVisible(true);
		b=new JButton("GrayScale");
		b.addActionListener(this);
		frame.add(b);
		b2=new JButton("Brightness");
		b2.addActionListener(this);
		frame.add(b2);
		b3=new JButton("Contrast");
		b3.addActionListener(this);
		frame.add(b3);
		b4=new JButton("Invert");
		b4.addActionListener(this);
		frame.add(b4);
		b5=new JButton("Restore");
		b5.addActionListener(this);
		frame.add(b5);
		
	}
	public static void main(String[] args) {
	
 		ImageConversion ic=new ImageConversion();
		ic.Gui();
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b)
		{
			GImageFilter gfilter = new GImageFilter();
			img = frame.createImage(new FilteredImageSource(image.getSource(),gfilter));
			imageLabel.setIcon(new ImageIcon(img));
		}
		if(e.getSource()==b2)
		{
			img = frame.createImage(new FilteredImageSource(img.getSource(),new BImageFilter(1)));
			imageLabel.setIcon(new ImageIcon(img));
		}
		if(e.getSource()==b3)
		{
			img = frame.createImage(new FilteredImageSource(img.getSource(),new CImageFilter(2)));
			imageLabel.setIcon(new ImageIcon(img));		
		}
		if(e.getSource()==b4)
		{
			IImageFilter ifilter = new IImageFilter();
			img = frame.createImage(new FilteredImageSource(image.getSource(),ifilter));
			imageLabel.setIcon(new ImageIcon(img));				
		}
		if(e.getSource()==b5)
		{
			imageLabel.setIcon(new ImageIcon(image));
			img=(Image)image;
		}
	}
	
}
class GImageFilter extends RGBImageFilter{
		 public GImageFilter() {
              canFilterIndexColorModel = true;
          }

          public int filterRGB(int x, int y, int rgb) {
			int a = (rgb>>24)&0xff;
			int r = (rgb>>16)&0xff;
			int g = (rgb>>8)&0xff;
			int b = rgb&0xff;
			int avg = (r+g+b)/3;
			rgb = (a<<24) | (avg<<16) | (avg<<8) | avg;
              return rgb;
          }
	}
class BImageFilter extends RGBImageFilter{
		 int factor=50;
		 public BImageFilter(int i) {
              canFilterIndexColorModel = true;
				factor=factor*i;
          }

          public int filterRGB(int x, int y, int rgb) {
			int a = (rgb>>24)&0xff;
			int r = (rgb>>16)&0xff;
			int g = (rgb>>8)&0xff;
			int b = rgb&0xff;
			r=r+factor;
			g=g+factor;
			b=b+factor;
			if(r>255) r=255;
			if(g>255) g=255;
			if(b>255) b=255;
			if(r<0) r=0;
			if(g<0) g=0;
			if(b<0) b=0;
			rgb = (a<<24) | (r<<16) | (g<<8) | b;
              return rgb;
          }
	}
class IImageFilter extends RGBImageFilter{
		 public IImageFilter() {
              canFilterIndexColorModel = true;
          }

          public int filterRGB(int x, int y, int rgb) {
			int a = (rgb>>24)&0xff;
			int r = (rgb>>16)&0xff;
			int g = (rgb>>8)&0xff;
			int b = rgb&0xff;
			r=255-r;
			g=255-g;
			b=255-b;
			
			rgb = (a<<24) | (r<<16) | (g<<8) | b;
              return rgb;
          }
	}
class CImageFilter extends RGBImageFilter{
		 double factor;
		 public CImageFilter(double i) {
              canFilterIndexColorModel = true;
				factor=i;
          }

          public int filterRGB(int x, int y, int rgb) {
			int a = (rgb>>24)&0xff;
			int r = (rgb>>16)&0xff;
			int g = (rgb>>8)&0xff;
			int b = rgb&0xff;
			double rr=r*factor;
			double gg=g*factor;
			double bb=b*factor;
			r=(int)rr;
			g=(int)gg;
			b=(int)bb;
			if(r>255) r=255;
			if(g>255) g=255;
			if(b>255) b=255;
			if(r<0) r=0;
			if(g<0) g=0;
			if(b<0) b=0;
			rgb = (a<<24) | (r<<16) | (g<<8) | b;
              return rgb;
          }
	}