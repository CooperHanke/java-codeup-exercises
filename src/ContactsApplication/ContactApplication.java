package ContactsApplication;

import util.Input;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactApplication {
    private static ArrayList<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        readdata();
        options();
    }
    public static void readdata() {
        String directory = "../data";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);
        if (Files.notExists(dataDirectory)) {
            try {
                Files.createDirectories(dataDirectory);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!Files.exists(dataFile)) {
            try {
                Files.createFile(dataFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            List<String> readLines = Files.readAllLines(dataFile);
            System.out.println(readLines);
        } catch (Exception e) {
            System.out.println("Made an Exception");
            e.printStackTrace();
        }
    }
    public static void options() {
        Input input = new Input();
        System.out.println("\n1. View contacts");
        System.out.println("2. Add a new contact");
        System.out.println("3. Search for a contact by name");
        System.out.println("4. Delete an existing contact");
        System.out.println("5. Exit");
        System.out.println("Enter an option (1, 2, 3, 4, or 5) >");
        int choice = input.getInt(1, 5);
        switch (choice) {
            case 1:
                viewContacts();
                break;
            case 2:
                addContact();
                break;
            case 3:
                searchContacts();
                break;
            case 4:
                deleteContact();
                break;
            case 5:
                exit();
            default: options();
        }
    }
    public static void viewContacts(){
        System.out.println("Would have viewed the contacts");
        options();
    }
    public static void addContact(){
        System.out.println("Would have added contact");
        options();
    }
    public static void searchContacts(){
        System.out.println("Would have searched contacts");
        options();
    }
    public static void deleteContact(){
        System.out.println("Would have deleted contact");
        options();
    }
    public static void exit() {
        System.out.println("Exiting the application...");
        System.exit(0);
    }
}
