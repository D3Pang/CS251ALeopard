package classes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Cart {
	private ArrayList<Quantity> products;
	private ArrayList<Product> listProducts;
	
	public String toString() {
		String displayer = "Products:";
		for(Quantity q: products) {
		displayer += " " + q.getProduct().toString() + " Quantity: " + q.getQuantity(); 
		}
		return displayer;
	}
	
	public Cart(){
		this.products = new ArrayList<Quantity>();
		this.listProducts = new ArrayList<Product>();
	}
	
	public Cart(ArrayList<Quantity> products){
		this.products = products;
		for(Quantity q: products){
			listProducts.add(q.getProduct());
		}
	}
	
	public void add(Product p, int q){
		if(!listProducts.contains(p)){
			products.add(new Quantity(p, q));
			listProducts.add(p);
		}
		else{
			int pos = products.indexOf(p);
			int oldQ = products.get(pos).getQuantity();
			products.get(pos).setQuantity(oldQ + q);
		}
	}

	public ArrayList<Quantity> getProducts() {
		return products;
	}

	public ArrayList<Product> getListProducts() {
		return listProducts;
	}
}
