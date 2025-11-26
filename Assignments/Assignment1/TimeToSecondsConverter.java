package Assignments.Assignment1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TimeToSecondsConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int hours = 0;
        int minutes = 0;
        int seconds = 0;

        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter number of hours");
                hours = input.nextInt();

                System.out.println("Enter number of minutes");
                minutes = input.nextInt();

                System.out.println("Enter number of seconds");
                seconds = input.nextInt();

                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. All fields must be whole numbers. \n\n");
                input.next();
            }
        }

        int totalSeconds = hours * 3600 + minutes * 60 + seconds;
        System.out.println(hours + " hours, " + minutes + " minutes and " + seconds + " seconds equals: " + totalSeconds + " seconds.");

        input.close();
    }
}


