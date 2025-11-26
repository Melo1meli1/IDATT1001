package Assignments.Assignment4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CurrencyCalculator {
    private String name;
    private double rateToNOK;

    public CurrencyCalculator(String name, double rateToNOK) {
        this.name = name;
        this.rateToNOK = rateToNOK;
    }

    public double toNOK(double amount) {
        return amount * rateToNOK;
    }

    public double fromNOK(double nokAmount) {
        return nokAmount / rateToNOK;
    }

    public String getName() {
        return name;
    }

    /**
     * Reads the menu choice.
     * Checks for valid input, and repeats until the requirement is fulfilled.
     *
     * @param input scanner used to read input
     * @return menu choice in int
     */
    private static int readInt(Scanner input) {
        while (true) {
            try {
                return input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.next();
            }
        }
    }

    /**
     * Reads double if user has desimal to convert.
     * Checks for valid input, and repeats until the requirement is fulfilled.
     *
     * @param input scanner used to read input
     * @return double number to be converted
     */
    private static double readDouble(Scanner input) {
        while (true) {
            try {
                return input.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.next();
            }
        }
    }

    /**
     * Prints the currency choice menu
     */
    private static void printCurrencyMenu() {
        System.out.println("""
                Choose currency:
                1: Dollar
                2: Euro
                3: Sek
                4: Exit""");
    }

    /**
     * Prints conversion direction menu
     */
    private static void printConversionMenu() {
        System.out.println("""
                Choose conversion:
                1: Currency → NOK
                2: NOK → Currency""");
    }

    /**
     * Handles the conversion process for the selected currency and direction.
     *
     * @param input    the Scanner used to read input
     * @param selectedCurrency the CurrencyCalculator object representing the chosen currency
     */
    private static void handleConversion(Scanner input, CurrencyCalculator selectedCurrency) {

        printConversionMenu();
        int direction = readInt(input);

        /**
         * Currency to nok = 1
         * nok to currency = 2
         */
        if (direction == 1) {
            System.out.print("Enter amount in " + selectedCurrency.getName() + ": ");
            double amount = readDouble(input);

            double nok = selectedCurrency.toNOK(amount);
            System.out.println(amount + " " + selectedCurrency.getName() + " = " + nok + " NOK");

        } else if (direction == 2) {
            System.out.print("Enter amount in NOK: ");
            double nokAmount = readDouble(input);

            double currencyAmount = selectedCurrency.fromNOK(nokAmount);
            System.out.println(nokAmount + " NOK = " + currencyAmount + " " + selectedCurrency.getName());

        } else {
            System.out.println("Invalid choice.");
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        CurrencyCalculator dollar = new CurrencyCalculator("Dollar", 10.50);
        CurrencyCalculator euro = new CurrencyCalculator("Euro", 11.30);
        CurrencyCalculator sek = new CurrencyCalculator("Swedish Krona", 1.00);

        boolean running = true;

        while (running) {

            printCurrencyMenu();
            int choice = readInt(input);

            CurrencyCalculator selectedCurrency = null;

            switch (choice) {
                case 1 -> selectedCurrency = dollar;
                case 2 -> selectedCurrency = euro;
                case 3 -> selectedCurrency = sek;
                case 4 -> running = false;
                default -> {
                    System.out.println("Invalid choice.");
                    continue;
                }
            }

            handleConversion(input, selectedCurrency);
        }

        input.close();
    }
}
