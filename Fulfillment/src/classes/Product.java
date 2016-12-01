package classes;

public class Product {
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
	
	
}
