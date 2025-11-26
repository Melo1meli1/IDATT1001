package Assignments.Assignment6;

import java.util.Random;

public class RandomCounter {
    public static void main(String[] args) {

        Random random = new Random();
        int[] occurrences = new int[10];

        int loops = 1000;

        for (int i = 0; i < loops; i++) {
            int number = random.nextInt(10);
            occurrences[number]++;
        }

        for (int i = 0; i < occurrences.length; i++) {
            System.out.println(i + ": " + occurrences[i]);
        }

        /*for (int i = 0; i < occurrences.length; i++) {
            int stars = Math.round(occurrences[i] / 10f);
            System.out.print(i + " " + occurrences[i] + " ");
            for (int s = 0; s < stars; s++) {
                System.out.print("*");
            }
            System.out.println();
        }*/

    }
}
