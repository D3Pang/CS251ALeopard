/**
 * 
 */
package modules;

import values.Money;

/**
 * @author vikram
 *
 */
public interface IShippingMethod {
	ShippingSpeed speed();
	Money shippingCost();
}
