package figures;

public interface Figure {

    public default void draw() {
        System.out.println("Рисуем " + this);
    }
}
