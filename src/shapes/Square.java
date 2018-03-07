package shapes;

public class Square extends Quadrilateral {
    private double myside;
    public Square(double side) {
        super(side, side);
        myside = side;
    }

    @Override
    void setLength() {
        this.length = myside;
    }

    @Override
    void setWidth() {
        this.width = myside;
    }

    @Override
    public double getPerimeter() {
        return myside * 4;
    }

    @Override
    public double getArea() {
        return myside * myside;
    }
}
