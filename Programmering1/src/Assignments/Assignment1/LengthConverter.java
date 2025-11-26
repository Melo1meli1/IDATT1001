package Assignments.Assignment1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LengthConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final double INCHES_PER_CM = 2.54;
        int cm = 0;

        boolean valid = false;


        while (!valid) {
            try {
                System.out.print("Enter number of centimeters: ");
                cm = input.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a whole number. \n\n");
                input.next();
            }
        }

        double inches = cm * INCHES_PER_CM;

        System.out.println(cm + " cm = " + inches + " inches");

        input.close();
    }
}
