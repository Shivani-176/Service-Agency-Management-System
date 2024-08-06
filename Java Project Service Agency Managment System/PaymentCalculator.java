import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaymentCalculator extends JFrame implements ActionListener 
{
    JLabel empIdLabel, empNameLabel, serviceIdLabel, serviceNameLabel, rateLabel, daysLabel, resultLabel;
    JTextField empIdField, empNameField, serviceIdField, serviceNameField, rateField, daysField;
    JButton calculateButton;

    PaymentCalculator() 
    {
        setTitle("Payment Calculator");
        setSize(7000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        Font f1 = new Font("Times New Roman", Font.PLAIN, 25);

        empIdLabel = new JLabel("Employee ID:");
        empNameLabel = new JLabel("Employee Name:");
        serviceIdLabel = new JLabel("Service ID:");
        serviceNameLabel = new JLabel("Service Name:");
        rateLabel = new JLabel("Rate per Day ($):");
        daysLabel = new JLabel("Days Worked:");
        resultLabel = new JLabel("");

        empIdField = new JTextField();
        empNameField = new JTextField();
        serviceIdField = new JTextField();
        serviceNameField = new JTextField();
        rateField = new JTextField();
        daysField = new JTextField();

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);

        // Setting bounds for labels, text fields, and button
        empIdLabel.setBounds(20, 20, 120, 25);
        empIdField.setBounds(150, 20, 200, 25);
        empNameLabel.setBounds(20, 50, 120, 25);
        empNameField.setBounds(150, 50, 200, 25);
        serviceIdLabel.setBounds(20, 80, 120, 25);
        serviceIdField.setBounds(150, 80, 200, 25);
        serviceNameLabel.setBounds(20, 110, 120, 25);
        serviceNameField.setBounds(150, 110, 200, 25);
        rateLabel.setBounds(20, 140, 120, 25);
        rateField.setBounds(150, 140, 200, 25);
        daysLabel.setBounds(20, 170, 120, 25);
        daysField.setBounds(150, 170, 200, 25);
        calculateButton.setBounds(150, 200, 100, 30);
        resultLabel.setBounds(20, 230, 300, 25);

        add(empIdLabel);
        add(empIdField);
        add(empNameLabel);
        add(empNameField);
        add(serviceIdLabel);
        add(serviceIdField);
        add(serviceNameLabel);
        add(serviceNameField);
        add(rateLabel);
        add(rateField);
        add(daysLabel);
        add(daysField);
        add(calculateButton);
        add(resultLabel);
    }

    public void actionPerformed(ActionEvent ae) {
        double rate = Double.parseDouble(rateField.getText());
        int days = Integer.parseInt(daysField.getText());
        double payment = rate * days;
        resultLabel.setText("Payment: " + payment);
    }

    public static void main(String[] args) {
        new PaymentCalculator();
    }
}
