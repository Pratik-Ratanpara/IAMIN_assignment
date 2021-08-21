
import javax.swing.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;

class ViewFrame extends JFrame 
{
    Container c;
    JTextArea txtarea, txtarea2;
    JButton btnBack;

    ViewFrame()
    {
        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.pink);

        txtarea = new JTextArea();
        txtarea.setBounds(20,20,450,150);
        c.add(txtarea);

	txtarea2 = new JTextArea();
        txtarea2.setBounds(20,200,450,150);
        c.add(txtarea2);

        btnBack = new JButton("Back");
        btnBack.setBounds(190, 360, 120, 25);
        c.add(btnBack);

        StringBuffer sb = new StringBuffer();
//	StringBuffer sbc = new StringBuffer();
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory sfact = cfg.buildSessionFactory();
        Session s = null;  
        Transaction t = null; 

    
        
            s = sfact.openSession();
            t = s.beginTransaction();
            List<Saving> sav = new ArrayList<>();
            sav = s.createQuery("from Saving").list();
            for(Saving sv : sav){
            sb.append("Goal ID: " + sv.getGno() + " => Goal: " + sv.getGname() + " =>  Goal Amount : " + sv.getGamount() +"\n");
	    
	    }
            if(sb.length() == 0)
            {
                txtarea.setText("No data");
            }
	     
             else
            {
                String str = sb.toString();
                txtarea.setText(str);
            }
        
        
        
      	 ActionListener a2 = (ae) -> 
        {
        MainFrame m = new MainFrame();
        dispose();
        };
        btnBack.addActionListener(a2);


    setTitle("View Goals");
    setSize(500,500);
    setLocationRelativeTo(c);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    }
}