package com.reece.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.reece.entity.AddressBook;



public class AddressBookManagerImplTest {
	
	private AddressBookManagerImpl addressBookManagerImpl =null; 
	private AddressBook book= null;
	@BeforeEach
	public void BeforeEach() {
		addressBookManagerImpl =new AddressBookManagerImpl();
		addressBookManagerImpl.getAddressBooksMap().clear();
		addressBookManagerImpl.getAllAddressBooks().clear();
	}

	
	@Test
	public void createAddressBookTest() {
		book = addressBookManagerImpl.findOrCreateAddressBook("AddressBookOne");
		book = addressBookManagerImpl.findOrCreateAddressBook("AddressBookTwo");
		book = addressBookManagerImpl.findOrCreateAddressBook("AddressBookThree");
		assertEquals(3,addressBookManagerImpl.getAllAddressBooks().size());
	}
	@Test
	public void removeAddressBookTest() {
		book = addressBookManagerImpl.findOrCreateAddressBook("Book");
		book = addressBookManagerImpl.findOrCreateAddressBook("Record");
		 addressBookManagerImpl.removeAddressBook("Book");
		assertEquals(1, addressBookManagerImpl.getAllAddressBooks().size());
	}
	
	@Test
	public void getAllAddressBooksTest()
	{
		AddressBookManagerImpl addressBookManagerImpl =new AddressBookManagerImpl();
		book = addressBookManagerImpl.findOrCreateAddressBook("MyBook");
		book = addressBookManagerImpl.findOrCreateAddressBook("Sales");
		book = addressBookManagerImpl.findOrCreateAddressBook("Operations");
		addressBookManagerImpl.getAllAddressBooks();
		assertEquals(3, addressBookManagerImpl.getAllAddressBooks().size());
	}
	
}
