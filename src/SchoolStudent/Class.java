package SchoolStudent;

import java.util.HashMap;
import java.util.Map;


public class Class {
	
	public static long studentID = 202504000;
	private Map<Long, String> student = new HashMap<>();
	
	class Student{
		
		public void addStudent(Class clas, String studentName) {
			++Class.studentID;
			clas.student.put(studentID, studentName);
			
		}
		
		public void displayStudent(Class clas) {
			int count = 0;
			for(long i = 202504001; i <= Class.studentID; i++) {
				if(clas.student.get(i) != null) {
					count++;
					System.out.println("Sutdent ID: " + i + " | Student Name: " + clas.student.get(i));
				}
			}
			System.out.println("Total No of Students: " + count);
		}
	}
}
