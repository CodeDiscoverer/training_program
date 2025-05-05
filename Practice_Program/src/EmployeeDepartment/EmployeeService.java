package EmployeeDepartment;

import java.util.*;

public class EmployeeService {

    Scanner read = new Scanner(System.in);
    List<EmployeeDetails> employees = new ArrayList<>();
    private int employeeIdSerial = 6540;

    static class EmployeeDetails {
    	
        private int employeeId;
        private String employeeName;
        private  String department;

        EmployeeDetails(int employeeId, String employeeName, String department) {
            this.employeeId = employeeId;
            this.employeeName = employeeName;
            this.department = department;
        }
    }

    public void createEmployee() {
    	
        System.out.print("Enter Your Name: ");
        String name = read.nextLine();
        System.out.print("Enter Your Department: ");
        String dept = read.nextLine();

        EmployeeDetails detail = new EmployeeDetails(++employeeIdSerial, name, dept);
        employees.add(detail);

        System.out.println("Employee Created Successfully!");
        System.out.println("Employee ID: " + employeeIdSerial);
    }

    public void displayDepartments() {
    	
        Set<String> departments = new HashSet<>();
        for (EmployeeDetails e : employees) {
            departments.add(e.department);
        }

        if (departments.isEmpty()) {
            System.out.println("No departments found.");
        } else {
            System.out.println("Departments:");
            for (String dept : departments) {
                System.out.println("- " + dept);
            }
        }
    }

    public void displayAllEmployees() {
    	
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        System.out.println("All Employees:");
        for (EmployeeDetails e : employees) {
            System.out.println("ID: " + e.employeeId + ", Name: " + e.employeeName + ", Department: " + e.department);
        }
    }
}