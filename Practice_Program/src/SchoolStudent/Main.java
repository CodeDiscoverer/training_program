package SchoolStudent;

public class Main {

	public static void main(String[] args) {
		
		Class IT = new Class();
		Class.Student student = IT.new Student();
	
		student.addStudent(IT, "HII");
		student.addStudent(IT, "HELLO");
		student.addStudent(IT, "BYE");
		
		System.out.println("%%%%%%%%%%%%%%%%%% IT %%%%%%%%%%%%%%%%%%");
		student.displayStudent(IT);
		
		
		Class CT = new Class();
		Class.Student studentCT = CT.new Student();
		
		studentCT.addStudent(CT, "hii");
		studentCT.addStudent(CT, "hello");
		studentCT.addStudent(CT, "bye");
		
		System.out.println("\n%%%%%%%%%%%%%%%%%% CT %%%%%%%%%%%%%%%%%%");
		student.displayStudent(CT);

	}

}
