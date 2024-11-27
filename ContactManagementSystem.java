import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phone;
    String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}

public class ContactManager {
    private static final ArrayList<Contact> contacts = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nContact Manager");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addContact();
                case 2 -> viewContacts();
                case 3 -> updateContact();
                case 4 -> deleteContact();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact added successfully!");
    }

    private static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts to display.");
            return;
        }
        System.out.println("\nContacts:");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
    }

    private static void updateContact() {
        viewContacts();
        if (contacts.isEmpty()) return;
        System.out.print("Enter the contact number to update: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        if (index < 0 || index >= contacts.size()) {
            System.out.println("Invalid contact number!");
            return;
        }
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();
        contacts.set(index, new Contact(name, phone, email));
        System.out.println("Contact updated successfully!");
    }

    private static void deleteContact() {
        viewContacts();
        if (contacts.isEmpty()) return;
        System.out.print("Enter the contact number to delete: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        if (index < 0 || index >= contacts.size()) {
            System.out
