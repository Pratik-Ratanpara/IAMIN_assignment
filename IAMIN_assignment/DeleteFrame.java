import javax.swing.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class DeleteFrame extends JFrame
{
	Container c;
	JLabel lblGno;
	JTextField txtGno;
	JButton btnSave, btnBack;
	
	DeleteFrame()
	{
	  c = getContentPane();
          c.setLayout(null);
          c.setBackground(Color.pink);
	
	  lblGno = new JLabel("Enter rno:");
          lblGno.setBounds(185, 10, 140, 30);
          c.add(lblGno);
	
	  txtGno = new JTextField(20);
          txtGno.setBounds(70, 40, 300, 22);
          txtGno.addKeyListener(new KeyAdapter() 
          {
            public void keyTyped(KeyEvent e) 
            {
                char input = e.getKeyChar();
                if((input < '0') && input != '\b') 
                {
                    JOptionPane.showMessageDialog(new JDialog(),"Enter goal id to delete");
                    e.consume();
                }
            }
          });
	  c.add(txtGno);

	  btnSave = new JButton("Save");
          btnSave.setBounds(160,90,120,25);
          c.add(btnSave);

	  btnBack = new JButton("Back");
          btnBack.setBounds(160,130,120,25);
          c.add(btnBack);


          ActionListener a1 = (ae) -> 
          {
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");

            SessionFactory sfact = cfg.buildSessionFactory();
            Session s = null;
            Transaction t = null;
        
            try
            {
                s = sfact.openSession();
                t = s.beginTransaction();
            
                int Gno = Integer.parseInt(txtGno.getText());
                Saving sav = (Saving)s.get(Saving.class, Gno);
                if(sav != null)
                {
                    
                    s.delete(sav);
                    t.commit();
                    JOptionPane.showMessageDialog(new JDialog(),"Record Deleted");
                }
                else
                {
                JOptionPane.showMessageDialog(new JDialog(),"Records doesn't exists");
                }
            }
            catch(Exception e)
            {
            JOptionPane.showMessageDialog(new JDialog(),"Please Provide some input");
            
            t.rollback();
            }
            finally
            {
                s.close();
                txtGno.setText("");
                txtGno.requestFocus();
            }
         };
         btnSave.addActionListener(a1);


	 ActionListener a2 = (ae) -> 
          {
            MainFrame m = new MainFrame();
            dispose();
          };
          btnBack.addActionListener(a2);
 

          setTitle("Delete Goal");
          setSize(450,500);
          setLocationRelativeTo(c);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setVisible(true);

	}
}




































































