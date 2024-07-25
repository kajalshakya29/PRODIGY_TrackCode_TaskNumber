import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        // Generate a random number between 1 and 100
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;

        // Initialize the number of attempts
        int attempts = 0;

        // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Game loop
        while (true) {
            // Prompt the user to input their guess
            System.out.print("Guess a number between 1 and 100: ");
            int userGuess = scanner.nextInt();
            attempts++;

            // Compare the user's guess to the secret number
            if (userGuess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > secretNumber) {
                System.out.println("Too high! Try again.");
            } else {
                // User guessed correctly!
                System.out.println(" Congratulations! You won!");
                System.out.println("It took you " + attempts + " attempts to win.");
                break;
            }
        }
    }
}