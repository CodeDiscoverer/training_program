package StudentProfile;

import java.util.*;

public class Main {
    
    
    public static void main(String[] args) {

    	Scanner read = new Scanner(System.in);
    	
        Course IT = new Course("IT");
        Course CT = new Course("CT");
        Course CS = new Course("CS");

        Service.addCourse(IT);
        Service.addCourse(CT);
        Service.addCourse(CS);

        Service.addStudent("IT", new Course.Student("Suriya",90, "IT"));
        Service.addStudent("CT", new Course.Student("Sudarsan",80, "CT"));
        Service.addStudent("CT", new Course.Student("Mohan",70, "CT"));
        Service.addStudent("CS", new Course.Student("Divya",80, "CS"));
        Service.addStudent("CS", new Course.Student("Monisha",87, "CS"));
        Service.addStudent("IT", new Course.Student("Prasad",99, "IT"));
        Service.addStudent("IT", new Course.Student("Sanjai",40, "IT"));
        
        int choice = -1;
        
        do {     
            System.out.print(
            		"\n1. Student, Course from Students" + 
                    "\n2. * from Students order by Name ASC" + 
                    "\n3. * from Students order by Grade DESC" + 
                    "\n4. Max(Grade) as Top Performer From Students" + 
                    "\n5. * as Failures from students where Grade < 60" + 
                    "\n6. * from students where name like ..." + 
                    "\n0. Exit" +
                    "\nEnter your choice: ");
            
            try {
                choice = read.nextInt();
                
                if(choice > 6 || choice < 0) {
                    System.err.println("\nEnter a Valid choice...");
                }
                
                switch (choice) {
                
                    case 1 :
                    	Service.displayStudentswithCourse("IT"); 
                        System.out.println("");
                        Service.displayStudentswithCourse("CT");
                        System.out.println("");
                        Service.displayStudentswithCourse("CS");
                        break;
                        
                    case 2:
                    	Service.displayAllStudentsSortedByName();
                        break;
                        
                    case 3:
                    	Service.displayAllStudentsSortedByGrade();
                        break;
                        
                    case 4:
                    	Service.displayTopStudent();
                        break;
                        
                    case 5:
                    	Service.displayFailedStudents();
                        break;
                        
                    case 6:
                    	Service.displayStudentsBySearch(); 
                        break;
                        
                }
            }catch(InputMismatchException e) {
                System.err.println("Kindly Select the correct choice...");
                read.next();
            }
            if(choice == 0){
                System.err.println("Thank You! Visit us Again... 👋");
            }
        }while(choice != 0); 
    }
}