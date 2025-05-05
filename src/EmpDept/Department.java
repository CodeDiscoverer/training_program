package EmpDept;

import java.util.ArrayList;

public class Department {
	
	private ArrayList<String> employee = new ArrayList<>();
	
	class Employee{
		
		public void addEmployee(Department department, String employeeName) {
			department.employee.add(employeeName);
		}
		
		public void displayEmployee(Department department) {
			for(String name : department.employee) {
				System.out.println(name);
			}
		}
	}
}
