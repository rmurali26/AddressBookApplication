package com.reece.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.reece.entity.AddressBook;
import com.reece.entity.Contact;

public class ContactManagerImpl implements ContactManager {

	private static List<Contact> allContactsList = null;
	private static Set<Contact> uniqueContactsSet = null;
	AddressBookManagerImpl addressBookManagerImpl = new AddressBookManagerImpl();

	@Override
	public Contact addContact(String contactName, String contactPhone, String addressBookName) {
		Contact contact = null;
		AddressBook book = addressBookManagerImpl.findOrCreateAddressBook(addressBookName);
		if (isValidContact(contactName, contactPhone, addressBookName)) {
			contact = new Contact(contactName, contactPhone, book);
			getAllContactList().add(contact);
		} else {
			System.out.println("Input Validation Failed!");
		}


		return contact;
	}

//	@Override
//	public List<Contact> getAddressBookContacts(String addressBookName) {
//		List<Contact> ContactsList =new ArrayList<>();
//		ContactsList = getAllContactList().stream()
//				.filter(e -> e.getAddressBook().getAddressBookName().equals(addressBookName))
//				.collect(Collectors.toList());
//
//		return ContactsList;
//	}

	@Override
	public Set<Contact> getAddressBookContacts(String addressBookName) {
		Set<Contact> Contacts =new HashSet<>();
		Contacts = getAllContactList().stream()
				.filter(e -> e.getAddressBook().getAddressBookName().equals(addressBookName))
				.collect(Collectors.toSet());

		return Contacts;
	}

	@Override
	public Set<Contact> getUniqueContacts() {

		if (uniqueContactsSet == null) {
			uniqueContactsSet = new HashSet<Contact>(getAllContactList());
		}

		uniqueContactsSet = getAllContactList().stream().distinct().collect(Collectors.toSet());

		return uniqueContactsSet;
	}

	public List<Contact> getAllContactList() {
		if (allContactsList == null) {
			allContactsList = new ArrayList<>();
		}

		return allContactsList;
	}
	//to be removed

	@Override
	public void printUniqueContacts() {
		Set<Contact> resultset = getUniqueContacts();
		resultset.stream().forEach(s -> System.out.println(s.getContactName() + " " + s.getContactPhone()));
	}
	@Override
	public void printAddressbookContacts(String addressBookName) {
		Set<Contact> contactSet = getAddressBookContacts(addressBookName);
		contactSet.stream().forEach(e -> System.out.println(e.getContactName() + " " + e.getContactPhone()));

	}

	private boolean isValidContact(String contactName, String contactPhone, String addressBookName) {
		boolean result = false;
		List<Contact> addressbookContacts = getAddressBookContacts(addressBookName).stream()
				.filter(e -> ((e.getContactName().equals(contactName)) && (e.getContactPhone().equals(contactPhone))))
				.collect(Collectors.toList());

		if (addressbookContacts.isEmpty())
			result = true;
		else
			result = false;

		return result;
	}
@Override
	public void removeContactFromAddressBook(String contactName,String contactPhone,String addressBookName) {
		
		Contact contact =null;
		AddressBookManagerImpl adBookManagerImpl = new AddressBookManagerImpl();
		if(adBookManagerImpl.getAddressBooksMap().containsKey(addressBookName)) {
			System.out.println("addressbook found "+addressBookName);
			
			Set<Contact> addressbookContacts = getAddressBookContacts(addressBookName).stream()
					.filter(e -> ((e.getContactName().equals(contactName)) && (e.getContactPhone().equals(contactPhone))))
					.collect(Collectors.toSet());
			
			if(addressbookContacts.isEmpty()) {
				System.out.println("No Contact Found!");
			}
			else {
			contact = new Contact(contactName, contactPhone,adBookManagerImpl.findOrCreateAddressBook(addressBookName));
			if(getAddressBookContacts(addressBookName).contains(contact)) {
				
				getAllContactList().remove(contact);
			}
			}
		}
		else {
			System.out.println("AddressBook Not Found!");
		}
	}

}
