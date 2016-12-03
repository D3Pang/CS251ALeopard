package modules;

import values.Money;

/**
 *
 */
public interface IShippingMethod {
	ShippingSpeed speed();
	Money shippingCost();
}
