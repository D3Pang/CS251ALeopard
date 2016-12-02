package modules;

import java.util.List;

import classes.Product;
import classes.PurchaseOrder;

public interface IInventory {
	List<Product> getProductListing();	// Browse Inventory
	List<Product> searchProducts(String str); // Search Inventory
	boolean confirmAvailability(PurchaseOrder po); // Confirm Purchase
	void cancelPurchase(PurchaseOrder po); // Cancel Purchase Order
	void fulfillOrder(PurchaseOrder po);	// 	Purchase successful; initiate delivery
}
