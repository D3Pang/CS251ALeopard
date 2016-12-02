package classes;

import java.util.ArrayList;
import java.util.HashMap;

import roles.Recipient;
import values.Money;

public class PurchaseOrder {
	private String POID;
	private String invoiceID;
	private String shipmentID;
	private POStatus status;
	private ArrayList<Coupon> coupons;
	private ArrayList<ShippingMethod> shippingOptions;
	private Cart purchaseCart;
	private Recipient recipient;
	
	public PurchaseOrder(String pOID, String invoiceID, String shipmentID,
			POStatus status, ArrayList<Coupon> coupons,
			ArrayList<ShippingMethod> shippingOptions, Cart purchaseCart,
			Recipient recipient) {
		POID = pOID;
		this.invoiceID = invoiceID;
		this.shipmentID = shipmentID;
		this.status = status;
		this.coupons = coupons;
		this.shippingOptions = shippingOptions;
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

	public ArrayList<ShippingMethod> getShippingOptions() {
		return shippingOptions;
	}

	public void setShippingOptions(ArrayList<ShippingMethod> shippingOptions) {
		this.shippingOptions = shippingOptions;
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

	public float calculateTotalCost(){
		float total = 0.0f;
		HashMap<Product, Integer> products = this.purchaseCart.getProductsAndQuantities();
		for(Product p: products.keySet()){
			total += p.getPrice() * (float)products.get(p);
		}
		return total;
	}
	
	public boolean isCartValid()
	{
		boolean isValid = true;
		for(Product p: this.purchaseCart.getProducts()){
			if(!p.getInStock()){
				isValid = false; 
				break;
			}
		}
		return isValid;
	}
		
}
