package lift.view;

import java.util.Scanner;

import lift.controller.LiftServiceController;

public class LiftView {
	
	Scanner read = new Scanner(System.in);
	
	public void liftPage() {
		
		int choice;
		LiftServiceController service = new LiftServiceController();
		
		try {
			service.initial();
			do {
				System.out.print("\n1. Install a new Lift\n2. Use Lift\n3. Lift Positions\nPress 0 to Exit\nEnter your Choice: ");
				
				choice = read.nextInt();
				
				if(choice == 1) {
					service.installLift();
				}
				
				else if(choice == 2) {
					service.moveLift();
				}
				
				else if(choice == 3) {
					service.liftStatus();
				}
				else {
					System.err.println("Oops! Invalid Choice...");
				}
				
			}while(choice !=0);
		}catch(Exception e) {
			liftPage();
		}
	}
}
