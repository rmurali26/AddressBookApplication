# AddressBookApplication
Application to manage AddressBooks and its contacts
## User Story

As Branch Manager I would like an address book application on my PC So that I can keep track of my customer contacts

## Acceptance Criteria

- Address book will hold name and phone numbers of contact entries
- Users should be able to add new contact entries
- Users should be able to remove existing contact entries
- Users should be able to print all contacts in an address book
- Users should be able to maintain multiple address books
- Users should be able to print a unique set of all contacts across 
  multiple address books
  
A working user interface is not required, nor is the use of any frameworks. All acceptance criteria should be covered by unit tests, with additional integration tests where appropriate. Tests will be included in the assessment criteria, as will demonstration of other good coding practices like: clear separation of concerns, clean code, standardised formatting, etc. Data should only be persisted in memory, using simple data structures like Set, List, etc.
- NOTE: Solution may be written in either Java or Kotlin

## Solution 
Solution is writen in Java. I have created a Maven Project to fulfil the requirements of the AddressBookApplication and JUnit tests are also included. 

## Assumptions
- UI for the application is NOT required to be done as part of this challenge
- Data Should only be persisted in memmory using simple data structures such as Set and List means no need to use a Database.
## PreRequisites
 - Java 8
 - Maven
## Instructions to run 

```bash
mvn clean install
mvn test

```
