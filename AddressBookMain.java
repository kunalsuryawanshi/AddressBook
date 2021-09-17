package com.bridgelabz.addressbook;

import java.util.*;

public class AddressBookMain {
	public static Scanner sc = new Scanner(System.in);
	public static List<PersonInfo> personInfo = new ArrayList<>();
	public static Map<String, PersonInfo> hashmap = new HashMap<>();

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

	// UC4 Delete Contact Method
	private static void deleteContact() {
		System.out.println("Enter first name for Delete Contact : ");
		String firstName = sc.nextLine();
		for (int i = 0; i < personInfo.size(); i++) {
			if (personInfo.get(i).getFirstName().equalsIgnoreCase(firstName)) { // Comparing Two Strings
				personInfo.remove(i); // REMOVING ARRAY
				System.out.println("Contact Deleted...");
			} else {
				System.out.println(firstName + " : No Contact found in Address Book");
			}
		}
	}

	private static void showContact() {
		for (PersonInfo personInfo2 : personInfo) {
			System.out.println(personInfo2);
		}
	}

	// UC3 editContact
	private static void editContact() {
		String enteredName;
		System.out.println("Enter First name of contact to edit it ");
		enteredName = sc.next();
		for (int i = 0; i < personInfo.size(); i++) {
			if (personInfo.get(i).getFirstName().equals(enteredName)) {
				int check = 0;
				System.out.println("Person found , what do you want to edit ?");
				System.out.println(
						"Enter\n1.First Name\n2.Last Name\n3.Address\n4.city\n5.State\n6.Zip\n7.Phone\n8.Email");
				check = sc.nextInt();
				switch (check) {
				case 1:
					System.out.println("Enter new first name");
					personInfo.get(i).setFirstName(sc.next());
					break;
				case 2:
					System.out.println("Enter new last name");
					personInfo.get(i).setLastName(sc.next());
					break;
				case 3:
					System.out.println("Enter new Address");
					personInfo.get(i).setAddress(sc.next());
					break;
				case 4:
					System.out.println("Enter new city");
					personInfo.get(i).setCity(sc.next());
					break;
				case 5:
					System.out.println("Enter new state");
					personInfo.get(i).setState(sc.next());
					break;
				case 6:
					System.out.println("Enter new zip");
					personInfo.get(i).setZip(sc.next());
					break;
				case 7:
					System.out.println("Enter new phone number");
					personInfo.get(i).setPhoneNumber(sc.next());
					break;
				case 8:
					System.out.println("Enter new email");
					personInfo.get(i).setEmail(sc.next());
					break;
				default:
					System.out.println("Invalid Entry");

				}
			}
		}

	}

	/*
	 * UC7 Ability to ensure there is no Duplicate Entry of the same Person in a
	 * particular
	 */
	private static void duplicateCheck(String firstName) {
		for (int k = 0; k < personInfo.size(); k++) {
			String contactName = personInfo.get(k).getFirstName();
			if (firstName.equals(contactName)) {
				System.out.println("This Person is Already Present");
			} else {
				System.out.println("You can Add this Person");
				break;
			}
		}
	}

	// main method
	public static void main(String[] args) {
		System.out.println("Welcome To AddressBook");
		String menuOption;
		do {
			System.out.println("	1.Add Contact");
			System.out.println("	2.Edit Contact");
			System.out.println("	3.Delete Contact");
			System.out.println("	4.Show Contact");
			System.out.println("	5.Duplicate Check");
			menuOption = sc.nextLine();
			switch (menuOption) {
			case "1":
				addContact();
				break;
			case "2":
				editContact();
				break;
			case "3":
				deleteContact();
				break;
			case "4":
				showContact();
				break;
			case "5":
				System.out.println(
						"Enter the Name of the Person You Wants to Check, weather that person is present or not");
				String name = sc.nextLine();
				duplicateCheck(name);
				break;
			default:
				System.out.println("Invalid Input");
			}

		} while (menuOption.equals("0") == false);

	}

}
