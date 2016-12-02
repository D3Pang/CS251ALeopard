package classes;
import java.util.*;

import values.Money;


public class Invoice {

	

    public Invoice(String invoiceID, CustomerAccount customer, Money amount) {
		super();
		this.invoiceID = invoiceID;
		this.customer = customer;
		this.amount = amount;
		
	}

	private String invoiceID;
	
	private InvoiceStatus status;

    private CustomerAccount customer;

    private Money amount;

	public String getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(String invoiceID) {
		this.invoiceID = invoiceID;
	}

	public CustomerAccount getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerAccount customer) {
		this.customer = customer;
	}

	public Money getAmount() {
		return amount;
	}

	public void setAmount(Money amount) {
		this.amount = amount;
	}

	public InvoiceStatus getStatus() {
		return status;
	}

	public void setStatus(InvoiceStatus status) {
		this.status = status;
	}
    
    

}