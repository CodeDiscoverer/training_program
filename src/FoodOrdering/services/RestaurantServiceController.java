package FoodOrdering.services;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import FoodOrdering.model.Menu;
import FoodOrdering.model.Menu.Dish;
import customException.controller.AccountServiceController;

public class RestaurantServiceController extends Thread implements RestaurantServices {
	
	Scanner read = new Scanner(System.in);
	
	List<String> orderedList = new ArrayList<>();
	double billAmount = 0;
	
	public void initialize() throws InterruptedException {
		System.out.println("Hang on tight! we are setting the Menu for you...");
		Menu.menuList.add(new Dish("120", "Rasamalai", 80));
		Menu.menuList.add(new Dish("121", "Masal Roast", 140));
		Menu.menuList.add(new Dish("122", "Idly", 40));
		Menu.menuList.add(new Dish("123", "Chola Poori", 160));
		Menu.menuList.add(new Dish("124", "Fride Rice", 180));
		Menu.menuList.add(new Dish("125", "Biriyani", 260));	
		Thread.sleep(3000);
		System.out.println("You are all set to go...");
	}
	
	@Override
	public void addDish() {
		try {
			System.out.print("Enter the Dish Id: ");
			String dishId = read.nextLine();
			
			System.out.print("Enter the Dish Name: ");
			String dishName = read.nextLine();
			
			System.out.print("Enter the " + dishName + " Price: ");
			double dishPrice = read.nextDouble();
						Menu.menuList.add(new Dish(dishId, dishName, dishPrice));
			
		}catch (InputMismatchException e) {
			read.next();
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	@Override
	public void viewMenuList() {
		Menu.menuList.forEach(System.out::println);
	}

	@Override
	public void orderFood() {
		try {
			Menu.menuList.forEach(System.out::println);
			System.out.print("Enter the Food ID you wanna order...  ");
			String dishId = read.next();
			
			Dish orderedDish = null;
			for (Dish d : Menu.menuList) {
			    if (d.getDishId().equals(dishId)) {
			        orderedDish = d;
			        break;
			    }
			}
			
			if (orderedDish != null) {
			    System.out.print("Quantity: ");
			    int quantity = read.nextInt();
			    billAmount += orderedDish.getDishPrice() * quantity;
			    orderedList.add(orderedDish.getDishName() + " => " + quantity + " x " + orderedDish.getDishPrice() + " = " + (orderedDish.getDishPrice()* quantity));
			    System.out.println("Your Order is Preparing...");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {	}
				System.out.println("Your Order is Prepared here is your " + orderedDish.getDishName());
			}
			else {
				throw new Exception("Invalid Food Id");
			}
			
		}catch (InputMismatchException e) {
			read.next();
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	@Override
	public void bill() {
		
		if(billAmount > 0) {
			System.out.println("Your Bill is Generating...");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {	}
			System.out.println("Your Bill is Generated");
			
			System.out.println("%%%%%%%%%% PROGRAMMERS RESTAURENT %%%%%%%%%%");
			orderedList.forEach(System.out::println);
			System.out.println("\n\tTotal Bill Amount: " + billAmount);
			System.out.println("-------------------------------------");
			System.out.print("Payment Options\n1. Net Banking\n2. Cash\nPress other Number to Exit\nEnter your Choice: ");
			int paymentOption = read.nextInt();
			switch(paymentOption) {
			case 1 : pay(); break;
			case 2 : System.out.print("Enter the amount received: "); 
			System.out.println("Remaining Amount: " + (read.nextInt() - billAmount));
			}
		}else {
			System.out.println("You Haven't Ordered Anything...");
		}
	}

	@Override
	public void pay() {
		AccountServiceController service = new AccountServiceController();
		
		System.out.print("Enter Account No: ");
		long accountNumber = read.nextLong();
		
		if(service.account.get(accountNumber) != null) {
			service.withdraw(accountNumber, billAmount);
		}
		else {
			System.out.println("log: 128/training_program/src/FoodOrdering/services/RestaurantServiceController.java");
		}
	}

}
