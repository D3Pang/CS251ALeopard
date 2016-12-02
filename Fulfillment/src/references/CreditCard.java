package references;

import factories.ICreditCard;

public class CreditCard implements ICreditCard{
	private int number;
	private int cvvNumber;
	private int expMonth;
	private int expYear;
	
	public CreditCard(int number, int cvvNumber, int expMonth, int expYear) {
		this.number = number;
		this.cvvNumber = cvvNumber;
		this.expMonth = expMonth;
		this.expYear = expYear;
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

}
