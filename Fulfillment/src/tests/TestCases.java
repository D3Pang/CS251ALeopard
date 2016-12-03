package tests;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import modules.Inventory;

import org.junit.Test;

import values.Currency;
import values.Money;
import classes.Cart;
import classes.CustomerAccount;
import classes.Product;
import classes.PurchaseOrder;
import classes.Quantity;
import factories.AccountFactory;
import factories.IAccountFactory;

public class TestCases {
	private Product nails = new Product("01", "Nails", true, 2, new Money(2.00, Currency.USD));
	private Product coffee = new Product("02", "Coffee", true, 2, new Money(3.00, Currency.USD));
	private Product invalid = new Product("00", "Invalid", false, 0, new Money(-1.0, Currency.USD));
	
	@Test
	public void testAddToCart() {
		Cart cart = new Cart();
		cart.add(nails, 1);
		assertEquals(true, cart.getListProducts().contains(nails));
	}
	
	@Test
	public void testCalculateCartTotal(){
		Cart cart = new Cart();
		cart.add(nails, 1);
		cart.add(coffee, 2);
		PurchaseOrder po = new PurchaseOrder(cart);
		Money expected = new Money(8.16, Currency.USD);
		assertEquals(expected.getAmount(), po.calculateTotalCost().getAmount(), 0.1);
	}
	
	@Test
	public void testFindInvalidCart(){
		Cart cart = new Cart();
		cart.add(invalid, 1);
		PurchaseOrder po = new PurchaseOrder(cart);
		assertEquals(false, po.isCartValid());
	}
	
	@Test
	public void testAccount() {
		Product nails = new Product("01", "Nails", true, 2, new Money(2.00, Currency.USD));
		IAccountFactory factory = new AccountFactory();
		CustomerAccount acc = new CustomerAccount("cusID", "username", "first", "last", "email", 11, 22, 33, 44, "area", "phone", "ext", "country", 
				"line1", "line2", "city", "province", 123, "country", factory);
		System.out.println("Account Created");
		//Add an item here
		System.out.println("Stop");
		acc.getCart().add(nails, 1);
		System.out.println("Second");
		acc.purchaseCart();////////////////
		System.out.println("Third");
		System.out.println("Cart purchased");
	}

}
