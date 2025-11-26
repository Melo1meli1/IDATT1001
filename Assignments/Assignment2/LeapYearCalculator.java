package Assignments.Assignment2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LeapYearCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int year = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter a year: ");
                year = input.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("The year must be a whole number. \n\n");
                input.next();
            }
        }

        if ((year % 400 == 0) || ((year % 100 != 0) & (year % 4 == 0))) {
            System.out.println(year + " is a leap year");
        } else {
            System.out.println(year + " is not a leap year");
        }

        input.close();
    }

}
