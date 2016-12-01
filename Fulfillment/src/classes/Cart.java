package classes;

import java.util.HashMap;
import java.util.Set;

public class Cart {
	private HashMap<Product, Integer> products;
	
	public Set<Product> getProducts(){
		return this.products.keySet();
	}
}
