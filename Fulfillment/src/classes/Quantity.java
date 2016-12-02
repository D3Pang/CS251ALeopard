package classes;

class Quantity {
	private Product product;
	private int quantity;
	public Quantity(Product p, int q){
		product = p;
		setQuantity(q);
	}
	
	public Product getProduct(){
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
