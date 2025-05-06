package FoodOrdering.screen;

import java.util.InputMismatchException;
import java.util.Scanner;

import FoodOrdering.services.RestaurantServiceController;

public class RestaurantScreen {
	
	RestaurantServiceController service = new RestaurantServiceController();
	Scanner read = new Scanner(System.in);
	
	int choice;
	
	public void homeScreen() {
		
		try {
			
			try {
				service.initialize();
			} catch (InterruptedException e) {}
			
			do {
				System.out.print("\n1. Add Dish\n2. Order Food\n3. View Menu\n4. Bill\nPress 0 to Exit\nEnter your Choice: ");
				choice = read.nextInt();
				
				switch (choice) {
				case 1 -> service.addDish();
				case 2 -> service.orderFood();
				case 3 -> service.viewMenuList();
				case 4 -> service.bill();
				case 0 -> System.err.println("Thank You! Kindly Visit Us Again...");
				default -> System.err.println("Oops! Invalid Choice...");
				}
				
			}while(choice != 0);
			
		}catch (InputMismatchException e) {
			read.next();
			homeScreen();
		}catch (Exception e) {
			System.err.println(e.getMessage());
			read.next();
			homeScreen();
		}
	}
}
