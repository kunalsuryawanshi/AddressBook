package com.bridgelabz.addressbook;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    // UC4 Delete PersonInfo Method
    public static void deleteContact() {
        System.out.println("Enter first name for Delete PersonInfo : ");
        String firstName = sc.nextLine();
        for (int i = 0; i < personInfo.size(); i++) {
            if (personInfo.get(i).getFirstName().equalsIgnoreCase(firstName)) { // Comparing Two Strings
                personInfo.remove(i); // REMOVING ARRAY
                System.out.println("PersonInfo Deleted...");
            } else {
                System.out.println(firstName + " : No PersonInfo found in Address Book");
            }
        }
    }

    public static void showContact() {
        personInfo.forEach(System.out::println);
    }

    // UC3 editContact
    static void editContact() {
        String enteredName;
        System.out.println("Enter First name of contact to edit it ");
        enteredName = sc.next();
        for (int index = 0; index < personInfo.size(); index++) {
            if (personInfo.get(index).getFirstName().equals(enteredName)) {
                int check = 0;
                System.out.println("Person found , what do you want to edit ?");
                System.out.println(
                        "Enter\n1.First Name\n2.Last Name\n3.Address\n4.city\n5.State\n6.Zip\n7.Phone\n8.Email");
                check = sc.nextInt();
                switch (check) {
                    case 1:
                        System.out.println("Enter new first name");
                        personInfo.get(index).setFirstName(sc.nextLine());
                        break;
                    case 2:
                        System.out.println("Enter new last name");
                        personInfo.get(index).setLastName(sc.nextLine());
                        break;
                    case 3:
                        System.out.println("Enter new Address");
                        personInfo.get(index).setAddress(sc.nextLine());
                        break;
                    case 4:
                        System.out.println("Enter new city");
                        personInfo.get(index).setCity(sc.nextLine());
                        break;
                    case 5:
                        System.out.println("Enter new state");
                        personInfo.get(index).setState(sc.nextLine());
                        break;
                    case 6:
                        System.out.println("Enter new zip");
                        personInfo.get(index).setZip(sc.nextLine());
                        break;
                    case 7:
                        System.out.println("Enter new phone number");
                        personInfo.get(index).setPhoneNumber(sc.nextLine());
                        break;
                    case 8:
                        System.out.println("Enter new email");
                        personInfo.get(index).setEmail(sc.nextLine());
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

    /*
     *UC8
     *Ability to search Person in a City or State across the multiple AddressBook
     */
    public static void searchPersonByName(String firstName) {
        List listPerson = (List) personInfo.stream()
                .filter(p -> p.getFirstName().equals(firstName))
                .collect(Collectors.toList());
        listPerson.forEach(System.out::println);
    }

    /*
     *UC9
     *Ability to search Person in a City or State across the multiple AddressBook
     *:: -> Method Reference
     */
    public static void searchPersonByCity(String City) {
        List listPerson = personInfo.stream()
                .filter(p -> p.getCity().equals(City))
                    //filtering Data
                .collect(Collectors.toList());
        listPerson.forEach(System.out::println);
    }

    /*
     *UC10 Ability to search Person in a City or State
     */
    public static void getCountByCity(String city) {
        List listPerson = personInfo.stream()
                .filter(p -> p.getCity().equals(city))
                    //filtering Data
                .collect(Collectors.toList());
                    //Collecting as a list
        long total = 0;
        total = Stream.of(listPerson).count();
        System.out.println("Totally " + total + " contacts present in the AddressBook");
    }

    /*
     * UC11
     * Ability to sort the entries in the address book alphabetically by Person’s name
     */
    public static void sortByName() {
        List listPerson = personInfo.stream()
                .sorted(Comparator.comparing(PersonInfo::getFirstName))
                    //Sorting data
                .collect(Collectors.toList());
                    //Collecting as a list
        listPerson.forEach(System.out::println);
    }

    public static void menu() {
        String menuOption;
        do {
            System.out.println("    1.Add Contact");
            System.out.println("	2.Edit Contact");
            System.out.println("	3.Delete Contact");
            System.out.println("	4.Show Contact");
            System.out.println("	5.Search Person Using Name");
            System.out.println("	6.Search Person Using City");
            System.out.println("	7.Number Of Contact Person");
            System.out.println("	8.Sort Person By Name");
            System.out.println("	0.Exit");

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
                    System.out.println("Enter First Name");
                    String firstname = sc.next();
                    searchPersonByName(firstname);
                    break;
                case "6":
                    System.out.println("Enter City Name");
                    String city = sc.next();
                    searchPersonByCity(city);
                    break;
                case "7":
                    System.out.println("Enter City Name");
                    String cityCount = sc.next();
                    getCountByCity(cityCount);
                    break;
                case "8":
                    sortByName();
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