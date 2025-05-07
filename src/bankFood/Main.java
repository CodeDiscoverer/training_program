package bankFood;

import java.util.InputMismatchException;
import java.util.Scanner;

import FoodOrdering.screen.RestaurantScreen;
import customException.view.AccountView;

public class Main {
	
	static Scanner read = new Scanner(System.in);
	
	public static void bankFood() {
		
		try {
			
			AccountView page = new AccountView();
			RestaurantScreen screen = new RestaurantScreen();
			
			
			System.out.print("\n1. Bank\n2. Restaurant\nEnter your choice: ");
	 
			switch(read.nextInt()){
			case 1 : page.accountView(); break;
			case 2 : screen.homeScreen();
			}
			
		} catch (InputMismatchException e) {
			read.next();
			bankFood();
		}
	}

	public static void main(String[] args) {
		bankFood();
	}
}
