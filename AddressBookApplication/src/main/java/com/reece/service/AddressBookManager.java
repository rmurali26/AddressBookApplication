package com.reece.service;

import java.util.Set;

import com.reece.entity.AddressBook;


public interface AddressBookManager {

public AddressBook findOrCreateAddressBook(String addressBookName);
public Set<String> getAllAddressBooks();
public void removeAddressBook(String addressBookName);


}
