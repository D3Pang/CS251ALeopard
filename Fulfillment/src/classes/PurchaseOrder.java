package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import modules.ShippingMethod;
import roles.Recipient;
import values.Currency;
import values.Money;

public class PurchaseOrder {
	private String POID;
	private String invoiceID;
	private String shipmentID;
	private POStatus status;
	private ArrayList<Coupon> coupons = new ArrayList<Coupon>();
	private Cart purchaseCart;
	private Recipient recipient;
	
	public PurchaseOrder(String POId){
		POID = POId;
		invoiceID = "";
		shipmentID = "";
		status = null;
		coupons = new ArrayList<Coupon>();
		purchaseCart = new Cart();
		recipient = new Recipient();
	}
	
	public PurchaseOrder(Cart c){
		purchaseCart = c;
		POID = "";
		invoiceID = "";
		shipmentID = "";
		status = null;
		coupons = new ArrayList<Coupon>();
		
		recipient = new Recipient();
	}
	
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

	public Money calculateTotalCost(){	//	Calculate coupon discounts
		double totalAmount = 0.00;
		ArrayList<Quantity> products = this.purchaseCart.getProducts();
		for(Quantity q: products){
			Product product = q.getProduct();
			double price = product.getPrice().getAmount();
			float tax = product.getTax();
			int quantity = q.getQuantity();
			totalAmount += price * (1 + ((double)tax / 100.0)) * (double)quantity;
			totalAmount += product.getShipping().shippingCost().getAmount();
			
		}
		for(Coupon c : coupons){
			if(c.isPercentageOffer()){
				totalAmount *= (1.0f - c.getCouponValue());
			}
			else{
				totalAmount -= c.getCouponValue();
			}
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

	public List<Product> getProductsInCart() {
		// TODO Auto-generated method stub
		ArrayList<Product> products = new ArrayList<Product>();
		ArrayList<Quantity> p = this.purchaseCart.getProducts();
		for(Quantity q: p){
			products.add(q.getProduct());
		}
		return products;
	}
		
}
