import java.util.Scanner;

public class ControlFlowExercises {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean again = true;
        while (again) {
            System.out.println("Grade: ");
            int grade = scanner.nextInt();
            String letter;
            if (grade > 88) {
                letter = "A";
            } else if (80 <= grade && grade <= 87) {
                letter = "B";
            } else if (grade >= 67 && grade <= 79) {
                letter = "C";
            } else if (grade >= 60 && grade <= 66) {
                letter = "D";
            } else letter = "F";
            System.out.println("Grade : " + grade + "\tLetter : " + letter);
            System.out.println("Would you like to continue? y/n");
            String answer = scanner.next();
            if (answer.contains("y")) {
                again = true;
            } else again = false;
        }
    }
}

