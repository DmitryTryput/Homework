package concurrency;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class Servant {

    private static final int MAX_OBTAINED_ELEMENTS = 4;
    private List<RobotPart> parts = new ArrayList<>();
    private int fatigue = 0;

    public void mine(Dumb dumb) {
        if (dumb.partsCount() == 0) {
            setFatigue(getFatigue() / 2);
            return;
        }
        int servantTake = new Random().nextInt(MAX_OBTAINED_ELEMENTS) + 1;
        if (servantTake > dumb.partsCount()) {
            servantTake = dumb.partsCount();
        }
        setFatigue(getFatigue() + servantTake);
        for (int i = 0; i < servantTake; i++) {
            getParts().add(dumb.getParts().remove());
        }
    }
}
