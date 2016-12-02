package factories;

import values.Address;
import values.Telephone;

public class AccountFactory implements IAccountFactory {

 //   public AccountFactory() {
 //   }

 //   private Telephone phoneNumber;

//    private Address address;

    /**
     * 
     */
    public class CreditCard implements ICreditCard {

        /**
         * 
         */
        public CreditCard(int number, int cvvNumber, int expMonth, int expYear) {
        	this.number = number;
        	this.cvvNumber = cvvNumber;
        	this.expMonth = expMonth;
        	this.expYear = expYear;
        }

        /**
         * 
         */
        private int number;

        /**
         * 
         */
        private int cvvNumber;

        /**
         * 
         */
        private int expMonth;

        /**
         * 
         */
        private int expYear;

		public int getNumber() {
			return number;
		}

		public int getCvvNumber() {
			return cvvNumber;
		}

		public int getExpMonth() {
			return expMonth;
		}

		public int getExpYear() {
			return expYear;
		}

    }

	public IAddress makeAddress(String addressLine1, String addressLine2,
			String city, String province, int postalCode, String country) {
		return new Address( addressLine1, addressLine2, city, province, postalCode, country);
	}

	public ICreditCard makeCC(int number, int cvvNumber, int expMonth,
			int expYear) {
		return new CreditCard(number, cvvNumber, expMonth, expYear);
	}

	public ITelephone makePhoneNumber(String areaCode, String number,
			String extension, String contryCode) {
		return new Telephone(areaCode, number, extension, contryCode);
	}
}