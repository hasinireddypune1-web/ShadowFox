package com.shadowfox.calculator;

import java.util.Scanner;

public class EnhancedCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n========== ENHANCED CALCULATOR MENU ==========");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Modulus");
            System.out.println("6. Power (x^y)");
            System.out.println("7. Square Root");
            System.out.println("8. Cube Root");
            System.out.println("9. Exponential (e^x)");
            System.out.println("10. Natural Logarithm (ln)");
            System.out.println("11. Base-10 Logarithm (log10)");
            System.out.println("12. Sine (sin)");
            System.out.println("13. Cosine (cos)");
            System.out.println("14. Tangent (tan)");
            System.out.println("15. Absolute Value (|x|)");
            System.out.println("16. Exit");
            System.out.println("==============================================");
            System.out.print("Enter operation (1 to 16): ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Clear newline from buffer
            } catch (Exception e) {
                System.out.println(">>> Error: Invalid input. Please enter a number between 1 and 16.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

            if (choice == 16) {
                System.out.println("Exiting the calculator. Goodbye!");
                running = false;
                break;
            }

            try {
                executeOperation(choice, scanner);
            } catch (Exception e) {
                System.out.println(">>> Error occurred: " + e.getMessage());
            }

            // Pause the execution so the user can easily take a screenshot
            System.out.println("\n[Press Enter to return to the main menu...]");
            scanner.nextLine();
        }
        scanner.close();
    }

    private static void executeOperation(int choice, Scanner scanner) {
        switch (choice) {
            case 1: // Addition
                System.out.print("[Op 1] Enter first number: ");
                double a1 = scanner.nextDouble(); scanner.nextLine();
                System.out.print("[Op 1] Enter second number: ");
                double b1 = scanner.nextDouble(); scanner.nextLine();
                System.out.println(">>> Execution Result: " + a1 + " + " + b1 + " = " + (a1 + b1));
                break;

            case 2: // Subtraction
                System.out.print("[Op 2] Enter first number: ");
                double a2 = scanner.nextDouble(); scanner.nextLine();
                System.out.print("[Op 2] Enter second number: ");
                double b2 = scanner.nextDouble(); scanner.nextLine();
                System.out.println(">>> Execution Result: " + a2 + " - " + b2 + " = " + (a2 - b2));
                break;

            case 3: // Multiplication
                System.out.print("[Op 3] Enter first number: ");
                double a3 = scanner.nextDouble(); scanner.nextLine();
                System.out.print("[Op 3] Enter second number: ");
                double b3 = scanner.nextDouble(); scanner.nextLine();
                System.out.println(">>> Execution Result: " + a3 + " * " + b3 + " = " + (a3 * b3));
                break;

            case 4: // Division
                System.out.print("[Op 4] Enter numerator: ");
                double a4 = scanner.nextDouble(); scanner.nextLine();
                System.out.print("[Op 4] Enter denominator: ");
                double b4 = scanner.nextDouble(); scanner.nextLine();
                if (b4 == 0) {
                    System.out.println(">>> Execution Result: Error! Division by zero is undefined.");
                } else {
                    System.out.println(">>> Execution Result: " + a4 + " / " + b4 + " = " + (a4 / b4));
                }
                break;

            case 5: // Modulus
                System.out.print("[Op 5] Enter first number: ");
                double a5 = scanner.nextDouble(); scanner.nextLine();
                System.out.print("[Op 5] Enter second number: ");
                double b5 = scanner.nextDouble(); scanner.nextLine();
                System.out.println(">>> Execution Result: " + a5 + " % " + b5 + " = " + (a5 % b5));
                break;

            case 6: // Power
                System.out.print("[Op 6] Enter base number: ");
                double base = scanner.nextDouble(); scanner.nextLine();
                System.out.print("[Op 6] Enter exponent (power): ");
                double exp = scanner.nextDouble(); scanner.nextLine();
                System.out.println(">>> Execution Result: " + base + " ^ " + exp + " = " + Math.pow(base, exp));
                break;

            case 7: // Square Root
                System.out.print("[Op 7] Enter number: ");
                double val7 = scanner.nextDouble(); scanner.nextLine();
                if (val7 < 0) {
                    System.out.println(">>> Execution Result: Error! Cannot calculate square root of a negative number.");
                } else {
                    System.out.println(">>> Execution Result: sqrt(" + val7 + ") = " + Math.sqrt(val7));
                }
                break;

            case 8: // Cube Root
                System.out.print("[Op 8] Enter number: ");
                double val8 = scanner.nextDouble(); scanner.nextLine();
                System.out.println(">>> Execution Result: cbrt(" + val8 + ") = " + Math.cbrt(val8));
                break;

            case 9: // Exponential
                System.out.print("[Op 9] Enter power for e (x): ");
                double val9 = scanner.nextDouble(); scanner.nextLine();
                System.out.println(">>> Execution Result: e^" + val9 + " = " + Math.exp(val9));
                break;

            case 10: // Natural Logarithm
                System.out.print("[Op 10] Enter number: ");
                double val10 = scanner.nextDouble(); scanner.nextLine();
                if (val10 <= 0) {
                    System.out.println(">>> Execution Result: Error! Logarithm must be greater than zero.");
                } else {
                    System.out.println(">>> Execution Result: ln(" + val10 + ") = " + Math.log(val10));
                }
                break;

            case 11: // Base-10 Logarithm
                System.out.print("[Op 11] Enter number: ");
                double val11 = scanner.nextDouble(); scanner.nextLine();
                if (val11 <= 0) {
                    System.out.println(">>> Execution Result: Error! Logarithm must be greater than zero.");
                } else {
                    System.out.println(">>> Execution Result: log10(" + val11 + ") = " + Math.log10(val11));
                }
                break;

            case 12: // Sine (Degrees)
                System.out.print("[Op 12] Enter angle in degrees: ");
                double deg12 = scanner.nextDouble(); scanner.nextLine();
                System.out.println(">>> Execution Result: sin(" + deg12 + "°) = " + Math.sin(Math.toRadians(deg12)));
                break;

            case 13: // Cosine (Degrees)
                System.out.print("[Op 13] Enter angle in degrees: ");
                double deg13 = scanner.nextDouble(); scanner.nextLine();
                System.out.println(">>> Execution Result: cos(" + deg13 + "°) = " + Math.cos(Math.toRadians(deg13)));
                break;

            case 14: // Tangent (Degrees)
                System.out.print("[Op 14] Enter angle in degrees: ");
                double deg14 = scanner.nextDouble(); scanner.nextLine();
                System.out.println(">>> Execution Result: tan(" + deg14 + "°) = " + Math.tan(Math.toRadians(deg14)));
                break;

            case 15: // Absolute Value
                System.out.print("[Op 15] Enter any value: ");
                double val15 = scanner.nextDouble(); scanner.nextLine();
                System.out.println(">>> Execution Result: |" + val15 + "| = " + Math.abs(val15));
                break;

            default:
                System.out.println(">>> Error: Operation option not recognized.");
                break;
        }
    }
}