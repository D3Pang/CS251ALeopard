package tests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import modules.Inventory;

import org.junit.Test;

import values.Currency;
import values.Money;
import classes.Cart;
import classes.Product;
import classes.PurchaseOrder;
import classes.Quantity;

public class TestCases {
	private Product nails = new Product("01", "Nails", true, 2, new Money(2.0, Currency.USD));
	private Product coffee = new Product("02", "Coffee", true, 2, new Money(3.0, Currency.USD));
	private Product invalid = new Product("00", "Invalid", false, 0, new Money(-1.0, Currency.USD));
	
	@Test
	public void testAddToCart() {
		Cart cart = new Cart();
		cart.add(nails, 1);
		assertEquals(true, cart.getProducts().contains(nails));
	}
	
	@Test
	public void testCalculateCartTotal(){
		Cart cart = new Cart();
		cart.add(nails, 1);
		cart.add(coffee, 2);
		PurchaseOrder po = new PurchaseOrder(cart);
		assertEquals(new Money(8.0, Currency.USD), po.calculateTotalCost());
	}
	
	@Test
	public void testFindInvalidCart(){
		Cart cart = new Cart();
		cart.add(invalid, 1);
		PurchaseOrder po = new PurchaseOrder(cart);
		assertEquals(false, po.isCartValid());
	}

}