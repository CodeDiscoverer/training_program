package EmployeeDepartment;

public class Main {
	
    public static void main(String[] args) {
    	
        EmployeeService service = new EmployeeService();
        EmployeeView view = new EmployeeView(service);
        
        view.employeeView();
    }
}