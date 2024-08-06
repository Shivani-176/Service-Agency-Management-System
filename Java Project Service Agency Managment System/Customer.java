import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.beans.Statement;
import java.sql.*;
import java.awt.*;

public class Customer extends JFrame implements ActionListener 
{
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9;
    JComboBox sd;
    JRadioButton maleRadio, femaleRadio;
    ButtonGroup genderGroup;
    
    JPanel p1, p2, p3;
    Connection cn;
    ResultSet rs;
    PreparedStatement pst;
    java.sql.Statement stmt;
    JTable table;
    DefaultTableModel model;

    Customer() {
        setVisible(true);
        setSize(7000, 1000);
        setTitle("Customer");
        setLayout(null);
        Font f1 = new Font("Times New Roman", Font.PLAIN, 25);
        Font f2 = new Font("Times New Roman", Font.BOLD, 30);

        l1 = new JLabel("Customer Id");
        l2 = new JLabel("Customer Name");
        l3 = new JLabel("Address");
        l4 = new JLabel("MobileNo");
        l6 = new JLabel("Gender");
        l7 = new JLabel("Services");
        l8 = new JLabel("Customer");
        l10 = new JLabel("Customer");
        

        l1.setFont(f1);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        l8.setFont(f2);
        

        t1 = new JTextField(15);
        t2 = new JTextField(15);
        t3 = new JTextField(15);
        t4 = new JTextField(15);
        t6 = new JTextField(15);
        t7 = new JTextField(15);

        t1.setFont(f1);
        t2.setFont(f1);
        t3.setFont(f1);
        t4.setFont(f1);
        t6.setFont(f1);
        t7.setFont(f1);

        String[] services = {"Home Cleaning", "Watchman", "Driver"};
        sd = new JComboBox(services);
        sd.setFont(f1);

        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        maleRadio.setFont(f1);
        femaleRadio.setFont(f1);

        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        b1 = new JButton("New");
        b2 = new JButton("Insert");
        b3 = new JButton("Update");
        b4 = new JButton("Delete");
        b5 = new JButton("Search");
        b6 = new JButton("Next");
        b7 = new JButton("Prev");
        b8 = new JButton("Exit");
        b9 = new JButton("View");

        b1.setFont(f1);
        b2.setFont(f1);
        b3.setFont(f1);
        b4.setFont(f1);
        b5.setFont(f1);
        b6.setFont(f1);
        b7.setFont(f1);
        b8.setFont(f1);
        b9.setFont(f1);


        model = new DefaultTableModel();
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

         model.addColumn("Customer Id");
         model.addColumn("Customer Name");
         model.addColumn("Address");
         model.addColumn("MobileNo");
         model.addColumn("Gender");
         model.addColumn("Services");
         
    
         l1.setBounds(550, 200, 200, 40);
         t1.setBounds(720, 200, 300, 40);
         l2.setBounds(550, 250, 200, 40);
         t2.setBounds(720, 250, 300, 40);
         l3.setBounds(550, 300, 200, 40);
         t3.setBounds(720, 300, 300, 40);
         l4.setBounds(550, 350, 200, 40);
         t4.setBounds(720, 350, 300, 40);
         l6.setBounds(550, 400, 200, 40);
         maleRadio.setBounds(720, 400, 80, 40);
         femaleRadio.setBounds(810, 400, 100, 40);
         l7.setBounds(550, 450, 200, 40);
         sd.setBounds(720, 450, 300, 40);
         b1.setBounds(530, 500, 100, 40);
         b2.setBounds(650, 500, 100, 40);
         b3.setBounds(770, 500, 130, 40);
         b4.setBounds(910, 500, 130, 40);
         b6.setBounds(530, 550, 100, 40);
         b7.setBounds(650, 550, 100, 40);
         b5.setBounds(770, 550, 130, 40);
         b8.setBounds(910, 550, 130, 40);
         scrollPane.setBounds(1200, 200, 700, 600);

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(l6);
        add(maleRadio);
        add(femaleRadio);
        add(l7);
        add(sd);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(scrollPane);          

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            cn = DriverManager.getConnection("jdbc:odbc:ShivJavaDSN");
            stmt = cn.createStatement();
            stmt=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * FROM Customer");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6)});
        }}
            catch (Exception ae) {
            System.out.println(ae);
        }
    }

    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource() == b1) {
            try {
                rs.last();
                int c = Integer.parseInt(rs.getString(1)) + 1;
                t1.setText(" " + c);
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t6.setText("");
                t7.setText("");
            } catch (Exception obj) {
                System.out.println(obj);
            }
        }
        
            if (ae.getSource() == b2) {
                try {
                    if (t4.getText().length() != 10) 
                    {
                        JOptionPane.showMessageDialog(null, "Mobile number must have exactly 10 digits.");
                        return;
                    }
                    String query = "INSERT INTO Customer (Name, Address, MobileNo, Services, Gender) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement insertStatement = cn.prepareStatement(query);
                    insertStatement.setString(1, t2.getText());
                    insertStatement.setString(2, t3.getText());
                    insertStatement.setString(3, t4.getText());
                    insertStatement.setString(4, sd.getSelectedItem().toString());
                    insertStatement.setString(5, maleRadio.isSelected() ? "Male" : "Female");
                
                    insertStatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record is Added");
                } catch (Exception ae1) {
                    System.out.println(ae1);
                }
                
                
            }
        
            if (ae.getSource() == b3) {
                try {
                    String updateQuery = "UPDATE Customer SET Name=?, Address=?, MobileNo=?, Gender=?, Services=? WHERE Cid=?";
                    PreparedStatement updateStatement = cn.prepareStatement(updateQuery);
                    updateStatement.setString(1, t2.getText());
                    updateStatement.setString(2, t3.getText());
                    updateStatement.setString(3, t4.getText());
                    updateStatement.setString(4, maleRadio.isSelected() ? "Male" : "Female");
                    updateStatement.setString(5, sd.getSelectedItem().toString());
                    updateStatement.setString(6, t1.getText());
            
                    int rowsUpdated = updateStatement.executeUpdate();
            
                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(null, "Record is Updated");
                    } else {
                        JOptionPane.showMessageDialog(null, "No record found with the specified Customer Id");
                    }
                } catch (Exception ae1) {
                    ae1.printStackTrace();
                }
            }
            if (ae.getSource() == b4) 
            {
                try {
                    if (rs != null) {
                        String customerId = t1.getText();
                        String deleteQuery = "DELETE FROM Customer WHERE Cid = ?";
                        PreparedStatement deleteStatement = cn.prepareStatement(deleteQuery);
                        deleteStatement.setString(1, customerId);
                        int rowsDeleted = deleteStatement.executeUpdate();
                    
                        if (rowsDeleted > 0) {
                            JOptionPane.showMessageDialog(null, "Record is Deleted");
                    
                            if (rs.next()) {
                                t1.setText("");
                                t2.setText(rs.getString(2));
                                t3.setText(rs.getString(3));
                                t4.setText(rs.getString(4));
                                t6.setText(rs.getString(5));
                                t7.setText(rs.getString(6));
                            }
                        }
                    }
                }
                catch (Exception ae1) {
                    ae1.printStackTrace();
                }
            }
                           
                
        if (ae.getSource() == b5) {
    try {
        String customerName = JOptionPane.showInputDialog(this, "Enter Customer Name");
        boolean found = false;
        rs.first();
        
        do {
            if (rs.getString(2).equals(customerName)) 
            {
                t1.setText(rs.getString(1));
                t2.setText(rs.getString(2));
                t3.setText(rs.getString(3));
                t4.setText(rs.getString(4));
                t6.setText(rs.getString(6));
                t7.setText(rs.getString(7));
                found = true;
                break;
            }
        } while (rs.next());

        if (!found) {
            JOptionPane.showMessageDialog(this, "Record not Found");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
if (ae.getSource() == b6) {
    try {
        rs.next();
        if (rs.isAfterLast()) {
            rs.last();
        }
        t1.setText(rs.getString(1));
        t2.setText(rs.getString(2));
        t3.setText(rs.getString(3));
        t4.setText(rs.getString(4));
        String selectedService = rs.getString(5); 
        sd.setSelectedItem(selectedService);

      
        String gender = rs.getString(6); 
        if ("Male".equals(gender)) {
            maleRadio.setSelected(true);
        } else if ("Female".equals(gender)) {
            femaleRadio.setSelected(true);
        }
    } catch (Exception ae2) {
        System.out.println(ae2);
    }
}

if (ae.getSource() == b7) {
    try {
        rs.previous();
        if (rs.isBeforeFirst()) {
            rs.first();
        }
        t1.setText(rs.getString(1));
        t2.setText(rs.getString(2));
        t3.setText(rs.getString(3));
        t4.setText(rs.getString(4));
        String selectedService = rs.getString(5); 
        sd.setSelectedItem(selectedService);
        String gender = rs.getString(6); 
        if ("Male".equals(gender)) 
        {
            maleRadio.setSelected(true);
        } else if ("Female".equals(gender)) 
        {
            femaleRadio.setSelected(true);
        }
    } catch (Exception ae2) {
        System.out.println(ae2);
    }
}

            if (ae.getSource() == b8) 
            {
                new MenuBar();
            }
    }
        

    public static void main(String[] args) 
    {
        new Customer();
    }
}
