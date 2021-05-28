package apcs.lucky7;

import java.util.Random;
import java.util.Scanner;

public class GameRunner {
    /*

    I completed an extension: this program will generate random versions of the game, and comments about the dealer, to keep things fresh.
    The game plays with 4 different games (Lucky 7, 8, 9, and 13), either rolling with d6 or d8 dice.

    This program demonstrates mastery because it demonstrates many java programming concepts.
    It makes use of arrays with the int[] diceTypes and String[] feelings array.
    It makes use of the static Random() class to generate random index values for both of the arrays used.
    It makes use of the while loop to keep the game going forever.
    It makes use of the do while loop to ask for a response from the player if they still want to keep playing.
    It makes use of the char datatype to store single characters.
    It makes use of the Scanner .next(), .charAt(), and nextInt() classes to process user input.

     */
    public static void main(String[] args) {

        int[] diceTypes = {7, 8, 9, 13}; // Array of potential games (roll __ to win)
        String[] feelings = {"risky", "amused", "pleased", "charmed", "delighted", "glad", "optimistic", "joyful", "enthusiastic"}; // Potential house emotions

        // Choose random game
        int rnd = new Random().nextInt(diceTypes.length); // Generate random array index for diceTypes
        int diceType = diceTypes[rnd]; // Set random array value as the game

        // Choose random house feeling
        int rnd2 = new Random().nextInt(feelings.length); // Generate random array index for feelings
        String feeling = feelings[rnd2]; // Set random feeling as the string

        // Choose dice in play
        int dice;
        if(diceType == 13) { // Roll with d8 instead of d6 when the game is Lucky 13
            dice = 8;
        } else {
            dice = 6;
        }

        System.out.println("The house is feeling " + feeling + " today. The game is Lucky " + diceType);
        System.out.println("Each round, you roll 2 d" + dice + ". If you roll a(n) " + diceType + ", you win $5.");
        System.out.println("Ante is $1.");

        // Start game loop
        while(true) {

            System.out.print("How many dollars do you want to lose today? $");

            // Read dollar amount from user
            Scanner reader = new Scanner(System.in);
            int startingBalance = reader.nextInt(); // balance that the user starts with each round
            int newBalance = startingBalance; // balance that the user ends with each round
            int highestBalance = startingBalance; // highest balance in the game
            int highestRound = 1; // round number with the highest balance in the game
            int count; // iteration count for game loop

            for(count = 0; newBalance > 0; count++) {

                startingBalance = newBalance; // Reset startingBalance

                // Generate 2 random dice throws
                int r1 = (int) (Math.random() * dice) + 1;
                int r2 = (int) (Math.random() * dice) + 1;
                int total = r1 + r2;

                System.out.print("Roll #" + (count + 1) + ": " + r1 + ", " + r2 + "   Total: " + total + " = ");

                // Calculate if the roll was a win or a loss
                if (total == diceType) {
                    System.out.print("WIN!");
                    newBalance += 4; // Net positive +$4
                } else {
                    System.out.print("LOSE!");
                    newBalance--; // Net $-1
                }

                // Set highestBalance and highestRound if this round is the best performing round so far
                if(newBalance > highestBalance) {
                    highestBalance = newBalance;
                    highestRound = count + 1;
                }

                System.out.print("   Starting Balance: $" + startingBalance + ". ");
                System.out.println("New Balance: $" + newBalance + ".");

            }

            System.out.println("You are broke after " + count + " roll(s).");
            System.out.println("You should have stopped after " + highestRound + " roll(s) when your balance was $" + highestBalance + ".");

            // Ask the user if they want to play again, and collect response
            char response;
            do {
                System.out.print("Do you want to play again [y/n]? ");
                response = reader.next().charAt(0);

                if(response == 'n') { // If the user does not want to play again
                    System.exit(0); // Exit the game
                }
            } while(response != 'y');

        }

    }
}
