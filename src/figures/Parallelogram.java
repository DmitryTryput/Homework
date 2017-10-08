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
        Point leftTop = new Point(rightTop.getX() - baseLength, rightTop.getY());
        Point highBottom = new Point(leftTop.getX(), leftBottom.getY());
        return Math.abs(Math.sqrt(Math.pow(leftBottom.distance(leftTop), 2)
                - Math.pow(leftBottom.distance(highBottom), 2)));
    }

    public double diagonal() {
        return leftBottom.distance(rightTop);
    }

    @Override
    public double perimeter() {
        return (baseLength + leftBottom.distance(new Point(rightTop.getX() - baseLength, rightTop.getY()))) * 2;
    }

    @Override
    public double square() {
        return high() * baseLength;
    }

    @Override
    public String toString() {
        return "Параллелограмм с кординатами левой нижней точки (" + leftBottom.getX() + "," +leftBottom.getY() +
                "), правой верхней точки (" + rightTop.getX() + "," + rightTop.getY() + ") и длиной основания " + getBaseLength();
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
