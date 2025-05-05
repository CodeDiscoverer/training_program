package StudentProfile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Service {
	
	private static Map<String, Course> Courses = new HashMap<>();
	static Scanner read = new Scanner(System.in);

    public static void addCourse(Course course) {
        Courses.put(course.getCourseName(), course);
    }

    public static void addStudent(String courseName, Course.Student student) {
        if (Courses.containsKey(courseName)) {
            Courses.get(courseName).setterStudent(student);
        } else {
            System.out.println("Course Name" + courseName + " not found.");
        }
    }

    public static void displayStudentswithCourse(String courseName) {
        if (Courses.containsKey(courseName)) {
            Course course = Courses.get(courseName);
            System.out.println("Students in Course: " + course.getCourseName());
            for (Course.Student student : course.getStudent()) {
                System.out.println(student);
            }
        } else {
            System.out.println("Course name " + courseName + " not found.");
        }
    }

    public static void displayAllStudentsSortedByName() {
        List<Course.Student> allStudents = new ArrayList<>();
        for (Course course : Courses.values()) {
            allStudents.addAll(course.getStudent());
        }

        Collections.sort(allStudents, Comparator.comparing(Course.Student::getStudentName));

        System.out.println("\nAll Students Sorted by Name:");
        for (Course.Student student : allStudents) {
            System.out.println(student);
        }
    }
    
    public static void displayAllStudentsSortedByGrade() {
        List<Course.Student> allStudents = new ArrayList<>();
        for (Course course : Courses.values()) {
            allStudents.addAll(course.getStudent());
        }

        Collections.sort(allStudents, Comparator.comparing(Course.Student::getStudentScore).reversed());

        System.out.println("\nAll Students Sorted by Grades:");
        for (Course.Student student : allStudents) {
            System.out.println(student.getStudentName() + " From " +student.getCourseName());
        }
    }
    
    public static void displayTopStudent() {
        List<Course.Student> allStudents = new ArrayList<>();
        for (Course course : Courses.values()) {
            allStudents.addAll(course.getStudent());
        }

        Collections.sort(allStudents, Comparator.comparing(Course.Student::getStudentScore).reversed());

        System.out.println("\nTop Student:");
        
        System.out.println(allStudents.get(0));
    }
    
    public static void displayFailedStudents() {
        List<Course.Student> allStudents = new ArrayList<>();
        for (Course course : Courses.values()) {
            allStudents.addAll(course.getStudent());
        }

        Collections.sort(allStudents, Comparator.comparing(Course.Student::getStudentScore).reversed());

        System.out.println("\nFailed Student List:");
       
        for (Course.Student student : allStudents) {
            if(student.getStudentScore()<60) {
                System.out.println(student.getStudentName() + " || " +student.getStudentScore());
            }
        }
    }
        
        public static void displayStudentsBySearch() {
        	
        	
        	System.out.print("Enter the name to Search: ");
        	String Name = read.nextLine();
            List<Course.Student> allStudents = new ArrayList<>();
            for (Course course : Courses.values()) {
                allStudents.addAll(course.getStudent());
            }

            Collections.sort(allStudents, Comparator.comparing(Course.Student::getStudentScore).reversed());

            System.out.println("\nSearching for Student by Name: "+Name);
           
            for (Course.Student student : allStudents) {
                if(student.getStudentName()==Name) {
                    System.out.println(student);
                }
            }
    }
}
