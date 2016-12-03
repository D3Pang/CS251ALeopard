/**
 * 
 */
package modules;

import values.Currency;
import values.Money;

/**
 *
 */
public class ShippingMethod implements IShippingMethod {

	private Money cost;
	private ShippingSpeed speed;
	
	public ShippingMethod(double cost, ShippingSpeed speed) {
		this.cost = new Money(cost, Currency.USD);
		this.speed = speed;
	}

	/* (non-Javadoc)
	 * @see modules.IShippingMethod#speed()
	 */
	public ShippingSpeed speed() {
		// TODO Auto-generated method stub
		return speed;
	}

	/* (non-Javadoc)
	 * @see modules.IShippingMethod#shippingCost()
	 */
	public Money shippingCost() {
		// TODO Auto-generated method stub
		return cost;
	}

}
