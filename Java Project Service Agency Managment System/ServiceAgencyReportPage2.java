import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ServiceAgencyReportPage2 extends JFrame {
    private JComboBox customerComboBox;
    private JComboBox employeeComboBox;
    private JComboBox serviceComboBox;
    private JComboBox dayComboBox;
    private JComboBox monthComboBox;
    private JComboBox yearComboBox;
    private JTextField timeField;
    private JTable detailsTable;
    private DefaultTableModel tableModel;
    private Connection connection;

    public ServiceAgencyReportPage2() {
        setTitle("Service Agency Report");
        setSize(7000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        Font f = new Font("Times New Roman", Font.PLAIN, 25);

        customerComboBox = new JComboBox();
        employeeComboBox = new JComboBox();
        serviceComboBox = new JComboBox(new String[]{"Home Cleaning", "Watchman", "Driver"});
        dayComboBox = new JComboBox();
        monthComboBox = new JComboBox(new String[]{"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"});
        yearComboBox = new JComboBox();
        timeField = new JTextField(10);
        detailsTable = new JTable();
        tableModel = new DefaultTableModel();

        JLabel customerLabel = new JLabel("Customer:");
        customerLabel.setBounds(550, 200, 200, 40);
        customerComboBox.setBounds(720, 200, 200, 40);
        add(customerLabel);
        customerLabel.setFont(f);
        add(customerComboBox);
        customerComboBox.setFont(f);

        JLabel employeeLabel = new JLabel("Employee:");
        employeeLabel.setBounds(550, 250, 200, 40);
        employeeComboBox.setBounds(720, 250, 200, 40);
        add(employeeLabel);
        add(employeeComboBox);
        employeeLabel.setFont(f);
        employeeComboBox.setFont(f);

        JLabel serviceLabel = new JLabel("Service:");
        serviceLabel.setBounds(550, 300, 200, 40);
        serviceComboBox.setBounds(720, 300, 200, 40);
        add(serviceLabel);
        add(serviceComboBox);
        serviceLabel.setFont(f);
        serviceComboBox.setFont(f);

        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(550, 350, 200, 40);
        dayComboBox.setBounds(720, 350, 200, 40);
        JLabel monthLabel = new JLabel("Month");
        monthLabel.setBounds(550, 400, 200, 40);
        monthComboBox.setBounds(720, 400, 200, 40); 
        JLabel yearLabel = new JLabel("Year");
        yearLabel.setBounds(550, 450, 200, 40);
        yearComboBox.setBounds(720, 450, 200, 40); 
        
        add(dateLabel);
        add(dayComboBox);
        dateLabel.setFont(f);
        dayComboBox.setFont(f);
        add(monthLabel);
        add(monthComboBox);
        monthLabel.setFont(f);
        monthComboBox.setFont(f);
        add(yearLabel);
        add(yearComboBox);
        yearLabel.setFont(f);
        yearComboBox.setFont(f);

        JLabel timeLabel = new JLabel("Time:");
        timeLabel.setBounds(550, 500, 200, 40);
        timeField.setBounds(720, 500, 200, 40);
        add(timeLabel);
        add(timeField);
        timeLabel.setFont(f);
        timeField.setFont(f);

        JButton generateButton = new JButton("Generate Report");
        generateButton.addActionListener(new ActionListener() 
        {
           
            public void actionPerformed(ActionEvent e) {
                generateReport();
            }
        });
        generateButton.setBounds(600,550, 250, 40);
        add(generateButton);
        generateButton.setFont(f);

        JScrollPane scrollPane = new JScrollPane(detailsTable);
        scrollPane.setBounds(550, 600, 400, 200);
        add(scrollPane);

        setVisible(true);

        // Establish database connection
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            connection = DriverManager.getConnection("jdbc:odbc:ShivJavaDSN");
            populateComboBoxes();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Populate day and year ComboBoxes
        for (int i = 1; i <= 31; i++) {
            dayComboBox.addItem(i);
        }

        for (int i = 2000; i <= 2025; i++) { // Adjust the range as needed
            yearComboBox.addItem(i);
        }
    }

    private void populateComboBoxes() {
        try {
            // Populate customer ComboBox
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Customer");
            while (rs.next()) {
                customerComboBox.addItem(rs.getString("Name"));
            }

            rs = stmt.executeQuery("SELECT * FROM Employee");
            while (rs.next()) {
                employeeComboBox.addItem(rs.getString("Name"));
            }

            // Close statement and result set
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void generateReport() {
        String selectedCustomer = (String) customerComboBox.getSelectedItem();
        String selectedEmployee = (String) employeeComboBox.getSelectedItem();
        String selectedService = (String) serviceComboBox.getSelectedItem();

        Integer selectedDay = (Integer) dayComboBox.getSelectedItem();
        String selectedMonth = (String) monthComboBox.getSelectedItem();
        Integer selectedYear = (Integer) yearComboBox.getSelectedItem();

        String selectedDate = selectedYear + "-" + (monthComboBox.getSelectedIndex() + 1) + "-" + selectedDay;
        String selectedTime = timeField.getText();

        tableModel.setColumnIdentifiers(new String[]{"Category", "Details"});
        tableModel.setRowCount(0);
        tableModel.addRow(new String[]{"Customer", selectedCustomer});
        tableModel.addRow(new String[]{"Employee", selectedEmployee});
        tableModel.addRow(new String[]{"Service", selectedService});
        tableModel.addRow(new String[]{"Date", selectedDate});
        tableModel.addRow(new String[]{"Time", selectedTime});
        detailsTable.setModel(tableModel);
    }

    public static void main(String[] args) {
        new ServiceAgencyReportPage2();
    }
}
