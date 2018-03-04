import java.util.Scanner;

public class HighLow {
    public static void main(String[] args) {
        game();
    }
    private static void game() {
        Scanner scan = new Scanner(System.in);
        System.out.print("How many guesses do you think you can get in this round? >");
        int guessesRemaining = scan.nextInt();
        int numberToGuess = randomize();
        determineChoice(numberToGuess, guessesRemaining);
        System.out.print("Would you like to play again? >");
        if (scan.next().toLowerCase().contains("y")) {
            game();
        }
    }
    private static void determineChoice(int numberToGuess, int guessesRemaining) {
        int upperBounds = 100;
        int lowerBounds = 1;
        while (guessesRemaining > 0) {
            Scanner scan = new Scanner(System.in);
            if (guessesRemaining == 1) {
                System.out.println("You have only have one more guess left!!");
            } else System.out.println("You have " + guessesRemaining + " guesses remaining.");
            System.out.print("Guess a number between 1 and 100: >");
            int guess = scan.nextInt();
            if ((guess > upperBounds) || (guess < lowerBounds)) {
                System.out.println("Sorry, pick a number in range: ");
                guess = scan.nextInt();
            }
            if (guess == numberToGuess) {
                guessesRemaining--;
                System.out.println("That was a good guess! You had " + guessesRemaining + " guesses left!");
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
