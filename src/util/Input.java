package util;

import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }
    public String getString() {
        return scanner.next();
    }
    public boolean yesNo() {
        return (scanner.next().toLowerCase().contains("y"));
    }
    public int getInt(int min, int max) {
        int number = scanner.nextInt();
        if (number < min || number > max) {
            return getInt(min, max);
        } else return number;
    }
    public int getInt() {
        return scanner.nextInt();
    }
    public double getDouble(double min, double max) {
        double number = scanner.nextDouble();
        if (number < min || number > max) {
            return getDouble(min, max);
        }
        return number;
    }
    public double getDouble() {
        return scanner.nextDouble();
    }
}
