package figures;

public class Quadrate extends Rectangle {

    public Quadrate(Point leftButtom, int sideLength) {
        super(leftButtom, new Point(leftButtom.getX() + sideLength, leftButtom.getY() + sideLength));
    }

    @Override
    public String toString() {
        return "Квадрат с кординатами левой нижней точки (" + getLeftBottom().getX() + "," +getLeftBottom().getY() +
                ") и правой верхней точки (" + getRightTop().getX() + "," + getRightTop().getY() + ")";
    }
}
