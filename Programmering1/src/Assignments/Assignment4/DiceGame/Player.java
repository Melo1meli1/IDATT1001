package Assignments.Assignment4.DiceGame;

import java.util.Random;

/**
 * Represents a player in the dice game.
 * Holds the player's total points and simulates dice rolls.
 */

public class Player {

    private String name;
    private int totalPoints = 0;
    private Random dice = new Random();

    /**
     * Creates a new player with a given name.
     * @param name the player's name
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Rolls the dice.
     * If dice hits 1, then points reset to 0.
     * Else the points are added to the total sum.
     * To win the player has to reach exactly 100 points,
     * if the points exceed, the peints are not counted.
     * @return the rolled value from 1-6
     */
    public int rollDice() {
        int roll = dice.nextInt(6) + 1;

        if (roll == 1) {
            totalPoints = 0;
        } else {
            totalPoints += roll;

            if (totalPoints > 100) {
                totalPoints -= roll;
            }
        }
        return roll;
    }

    /**
     * @return the players total points
     */
    public int getTotalPoints() {
        return totalPoints;
    }

    /**
     * Checks if the player has reached 100 points.
     * @return true if totalPoints = 100
     */
    public boolean isFinished() {
        return totalPoints >= 100;
    }

    /**
     * @return the players name
     */
    public String getName() {
        return name;
    }
}
