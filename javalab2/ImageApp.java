import java.awt.*;
import java.applet.*;

public class ImageApp extends Applet
{
	Image picture;
	public void init()
	{
		picture=getImage(getDocumentBase(),"img.png");
	}
	public void paint(Graphics g)
	{
		g.drawImage(picture,0,0,this);
		g.drawString("Java Programming",50,220);
	}
}
/*<applet code="ImageApp.class" width="250" height="250">
</applet>*/
