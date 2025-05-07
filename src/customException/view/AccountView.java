package customException.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import customException.controller.AccountServiceController;
import bankFood.Main;

public class AccountView {
	
	Scanner read = new Scanner(System.in);
	
	public void accountView(){
		int choice = 0;
		AccountServiceController service = new AccountServiceController();
		
		do {
			System.out.print("\n1. Create Account\n2. Transact\n3. View All Account Info\nPress 0 to Exit\nEnter your Choice: ");
			try {
				choice = read.nextInt();
				
				if(choice != 0) {
					if(choice == 1) {
						service.createAccount();
					}
					
					else if(choice == 2) {
						service.transact();
						
					}
					
					else if(choice == 3) {
						service.displayAllAccountStats();
					}
					else {
						System.err.println("Oops! Invalid Choice...");
					}
				}
				else {
					Main.bankFood();
				}
			}catch (InputMismatchException e) {
				read.next();
				accountView();
			}
		}while(choice != 0);
	}

}
