package com.bridgelabz.addressbook;

import java.io.*;
import java.util.List;

public class FileIO {
    //Defined file path static because we can use File Path all The Methods
    static File file = new File("F:/Core Java/src/com/bridgelabz/addressbook/addressbook.txt");

    /*
     * @pram personInfo : Contact List
     * Contact List return in txt File
     */
    public void writeFile(List<PersonInfo> personInfo) throws IOException {
        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File Created Successfully..!");
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(String.valueOf(personInfo));
            bufferedWriter.newLine();
            bufferedWriter.close();
            System.out.println("Data Added..!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Read Contacts From Txt File
     */
    public static void readFile() throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String data = bufferedReader.readLine();
            while ((data) != null) {
                System.out.println(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
