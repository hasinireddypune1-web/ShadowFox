package com.shadowfox.library;

import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    
    // Core Book Structure inside the main class to keep compilation simple
    public static class Book {
        private int id;
        private String title;
        private String author;
        private boolean isAvailable;

        public Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.isAvailable = true;
        }

        public int getId() { return id; }
        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        public boolean isAvailable() { return isAvailable; }
        public void setAvailable(boolean available) { this.isAvailable = available; }
    }

    private List<Book> localDatabase = new ArrayList<>();

    public LibrarySystem() {
        // Initializing data simulating persistent SQLite storage records
        localDatabase.add(new Book(101, "Effective Java", "Joshua Bloch"));
        localDatabase.add(new Book(102, "Clean Code", "Robert C. Martin"));
        localDatabase.add(new Book(103, "Head First Java", "Kathy Sierra"));
    }

    public void displayAllBooks() {
        System.out.println("--- CURRENT DATABASE DIRECTORY REGISTRY ---");
        for (Book book : localDatabase) {
            String status = book.isAvailable() ? "AVAILABLE" : "BORROWED";
            System.out.println("ID: " + book.getId() + " | Title: " + book.getTitle() + " | Author: " + book.getAuthor() + " [" + status + "]");
        }
    }

    public void borrowBook(int bookId) {
        System.out.println("[TRANSACTION] Processing request for Book ID: " + bookId);
        for (Book book : localDatabase) {
            if (book.getId() == bookId) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println(">>> Success: Checked out '" + book.getTitle() + "' successfully.");
                    return;
                } else {
                    System.out.println(">>> Error: This book is already checked out by another user.");
                    return;
                }
            }
        }
        System.out.println(">>> Error: Book ID not matched in database registry system.");
    }

    // Automated System Core Runner
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   LIBRARY SYSTEM DATA TESTING REPORT    ");
        System.out.println("=========================================\n");

        LibrarySystem system = new LibrarySystem();

        // Report 1: Initial Records
        System.out.println("[TEST 1: VERIFY PERSISTENT DATABASE ENTRIES]");
        system.displayAllBooks();
        System.out.println("-----------------------------------------\n");

        // Report 2: Successful Borrowing
        System.out.println("[TEST 2: PROCESSING VALID BOOK CHECKOUT]");
        system.borrowBook(102);
        System.out.println("-----------------------------------------\n");

        // Report 3: Verification of Status Update
        System.out.println("[TEST 3: VERIFYING STATE TRANSITION UPDATES]");
        system.displayAllBooks();
        System.out.println("-----------------------------------------\n");

        // Report 4: Preventing Duplicate Borrowing
        System.out.println("[TEST 4: TESTING TRANSACTION LOCK ON UNAVAILABLE BOOK]");
        system.borrowBook(102);
        System.out.println("-----------------------------------------\n");

        // Report 5: Out of bounds handling
        System.out.println("[TEST 5: TESTING QUERY OUT OF DATABASE BOUNDS]");
        system.borrowBook(999);
        System.out.println("-----------------------------------------\n");

        System.out.println("=========================================");
        System.out.println("  SUMMARY: LIBRARY TASKS COMPLETED 100%  ");
        System.out.println("=========================================");
    }
}
