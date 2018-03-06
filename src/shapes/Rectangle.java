package shapes;

public class Rectangle {
    private int length, width;
    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public Rectangle(int side) {
        this.length = side;
        this.width = side;
    }

    public int getArea() {
        return (2 * this.width) + (2 * this.length);
    }
    public int getPerimeter() {
        return this.length * this.width;
    }
}
