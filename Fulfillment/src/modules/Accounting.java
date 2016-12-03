package modules;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.activity.InvalidActivityException;

import classes.PurchaseOrder;
import factories.ICreditCard;
import references.CreditCard;
import roles.ServiceAgent;


public class Accounting implements IAccounting {

	private static Accounting mAccounting;
	private long invoiceIdIndex = 0;
	private Set<Invoice> invoiceMaster = new HashSet<Invoice>();
	public static Accounting getInstance() {
		
		if(mAccounting == null) {
			synchronized (Accounting.class) {
				if(mAccounting == null) { 
					mAccounting = new Accounting();
				}
			}
		}
		return mAccounting;
	}

	/* (non-Javadoc)
	 * @see modules.IAccounting#generateInvoice(java.lang.String, classes.PurchaseOrder)
	 */
	public String generateInvoice(String custId, PurchaseOrder po) {

		Invoice inv = createInvoice(custId, po);
		/* 
		* Do required operations on invoice
		*/
		inv.setStatus(InvoiceStatus.PENDING);
		return inv.getInvoiceID();
	}

	/* (non-Javadoc)
	 * @see modules.IAccounting#getInvoiceStatus(java.lang.String)
	 */
	public InvoiceStatus getInvoiceStatus(String invoiceId) {
		return getInvoiceById(invoiceId).getStatus();
	}

	/* (non-Javadoc)
	 * @see modules.IAccounting#updateInvoice(java.lang.String, references.CreditCard)
	 */
	public boolean processPayment(String invoiceId, ICreditCard cc) {
		// Charge creditcard if successful mark the invoice as paid
		Invoice inv = getInvoiceById(invoiceId);
		if(inv != null){
			if(this.chargeCard(cc, inv.getAmount().getAmount())){
				inv.setStatus(InvoiceStatus.PAID);
				return true;
			}
			else return false;
		}
		throw new NoSuchElementException("Invoice not found!");
	}
	
	/* (non-Javadoc)
	 * @see modules.IAccounting#refundInvoice(java.lang.String)
	 */
	public void refundInvoice(String invoiceId, ServiceAgent agent) {
		
		if(agent instanceof ServiceAgent) {
			// process refund
			Invoice inv = getInvoiceById(invoiceId);
			if(inv != null){
				inv.setStatus(InvoiceStatus.REFUNDED);
				return;
			}
			throw new NoSuchElementException("Invoice not found!");
		}
		//	Ensures that Only System Agents can initiate invoice refund
		//throw new InvalidActivityException("Only System Agents can initiate invoice refund");
	}
	private Invoice createInvoice(String customerId, PurchaseOrder po) {
		String newInvoiceId = "INV"+Long.toString(++invoiceIdIndex);
		Invoice invoice = new Invoice(newInvoiceId, customerId, po); 
		invoiceMaster.add(invoice);
		return invoice;
	}
	private Invoice getInvoiceById(String invoiceId) {
		for(Invoice invoice : invoiceMaster) {
			if(invoice.getInvoiceID() == invoiceId) return invoice;
		}
		return null;
	}
	
	private boolean chargeCard(ICreditCard c, double amount){
		return c.getBalance() + amount < c.getMaxBalance();
	}
}
