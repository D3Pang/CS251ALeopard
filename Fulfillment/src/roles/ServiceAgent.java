package roles;
import java.util.*;

public class ServiceAgent {
	private Person person;
	
	
    public ServiceAgent() {
    	
    }

    private void cancelPO(String POID) {
        PurchaseOrder order = DBUtils.getPO(POID);
    	order.setStatus(POStatus.CANCELLED);
    	DBUtils.savePO(POID);
    }

    private void refundInvoice(String invoiceID) {
    	Invoice invoice = DBUtils.getInvoice(invoiceID);
    	invoice.setStatus(InvoiceStatus.REFUNDED);
    	DBUtils.savePO(invoiceID);
    }

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
    

}