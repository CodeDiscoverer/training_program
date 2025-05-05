package customException.controller;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import customException.model.Account;
import customException.view.AccountView;


public class AccountServiceController implements AccountService{
	
	Scanner read = new Scanner(System.in);
	
	Map<Long, Account> account = new HashMap<>();
	Map<String, Long> accountExist = new HashMap<>();
	AccountView page = new AccountView();
	long accountNoSerial = 202504001;

	@Override
	public void createAccount() {
		
		System.out.print("Enter Your Name: ");
		String name = read.nextLine();
		System.out.print("Enter Your Date of Birth: ");
		String dob = read.nextLine();
		System.out.print("Enter Your Number: ");
		String number = read.nextLine();
		System.out.print("Enter Your PIN: ");
		String pin = read.nextLine();
		
		if(accountExist.get(number) == null) {
			accountExist.put(number, accountNoSerial);
			account.put(accountNoSerial, new Account());
			
			account.get(accountNoSerial).setAccountHolderName(name);
			account.get(accountNoSerial).setAccountHolderDOB(dob);
			account.get(accountNoSerial).setAccountHolderNo(number);
			account.get(accountNoSerial).setAccountPin(pin);
			account.get(accountNoSerial).setAccountNo(accountNoSerial);
			
			System.out.println("Account Created Successfully!");
			System.out.println("Account No: " + accountNoSerial);
			accountNoSerial++;
			
		}else {
			System.err.println("User Already Exist!");
		}
		
	}

	@Override
	public void deposit(long accountNo, double depositAmount) {
		try {
			if(depositAmount >= 0) {
				double balance = account.get(accountNo).getCurrentBalance();
				
				balance += depositAmount;
				
				account.get(accountNo).setCurrentBalance(balance);
			}
			else {
				throw new Exception("Deposit Amount Can't be 0 or Minus Value");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
		}
	}

	@Override
	public void withdraw(long accountNumber, double withdrawAmount) {
		
		double currentBalance = account.get(accountNumber).getCurrentBalance();
		double minimumLimit =  account.get(accountNumber).getMinimumBalanceLimit();
		try {
			if((currentBalance > withdrawAmount) && (minimumLimit >= (currentBalance-withdrawAmount)) ) {
				throw new Exception("Transaction Declined! Insufficient Balance");
			}
			else {
				System.out.print("Enter your PIN: ");
				String enteredPIN = read.next();
				String pin = account.get(accountNumber).getAccountPin();
				
				if(enteredPIN.equals(pin)) {
					account.get(accountNumber).setCurrentBalance(currentBalance-withdrawAmount);
					System.out.println("Transaction Successfully Completed!");
				}
				else {
					throw new Exception("Transaction Declined! Incorrect PIN");
				}
			}
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		
	}

	@Override
	public void displayBalance(long accountNumber) {
		
		try {
			
			System.out.println(
			"Welcome " + account.get(accountNumber).getAccountHolderName()+ 
			" | Balance: " + account.get(accountNumber).getCurrentBalance());
			
		}catch(Exception e) {
			displayBalance(accountNumber);
		}
	}

	@Override
	public void displayAllAccountStats() {
		
		System.out.println("Account Lists are 👇");
		for(long i = 202504001; i < accountNoSerial; i++) {
			System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println(
					"Account No: " + i +
					"\nAccount Balance : " + account.get(i).getCurrentBalance() +
					"\nAccount Holder Name: " + account.get(i).getAccountHolderName() + 
					"\nAccount Holder DOB: " + account.get(i).getAccountHolderDOB() +
					"\nAccount Holder Number: " + account.get(i).getAccountHolderNo()
					);
		}
	}

	@Override
	public void transact() {
		
		try {
			System.out.print("Enter Account No: ");
			long accountNumber = read.nextLong();
			
			if(account.get(accountNumber) != null) {
				try {
					int choice1;
					
					do {
						System.out.print("\n1. Deposit\n2. Withdraw\n3. Check Balance\nPress 0 to Exit\nEnter your choice: ");
						choice1 = read.nextInt();
						
						if(choice1 == 1) {
							System.out.print("Enter the amount to Deposit: ");
							double amount = read.nextDouble();
							deposit(accountNumber, amount);
						}
						else if(choice1 == 2) {
							System.out.print("Enter the amount to Withdraw: ");
							double amount = read.nextDouble();
							withdraw(accountNumber, amount);
						}
						else if(choice1 == 3) {
							displayBalance(accountNumber);
						}
						else {
							System.err.println("Invalid Choice...");
						}
						
					}while(choice1 != 0);
					
				}catch (InputMismatchException e) {
					transact();
				}catch (Exception e) {
					transact();
				}
			}
			else {
				throw new Exception("Oops! Account Not Found...");
			}
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	
}
