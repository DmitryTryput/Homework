package lesson15;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class Servant {

    private static final int MAX_OBTAINED_ELEMENTS = 4;
    private List<RobotPart> parts = new ArrayList<>();
    private String name;

    public Servant(String name) {
        this.name = name;
    }

    public void mine(Dumb dumb) {
        int servantTake = new Random().nextInt(MAX_OBTAINED_ELEMENTS) + 1;
        if (servantTake > dumb.partsCount()) {
            servantTake = dumb.partsCount();
        }
        for (int i = 0; i < servantTake; i++) {
            getParts().add(dumb.getParts().remove());
        }
    }
}
