package HMS;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TimeConverter {
	
	int hour;
	int minutes;
	long seconds;
	
	class Time {
		
		Scanner read = new Scanner(System.in);
		
		void getTime(TimeConverter tc) {
			
			while(true) {
				try {
					System.out.print("Enter the Hours: ");
					int hour = read.nextInt();
					if(!(hour > 0 && hour < 24)) {
						throw new Exception("Invalid Hour!");
					}
					
					System.out.print("Enter the Minutes: ");
					int minutes = read.nextInt();
					if(!(minutes > 0 && minutes < 60)) {
						throw new Exception("Invalid Minutes!");
					}
					
					tc.hour = hour;
					tc.minutes = minutes;
					tc.secondsConverter();
					break;
					
				} catch (InputMismatchException e) {
					System.err.println("Invalid Input");
					read.next();
				} catch (Exception e) {
					System.err.println(e.getMessage());
				} finally {
					System.err.println("Thank you! Visit again...");
				}
			}
		}
	}
	
	void secondsConverter() {
		
		System.out.println("The Seconds are " + ((hour * 60) + minutes) * 60);
		
	}

}
