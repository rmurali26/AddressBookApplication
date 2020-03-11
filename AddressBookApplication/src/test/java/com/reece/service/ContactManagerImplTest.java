package com.reece.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.reece.entity.AddressBook;

public class ContactManagerImplTest {
	
	private ContactManagerImpl contactManagerImpl=null;
	private AddressBookManagerImpl addressBookImpl=null;
	
	@BeforeEach
	public void BeforeEach() {
		addressBookImpl =new AddressBookManagerImpl();
		contactManagerImpl =new ContactManagerImpl();
		addressBookImpl.getAddressBooksMap().clear();
		addressBookImpl.getAllAddressBooks().clear();
		contactManagerImpl.getAllContactList().clear();
	}
	@Test
	public void addContactTest() {
		String addressBookName = "book1";
		contactManagerImpl.addContact("Joy", "+61457856926", addressBookName);
		assertEquals(1, contactManagerImpl.getAddressBookContacts(addressBookName).size());
	}

	@Test
	public void getAddressBookContactsTest() {
	
		String addressBookName = "book1";
		contactManagerImpl.addContact("Jocob", "+61457856926", addressBookName);
		contactManagerImpl.addContact("Jocy", "+61457856927", addressBookName);
		contactManagerImpl.addContact("Daniel", "+61457856955", addressBookName);
		assertEquals(3, contactManagerImpl.getAddressBookContacts(addressBookName).size());
	}
	
	@Test
	public void removeContactTest() {
		String addressBookName = "book10";
		contactManagerImpl.addContact("Jocob", "+61457856926", addressBookName);
		contactManagerImpl.removeContactFromAddressBook("Jocob", "+61457856926", addressBookName);
		assertEquals(0,contactManagerImpl.getAddressBookContacts(addressBookName).size());
	}
	
	@Test
	public void getUniqueContactsTest() {
		contactManagerImpl.addContact("Ben", "0469239756", "book1");
		contactManagerImpl.addContact("Ben", "0469239756", "book2");
		contactManagerImpl.addContact("Ben", "0469239756", "book3");
		contactManagerImpl.addContact("Sam", "0469239757", "book1");
		contactManagerImpl.addContact("Sam", "0469239757", "book2");
		contactManagerImpl.addContact("Sam", "0469239757", "book3");
		assertEquals(2, contactManagerImpl.getUniqueContacts().size());
	}
}
