package modules;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import classes.POStatus;
import classes.PurchaseOrder;
import factories.ICreditCard;


public class Fulfillment {

	private static Fulfillment mFulfillment;
	private long POIdIndex = 0;
	private Set<PurchaseOrder> POMaster = new HashSet<PurchaseOrder>();
	public static Fulfillment getInstance() {
		
		if(mFulfillment == null) {
			synchronized (Fulfillment.class) {
				if(mFulfillment == null) { 
					mFulfillment = new Fulfillment();
				}
			}
		}
		return mFulfillment;
	}

	public PurchaseOrder generatePurchaseOrder() {

		PurchaseOrder po = createPurchaseOrder();
		/* 
		* Do required operations on purchaseOrder
		*/
		po.setStatus(POStatus.QUERY);
		return po;
	}
	private PurchaseOrder createPurchaseOrder() {
		String newPOId = "PO"+Long.toString(++POIdIndex);
		PurchaseOrder po = new PurchaseOrder(newPOId); 
		POMaster.add(po);
		return po;
	}
	public PurchaseOrder getPurchaseOrderById(String POId) {
		for(PurchaseOrder po : POMaster) {
			if(po.getPOID() == POId) return po;
		}
		return null;
	}
}
