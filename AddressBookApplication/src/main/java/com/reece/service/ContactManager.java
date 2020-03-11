package com.reece.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.reece.entity.Contact;

public interface ContactManager {

	public Contact addContact(String contactName,String contactPhone,String AddressBookName) ;
	public void removeContactFromAddressBook(String contactName,String contactPhone,String addressBookName);
	public Set<Contact> getAddressBookContacts(String addressBookName);
	public void printAddressbookContacts(String addressBookName);
	public Set<Contact> getUniqueContacts();
	public void printUniqueContacts();
	
}
