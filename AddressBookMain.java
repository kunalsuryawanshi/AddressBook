package com.bridgelabz.addressbook;

import java.util.*;

public class AddressBookMain {
    public static Scanner sc = new Scanner(System.in);
    public static List<PersonInfo> personInfo = new ArrayList<>();
    public static Map<String, List<PersonInfo>> hashmap = new HashMap<String, List<PersonInfo>>();

    // Created a method for adding Contacts
    public static void addContact() {
        System.out.print("Enter Your First Name : ");
        String firstName = sc.next();
        System.out.print("Enter Your Last Name : ");
        String lastName = sc.next();
        if (checkExist(firstName, lastName, personInfo) == true) {
            System.out.println("Record already exists cant add !!!");
            menu();
        } else
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
    public static void deleteContact() {
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

    public static void showContact() {
        for (int i = 0; i < personInfo.size(); i++) {
            hashmap.put(personInfo.get(i).getPhoneNumber(), personInfo);
            System.out.println(hashmap.toString());
        }
    }

    // UC3 editContact
    static void editContact() {
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
                        personInfo.get(i).setFirstName(sc.nextLine());
                        break;
                    case 2:
                        System.out.println("Enter new last name");
                        personInfo.get(i).setLastName(sc.nextLine());
                        break;
                    case 3:
                        System.out.println("Enter new Address");
                        personInfo.get(i).setAddress(sc.nextLine());
                        break;
                    case 4:
                        System.out.println("Enter new city");
                        personInfo.get(i).setCity(sc.nextLine());
                        break;
                    case 5:
                        System.out.println("Enter new state");
                        personInfo.get(i).setState(sc.nextLine());
                        break;
                    case 6:
                        System.out.println("Enter new zip");
                        personInfo.get(i).setZip(sc.nextLine());
                        break;
                    case 7:
                        System.out.println("Enter new phone number");
                        personInfo.get(i).setPhoneNumber(sc.next());
                        break;
                    case 8:
                        System.out.println("Enter new email");
                        personInfo.get(i).setEmail(sc.nextLine());
                        break;
                    default:
                        System.out.println("Invalid Entry");

                }
            }
        }

    }

    //UC7 Ability to ensure there is no Duplicate Entry of the same Person
    private static boolean checkExist(String firstName, String lastName, List<PersonInfo> personInfo) {
        boolean result = false;
        for (PersonInfo check : personInfo) {
            if (firstName.equals(check.getFirstName()) && lastName.equals(check.getLastName())) {
                result = true;
            }
        }
        return result;
    }

    public static void menu() {
        String menuOption;
        do {
            System.out.println("	1.Add Contact");
            System.out.println("	2.Edit Contact");
            System.out.println("	3.Delete Contact");
            System.out.println("	4.Show Contact");
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
                default:
                    System.out.println("Invalid Input");
            }

        } while (menuOption.equals("0") == false);

    }

    // main method
    public static void main(String[] args) {
        AddressBookMain book = new AddressBookMain();
        System.out.println("Welcome To AddressBook");
        menu();
    }
}