package com.shadowfox.contact;

import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Name: " + name + " | Phone: " + phoneNumber + " | Email: " + email;
    }
}

public class ContactManager {
    private static ArrayList<Contact> contactList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== CONTACT MANAGEMENT SYSTEM ===");
            System.out.println("1. Add New Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search Contact by Name");
            System.out.println("4. Delete a Contact");
            System.out.println("5. Exit Application");
            System.out.print("Select an option (1-5): ");

            String choiceInput = scanner.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                System.out.println(">>> Error: Invalid input! Please enter a number between 1 and 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Closing the application. Goodbye!");
                    return;
                default:
                    System.out.println(">>> Error: Option not recognized. Choose 1 to 5.");
            }
        }
    }

    private static void addContact() {
        System.out.print("Enter Contact Name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println(">>> Error: Name cannot be empty!");
            return;
        }

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine().trim();
        if (phone.isEmpty()) {
            System.out.println(">>> Error: Phone number cannot be empty!");
            return;
        }

        System.out.print("Enter Email Address: ");
        String email = scanner.nextLine().trim();
        if (email.isEmpty()) {
            System.out.println(">>> Error: Email cannot be empty!");
            return;
        }

        contactList.add(new Contact(name, phone, email));
        System.out.println(">>> Success: Contact added successfully!");
    }

    private static void viewContacts() {
        if (contactList.isEmpty()) {
            System.out.println(">>> Notice: Your contact directory is empty.");
            return;
        }
        System.out.println("\n--- Saved Contacts List ---");
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println((i + 1) + ". " + contactList.get(i));
        }
    }

    private static void searchContact() {
        if (contactList.isEmpty()) {
            System.out.println(">>> Notice: Your contact directory is empty.");
            return;
        }
        System.out.print("Enter the name to search: ");
        String searchName = scanner.nextLine().trim();
        boolean found = false;

        for (Contact contact : contactList) {
            if (contact.getName().equalsIgnoreCase(searchName)) {
                System.out.println(">>> Match Found: " + contact);
                found = true;
            }
        }
        if (!found) {
            System.out.println(">>> Notice: No contact found matching the name: " + searchName);
        }
    }

    private static void deleteContact() {
        if (contactList.isEmpty()) {
            System.out.println(">>> Notice: Your contact directory is empty.");
            return;
        }
        System.out.print("Enter the exact name of the contact to delete: ");
        String targetName = scanner.nextLine().trim();
        Contact toRemove = null;

        for (Contact contact : contactList) {
            if (contact.getName().equalsIgnoreCase(targetName)) {
                toRemove = contact;
                break;
            }
        }

        if (toRemove != null) {
            contactList.remove(toRemove);
            System.out.println(">>> Success: Contact removed successfully!");
        } else {
            System.out.println(">>> Error: Contact not found.");
        }
    }
}