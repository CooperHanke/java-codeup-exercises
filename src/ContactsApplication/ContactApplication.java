package ContactsApplication;

import util.Input;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class ContactApplication {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static String directory = "data";
    private static String filename = "contacts.txt";
    private static Path dataDirectory = Paths.get(directory);
    private static Path dataFile = Paths.get(directory, filename);

    public static void main(String[] args) {
        initializeData();
        generateTest();
        options();
    }
    public static void generateTest() {
        Contact test1 = new Contact("test1","222-222-2222");
        Contact test2 = new Contact("test2","333-333-3333");
        Contact test3 = new Contact("test3","444-444-4444");
        contacts.add(test1);
        contacts.add(test2);
        contacts.add(test3);
    }
    protected static void initializeData() {
        if (Files.notExists(dataDirectory)) {
            Input input = new Input();
            System.out.print("Data directory \"" + dataDirectory.toAbsolutePath() +
                    "\" does not exist. Do you wish to create it? (yes/no) > ");
            boolean choice = input.yesNo();
            if (choice) {
                createDirectory();
            } else {
                System.out.println("If there is no data file, then there is no reason to continue the program.");
                exit();
            }
        } else {
            System.out.println("Data directory \"" + dataDirectory.toAbsolutePath() + "\" exists, checking for the data file now...");
        }
        if (!Files.exists(dataFile)) {
            System.out.println("The file \"" + dataFile.toAbsolutePath() + "\" does not exist. Want to create a new data file?");
            Input input = new Input();
            boolean shouldCreate = input.yesNo();
            if (shouldCreate) {
                createFile();
            }
        } else {
            System.out.println("Data file \"" + dataFile.toAbsolutePath() + "\" exists, reading from the file...");
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
    protected static void createDirectory() {
        try {
            Files.createDirectories(dataDirectory);
            System.out.println("Creating \"" + dataDirectory.toAbsolutePath() + "\"");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected static void createFile() {
        try {
            Files.createFile(dataFile);
            System.out.println("Creating \"" + dataFile.toAbsolutePath() + "\"...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected static void viewContacts(){
        System.out.println("Displaying list of contacts...");
        try {
            List<String> output = Files.readAllLines(dataFile);
            System.out.println("DEBUG: datafile:\n" + output);
            for (String contact : output) {
                System.out.println("DEBUG: Should be: " + contact);
                System.out.println(contact);
            }
            System.out.println("End of contacts list");
        } catch (Exception e) {
            System.out.println("Made an Exception");
            e.printStackTrace();
        }
        options();
    }
    protected static void addContact(){
        System.out.println("Would have added contact");
        System.out.println("For now, we will provide the Contacts objects");
        List<String> contactsAsStrings = new ArrayList<>();
        for (Contact contact : contacts) {
            contactsAsStrings.add(contact.getName() + " " + contact.getPhone());
        }
        try {
            Files.write(dataFile,contactsAsStrings, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Made file \"" + dataFile.toAbsolutePath() + "\"\n");
        options();
    }
    protected static void searchContacts(){
        System.out.println("Would have searched contacts");
        options();
    }
    protected static void deleteContact(){
        System.out.println("Would have deleted contact");
        options();
    }
    private static void exit() {
        System.out.println("Exiting the application...");
        System.exit(0);
    }
}
