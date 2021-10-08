package com.bridgelabz.addressbook;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSON {
    private static final String SAMPLE_JSON_FILE_PATH = "F:/Core Java/src/com/bridgelabz/addressbook/contacts.json";

    public void writeJson(List<PersonInfo> personInfo) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(personInfo);
        FileWriter writer = new FileWriter(SAMPLE_JSON_FILE_PATH);
        writer.write(json);
        writer.close();
    }

    public void readJson() throws IOException {
        ArrayList<PersonInfo> contactList;
        Path SAMPLE_JSON_FILE_PATH = Paths.get("Contacts.json");
        try (Reader reader = Files.newBufferedReader(SAMPLE_JSON_FILE_PATH)) {
            Gson gson = new Gson();
            contactList = new ArrayList<>(Arrays.asList(gson.fromJson(reader, PersonInfo[].class)));
            for (PersonInfo contact : contactList) {
                System.out.println("Firstname : " + contact.getFirstName());
                System.out.println("Lastname : " + contact.getLastName());
                System.out.println("Address : " + contact.getAddress());
                System.out.println("City : " + contact.getCity());
                System.out.println("State : " + contact.getState());
                System.out.println("Zip Code : " + contact.getZip());
                System.out.println("Phone number : " + contact.getPhoneNumber());
                System.out.println("Email : " + contact.getEmail());
            }
        }
    }
}

