import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Driver extends JFrame implements ActionListener {

    JTable customerTable;
    JTable employeeTable;
    Connection cn;
    Statement stmt;
    JLabel l1,l2;
    JButton b1;

    Font f1 = new Font("Times New Roman", Font.BOLD, 30);

    public Driver() 
    {
        setTitle("Driver Service Info");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(7000, 1000);   
        setVisible(true);
        setLayout(null);

        DefaultTableModel customerTableModel = new DefaultTableModel();
        customerTableModel.addColumn("Customer ID");
        customerTableModel.addColumn("Customer Name");

        DefaultTableModel employeeTableModel = new DefaultTableModel();
        employeeTableModel.addColumn("Employee ID");
        employeeTableModel.addColumn("Employee Name");

        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            cn=DriverManager.getConnection("jdbc:odbc:ShivJavaDSN");
            stmt = cn.createStatement();
            stmt=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet  rsCustomer = stmt.executeQuery("SELECT Cid, Name FROM Customer WHERE Services='Driver'");


            while (rsCustomer.next()) 
            {
                customerTableModel.addRow(new Object[]{rsCustomer.getInt("Cid"), rsCustomer.getString("Name")});
            }
            ResultSet rsEmployee = stmt.executeQuery("SELECT Eid, Name FROM Employee WHERE Services='Driver'");

            while (rsEmployee.next()) {
                employeeTableModel.addRow(new Object[]{rsEmployee.getInt("Eid"), rsEmployee.getString("Name")});
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        customerTable = new JTable(customerTableModel);
        employeeTable = new JTable(employeeTableModel);

        l1 = new JLabel("Customer");
        l2 = new JLabel("Employee");

        b1 = new JButton("Back");

        JScrollPane customerScrollPane = new JScrollPane(customerTable);
        JScrollPane employeeScrollPane = new JScrollPane(employeeTable);

        customerScrollPane.setBounds(400, 200, 300, 400);
        employeeScrollPane.setBounds(800, 200, 300, 400);

        l1.setBounds(500, 450, 300, 400);
        l2.setBounds(900, 450, 300, 400);
        b1.setBounds(100,100,130,40);

        l1.setFont(f1);
        l2.setFont(f1);
        b1.setFont(f1);

        add(customerScrollPane);
        add(employeeScrollPane);

        add(l1);
        add(l2);
        add(b1);

        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            new Service();
        }
    }

    public static void main(String[] args) {
        new Driver();
    }
}
