package shapes;

import util.Input;

public class CircleApp {
    public static void main(String[] args) {
        System.out.println("What is the radius of the circle? ");
        Input input = new Input();
        double userRadius = input.getDouble();
        Circle userCircle = new Circle(userRadius);
        System.out.println("The radius was " + userRadius);
        System.out.println("Area: " + userCircle.getArea());
        System.out.println("Circumference: " + userCircle.getCircumference());
    }
}
