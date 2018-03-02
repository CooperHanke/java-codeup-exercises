import util.Input;

public class InputTest {
    public static void main(String[] args) {

        Input test = new Input();
        System.out.print("Please give us a string: ");
        String string = test.getString();
        System.out.println(string);
        System.out.print("Do you want to continue (test)? ");
        Boolean bool = test.yesNo();
        System.out.println(bool);
        System.out.print("What two numbers would you like to see if a number is between? ");
        int num1 = test.getInt();
        int num2 = test.getInt();
        System.out.println("Here is the range: min is " + num1 + " while max is " + num2);
        System.out.println("Now, let's check it with test.getInt(" + num1 + ", " + num2 + ")");
        System.out.print("Please give a number between these, or else I'll keep asking: ");
        int numberToCheck = test.getInt(num1, num2);
        System.out.println("Great, " + numberToCheck + " is between " + num1 + " and " + num2 + "!");

        System.out.print("What two numbers would you like to see if a number is between? ");
        double num3 = test.getDouble();
        double num4 = test.getDouble();
        System.out.println("Here is the range: min is " + num3 + " while max is " + num4);
        System.out.println("Now, let's check it with test.getInt(" + num3 + ", " + num4 + ")");
        System.out.print("Please give a number between these, or else I'll keep asking: ");
        double anotherNumberToCheck = test.getDouble(num3, num4);
        System.out.println("Great, " + anotherNumberToCheck + "is between " + num3 + " and " + num4 + "!");

        System.out.println("Never to leave any of our methods useless and idle, give me one int, and then one floating point number: ");
        int num5 = test.getInt();
        double num6 = test.getDouble();
        System.out.println("And here, you are, one int of " + num5 + ", and then one double of " + num6);
    }
}
