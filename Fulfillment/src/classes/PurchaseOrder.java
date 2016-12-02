package classes;

import java.util.ArrayList;
import java.util.Set;

import roles.Recipient;
import values.Currency;
import values.Money;

public class PurchaseOrder {
	private String POID;
	private String invoiceID;
	private String shipmentID;
	private POStatus status;
	private ArrayList<Coupon> coupons;
	private Cart purchaseCart;
	private Recipient recipient;
	
	public PurchaseOrder(String pOID, String invoiceID, String shipmentID,
			POStatus status, ArrayList<Coupon> coupons,
			 Cart purchaseCart,
			Recipient recipient) {
		POID = pOID;
		this.invoiceID = invoiceID;
		this.shipmentID = shipmentID;
		this.status = status;
		this.coupons = coupons;
		this.purchaseCart = purchaseCart;
		this.recipient = recipient;
	}

	public String getPOID() {
		return POID;
	}

	public void setPOID(String pOID) {
		POID = pOID;
	}

	public String getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(String invoiceID) {
		this.invoiceID = invoiceID;
	}

	public String getShipmentID() {
		return shipmentID;
	}

	public void setShipmentID(String shipmentID) {
		this.shipmentID = shipmentID;
	}

	public POStatus getStatus() {
		return status;
	}

	public void setStatus(POStatus status) {
		this.status = status;
	}

	public ArrayList<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(ArrayList<Coupon> coupons) {
		this.coupons = coupons;
	}

	public Cart getPurchaseCart() {
		return purchaseCart;
	}

	public void setPurchaseCart(Cart purchaseCart) {
		this.purchaseCart = purchaseCart;
	}

	public Recipient getRecipient() {
		return recipient;
	}

	public void setRecipient(Recipient recipient) {
		this.recipient = recipient;
	}

	public Money calculateTotalCost(){
		double totalAmount = 0.00;
		Set<Quantity> products = this.purchaseCart.getProducts();
		for(Quantity q: products){
			Product product = q.getProduct();
			double price = product.getPrice().getAmount();
			float tax = product.getTax();
			int quantity = q.getQuantity();
			totalAmount += price + (price * tax / 100) * quantity;
		}
		return new Money(totalAmount, Currency.USD);
	}
	
	public boolean isCartValid()
	{
		boolean isValid = true;
		for(Quantity q: this.purchaseCart.getProducts()){
			if(!q.getProduct().isInStock()){
				isValid = false; 
				break;
			}
		}
		return isValid;
	}
		
}
