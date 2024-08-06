import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Service extends JFrame implements ActionListener 
{
    
    JLabel l1, l2, l3, l4, l5, l6;
    JButton b1, b2, b3 ,b4;

    Service() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(7000, 1000);
        setTitle("Services");
        setVisible(true);
        setLayout(null);
        Font f1 = new Font("Times New Roman", Font.BOLD, 35);

        ImageIcon img, img2, img3;

        img = new ImageIcon("ig1.jpg");
        img2 = new ImageIcon("ig2.jpg");
        img3 = new ImageIcon("ig3.jpg");

        img.setImage(img.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH));
        img2.setImage(img2.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH));
        img3.setImage(img3.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH));

        l1 = new JLabel(img);
        l2 = new JLabel(img2);
        l3 = new JLabel(img3);
        l4 = new JLabel(" Watchman");
        l5 = new JLabel("Driver");
        l6 = new JLabel("Home Cleaning");
        b1 = new JButton("View");
        b2 = new JButton("View");
        b3 = new JButton("View");
        b4 = new JButton("Exit");

        l1.setBounds(150, 200, 500, 500);
        l2.setBounds(600, 200, 500, 500);
        l3.setBounds(1050, 200, 500, 500);

        l4.setBounds(300, 5, 500, 500);
        l5.setBounds(750, 5, 500, 500);
        l6.setBounds(1200, 5, 500, 500);

        b1.setBounds(300, 680, 200, 50);
        b2.setBounds(750, 680, 200, 50);
        b3.setBounds(1200, 680, 200, 50);
        b4.setBounds(50, 100, 200, 50);

        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);

        b1.setFont(f1);
        b2.setFont(f1);
        b3.setFont(f1);
        b4.setFont(f1);

        add(l1);
        add(l2);
        add(l3);

        add(l4);
        add(l5);
        add(l6);

        add(b1);
        add(b2);
        add(b3);
        add(b4);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) 
        {
           new Watchman();
        } 
        else if (ae.getSource() == b2) 
        {
           new Driver();
        }
         else if (ae.getSource() == b3) 
        {
            new HomeCleaning(); 
        }
        else if (ae.getSource() == b4) 
        {
            new MenuBar(); 
        }
    }

    public static void main(String[] args) {
        new Service();
    }
}
