package UserAddress;

import java.util.InputMismatchException;
import java.util.Scanner;

public class User {
	
	public String address;
	public int pincode;
	
	class Address {
		
		Scanner read = new Scanner(System.in);
		
		void getAddressValidation() {
			
            System.out.print("Enter your Address: ");
            address = read.nextLine();
            
            while(true) {
            	
            	try {
            		System.out.print("Enter your Pincode: ");
                    pincode = read.nextInt();
                    
                    if(validation(pincode)) {
                        System.out.println("Your Address is Perfect!");
                        System.out.println("Address: " + address + " ,\nPincode: " + pincode) ;
                        break;
                    }
                    else {
                        read.nextLine();
                        continue;        
                    }
            	}catch(InputMismatchException e) {
            		System.err.println("Invalid Pincode...\n");
            		read.next();
            	}
            	
            }
        }
        
    }
    
    boolean validation(Integer pincode) {
    	
        String receivedPincode = pincode.toString();
        
        try {
            if(receivedPincode.length() < 6 || receivedPincode.length() > 6) {
                throw new Exception("Invalid Pincode!\n");
            }
            else {
                return true;
            }
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
	}
}
