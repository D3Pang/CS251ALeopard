package values;

public class Currency {
	public static Currency USD = new Currency("US Dollars", "$", "USA", "USD");
	private String name;
	private String symbol;
	private String country;
	private String ISOCode;
	public Currency(String name, String sym, String country, String iso) {
		this.name = name;
		this.symbol = sym;
		this.country = country;
		ISOCode = iso;
	}
	public String toString() {
		return ISOCode;
	}
	
}
