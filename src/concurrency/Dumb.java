package concurrency;

import lombok.Data;

import java.util.*;

@Data
public class Dumb {

    private static final int PRODUCED_ELEMENTS = 20;
    private static final int PARTS_COUNT = 9;
    private Deque<RobotPart> parts = new LinkedList<>();

    public Dumb() {
        createParts();
    }

    private void createParts() {
        for (int i = 0; i < PRODUCED_ELEMENTS; i++) {
            getParts().add(RobotPart.randomProduce());
        }
    }

    public int partsCount() {
        return getParts().size();
    }
}
