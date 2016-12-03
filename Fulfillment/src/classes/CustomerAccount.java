package classes;


import java.util.*;

import references.CreditCard;
import roles.Recipient;
import factories.IAccountFactory;
import factories.IAddress;
import factories.ICreditCard;
import factories.ITelephone;
import modules.Accounting;
import modules.Fulfillment;
import modules.Inventory;

/**
 * 
 */
public class CustomerAccount {

  
	private Fulfillment mFulfillment = Fulfillment.getInstance();
    /**
     * A unique identification for our PFS system to identify an account with
     */
    private String customerID;
    public String getCustomerID() {
    	return customerID;
    }

    /**
     * A unique username that the customer chooses to represent their account. 
     * It can be changed by the customer to another unique username
     */
    private String username;
    public String getUsername() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}

    /**
     * The listed first name that the customer inputs for the account.
     */
    private String firstName;
    
    public String getFirstName() {
		return firstName;
	}
    
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

    /**
     * The listed last name that the customer inputs for the account.
     */
    private String lastName;
    
    public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

    /**
     * The email that the customer registers the account with.
     */
    private String emailID;
    public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

    /**
     * A list of invoice IDs to allow the customer to browse past invoices made on this account.
     */
    private ArrayList<String> invoiceHistory = new ArrayList<String>();
    public ArrayList<String> getInvoiceHistory() {
    	return invoiceHistory;
    }
    public void addInvoice(String invoiceID) {
    	invoiceHistory.add(invoiceID);
    }

    /**
     * The credit card/s that the customer have added to their account.
     */
    private ArrayList<ICreditCard> creditCards = new ArrayList<ICreditCard>();
    public ArrayList<ICreditCard> getcreditCards() {
    	return creditCards;
    }
    public void addCC(ICreditCard card) {
    	creditCards.add(card);
    }
    public void removeCC(int i) {
    	creditCards.remove(i);
    }

    /**
     * The phone number/s that the customer have added to their account.
     */
    private ArrayList<ITelephone> phoneNumbers = new ArrayList<ITelephone>();
    public ArrayList<ITelephone> getphoneNumbers() {
    	return phoneNumbers;
    }
    public void addTelephone(ITelephone phone) {
    	phoneNumbers.add(phone);
    }
    public void removeTelephone(int i) {
    	phoneNumbers.remove(i);
    }

    /**
     * The coupon/s that the customer have added to their account.
     */
    private ArrayList<Coupon> coupons = new ArrayList<Coupon>();
    public ArrayList<Coupon> getCoupons() {
    	return coupons;
    }
    public void addCoupon(Coupon coupon) {
    	coupons.add(coupon);
    }
    public void removeCoupon(int i) {
    	coupons.remove(i);
    }

    /**
     * The purchase order/s that the customer have made on this account.
     */
    private ArrayList<PurchaseOrder> purchaseOrders = new ArrayList<PurchaseOrder>();
    public ArrayList<PurchaseOrder> getpurchaseOrders() {
    	return purchaseOrders;
    }
    public void addPO(PurchaseOrder po) {
    	purchaseOrders.add(po);
    }

    /**
     * The cart of the customer account holds products that the customer has placed into it.
     */
    private Cart shoppingCart;
    public Cart getCart() {
    	return shoppingCart;
    }

    /**
     * The address/es that the customer has added into their account,
     */
    private ArrayList<IAddress> deliveryAddress = new ArrayList<IAddress>();
    public ArrayList<IAddress> getdeliveryAddress() {
    	return deliveryAddress;
    }
    public void addAddress(IAddress address) {
    	deliveryAddress.add(address);
    }
    public void removeAddress(int i) {
    	deliveryAddress.remove(i);
    }
    
    
    private Accounting mAccounting = Accounting.getInstance();
    /**
     * A constructor for CustomerAccount to generate a mock customer account
     */
    public CustomerAccount(String customerID, String username, String firstName, String lastName, String emailID,
    		int number, int cvvNumber, int expMonth, int expYear, 
    		String areaCode, String phoneNumber, String extension, String countryCode,
    		String addressLine1, String addressLine2, String city, String province, int postalCode, String country,
    		IAccountFactory factory) {
    	this.customerID = customerID;
    	this.username = username;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.emailID = emailID;
    	this.creditCards.add(factory.makeCC(number, cvvNumber, expMonth, expYear));
    	this.phoneNumbers.add(factory.makePhoneNumber(areaCode, phoneNumber, extension, countryCode));
    	this.deliveryAddress.add(factory.makeAddress(addressLine1, addressLine2, city, province, postalCode, country));
    }
    
    
    


    /**
     * In this implementation it creates a mock purchase order for testing purposes
     * @return a boolean decision on whether or not the cart is purchased
     */
    public Boolean purchaseCart() {
        	//TODO Need to send a request to IMS to check on products
        	PurchaseOrder po = mFulfillment.generatePurchaseOrder();
        	
        	// When we send PurchaseOrder to Accounting to generate corresponding invoice, it calls the setInvoiceId method on the PurchaseOrder instance
        	po.setInvoiceID("invoice1");
        	po.setShipmentID("shipement1");
        	po.setCoupons(coupons);
        	po.setPurchaseCart(shoppingCart);
        	Recipient recipient = new Recipient();
        	po.setRecipient(recipient);
       
        	return confirmPurchase(po);
    }

    /**
     * This is a mock implementation of the confirmPurchase method
     * Checks with inventory to see if purchase order has the inventory to make it valid,
     * afterwards it shows what the final purchase order will look like. Customer can choose to accept or reject it.
     * @param confirmation or not from the user to accept or reject the purchase.
     * @return a boolean decision on whether or not purchase is to be purchases
     */
    private Boolean confirmPurchase(PurchaseOrder po) {
    	Scanner response = new Scanner(System.in);
    	System.out.println(shoppingCart.getProducts());
		System.out.println(po.calculateTotalCost().toString());
    	if(!po.isCartValid()) {
    		System.out.println("Some items are not available. Would you still like to continue with purchase?");
    		String input = response.nextLine(); 
    		Boolean validResponse = false;
    		while(validResponse == false) {
    		if(input.equalsIgnoreCase("Yes") || input.equalsIgnoreCase("Y")) {
    			//TODO have communication to related systems
    			po.setStatus(POStatus.CONFIRMED);
    			System.out.println("Which creditcard would you like to use?");
    			input = response.nextLine();
    			int cc = Integer.valueOf(input);
    			
    			int ccIndex = 0;
    			
				int cv, month, year;
				System.out.println("What is the cvvNumber?");
				input = response.nextLine();
				cv = Integer.valueOf(input);
				System.out.println("What is the expiration month?");
				input = response.nextLine();
				month = Integer.valueOf(input);
				System.out.println("What is the expiration year?");
				input = response.nextLine();
				year = Integer.valueOf(input);
				ICreditCard card = new CreditCard(cc, cv, month, year, 5000, 10000); //Balance is for just for testing purposes
				
    			if(!creditCards.contains(cc)) {
    				creditCards.add(card);
    				ccIndex = creditCards.indexOf(card);
    			}
    			else {
    				ccIndex = creditCards.indexOf(card);
    			}
    			validResponse = true;
    			String invId = mAccounting.generateInvoice(this.customerID, po);
    			System.out.println(invId);
    			mAccounting.processPayment(invId, creditCards.get(ccIndex));
    			return true;
    			
    			}
    		else if (input.equalsIgnoreCase("No") || input.equalsIgnoreCase("N")) {
    			validResponse = true;
    			po.setStatus(POStatus.CANCELLED);
    			return false;
    			}
    		else{
    			System.out.println("Sorry response not recognized. Please try again.");
    			validResponse = false;
    			return null;
    			}
    		}
    	}
    	return null;
    }

    /**
     * Search the inventory for a specific product
     * @param query the search term to search the inventory for a certain product.
     * @return
     */
    private List<Product> search(String query) {
        Inventory inv = Inventory.getInstance();
		return inv.searchProducts(query);
    }

    /**
     * Browse the inventory of the products it has
     * @return a products available in the inventory
     */
    private List<Product> browse() {
    	Inventory inv = Inventory.getInstance();
    	return inv.getProductListing();
    }

}
