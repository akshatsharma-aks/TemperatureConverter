/**
 * TemperatureConverter.java
 * ─────────────────────────────────────────────────────────────────────────────
 * A menu-driven console application to convert temperatures between
 * Celsius and Fahrenheit.
 *
 * Formulas Used:
 *   Celsius → Fahrenheit : F = (C × 9/5) + 32
 *   Fahrenheit → Celsius : C = (F - 32) × 5/9
 *
 * Author  : [Your Name]
 * Project : Temperature Converter — Internship Submission
 * Version : 1.0
 * ─────────────────────────────────────────────────────────────────────────────
 */

import java.util.Scanner;

public class TemperatureConverter {

    // ─────────────────────────────────────────────
    //  CONVERSION METHODS
    // ─────────────────────────────────────────────

    /**
     * Converts Celsius to Fahrenheit.
     * Formula: F = (C × 9/5) + 32
     *
     * @param celsius Temperature in Celsius
     * @return        Equivalent temperature in Fahrenheit
     */
    static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    /**
     * Converts Fahrenheit to Celsius.
     * Formula: C = (F - 32) × 5/9
     *
     * @param fahrenheit Temperature in Fahrenheit
     * @return           Equivalent temperature in Celsius
     */
    static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }

    // ─────────────────────────────────────────────
    //  INPUT HELPER — Safe Double Reader
    // ─────────────────────────────────────────────

    /**
     * Safely reads a double from the user.
     * Keeps re-prompting if the input is not a valid number.
     * Prevents NumberFormatException from crashing the app.
     *
     * @param scanner Scanner object for reading input
     * @param prompt  Message shown to the user
     * @return        A valid double value entered by the user
     */
    static double getDoubleInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                // Input was not a valid number — ask again
                printError("Invalid input! Please enter a numeric value (e.g. 37.5 or -10).");
            }
        }
    }

    // ─────────────────────────────────────────────
    //  MAIN METHOD — Application Entry Point
    // ─────────────────────────────────────────────

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display welcome banner on startup
        printWelcomeBanner();

        // Main application loop — runs until user selects Exit
        boolean running = true;
        while (running) {

            printMenu();

            // Read user's menu choice safely (handles non-integer input)
            int choice = getMenuChoice(scanner);

            switch (choice) {

                // ── Option 1: Celsius → Fahrenheit ──
                case 1:
                    printSectionHeader("CELSIUS  →  FAHRENHEIT");
                    double celsius = getDoubleInput(scanner, "  Enter temperature in Celsius    : ");
                    double fahrenheit = celsiusToFahrenheit(celsius);
                    printResult(
                        String.format("%.2f °C", celsius),
                        String.format("%.2f °F", fahrenheit),
                        "Celsius", "Fahrenheit"
                    );
                    break;

                // ── Option 2: Fahrenheit → Celsius ──
                case 2:
                    printSectionHeader("FAHRENHEIT  →  CELSIUS");
                    double fahr = getDoubleInput(scanner, "  Enter temperature in Fahrenheit : ");
                    double cel  = fahrenheitToCelsius(fahr);
                    printResult(
                        String.format("%.2f °F", fahr),
                        String.format("%.2f °C", cel),
                        "Fahrenheit", "Celsius"
                    );
                    break;

                // ── Option 3: Exit ──
                case 3:
                    running = false;
                    printExitMessage();
                    break;

                // ── Invalid option ──
                default:
                    printError("Invalid choice! Please select 1, 2, or 3.");
            }
        }

        scanner.close();
    }

    // ─────────────────────────────────────────────
    //  HELPER — Safe Menu Choice Reader
    // ─────────────────────────────────────────────

    /**
     * Reads the user's menu selection as an integer.
     * Handles non-numeric input gracefully without crashing.
     *
     * @param scanner Scanner to read from
     * @return        Integer menu choice (may be invalid; handled in switch-case)
     */
    static int getMenuChoice(Scanner scanner) {
        System.out.print("  Enter your choice: ");
        String input = scanner.nextLine().trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            // Return -1 to trigger the default case in the switch statement
            return -1;
        }
    }

    // ─────────────────────────────────────────────
    //  UI HELPERS — Banners, Menus, Output
    // ─────────────────────────────────────────────

    /** Displays the welcome banner at application startup. */
    static void printWelcomeBanner() {
        System.out.println();
        System.out.println("  ╔════════════════════════════════════════════════╗");
        System.out.println("  ║         TEMPERATURE CONVERTER  v1.0            ║");
        System.out.println("  ║       Internship Project  —  Java Console      ║");
        System.out.println("  ╚════════════════════════════════════════════════╝");
        System.out.println("  Supports: Celsius ↔ Fahrenheit");
        System.out.println("  Output precision: 2 decimal places");
        System.out.println();
    }

    /** Prints the main navigation menu. */
    static void printMenu() {
        System.out.println("  ┌──────────────────────────────────┐");
        System.out.println("  │            MAIN MENU             │");
        System.out.println("  ├──────────────────────────────────┤");
        System.out.println("  │  1.  Celsius  →  Fahrenheit      │");
        System.out.println("  │  2.  Fahrenheit  →  Celsius      │");
        System.out.println("  │  3.  Exit                        │");
        System.out.println("  └──────────────────────────────────┘");
    }

    /**
     * Prints a clean, formatted conversion result block.
     *
     * @param input     Formatted input temperature string
     * @param output    Formatted output temperature string
     * @param fromUnit  Source unit name (e.g. "Celsius")
     * @param toUnit    Target unit name (e.g. "Fahrenheit")
     */
    static void printResult(String input, String output, String fromUnit, String toUnit) {
        System.out.println();
        System.out.println("  ┌──────────────────────────────────────────┐");
        System.out.println("  │               RESULT                     │");
        System.out.println("  ├──────────────────────────────────────────┤");
        System.out.printf( "  │  Input  (%s)  : %-23s│%n", padUnit(fromUnit), input);
        System.out.printf( "  │  Output (%s)  : %-23s│%n", padUnit(toUnit),   output);
        System.out.println("  └──────────────────────────────────────────┘");
        System.out.println();
    }

    /** Prints a section header for each conversion type. */
    static void printSectionHeader(String title) {
        System.out.println();
        System.out.println("  ════════════════════════════════════════════");
        System.out.println("   " + title);
        System.out.println("  ════════════════════════════════════════════");
    }

    /** Prints an error message in a consistent format. */
    static void printError(String message) {
        System.out.println("  ✖  " + message);
        System.out.println();
    }

    /** Prints the goodbye message on exit. */
    static void printExitMessage() {
        System.out.println();
        System.out.println("  ════════════════════════════════════════════");
        System.out.println("   Thank you for using Temperature Converter!");
        System.out.println("   Have a great day. Goodbye! 👋");
        System.out.println("  ════════════════════════════════════════════");
        System.out.println();
    }

    /**
     * Pads a unit name to a fixed width for aligned table output.
     * Ensures "Celsius" and "Fahrenheit" both produce equally wide columns.
     *
     * @param unit Unit name string
     * @return     Padded string of fixed width
     */
    static String padUnit(String unit) {
        // Target width = "Fahrenheit".length() = 10
        return String.format("%-10s", unit);
    }
}
