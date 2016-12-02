package classes;

public class Coupon {

	public enum CouponStatus {
		EXPIRED, ACTIVE, INACTIVE;
	}	
	private String ckey; 			// e.g. CHRISTMAS50
	private float value; 			// say 20
	private boolean isPercentage;	// if true implies it's a 20% off coupon, else a $20 coupon
	private CouponStatus status;
	
	public Coupon(String str, float value, boolean isPercent, CouponStatus status) {
		this.ckey = str;
		this.value = value;
		this.isPercentage = isPercent;
		this.status = status;
	}
	public String getCouponKey() {
		return ckey;
	}
	public float getCouponValue() {
		return value;
	}
	public boolean isPercentageOffer() {
		return isPercentage;
	}
	public void setCouponStatus(CouponStatus status) {
		this.status = status;
	}
	public CouponStatus getCouponStatus() {
		return this.status;
	}
}
