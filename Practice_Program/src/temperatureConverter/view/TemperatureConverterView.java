package temperatureConverter.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import temperatureConverter.controller.TemperatureConverterController;

public class TemperatureConverterView {
	
	Scanner read = new Scanner(System.in);
	TemperatureConverterController service = new TemperatureConverterController();
	
	public void homePage() {
		int choice;
		try {
			do {
				System.out.print("\n1. Celsius to Fahrenheit\n2. Fahrenheit to Celsius\nPress 0 Exit\nEnter your choice: ");
				choice = read.nextInt();
				
				if(choice == 1) {
					System.out.print("Enter Celsius to Convert... ");
					double fahrenheit = read.nextDouble();
					service.convertCelsius(fahrenheit);
				}
				else if(choice == 2){
					System.out.print("Enter Fahrenheit to Convert... ");
					double celsius = read.nextDouble();
					service.convertFahrenheit(celsius);
				}
				else {
					System.err.println("Invalid Choice");
				}
				
			}while (choice != 0);
		}catch (InputMismatchException in) {
			System.err.println("Invalid Input");
		}catch (NumberFormatException e) {
			System.err.println("Invalid Input");
		}catch (Exception e) {
			System.err.println("Invalid Input");
		}finally {
			System.err.println("Thank you! Visit us again...");
		}
	}

}
