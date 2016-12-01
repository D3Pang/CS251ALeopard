package values;

import factories.IAddress;

public class Address implements IAddress {
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String province;
	private int postalCode;
	private String country;
	
	public Address(String addressLine1, String addressLine2, String city, String province, int postalCode, String country) {
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
		this.country = country;
	}

	public String getLine1() {
		// TODO Auto-generated method stub
		return addressLine1;
	}

	public String getLine2() {
		// TODO Auto-generated method stub
		return addressLine2;
	}

	public String getCity() {
		// TODO Auto-generated method stub
		return city;
	}

	public String getProvince() {
		// TODO Auto-generated method stub
		return province;
	}

	public int getPostalCode() {
		// TODO Auto-generated method stub
		return postalCode;
	}

	public String getCountry() {
		// TODO Auto-generated method stub
		return country;
	}

}
