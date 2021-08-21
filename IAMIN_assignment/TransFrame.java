import javax.swing.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class TransFrame extends JFrame
{
	Container c;
	JLabel lblTrans;
	JTextField txtTrans;
	JButton btnSave, btnBack;
	
	TransFrame()
	{
	c = getContentPane();
    	c.setLayout(null);
    	c.setBackground(Color.pink);

	lblTrans = new JLabel("Enter Savings");
	lblTrans.setBounds(172, 70, 140, 30);
	lblTrans.setFont(new Font("Dialog", Font.BOLD, 16));
    	c.add(lblTrans);

	txtTrans = new JTextField(20);
    	txtTrans.setBounds(70, 100, 300, 22);
    	txtTrans.addKeyListener(new KeyAdapter() 
    	{
        	public void keyTyped(KeyEvent e) 
        {
            char input = e.getKeyChar();
            if((input < '0') && input != '\b') 
            {
                JOptionPane.showMessageDialog(new JDialog(), "Enter Amount");
                e.consume();
            }
        }
    	});
    	c.add(txtTrans);
	
	
    	btnSave = new JButton("Save");
    	btnSave.setBounds(160, 320, 120, 25);
    	c.add(btnSave);

    	btnBack = new JButton("Back");
    	btnBack.setBounds(160, 360, 120, 25);
    	c.add(btnBack);
	
	ActionListener a1 = (ae) -> 
    	{
          Configuration cfg = new Configuration();
          cfg.configure("hibernate.cfg.xml");

          SessionFactory sfact = cfg.buildSessionFactory();
          Session s = null;
          Transaction t = null;
	  try{
 	    s = sfact.openSession();
            t = s.beginTransaction();	
	    Transact t1 = new Transact();

	    int transAmount = Integer.parseInt(txtTrans.getText());
	    
	    
	    if(transAmount < 0)
            {
              JOptionPane.showMessageDialog(new JDialog(), "Enter amount properly");
            }
	    else if(transAmount > 0)
            {
              t1.setGtransAmount(transAmount);
	      s.save(t1);
	      t.commit();
	      JOptionPane.showMessageDialog(new JDialog(),"Record inserted");	
	    }
	    else 
	    {
              JOptionPane.showMessageDialog(new JDialog(),"please insert the proper details"); 
	    }	
 
           }
	   finally
	   {
	     s.close();
	     txtTrans.setText("");
	     txtTrans.requestFocus();
	   }
	};
	btnSave.addActionListener(a1);
	
	
	
	ActionListener a2 = (ae) -> 
    	{
        	MainFrame m = new MainFrame();
        	dispose();
    	};
    	btnBack.addActionListener(a2);
	
	setTitle("Add Saving");
    	setSize(450,500);
    	setLocationRelativeTo(c);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(true);
	
	}	
}
