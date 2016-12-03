package modules;

import java.util.ArrayList;
import java.util.List;

import classes.PurchaseOrder;

/**
 * Singleton Shipping that will act as an adapter between Fulfillment & SS (to be implemented by SS).
 */
public final class Shipping {

	/**
	 * 
	 */
	private Shipping () {
		
	}

	private static Shipping mShipping;
	public static Shipping getInstance() {
		
		if(mShipping == null) {
			synchronized (Shipping.class) {
				if(mShipping == null) 
					mShipping = new Shipping();
			}
		}
		return mShipping;
	}
	public List<IShippingMethod> getShippingOptions(PurchaseOrder po) {
		List<IShippingMethod> shippingOptions = new ArrayList<IShippingMethod>();
		return shippingOptions;
	}
}
