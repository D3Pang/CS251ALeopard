package modules;

import classes.PurchaseOrder;
import factories.ICreditCard;
import roles.ServiceAgent;

public interface IAccounting {
	//  Generates Invoice and returns the invoice id
	public String generateInvoice(String custId, PurchaseOrder po);
	
	public InvoiceStatus getInvoiceStatus(String invoiceId);
	
	//	Once payment is successful, marks the invoice as 'Paid' and stores payment information. Returns true on success, else false.
	public boolean processPayment(String invoiceId, ICreditCard cc);

	//	processes refund. Returns 'true' if process successfully initiated
	public void refundInvoice(String invoiceId, ServiceAgent agent);
}
