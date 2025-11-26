package Assignments.Assignment1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SecondsToTimeConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int secondsInput = 0;

        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter number of seconds");
                secondsInput = input.nextInt();

                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Input must be a whole number. \n\n");
                input.next();
            }
        }

        int hours = secondsInput / 3600;
        int minutes = (secondsInput % 3600) / 60;
        int seconds = secondsInput % 60;

        System.out.println(hours + " hours, " + minutes + " minutes, " + seconds + " seconds");

        input.close();
    }

}
