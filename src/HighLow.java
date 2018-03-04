import java.util.Scanner;

public class HighLow {
    public static void main(String[] args) {
        int wins = 0;
        int loses = 0;
        game(wins, loses);
    }
    private static void game(int wins, int loses) {
        Scanner scan = new Scanner(System.in);
        System.out.print("How many guesses do you think you can get in this round? >");
        int guessesRemaining = scan.nextInt();
        System.out.println("What will be the low number? >");
        int lowerBounds = scan.nextInt();
        System.out.println("What will be the high number? >");
        int higherBounds = scan.nextInt();
        int numberToGuess = randomize(lowerBounds, higherBounds);
        boolean won = determineChoice(lowerBounds, higherBounds, numberToGuess, guessesRemaining);
        if (!won) {
            loses++;
        } else wins++;
        System.out.print("Would you like to play again? >");
        if (scan.next().toLowerCase().contains("y")) {
            game(wins, loses);
        } else System.out.println("You won " + wins + " this many times and lost " + loses + " many times");
    }
    private static boolean determineChoice(int lowerBounds, int higherBounds, int numberToGuess, int guessesRemaining) {
        while (guessesRemaining > 0) {
            Scanner scan = new Scanner(System.in);
            if (guessesRemaining == 1) {
                System.out.println("You have only have one more guess left!!");
            } else System.out.println("You have " + guessesRemaining + " guesses remaining.");
            System.out.print("Guess a number between " + lowerBounds + " and " + higherBounds + ": >");
            int guess = scan.nextInt();
            if ((guess > higherBounds) || (guess < lowerBounds)) {
                System.out.println("Sorry, pick a number in range: ");
                guess = scan.nextInt();
            }
            if (guess == numberToGuess) {
                guessesRemaining--;
                System.out.println("That was a good guess! You had " + guessesRemaining + " guesses left!");
                return true;
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
        return false;
    }
    private static int randomize(int low, int high) {
        return (int)(low + (Math.random() * ((high - low) + 1)));
    }
}
