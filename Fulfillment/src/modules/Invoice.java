package modules;
import classes.PurchaseOrder;
import values.Money;


public class Invoice {

	

    public Invoice(String invoiceID, String custAccId, PurchaseOrder po) {
		super();
		this.invoiceID = invoiceID;
		this.custAccountId = custAccId;
		this.associatedPO = po;
		
	}

	private String invoiceID;
	
	private InvoiceStatus status;

    private String custAccountId;

    private PurchaseOrder associatedPO;

	public String getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(String invoiceID) {
		this.invoiceID = invoiceID;
	}

	// Removed setCustomer since the customer is set in the constructor when the invoice is created and cannot be changed later.
	public String getCustomerAccountId() {
		return custAccountId;
	}
	public Money getAmount() {
		return associatedPO.calculateTotalCost();
	}

	public InvoiceStatus getStatus() {
		return status;
	}
	//	Only Accounting is allowed to change status of an invoice.
	void setStatus(InvoiceStatus status) {
		this.status = status;
	}
    
    

}