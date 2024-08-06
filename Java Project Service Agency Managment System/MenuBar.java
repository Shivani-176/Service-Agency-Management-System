import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuBar extends JFrame implements ActionListener 
{
    JMenuBar mb;
    JMenu home, form, report;
    JMenuItem customer, employee, service , chreport;

    Font f1 = new Font("Times New Roman", Font.BOLD, 30);

    MenuBar() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(7000, 1000);
        setTitle("Menu");
        setVisible(true);
        setLayout(new BorderLayout()); 

        home = new JMenu(" Home   ");
        form = new JMenu(" Forms   ");
        report = new JMenu(" Report   ");

        customer = new JMenuItem(" Customer   ");
        employee = new JMenuItem(" Employee   ");
        service = new JMenuItem(" Services   ");
        chreport = new JMenuItem( " Check Reports   ");
        

        home.setFont(f1);
        customer.setFont(f1);
        employee.setFont(f1);
        service.setFont(f1);
        report.setFont(f1);
        chreport.setFont(f1);
        form.setFont(f1);

        form.add(customer);
        form.add(employee);
        form.add(service);

        report.add(chreport);

        mb = new JMenuBar();
        mb.add(home);
        mb.add(form);
        mb.add(report);
       
        mb.setFont(f1);

        customer.addActionListener(this);
        employee.addActionListener(this);
        service.addActionListener(this);

        setJMenuBar(mb);

        ImageIcon img = new ImageIcon("img2.jpg");
        int frameWidth = getWidth();  
        int frameHeight = getHeight();
        int newWidth = frameWidth - 50;
        int newHeight = frameHeight - 100; 
        Image scaledImage = img.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        img = new ImageIcon(scaledImage);

        JLabel l1 = new JLabel(img);
        add(l1);
        pack();
    }

    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource() == customer) 
        {
             new Customer();
        }
        else if(ae.getSource() == employee)
        {
            new Employee();
        }
        else if (ae.getSource() == service) 
        { 
            new Service();
        }
    }

    public static void main(String[] args) 
    {
        new MenuBar();
    }
}


