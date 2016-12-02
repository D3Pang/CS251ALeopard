package factories;

public interface IAccountFactory {
  IAddress makeAddress(String addressLine1, String addressLine2, String city, String province, int postalCode, String country);
  ICreditCard makeCC(int number, int cvvNumber, int expMonth, int expYear);
  ITelephone makePhoneNumber(String areaCode, String number, String extension, String countryCode);
}