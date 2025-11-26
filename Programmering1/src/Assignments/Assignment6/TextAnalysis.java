package Assignments.Assignment6;

import java.util.Scanner;

public class TextAnalysis {

    private int[] counts = new int[30];

    public TextAnalysis(String text) {
        text = text.toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c >= 'a' && c <= 'z') {
                counts[c - 'a']++;

            } else if (c == 'å') {
                counts[26]++;

            } else if (c == 'æ') {
                counts[27]++;

            } else if (c == 'ø') {
                counts[28]++;

            } else {
                counts[29]++;
            }
        }
    }

    /**
     * @return number of different letters appearing at least once
     */
    public int getNumberOfDifferentLetters() {
        int unique = 0;
        for (int i = 0; i < 29; i++) {
            if (counts[i] > 0) unique++;
        }
        return unique;
    }

    /**
     * @return total number of letters
     */
    public int getTotalLetters() {
        int sum = 0;
        for (int i = 0; i < 29; i++) sum += counts[i];
        return sum;
    }

    /**
     * @return percent of characters that are NOT letters
     */
    public double getNonLetterPercentage() {
        int nonLetters = counts[29];
        int total = nonLetters + getTotalLetters();
        return (nonLetters * 100.0) / total;
    }

    /**
     * @return occurrences of a specific character
     */
    public int getOccurrencesOf(char c) {
        c = Character.toLowerCase(c);

        if (c >= 'a' && c <= 'z') return counts[c - 'a'];
        if (c == 'å') return counts[26];
        if (c == 'æ') return counts[27];
        if (c == 'ø') return counts[28];

        return 0;
    }

    /**
     * @return highest count of any letter
     */
    public int getMostFrequentCount() {
        int max = 0;
        for (int i = 0; i < 29; i++) {
            if (counts[i] > max) max = counts[i];
        }
        return max;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a text (or 'exit'): ");
            String text = scanner.nextLine();

            if (text.equalsIgnoreCase("exit")) break;

            TextAnalysis analysis = new TextAnalysis(text);

            System.out.println("Different letters: " + analysis.getNumberOfDifferentLetters());
            System.out.println("Total letters: " + analysis.getTotalLetters());
            System.out.println("Non-letter percentage: " + analysis.getNonLetterPercentage() + "%");
            System.out.println("Most frequent letter count: " + analysis.getMostFrequentCount());
        }

        scanner.close();
    }

}


