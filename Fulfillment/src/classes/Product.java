package classes;

import values.Money;

public class Product {
	private String productId;
	private String desc;
	private boolean inStock;
	private float tax;
	private Money price;
	
	public Product(String id, String description, boolean status, float tax, Money price) {
		productId = id;
		desc = description;
		inStock = status;
		this.tax = tax;
		this.price = price;
	}
	public String toString() {
		return "Product[id="+productId+", info="+desc+", tax="+Float.toString(tax)+", price="+price.toString()+"]";
	}
	public String getProductId() {
		return productId;
	}
	public String getProductDesc() {
		return desc;
	}
	public Money getPrice(){
		//return price.addTax(tax);
		return price;
	}
	public float getTax() {
		return tax;
	}
	public boolean isInStock() {
		return inStock;
	}
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
}
