public class MethodsExercises {
    public static void main(String[] args) {
        calculateMethods();
    }
    private static double addition (double x, double y) {
        return x + y;
    }
    private static double subtraction (double x, double y) {
        return y - x;
    }
    private static double multiply (double x, double y) {
//        return x * y; // using built-in * method vs creating a method multiplying without *
        double result = 0;
        while (x > 0) {
            result += y;
            x--;
        }
        return result;
    }
    private static double divide (double x, double y) {
        return y / x;
    }
    private static int remainder (double x, double y) {
        return (int)(y % x);
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
    }
}