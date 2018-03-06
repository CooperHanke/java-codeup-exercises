package shapes;

public class Square extends Rectangle{
    private int side;
    public Square(int length, int width) {
        super(length, width);
        new Rectangle(side);
    }
    public int getArea() {
        return side * side;
    }
    public int getPerimeter () {
        return side * 4;
    }
}
