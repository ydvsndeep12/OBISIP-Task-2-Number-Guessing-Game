import java.util.Random;
import java.util.Scanner;

public class guess_number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int attempts = 0;
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to Guess the Number!");
        System.out.println("I'm thinking of a number between " + lowerBound + " and " + upperBound);

        
        while (playAgain) {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int guess;
            boolean hasGuessedCorrectly = false;

            System.out.println("You have 10 attempts to guess the number.");

            for (attempts = 1; attempts <= 10; attempts++) {
                System.out.print("Attempt #" + attempts + ": Enter your guess: ");
                guess = scanner.nextInt();

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number!");
                    hasGuessedCorrectly = true;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Try a higher number.");
                } else {
                    System.out.println("Try a lower number.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The number was " + targetNumber);
            }

            score += (11 - attempts);
            System.out.println("Your score for this round: " + (11 - attempts));
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes");
        }

        System.out.println("Game over! Your final score: " + score);
        scanner.close();
    }
}
