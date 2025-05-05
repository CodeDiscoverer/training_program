package training.calculator;

import java.util.Scanner;

import training.calculator.operations.Difference;
import training.calculator.operations.Divison;
import training.calculator.operations.Product;
import training.calculator.operations.Sum;

public class Calculator {

    protected int operationChoice;
    protected int noOfElements;
    protected int[] elements = new int[noOfElements];

    Calculator(int operationChoice){
        this.operationChoice = operationChoice;
    }

    protected Calculator(int noOfElements, int[] elements){
        this.noOfElements = noOfElements;
        this.elements = elements;
    }

    public void displayResult(){

        Scanner read = new Scanner(System.in);

        if(operationChoice == 1){
            System.out.print("Enter no of Elements: ");
            noOfElements = read.nextInt();

            int[] elements = new int[noOfElements];
            System.out.print("Enter " + noOfElements + " Elements to Sum 👇\n");
            for(int i = 0; i < noOfElements; i++){
                elements[i] = read.nextInt();
            }

            Sum calc = new Sum(noOfElements, elements);
            System.out.println("The Result is: " + calc.sum());
        }
        
        if(operationChoice == 2){
            System.out.print("Enter no of Elements: ");
            noOfElements = read.nextInt();

            int[] elements = new int[noOfElements];
            System.out.println("Enter " + noOfElements + " Elements to Difference 👇\n");
            for(int i = 0; i < noOfElements; i++){
                elements[i] = read.nextInt();
            }

            Difference diff = new Difference(noOfElements, elements);
            System.out.println("The Result is: " + diff.difference());
        }
        
        if(operationChoice == 3){
            System.out.print("Enter no of Elements: ");
            noOfElements = read.nextInt();

            int[] elements = new int[noOfElements];
            System.out.println("Enter " + noOfElements + " Elements to Multiplication 👇\n");
            for(int i = 0; i < noOfElements; i++){
                elements[i] = read.nextInt();
            }

            Product prod = new Product(noOfElements, elements);
            System.out.println("The Result is: " + prod.product());
        }
        
        if(operationChoice == 4){
            //System.out.println("Enter no of Elements: ");
            noOfElements = 2;

            int[] elements = new int[noOfElements];
            System.out.println("Enter " + noOfElements + " Elements to Division  👇\n");
            for(int i = 0; i < noOfElements; i++){
                elements[i] = read.nextInt();
            }

            Divison div = new Divison(noOfElements, elements);
            System.out.println("The Result is: " + div.divison());
        }
        
    }

    public int sum() {
        return 0;
    }

	public int difference() {
		return 0;
	}

	public int product() {
		return 0;
	}

	public int divison() {
		return 0;
	}

}
