package lift.controller;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import lift.model.Lift;

public class LiftServiceController implements LiftService{
	
	int choice, liftId = 1;
	Map<Integer, Lift> lift = new HashMap<>();
	Scanner read = new Scanner(System.in);
	
	public void initial() {
		
		System.out.print("How Many No of Lifts are there...");
		int n = read.nextInt();

		for(int i = liftId; i <= n; i++) {
			lift.put(i, new Lift());
			//System.err.println("Lift No: " + (liftId) + " Lift Current Position: " + lift[liftId].getLiftCurrentFloor());
			liftId++;	
		}
		System.out.println(n + " Lifts Created Successflly!");
	}
	
	public void installLift() {
		try {
			lift.put(liftId, new Lift());
			
			System.out.println("=>Lift No: " + (liftId) + " Lift Current Position: " + lift.get(liftId).getLiftCurrentFloor());
			System.out.println("Lift Created Successflly!");
			liftId++;
		}catch (Exception e) {}
		
	}
	
	public void liftStatus() {
		System.out.println("Lift Status are 👇");
		for(int i = 1; i < liftId; i++) {
			System.out.println("=>Lift No: " + i + " Lift Current Position: " + lift.get(i).getLiftCurrentFloor());
		}
	}
	
	public void moveLift() {
		
		liftStatus(); 
		try {
			System.out.print("Enter the Lift ID: ");
			int liftId = read.nextInt();
			/*
			 * System.out.print("Enter your Floor: "); int liftRequestFloor =
			 * read.nextInt();
			 */
			System.out.print("Enter the Floor want to move: ");
			int liftMoveToFloor = read.nextInt();
			
			//lift[liftId].setLiftRequestFloor(liftRequestFloor);
			lift.get(liftId).setliftDestination(liftMoveToFloor);
			
			moveLift(liftId);
		}catch (InputMismatchException e) {

		}
		
	}
	
	public void moveLift(int liftId) {
		
		//int liftRequestFloor = lift[id].getLiftRequestFloor();
		int liftDestination = lift.get(liftId).getliftDestination();
		int liftCurrentFloor = lift.get(liftId).getLiftCurrentFloor();
		
		if(liftDestination > -1) {
			
			if(liftCurrentFloor < liftDestination) {
				System.out.println("Lift is Moving 👇");	
				for(int i = liftCurrentFloor; i <= liftDestination; i++) {
					System.out.println("=>Lift No: 1" + " Lift is Moving Up... " + i);
				}
				lift.get(liftId).setLiftCurrentFloor(liftDestination);
				System.out.println("Lift Reached: " + lift.get(liftId).getLiftCurrentFloor());
			}
			else if(liftCurrentFloor > liftDestination) {
				System.out.println("Lift is Moving 👇");	
				for(int i = liftCurrentFloor; i >= liftDestination; i--) {
					System.out.println("=>Lift No: 1" + " Lift is Moving Down... " + i);
				}
				lift.get(liftId).setLiftCurrentFloor(liftDestination);
				System.out.println("Lift Reached: " + lift.get(liftId).getLiftCurrentFloor());
			}
			else {
				System.err.println("Same Floor");
			}
			
		}
		else {
			System.err.println("Invalid Floor!");
		}
	}
}
