package com.reece.entity;

import java.util.Set;

public class AddressBook {
	
	private String addressBookName;
	
	public AddressBook(String addressBookName) {
		this.addressBookName =addressBookName;
	}

	
	public String getAddressBookName() {
		return addressBookName;
	}
	public void setAddressBookName(String addressBookName) {
		this.addressBookName = addressBookName;
	}

	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressBookName == null) ? 0 : addressBookName.hashCode());
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
		AddressBook other = (AddressBook) obj;
		if (addressBookName == null) {
			if (other.addressBookName != null)
				return false;
		} else if (!addressBookName.equals(other.addressBookName))
			return false;
		return true;
	}
	
}
