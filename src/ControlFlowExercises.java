import java.util.Scanner;

public class ControlFlowExercises {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean again = true;
        while (again) {
            System.out.println("Would you kindly give me an integer?");
            int number = scanner.nextInt();

            System.out.println("Here is what you get:");


            System.out.println("number\t| squared\t| cubed\t");
            System.out.println("------\t| -------\t| ------\t");

            int counter = 1;
            while (counter <= number) {
                System.out.printf(" %-7d| %-10d| %-10d\n" ,counter, ((int)(Math.pow(counter, 2))),((int)(Math.pow(counter, 3))));
                counter++;
            }
            System.out.println("Would you like to give me a number? y/N");
            String answer = scanner.next();
            if (answer.contains("y")) {
                again = true;
            } else again = false;
        }
    }
}
