package training.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	public static void call() {
		Scanner readInput = new Scanner(System.in);
		int operationChoice;
		
        do{    
            System.out.print("\nOperation Type\n1. Sum\n2. Difference\n3. Product\n4. Division\nPress 0 to Exit\nEnter Your Choice: ");
            operationChoice  = readInput.nextInt();
           
    
            if(operationChoice <= 5  && operationChoice >= 0) {
            	Calculator opChoice = new Calculator(operationChoice);
            	opChoice.displayResult();
            }
            
            else {
            	System.err.println("Invalid Choice!");
            }
            
        }while((operationChoice != 0));
	}

    public static void main(String[] args) {    	
    	Scanner read = new Scanner(System.in);
       try{
    	   call();
        } catch (InputMismatchException e) {
        	System.err.println("Kindly Enter only Numerals");
        	call();
		} catch (ArithmeticException e) {
			System.err.println("Divisible is Zero is not possible");
        	call();
		} catch (IllegalArgumentException e) {
			System.err.println("Illegal Argument Exception");
        	call();
		} finally {
        	System.err.println("Thank you for using this Application!\nVisit Again...");
        }
    }
}