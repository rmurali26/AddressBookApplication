package com.reece.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.reece.entity.AddressBook;

public class AddressBookManagerImpl implements AddressBookManager {

	private  Set<String> addressBookSet = null;
	private static  Map<String, AddressBook> booksMap =null;
	private ContactManagerImpl ContactManagerImpl=null;
	
	@Override
	public AddressBook findOrCreateAddressBook(String addressBookName) {
		AddressBook book = null;
		if(addressBookName==" "|| addressBookName.equals(null))
		{
			throw new RuntimeException("Addressbookname is mandatory!");
		}
		if (getAddressBooksMap().containsKey(addressBookName)) {
			book = getAddressBooksMap().get(addressBookName);
		}
		else {
			book = new AddressBook(addressBookName);
			getAddressBooksMap().put(addressBookName, book);
		}
		
		return book;
	}
	@Override
	public Set<String> getAllAddressBooks() {
		addressBookSet = new HashSet<>();
		addressBookSet = getAddressBooksMap().keySet();
		return addressBookSet;
	}

	public Map<String, AddressBook> getAddressBooksMap() {
		
		if (booksMap == null) {
			booksMap = new HashMap<String, AddressBook>();
		}
		return booksMap;
	}

	@Override
	public void removeAddressBook(String addressBookName) {
		ContactManagerImpl =new ContactManagerImpl();
		if(getAddressBooksMap().containsKey(addressBookName)&&(ContactManagerImpl.getAddressBookContacts(addressBookName).size()==0)) {
		getAddressBooksMap().remove(addressBookName);
		}
		else
		{
			System.out.println("No address book found");
		}
	}


	
	public void showAddressBooks() {
		Set<String> resultset=getAllAddressBooks();
		resultset.stream().forEach(s->System.out.println(s));
	}
}
