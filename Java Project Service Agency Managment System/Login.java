import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class Login extends JFrame implements ActionListener 
{
    JLabel l1, l2 ,l3;
    JTextField t1;
    JPasswordField p1;
    JButton b1, b2;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    Login() 
    {
        setVisible(true);
        setSize(7000, 1000);
        setTitle("Login");
        setLayout(null);      

        Font f = new Font("Arial", Font.BOLD, 30);

        l1 = new JLabel("UserName");
        l1.setFont(f);
        l2 = new JLabel("Password");
        l2.setFont(f);
        l3 = new JLabel("Admin Login");
        l3.setFont(f);
        

        t1 = new JTextField(20);
        t1.setFont(f);
        p1 = new JPasswordField(20);
        p1.setFont(f);

        b1 = new JButton("Login");
        b2 = new JButton("Reset");
        b1.setFont(f);
        b2.setFont(f);

        b1.addActionListener(this);
        b2.addActionListener(this);


        l3.setBounds(770, 200, 200, 40);
        l1.setBounds(700, 350, 150, 40);
        t1.setBounds(870, 350, 200, 40);
        l2.setBounds(700, 400, 150, 40);
        p1.setBounds(870, 400, 200, 40);

        b1.setBounds(730, 470, 150, 50);
        b2.setBounds(900, 470, 150, 50);
   
        add(l3);
        add(l1);
        add(t1);
        add(l2);
        add(p1);
        add(b1);
        add(b2);
        try {
             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
             con=DriverManager.getConnection("jdbc:odbc:ShivJavaDSN");
            } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }


    

    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource() == b2) 
        {
            t1.setText("");
            p1.setText("");
        } 
         if (ae.getSource() == b1) 
         {
            String un = t1.getText().trim();
            String pss = new String(p1.getPassword()).trim();

            try {
                ps = con.prepareStatement("SELECT * FROM Login WHERE UserId=? AND Password=?");
                ps.setString(1, un);
                ps.setString(2, pss);
                
                rs = ps.executeQuery();
                if(un.isEmpty())
                {
                   JOptionPane.showMessageDialog(null,"Please Enter User Name");
                }
                else if(pss.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Please Enter Password");
                }
                else 
                if (rs.next()) 
                {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    new MenuBar();
                }
                 else 
                {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                }

            } 
        
        
        catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
    }
    

    public static void main(String args[]) 
    {
        new Login();
    }
}