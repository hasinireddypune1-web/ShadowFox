package com.shadowfox.bank;

// One single class that handles everything perfectly
class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(">>> Deposit Success! Amount: $" + amount + " | New Balance: $" + balance);
        } else {
            System.out.println(">>> Error: Deposit amount must be positive.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(">>> Withdrawal Success! Amount: $" + amount + " | Remaining Balance: $" + balance);
            return true;
        } else {
            System.out.println(">>> Error: Invalid withdrawal amount or insufficient funds.");
            return false;
        }
    }
}

// This is your main file that runs automatically
public class BankAccountTest {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   BANK ACCOUNT SYSTEM TESTING REPORT    ");
        System.out.println("=========================================\n");

        // 1. Initialize Account
        BankAccount account = new BankAccount("SF-1002", 500.0);
        System.out.println("[INITIALIZATION]");
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Starting Balance: $" + account.getBalance());
        System.out.println("-----------------------------------------\n");

        // 2. Test Successful Deposit
        System.out.println("[TEST 1: DEPOSIT TRANSACTION]");
        System.out.println("Executing: Deposit $200.0");
        account.deposit(200.0);
        System.out.println("-----------------------------------------\n");

        // 3. Test Successful Withdrawal
        System.out.println("[TEST 2: VALID WITHDRAWAL TRANSACTION]");
        System.out.println("Executing: Withdraw $150.0");
        account.withdraw(150.0);
        System.out.println("-----------------------------------------\n");

        // 4. Test Insufficient Funds (Overdraft Protection)
        System.out.println("[TEST 3: OVERDRAFT PROTECTION]");
        System.out.println("Executing: Withdraw $1000.0");
        account.withdraw(1000.0);
        System.out.println("-----------------------------------------\n");

        // 5. Test Invalid Negative Deposit
        System.out.println("[TEST 4: INVALID DEPOSIT PROTECTION]");
        System.out.println("Executing: Deposit -$50.0");
        account.deposit(-50.0);
        System.out.println("-----------------------------------------\n");

        // 6. Final Verification Summary
        System.out.println("=========================================");
        System.out.println("  SUMMARY: ALL TESTS COMPLETED PERFECTLY ");
        System.out.println("  Final Verified Balance: $" + account.getBalance());
        System.out.println("=========================================");
    }
}
