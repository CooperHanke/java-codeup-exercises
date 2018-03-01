import java.util.Scanner;

public class HighLow {
    public static void main(String[] args) {
        game();
    }
    private static void game() {
        Scanner scan = new Scanner(System.in);
        int guessesRemaining = 10;
        int numberToGuess = randomize();
        determineChoice(numberToGuess, guessesRemaining);
        System.out.print("Would you like to play again? ");
        if (scan.next().toLowerCase().contains("y")) {
            game();
        }
    }
    private static void determineChoice(int numberToGuess, int guessesRemaining) {
        int upperBounds = 100;
        int lowerBounds = 1;
        while (guessesRemaining > 0) {
            Scanner scan = new Scanner(System.in);
            System.out.println("You have " + guessesRemaining + " remaining.");
            System.out.println("Guess a number between 1 and 100: ");
            int guess = scan.nextInt();
            if ((guess > upperBounds) || (guess < lowerBounds)) {
                System.out.println("Sorry, pick a number in range: ");
                guess = scan.nextInt();
            }
            if (guess == numberToGuess) {
                guessesRemaining--;
                System.out.println("That was a good guess! You had " + guessesRemaining + "!");
                break;
            } else if (guess < numberToGuess) {
                guessesRemaining--;
                System.out.println("HIGHER!");
            } else if (guess > numberToGuess) {
                guessesRemaining--;
                System.out.println("LOWER!");
            }
        }
        if (guessesRemaining == 0) {
            System.out.println("Sorry, you didn't win this round. The number to guess was " + numberToGuess);
        }
    }
    private static int randomize() {
        return (int)(Math.random() * 101);
    }
}
