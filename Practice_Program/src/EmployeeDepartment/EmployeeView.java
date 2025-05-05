package EmployeeDepartment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeView {

    private final Scanner read = new Scanner(System.in);
    private final EmployeeService service;

    public EmployeeView(EmployeeService service) {
        this.service = service;
    }

    public void employeeView() {
    	
        int choice = -1;

        while (choice != 0) {
        	
            System.out.print("\n1. Create Employee\n2. View All Employees\n0. Exit\nEnter your Choice: ");
            
            try {
                choice = read.nextInt(); 

                switch (choice) {
                    case 1 -> service.createEmployee();
                    case 2 -> service.displayAllEmployees();
                    case 0 -> System.out.println("Exiting...");
                    default -> System.err.println("Oops! Invalid Choice...");
                }

            } catch (InputMismatchException e) {
                System.err.println("Please enter a valid number!");
                read.next();
            }
        }
    }
}