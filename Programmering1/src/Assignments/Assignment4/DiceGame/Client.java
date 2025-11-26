package Assignments.Assignment4.DiceGame;

/**
 * Client program that runs the dice game "100".
 * Two players roll the dice until one reaches 100 points.
 * Prints each round's results.
 */

public class Client {

    public static void main(String[] args) {

        Player playerA = new Player("Player A");
        Player playerB = new Player("Player B");

        int round = 1;
        boolean gameRunning = true;

        System.out.println("Starting the dice game 100...\n");

        while (gameRunning) {

            System.out.println("Round " + round);

            playTurn(playerA);
            if (playerA.isFinished()) {
                System.out.println(playerA.getName() + " wins!");
                break;
            }

            playTurn(playerB);
            if (playerB.isFinished()) {
                System.out.println(playerB.getName() + " wins!");
                break;
            }

            round++;
            System.out.println();
        }
    }

    /**
     * Plays one turn for the given player: roll dice + update score.
     * @param player the player taking the turn
     */
    private static void playTurn(Player player) {
        int roll = player.rollDice();
        System.out.println(player.getName() + " rolled " + roll +
                " | Total points: " + player.getTotalPoints());
    }
}
