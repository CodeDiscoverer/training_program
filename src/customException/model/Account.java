package customException.model;

public class Account {
	
	private long accountNo;
	private String accountHolderName;
	private String accountHolderDOB;
	private String accountHolderNo;
	private String accountPin;
	private double minimumBalanceLimit = 500;
	private double currentBalance;
	
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getAccountHolderDOB() {
		return accountHolderDOB;
	}
	public void setAccountHolderDOB(String accountHolderDOB) {
		this.accountHolderDOB = accountHolderDOB;
	}
	public String getAccountHolderNo() {
		return accountHolderNo;
	}
	public void setAccountHolderNo(String accountHolderNo) {
		this.accountHolderNo = accountHolderNo;
	}
	public String getAccountPin() {
		return accountPin;
	}
	public void setAccountPin(String accountPin) {
		this.accountPin = accountPin;
	}
	public double getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	public double getMinimumBalanceLimit() {
		return minimumBalanceLimit;
	}
	public void setMinimumBalanceLimit(double minimumBalanceLimit) {
		this.minimumBalanceLimit = minimumBalanceLimit;
	}

}
