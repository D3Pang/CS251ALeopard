package classes;

import java.util.HashMap;
import java.util.Set;

public class Cart {
	private HashMap<Product, Integer> products;
	
	public Cart(HashMap<Product, Integer> products){
		this.products = products;
	}
	
	public Set<Product> getProducts(){
		return this.products.keySet();
	}
	
	public HashMap<Product, Integer> getProductsAndQuantities(){
		return this.products;
	}
	
	public void addItem(Product p){
		if(products.containsKey(p)){
			Integer q = products.get(p);
			q++;
		}
		else this.products.put(p, 1);
	}
	
	public void addQuantity(Product p, int q){
		if(products.containsKey(p)){
			Integer qu = products.get(p);
			qu += q;
		}
		else this.products.put(p, q);
	}
	
	public boolean removeItem(Product p){
		Integer removed = products.remove(p);
		return !(removed.equals(null));
	}
	
	public boolean removeQuantity(Product p, int q){
		if(products.containsKey(p)){
			Integer qu = products.get(p);
			qu -= q;
			if(qu <= 0) removeItem(p);
			return true;
		}
		else return false;
	}
}
