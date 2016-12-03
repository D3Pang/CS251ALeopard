package references;

import factories.ICreditCard;

public class CreditCard implements ICreditCard{
	private int number;
	private int cvvNumber;
	private int expMonth;
	private int expYear;
	private double balance;
	private double maxBalance;
	
	public CreditCard(int number, int cvvNumber, int expMonth, int expYear, double balance, double maxBalance) {
		this.number = number;
		this.cvvNumber = cvvNumber;
		this.expMonth = expMonth;
		this.expYear = expYear;
		this.balance = balance;
		this.maxBalance = maxBalance;
	}

	public int getNumber() {
		return number;
	}

	public int getCvvNumber() {
		return cvvNumber;
	}

	public int getExpMonth() {
		return expMonth;
	}

	public int getExpYear() {
		return expYear;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public double getMaxBalance(){
		return maxBalance;
	}

}
