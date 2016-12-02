package classes;

import values.Money;

public class Product {
<<<<<<< HEAD
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
	public boolean isInStock() {
		return inStock;
	}
	public void setInStockStatus(boolean status) {
		inStock = status;
	}

	public String getProductId() {
		return productId;
	}
	public String getProductDesc() {
		return desc;
	}
	public Money getPrice() {
		return price;
	}
=======
	private boolean inStock;
	private String productID;
	private String desc;
	private float tax, price;
	
	public Product(boolean inStock, String productID, String desc, float tax,
			float price) {
		super();
		this.inStock = inStock;
		this.productID = productID;
		this.desc = desc;
		this.tax = tax;
		this.price = price;
	}
	
	public boolean getInStock(){
		return this.inStock;
	}
	
	public float getPrice(){
		return price + tax;
	}

	public String getProductID() {
		return productID;
	}

	public String getDesc() {
		return desc;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
	
	
>>>>>>> refs/remotes/origin/implementation_fvescio
}
