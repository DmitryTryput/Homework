package figures;

public class Quadrate extends Rectangle {

    private int sideLength;

    public Quadrate(Point leftBottom, int sideLength) {
        super(leftBottom, new Point(leftBottom.getX() + sideLength, leftBottom.getY() + sideLength));
        this.sideLength = sideLength;
    }

    @Override
    public String toString() {
        return "Квадрат с кординатами левой нижней точки (" + getLeftBottom().getX() + "," +getLeftBottom().getY() +
                ") и правой верхней точки (" + getRightTop().getX() + "," + getRightTop().getY() + ")";
    }

    public int getSideLength() {
        return sideLength;
    }
}
