package com.bridgelabz.addressbook;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSV {
    static File file = new File("F:/Core Java/src/com/bridgelabz/addressbook/addressbook.csv");

    /*
     * @pram personInfo : Contact List
     * Data Write in CSV File
     */
    public static void writeCSV(List<PersonInfo> personInfo) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("File Created Successfully..!");
        }
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            CSVWriter writer = new CSVWriter(fileWriter);
            List<String[]> data = new ArrayList<>();
            for (PersonInfo person : personInfo) {
                data.add(new String[]{"Person: " + "\nFirst Name: " + person.getFirstName() + "\nLast Name: " + person.getLastName() + "\nAddress: " + person.getAddress() + "\nCity: " + person.getCity() + "\nState: "
                        + person.getState() + "\nZip: " + person.getZip() + "\nPhoneNumber: " + person.getPhoneNumber() + "\nEmail: " + person.getEmail() + "\n"});
            }
            writer.writeAll(data);
            writer.close();
        } catch (IOException message) {
            message.printStackTrace();
        }
    }

    /*
     * Purpose : Data Read From CSV File
     */
    public static void readCSV() throws CsvValidationException {
        try {
            CSVReader reader = new CSVReader(new FileReader(file));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
               for (String person : nextLine){
                   System.out.println(person);
               }
            }
        } catch (IOException message) {
            message.printStackTrace();
        }
    }
}
