package values;

public class Money implements Comparable<Money> {

	private double amount;
	private Currency currency;
	public Money(double amt, Currency curr){
		amount = amt;
		currency = curr;
	}
	public double getAmount() {
		return amount;
	}
	public String toString() {
		return "Money["+Double.toString(amount)+" "+currency.toString()+"]";
	}
	
	public int compareTo(Money o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
