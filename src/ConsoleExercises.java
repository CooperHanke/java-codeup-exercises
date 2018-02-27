import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ConsoleExercises {
    public static void main(String[] args) {
        int getNumber, widthAsInt, lengthAsInt, area, perimeter;
        String first, second, third, sentence, widthAsString, lengthAsString;
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter an integer: ");
        getNumber = sc.nextInt();

        System.out.println("You entered " + getNumber);

        System.out.println("Please give us three words, would ya?");
        first = sc.next();
        second = sc.next();
        third = sc.next();

        System.out.print(first + " " + second + " " + third + "\n");

        System.out.println("How about a whole sentence to have a gander at?");
        sc.nextLine();
        sentence = sc.nextLine();

        System.out.println("Well, you gave me : \"" + sentence + "\"");

        System.out.println("And now, it's time to measure a classroom!");
        System.out.println("How long is the room?");
        lengthAsString = sc.nextLine();

        System.out.println("And now how about how big the opposite wall is?");
        widthAsString = sc.nextLine();

        lengthAsInt = parseInt(lengthAsString);
        widthAsInt = parseInt(widthAsString);
        area = lengthAsInt * widthAsInt;
        perimeter = (2 * lengthAsInt) + (2 * lengthAsInt);

        System.out.println("The area is " + area + ", while the perimeter is " + perimeter);
    }
}
