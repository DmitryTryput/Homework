package figures;

public class Parallelogram implements ScalableFigure, Polygon {

    private Point leftBottom;
    private Point rightTop;
    private int baseLength;

    public Parallelogram(Point leftBottom, Point rightTop, int baseLength) {
        this.leftBottom = leftBottom;
        this.rightTop = rightTop;
        this.baseLength = baseLength;
    }

    @Override
    public double high() {
        Point leftTop = new Point(getRightTop().getX() - getBaseLength(), getRightTop().getY());
        Point highBottom = new Point(leftTop.getX(), getLeftBottom().getY());
        return Math.abs(Math.sqrt(Math.pow(getLeftBottom().distance(leftTop), 2)
                - Math.pow(getLeftBottom().distance(highBottom), 2)));
    }

    public double diagonal() {
        return getLeftBottom().distance(getRightTop());
    }

    @Override
    public double perimeter() {
        return (getBaseLength() + getLeftBottom().distance(new Point(getRightTop().getX() - getBaseLength(), getRightTop().getY()))) * 2;
    }

    @Override
    public double square() {
        return high() * getBaseLength();
    }

    @Override
    public String toString() {
        return "Параллелограмм с кординатами левой нижней точки (" + getLeftBottom().getX() + "," +getLeftBottom().getY() +
                "), правой верхней точки (" + getRightTop().getX() + "," + getRightTop().getY() + ") и длиной основания " + getBaseLength();
    }

    public Point getLeftBottom() {
        return leftBottom;
    }

    public Point getRightTop() {
        return rightTop;
    }

    public int getBaseLength() {
        return baseLength;
    }
}
