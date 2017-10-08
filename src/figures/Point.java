package figures;

public class Point implements Figure {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point p) {
        return Math.abs(Math.sqrt(Math.pow((getX() - p.getX()), 2) + Math.pow((getY() - p.getY()), 2)));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Точка с кординатами: " + getX() + " " + getY();
    }
}
