package classes;

import java.util.Set;

public class Cart {
	private Set<Quantity> products;
	
	public Cart(Set<Quantity> products){
		this.products = products;
	}
	
	public void add(Product p, int q){
		products.add(new Quantity(p, q));
	}

	public Set<Quantity> getProducts() {
		return products;
	}
}
