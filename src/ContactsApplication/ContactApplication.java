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
        options();
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
            System.out.println("Dev Mode: The file \"" + dataFile.toAbsolutePath() + "\" does not exist.\nWant to create a new data file?");
            Input input = new Input();
            boolean shouldCreate = input.yesNo();
            if (shouldCreate) {
                createTestFile();
            }
        } else {
            System.out.println("Data test file \"" + dataFile.toAbsolutePath() + "\" exists, reading from the file...");
        }
    }

    public static void options() {
        Input input = new Input();
        System.out.println("\n1. View contacts");
        System.out.println("2. Add a new contact");
        System.out.println("3. Search for a contact by name");
        System.out.println("4. Delete an existing contact");
        System.out.println("5. Exit");
        System.out.println("Enter an option (1, 2, 3, 4, or 5) > ");
        int choice = input.getInt(1, 6);
        switch (choice) {
            case 1:
                viewContacts();
                break;
            case 2:
                makeNewContactFromMenu();
                break;
            case 3:
                searchContact();
                break;
            case 4:
                deleteContact();
                break;
            case 5:
                exit();
                break;
            case 6:
                System.out.println("Dev Mode");
                createTestFile();
            default: {
                System.out.println("Sorry, that is not a valid option. Please try again.");
                options();
            }
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

    protected static void createTestFile() {
        List<String> contactsAsStrings = new ArrayList<>();
        Contact test1 = new Contact("test1", "222-222-2222");
        Contact test2 = new Contact("test2", "333-333-3333");
        Contact test3 = new Contact("test3", "444-444-4444");
        contacts.add(test1);
        contacts.add(test2);
        contacts.add(test3);
        try {
            Files.createFile(dataFile);
            System.out.println("Creating test file\"" + dataFile.toAbsolutePath() + "\"...");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Contact contact : contacts) {
            contactsAsStrings.add(contact.getName() + " " + contact.getPhone());
        }
        try {
            Files.write(dataFile, contactsAsStrings);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Made test file \"" + dataFile.toAbsolutePath() + "\"\n");
    }

    protected static void viewContacts() {
        try {
            List<String> contactsFromFile = Files.readAllLines(dataFile);
            for (String contact : contactsFromFile) {
                System.out.println(contact);
            }
        } catch (Exception e) {
            System.out.println("Made an Exception. Unable to read data from file.");
            e.printStackTrace();
        }
        options();
    }

    protected static void makeNewContactFromMenu() {
        String name = getNewContactName();
        String number = getPhoneNumber();
        createContact(name, number);
        viewContacts();
    }
    protected static String getNewContactName() {
        Input input = new Input();
        String newName;
        boolean confirm;
        do {
            System.out.print("New contact name: > ");
            newName = input.getString();
            System.out.print("Name: \"" + newName + " is correct. Confirm? (yes/no) > ");
            confirm = input.yesNo();
        } while (!confirm);
        return newName;
    }
    protected static String getPhoneNumber () {
        Input input = new Input();
        String newPhone;
        boolean confirm;
        do {
            System.out.print("New contact number: > ");
            newPhone = input.getString();
            System.out.println("New contact number: " + newPhone + "\nConfirm? (yes/no) >");
            confirm = input.yesNo();
        } while (!confirm);
        return String.valueOf(newPhone).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3");
    }
    public static void createContact(String name, String number) {
        List<String> contactsAsStrings = new ArrayList<>();
        Contact contact = new Contact();
        contact.setName(name);
        contact.setPhone(number);
        contacts.add(contact);
        for (Contact item : contacts) {
            contactsAsStrings.add(item.getName() + " " + item.getPhone());
        }
        try {
            Files.write(dataFile,contactsAsStrings,StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        viewContacts();
    }
    protected static void searchContact () {
        int entriesMatching = 0;
        Input input = new Input();
        System.out.print("Contact name: > ");
        String search = input.getString();
        try {
            List<String> contacts = Files.readAllLines(dataFile);
            for (String contact : contacts) {
                if (contact.toLowerCase().contains(search)) {
                    System.out.println(contact);
                    entriesMatching++;
                }
            }
            if (entriesMatching == 1) {
                System.out.println(entriesMatching + " entry matches the given search: " + search);
                options();
            } else if (entriesMatching > 0) {
                System.out.println(entriesMatching + " entries match the given search: " + search);
                options();
            } else {
                System.out.println("The contact " + search + " does not exist.\nWould you like to create them now? (yes/no) > ");
                boolean wantsToAdd = input.yesNo();
                if (wantsToAdd) {
                    makeNewContactFromSearch(search);
                } else {
                    options();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected static void makeNewContactFromSearch(String searchedName) {
        String number = getPhoneNumber();
        createContact(searchedName, number);
        viewContacts();
    }
    protected static void deleteContact () {
        Input input = new Input();
        viewContacts();
        System.out.println("Which of the contacts did you want to delete? > ");
        String searchToDelete = input.getString();
        try {
            List<String> contacts = Files.readAllLines(dataFile);
            for (String contact : contacts) {
                if (contact.toLowerCase().contains(searchToDelete)) {
                    System.out.println("Confirm delete " + contact + "? (yes/no) > ");
                    boolean confirm = input.yesNo();
                    if (confirm) {
                        contacts.remove(contact.toLowerCase().indexOf(searchToDelete));
                        Files.write(dataFile,contacts);
                    } else {
                        System.out.println("Not deleting " + searchToDelete + ". Returning to the main menu...");
                        options();
                    }
                } else {
                    System.out.println("The contact " + searchToDelete + " does not exist. Please enter a valid contact.");
                    deleteContact();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        options();
    }
    private static void exit () {
        System.out.println("DEBUG: Exiting the application...");
        System.exit(0);
    }
}
