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
	public Money addTax(float tax) {
		return new Money(amount+(amount*tax)/100, currency);
	}
	public Money add(Money other) {
		return new Money(other.getAmount() + amount, currency);
	}
	public Money subtract(Money other) {
		return new Money(other.getAmount() - amount, currency);
	}
	public Money multiply(double factor) {
		return new Money(amount * factor, currency);
	}
	public Money divide(double factor) {
		return new Money(amount * factor, currency);
	}
	public int compareTo(Money other) {
		if(this.amount < other.getAmount()) return -1;
		if(this.amount > other.getAmount()) return 1;
		return 0;
	}
	
}
