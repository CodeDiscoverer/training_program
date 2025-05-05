package StudentProfile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Course {
	
	private String courseName;
	private List<Student> student;
	
	Course(String courseName){
		this.courseName = courseName;
		this.student = new ArrayList<>();
	}
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	public void setterStudent(Student student) {
		this.student.add(student);
	}

	static class Student {
		
		Instant now = Instant.now();
		private long StudentId;
		private String studentName;
		private int studentScore;
		private String courseName;
		
		Student(String studentName, int StudentScore, String courseName){
			setStudentId(now.toEpochMilli());
			this.setStudentName(studentName);
			this.setStudentScore(StudentScore);
			this.setCourseName(courseName);
		}

		public long getStudentId() {
			return StudentId;
		}
		public void setStudentId(long studentId) {
			StudentId = studentId;
		}

		public String getStudentName() {
			return studentName;
		}
		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}

		public double getStudentScore() {
			return studentScore;
		}
		public void setStudentScore(int studentScore) {
			this.studentScore = studentScore;
		}

		public String getCourseName() {
			return courseName;
		}
		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}
		
		public String toString() {
			return 
					"Student Id: " + StudentId +
					" Name: " + studentName +
					" Score: " + studentScore + 
					" Course: " + courseName;
		}
		
	}
}
