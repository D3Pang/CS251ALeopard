package modules;

import java.util.ArrayList;
import java.util.List;

import classes.Product;
import classes.PurchaseOrder;
import values.Money;
import values.Currency;
/**
 * @author Vikram
 * Singleton Inventory that will act as an adapter between Fulfillment & IMS (to be implemented by IMS).
 */
public final class Inventory {

	private int index = 0;
	private static final int PAGE_SIZE = 10;
	private List<Product> products;
	/**
	 * 
	 */
	private Inventory() {
		products.add(new Product("p001", "Android phone", true, (float) 7.5, new Money(799, Currency.USD)));
		products.add(new Product("p002", "Apple iPhone", true, (float) 7.5, new Money(499, Currency.USD)));
		products.add(new Product("p003", "Dell laptop", true, (float) 7.5, new Money(749, Currency.USD)));
		products.add(new Product("p004", "Blackberry", true, (float) 7.5, new Money(399, Currency.USD)));
		products.add(new Product("p005", "Amazon Kindle Fire", true, (float) 7.5, new Money(59.99, Currency.USD)));
		products.add(new Product("p006", "Apple TV", true, (float) 7.5, new Money(199.99, Currency.USD)));
		products.add(new Product("p007", "Chromecast", true, (float) 7.5, new Money(25.99, Currency.USD)));
		products.add(new Product("p008", "Android phone", true, (float) 7.5, new Money(799, Currency.USD)));
		products.add(new Product("p009", "Hershey's Chocolates", true, (float) 2.5, new Money(29.99, Currency.USD)));
		products.add(new Product("p009", "Ghirardelli Gift Box", true, (float) 2.5, new Money(69.99, Currency.USD)));
	}
	private static Inventory mInventory;
	public static Inventory getInstance() {
		
		if(mInventory == null) {
			synchronized (Inventory.class) {
				if(mInventory == null) 
					mInventory = new Inventory();
			}
		}
		return mInventory;
	}
	/**
	 * index and PAGE SIZE help in paginating the product listing so that the entire inventory 
	 * need not be sent over to Fulfillment.
	 * 
	 * @return a list of items
	 */
	public List<Product> getProductListing(int index) {	//	BROWSE INVENTORY
		return products.subList(index, PAGE_SIZE);
	}
	// Function overloading is done so that passing index value can be optional
	public List<Product> getProductListing() {	//	BROWSE INVENTORY
		return getProductListing(0);
	}
	
	public List<Product> searchProducts(String str) { // SEARCH INVENTORY
		List<Product> matches = new ArrayList<Product>();
		for(Product product : products) {
			if(product.getProductDesc().contains(str)){
				matches.add(product);
			}
		}
		return matches;
	}
	public boolean confirmAvailability(PurchaseOrder po) {
		List<Product> cart = po.getProductsInCart();
		for(Product product : cart) {
			if(!product.isInStock()) {
				return false;
			}
		}
		return true;
	}
	public void cancelPurchase(PurchaseOrder po) {
		// TODO: cancel purchase and return item(s) back to warehouse
	}

	public void fulfillOrder(PurchaseOrder po) {
		// TODO: Updates inventory (if required) and initiate fulfillment and delivery
	}
	
}
