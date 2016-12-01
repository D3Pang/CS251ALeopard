package values;

import factories.ITelephone;

public class Telephone implements ITelephone {
	private String areaCode;
	private String number;
	private String extension;
	private String countryCode;
	
	public Telephone(String areaCode, String number, String extension, String countryCode) {
		this.areaCode = areaCode;
		this.number = number;
		this.extension = extension;
		this.countryCode = countryCode;
	}
	
	public String getAreaCode() {
		return areaCode;
	}
	public String getNumber() {
		return number;
	}
	public String getExtension() {
		return extension;
	}
	public String getCountryCode() {
		return countryCode;
	}

}
