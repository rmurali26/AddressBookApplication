package com.reece.entity;

public class Contact {
	private String ContactName;
	private String ContactPhone;
	private AddressBook addressBook;
	
	public Contact(String contactName,String contactPhone) {
		this.ContactName =contactName;
		this.ContactPhone=contactPhone;
	}
	public Contact(String contactName,String contactPhone,AddressBook addressBook) {
		this.ContactName = contactName;
		this.ContactPhone = contactPhone;
		this.addressBook = addressBook;
	}
	
	public String getContactName() {
		return ContactName;
	}
	public void setContactName(String contactName) {
		ContactName = contactName;
	}
	public String getContactPhone() {
		return ContactPhone;
	}
	public void setContactPhone(String contactPhone) {
		ContactPhone = contactPhone;
	}
	public AddressBook getAddressBook() {
		return addressBook;
	}
	public void setAddressBook(AddressBook addressBook) {
		this.addressBook = addressBook;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((ContactName == null) ? 0 : ContactName.hashCode());
		result = prime * result + ((ContactPhone == null) ? 0 : ContactPhone.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
//		if (ContactName == null) {
//			if (other.ContactName != null)
//				return false;
//		} else if (!ContactName.equals(other.ContactName))
//			return false;
		if (ContactPhone == null) {
			if (other.ContactPhone != null)
				return false;
		} else if (!ContactPhone.equals(other.ContactPhone))
			return false;
		return true;
	}
	

}
