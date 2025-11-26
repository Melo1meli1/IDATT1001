package Assignments.Assignment5;

import java.util.Random;

/**
 * A class that generates random integers and decimals
 * within given intervals.
 */
public class MinRandom {

    private Random random = new Random();

    /**
     * Generates a random integer in the interval
     * @param lower value
     * @param upper value
     * @return random integer within interval
     */
    public int nextInteger(int lower, int upper) {
        return random.nextInt((upper - lower) + 1) + lower;
    }

    /**
     * Generates a random decimal in the interval
     * @param lower value
     * @param upper value
     * @return random decimal within interval
     */
    public double nextDecimal(double lower, double upper) {
        return lower + (random.nextDouble() * (upper - lower));
    }

    /**
     * Test client for MinRandom class.
     */
    public static void main(String[] args) {
        MinRandom generator = new MinRandom();

        System.out.println("Random integers between 1 and 10:");
        for (int i = 0; i < 10; i++) {
            System.out.println(generator.nextInteger(1, 10));
        }

        System.out.println("\nRandom decimals between 0 and 5:");
        for (int i = 0; i < 10; i++) {
            System.out.println(generator.nextDecimal(0.0, 5.0));
        }
    }
}
