package EmpDept;

public class Main {

	public static void main(String[] args) {
		
		Department IT = new Department();
		Department.Employee employeee = IT.new Employee();
		
		employeee.addEmployee(IT, "Suriya");
		
		employeee.displayEmployee(IT);

	}

}
