package roles;
import classes.POStatus;
import classes.PurchaseOrder;
import modules.Accounting;
import modules.Fulfillment;

public class ServiceAgent {
	private Person person;
	
	private Accounting mAccounting;
	private Fulfillment mFulfillment;

	public ServiceAgent() {
    	mAccounting = Accounting.getInstance();
    	mFulfillment = Fulfillment.getInstance();
    }

    private void cancelPO(String POID) {
        PurchaseOrder order = mFulfillment.getPurchaseOrderById(POID);
    	order.setStatus(POStatus.CANCELLED);
    }

    private void refundInvoice(String invoiceID) {
    	mAccounting.refundInvoice(invoiceID, this);
    }

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
   
}