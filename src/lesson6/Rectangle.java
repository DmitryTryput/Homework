package lesson6;

public class Rectangle {

    private Point leftTop;
    private Point rightBottom;

    public Rectangle(Point leftTop, Point rightBottom) {
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;
    }

    public Rectangle(int leftX, int leftY, int rightX, int rightY) {
        leftTop = new Point(leftX, leftY);
        rightBottom = new Point(rightX, rightY);
    }

    public double diameter() {
        return  leftTop.distance(rightBottom);
    }

    public int square() {
        return xSize() * ySize();
    }

    private int xSize() {
        return Math.abs(Math.max(leftTop.getX(), rightBottom.getX()) - Math.min(leftTop.getX(), rightBottom.getX()));
    }

    private int ySize() {
        return Math.abs(Math.max(leftTop.getY(), rightBottom.getY()) - Math.min(leftTop.getY(), rightBottom.getY()));
    }
}
