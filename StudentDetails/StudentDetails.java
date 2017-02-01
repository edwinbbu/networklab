import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class StudentDetails implements ActionListener {

    JFrame frame;
	JPanel p1,p2;
    JButton b;
    JLabel name,no,branch,year,m1,m2,m3,result;
    JTextField tname,tno,tyear,tm1,tm2,tm3;
    JRadioButton tbranch,cs,it,ec,ee,me,cv;
    JButton submit;
    String[] str={"2013","2014","2015","2016","2017"};
    JComboBox y;
	ButtonGroup g;
    JLabel nam,n,br,yea,mk;
    StudentDetails()
    {
        frame=new JFrame("Student Details");
        frame.setSize(600,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        name=new JLabel("Student name:");
        name.setBounds(20, 20, 100, 10);
        frame.add(name);
        tname=new JTextField("");
        tname.setBounds(140, 15, 100, 20);
        frame.add(tname);
        no=new JLabel("Roll No:");
        no.setBounds(20,50,100,20);
        frame.add(no);
        tno=new JTextField("");
        tno.setBounds(140,45,60,20);
        frame.add(tno);
        branch=new JLabel("Enter your branch:");
        branch.setBounds(20,80,150,20);
        frame.add(branch);
        cs=new JRadioButton("CS");
        cs.setBounds(40, 100, 50, 20);
        it=new JRadioButton("IT");
        it.setBounds(120, 100, 50, 20);
        ec=new JRadioButton("EC");
        ec.setBounds(40, 130, 50, 20);
        ee=new JRadioButton("EE");
        ee.setBounds(120, 130, 50, 20);
        me=new JRadioButton("ME");
        me.setBounds(40, 160, 50, 20);
        cv=new JRadioButton("CE");
        cv.setBounds(120, 160, 50, 20);
        g=new ButtonGroup();
        g.add(cs);
        g.add(it);
        g.add(ec);
        g.add(ee);
        g.add(me);
        g.add(cv);
        frame.add(cs);
        frame.add(it);
        frame.add(ec);
        frame.add(ee);
        frame.add(me);
        frame.add(cv);
        year=new JLabel("Enter the year:");
        year.setBounds(20,190,100,20);
        frame.add(year);
        y=new JComboBox(str);
        y.setBounds(140,185,100,20);
        frame.add(y);
        m1=new JLabel("Enter the marks1:");
        m1.setBounds(20,220,120,20);
        frame.add(m1);
        tm1=new JTextField("");
        tm1.setBounds(140, 215, 80, 20);
        frame.add(tm1);
		m2=new JLabel("Enter the marks2:");
        m2.setBounds(20,250,120,20);
        frame.add(m2);
        tm2=new JTextField("");
        tm2.setBounds(140, 245, 80, 20);
        frame.add(tm2);
		m3=new JLabel("Enter the marks3:");
        m3.setBounds(20,280,120,20);
        frame.add(m3);
        tm3=new JTextField("");
        tm3.setBounds(140, 275, 80, 20);
        frame.add(tm3);
        b=new JButton("Submit");
        b.setBounds(40,350,100,30);
        frame.add(b);
        
        b.addActionListener(this);
        tname.addActionListener(this);
        tno.addActionListener(this);
        tm1.addActionListener(this);
        y.addActionListener(this);
        
        result=new JLabel("");
        result.setBounds(400,20,100,20);
        frame.add(result);
        
        nam=new JLabel("");
        nam.setBounds(300,40,200,20);
        frame.add(nam);
        
        n=new JLabel("");
        n.setBounds(300,60,200,20);
        frame.add(n);
        
        
        yea=new JLabel("");
        yea.setBounds(300,80,200,20);
        frame.add(yea);
        
		br=new JLabel("");
		br.setBounds(300,120,200,20);
		frame.add(br);
		
		mk=new JLabel("");
        mk.setBounds(300,100,200,20);
        frame.add(mk);
    }
   
    public static void main(String[] args) {
       
        SwingUtilities.invokeLater(new Runnable() {    
           public void run() {
             new StudentDetails();
          }
      });
       
    }

   
    public void actionPerformed(ActionEvent e) {
		
        if(e.getSource()==b)
        {
			String branch=new String();
			int ag,mark1=0,mark2=0,mark3=0;
			mark1=Integer.parseInt(tm1.getText());
			mark2=Integer.parseInt(tm2.getText());
			mark3=Integer.parseInt(tm3.getText());
			ag=(mark1+mark2+mark3);
            result.setText("Details"); 
            nam.setText("Student name: "+tname.getText());
            n.setText("Roll no: "+tno.getText());
            yea.setText("Year: "+y.getSelectedItem().toString());
            mk.setText("Total mark: "+ag);
			if(cs.isSelected())
			{
				branch="CS";
			}
			else if(it.isSelected())
			{
				branch="IT";
			}
			else if(ec.isSelected())
			{
				branch="EC";
			}
			else if(ee.isSelected())
			{
				branch="EE";
			}
			else if(me.isSelected())
			{
				branch="ME";
			}
			else if(cv.isSelected())
			{
				branch="CE";
			}
			
			br.setText("Branch: "+branch);
        }
    }
    
}
