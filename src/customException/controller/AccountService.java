package customException.controller;

interface AccountService {
	
	void createAccount();
	void transact();
	void deposit(long accountNo, double depositAmount);
	void withdraw(long accountNo, double withdrawAmount);
	void displayBalance(long accountNo);
	void displayAllAccountStats();
}
