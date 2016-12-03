package classes;

import modules.ShippingMethod;

public class ShippingOption {
	private double cost;
	private ShippingMethod speed;
	
	public ShippingOption(double cost, ShippingMethod speed){
		this.cost = cost;
		this.speed = speed;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public ShippingMethod getSpeed() {
		return speed;
	}

	public void setSpeed(ShippingMethod speed) {
		this.speed = speed;
	}
	
	
}
