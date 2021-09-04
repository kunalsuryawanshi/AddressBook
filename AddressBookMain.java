package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain {
	static Scanner sc = new Scanner(System.in);
	static List<PersonInfo> personInfo = new ArrayList<>();

	// Created a method for adding Contacts
	public static void addContact() {
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

	// Edit Contact method
	private static void editContact() {
		System.out.println("Enter first name for edit : ");
		String firstName = sc.nextLine();							
		for (int i = 0; i < personInfo.size(); i++) {				
			if (personInfo.get(i).getFirstName().equalsIgnoreCase(firstName)) {		//CHECKING USER INPUT == Array
				personInfo.remove(i);								//REMOVING ARRAY
				addContact();										//ADDING NEW ARRAY
				System.out.println("Edit Successfully");
			} else {
				System.out.println(firstName + " : No Contact found in Address Book");
			}
		}
	}
	//main method
	public static void main(String[] args) {
		System.out.println("Welcome To AddressBook");
		String menuOption;
		do {
			System.out.println("	1.Add Contact");
			System.out.println("	2.Edit Contact");
			menuOption = sc.nextLine();
			if (menuOption.equals("1")) {
				addContact();
			} else if (menuOption.equals("2")) {
				editContact();
			}
		} while (menuOption.equals("0") == false);

	}

}
