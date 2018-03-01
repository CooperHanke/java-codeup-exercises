import java.util.Scanner;

public class MethodsExercises {
    public static void main(String[] args) {
        calculateMethods();
    }

    private static double addition(double x, double y) {
        return x + y;
    }

    private static double subtraction(double x, double y) {
        return y - x;
    }

    private static double multiply(double x, double y) {
//        return x * y; // using built-in * method vs creating a method multiplying without *
        double result = 0;
        while (x > 0) {
            result += y;
            x--;
        }
        return result;
    }

    private static double divide(double x, double y) {
        return y / x;
    }

    private static int remainder(double x, double y) {
        return (int) (y % x);
    }

    public static int getInteger(int min, int max) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number between 1 and 10: ");
        int proposedNumber = scan.nextInt();
        if ((proposedNumber > max) || (proposedNumber < min)) {
            return getInteger(1, 10);
        }
        return proposedNumber;
    }

    public static void askUser() {
        System.out.println("Do you wish to continue?");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        if (answer.toLowerCase().contains("y")) {
            factorials();
        }
    }
    public static void factorials() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number whose factorial is to be found: ");
        int n = scanner.nextInt();
        if ((n > 10) || (n < 1)) {
            System.out.println("Nope, I said between 1 and 10!!");
            factorials();
        }
        if (n > 0 && n < 11) {
            long result = factFind(n);
            System.out.println("The factorial of " + n + " is " + result);
            askUser();
        }
    }
    public static long factFind(int number) {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result = result * i;
        }
        return result;
    }
    private static void rollDice() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Come, roll the dice with us! How many sides should the dice have?");
        int sides = scan.nextInt();
        int die1 = randomize(sides);
        int die2 = randomize(sides);
        System.out.println("The roll of the first die was " + die1 + ", and the roll of the second was " + die2);
        System.out.println("The total was " + (die1 + die2));
        System.out.println("Would you like to roll again?");
        if (scan.next().toLowerCase().contains("y")) {
            rollDice();
        }
    }
    private static int randomize(int diceSize) {
        return (int) (Math.random() * diceSize + 1);
    }
    private static void calculateMethods() {
        double num1 = 3;
        double num2 = 7;
        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);
        System.out.println(addition(num1, num2));
        System.out.println(subtraction(num1, num2));
        System.out.println("Expected result: 21\nActual Result: " + multiply(num1, num2));
        System.out.println(divide(num1, num2));
        System.out.println("Expected result: 1\nActual Result: " + remainder(num1, num2));
        int userInput = getInteger(1, 10);
        factorials();
        rollDice();
    }
}

