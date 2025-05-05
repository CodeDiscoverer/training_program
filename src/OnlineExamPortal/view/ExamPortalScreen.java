package OnlineExamPortal.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

import OnlineExamPortal.controller.ExamEngineController;

public class ExamPortalScreen {
	
	BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
	
	ExamEngineController service = new ExamEngineController();
	
	public void homePage() {
		
		char choice;
		
		try {
			
			do {
				System.out.print("A. Start the Exam\nPress 'q' to Exit the Exam\nEnter your Choice: ");
				choice = (char) read.read();
				
				if(choice == 'A') {
					service.assesmentStart();
					read.read();
					read.read();
				}
				else if(choice == 'q') {
					throw new Exception("Exiting...");
				}
				else {
					System.err.println("Invalid Choice...\n");
					read.read();
					read.read();
				}
			}while(choice != 'q');
			
		}catch(IOException e) {
			System.err.println("IO Exception....");
		}catch (InputMismatchException e) {
			System.err.println("Invalid Input\n");
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}finally {
			System.err.println("Thank you! Visit us Again...");
		}
	}
}
