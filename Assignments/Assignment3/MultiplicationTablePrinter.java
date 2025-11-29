package Assignments.Assignment3;

import java.util.Scanner;

public class MultiplicationTablePrinter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter start number: ");
        int start = input.nextInt();

        System.out.print("Enter end number: ");
        int end = input.nextInt();

        if (start > end) {
            int newStart = start;
            start = end;
            end = newStart;
        }

        for (int tableNumber = start; tableNumber <= end; tableNumber++) {
            System.out.println("Table" + tableNumber);

            for (int multiplier = 1; multiplier <= 10; multiplier++) {
                System.out.println(tableNumber + " x " + multiplier + " = " + (tableNumber * multiplier));
            }
            System.out.println();
        }
        input.close();
    }
}


