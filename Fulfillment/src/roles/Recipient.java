package roles;

import factories.ITelephone;

public class Recipient{
	private Person person;
	private ITelephone contactNo;
	public Recipient(Person person, ITelephone contactNo) {
		super();
		this.person = person;
		this.contactNo = contactNo;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public ITelephone getContactNo() {
		return contactNo;
	}
	public void setContactNo(ITelephone contactNo) {
		this.contactNo = contactNo;
	}
	
	
}
