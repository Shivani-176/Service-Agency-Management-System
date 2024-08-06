
import java.util.*;

class Employee {
    private int id;
    private String name;
    
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    // Getters and setters
}

class Service {
    private int id;
    private String type;
    
    public Service(int id, String type) {
        this.id = id;
        this.type = type;
    }
    
    // Getters and setters
}

class Customer {
    private int id;
    private String name;
    
    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    // Getters and setters
}

class Allocation {
    private int id;
    private Employee employee;
    private Service service;
    private Customer customer;
    private Date startDate;
    private Date endDate;
    
    public Allocation(int id, Employee employee, Service service, Customer customer, Date startDate, Date endDate) {
        this.id = id;
        this.employee = employee;
        this.service = service;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    // Getters and setters
}

public class Main {
    public static void main(String[] args) {
        // Create sample employee, service, and customer
        Employee employee = new Employee(1, "John Doe");
        Service service = new Service(1, "Home Cleaning");
        Customer customer = new Customer(1, "Jane Smith");
        
        // Sample dates
        Date startDate = new Date();
        Date endDate = new Date();
        
        // Create an allocation
        Allocation allocation = new Allocation(1, employee, service, customer, startDate, endDate);
        
        // Display allocation details
        System.out.println("Allocation Details:");
        System.out.println("ID: " + allocation.getId());
        System.out.println("Employee: " + allocation.getEmployee().getName());
        System.out.println("Service: " + allocation.getService().getType());
        System.out.println("Customer: " + allocation.getCustomer().getName());
        System.out.println("Start Date: " + allocation.getStartDate());
        System.out.println("End Date: " + allocation.getEndDate());
    }
}
