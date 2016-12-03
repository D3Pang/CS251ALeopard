package classes;

import modules.ShippingMethod;
import values.Money;

public class Product {
	private String productId;
	private String desc;
	private boolean inStock;
	private float tax;
	private Money price;
	private ShippingMethod shipping;
	
	public Product(String id, String description, boolean status, float tax, Money price, ShippingMethod shipping) {
		productId = id;
		desc = description;
		inStock = status;
		this.tax = tax;
		this.price = price;
		this.shipping = shipping;
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
	public ShippingMethod getShipping() {
		return shipping;
	}
	public void setShipping(ShippingMethod shipping) {
		this.shipping = shipping;
	}
}
