package Assignments.Assignment3;

import java.util.Scanner;

public class PrimeNumberChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String answer = "y";

        while (answer.equalsIgnoreCase("y")) {
            System.out.print("Enter a number: ");
            int number = input.nextInt();

            boolean isPrime = true;

            if (number <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i < number; i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if (isPrime) {
                System.out.println(number + " is a prime number.");
            } else {
                System.out.println(number + " is not a prime number.");
            }

            System.out.print("Check another number? (y/n): ");
            answer = input.next();
        }

        input.close();
    }
}
