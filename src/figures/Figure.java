package figures;

public interface Figure {

    default void draw() {
        System.out.println("Рисуем " + this);
    }
}
