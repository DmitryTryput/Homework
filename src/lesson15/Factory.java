package lesson15;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class Factory {

    private static final int PRODUCED_ELEMENTS = 4;
    private List<RobotPart> produced = new ArrayList<>();

    public void addPartsToDumb(Dumb dumb) {
        createParts();
        dumb.getParts().addAll(getProduced());
        getProduced().clear();
    }

    private void createParts() {
        int count = new Random().nextInt(PRODUCED_ELEMENTS) + 1;
        for (int i = 0; i < count; i++) {
            getProduced().add(RobotPart.randomProduce());
        }
    }
}
