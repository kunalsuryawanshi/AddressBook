package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain {
	static Scanner sc = new Scanner(System.in);
	List<PersonInfo> personInfo = new ArrayList<>();

	// Created a method for adding Contacts
	public void addContact() {
		System.out.print("Enter Your First Name : ");
		String firstName = sc.next();
		System.out.print("Enter Your Last Name : ");
		String lastName = sc.next();
		System.out.print("Enter Your Address : ");
		String address = sc.next();
		System.out.print("Enter Your City : ");
		String city = sc.next();
		System.out.print("Enter Your State : ");
		String state = sc.next();
		System.out.print("Enter Your Zip Code : ");
		String zipCode = sc.next();
		System.out.print("Enter Your Email : ");
		String email = sc.next();
		System.out.print("Enter Your Phone Number : ");
		String phoneNo = sc.next();
		PersonInfo person = new PersonInfo(firstName, lastName, address, city, state, zipCode, email, phoneNo);
		personInfo.add(person);
		for (PersonInfo personInfo2 : personInfo) {
			System.out.println(personInfo2);
		}
	}

	public static void main(String[] args) {

		System.out.println("Welcome To AddressBook");
		AddressBookMain addressBook = new AddressBookMain();
		String choose ="y";
		do {
			addressBook.addContact();	
			System.out.println("You want to add contact Y/N");
			choose =sc.next();
		}while(choose.equalsIgnoreCase("y")||choose.equalsIgnoreCase("Y"));
	
	}

}
