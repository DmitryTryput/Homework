package concurrency;

import java.util.Random;

public interface RobotPart {

    int PARTS_COUNT = 9;

    static RobotPart randomProduce() {
        switch (new Random().nextInt(PARTS_COUNT)) {
            case 0:
                return new Body();
            case 1:
                return new Head();
            case 2:
                return new LeftFoot();
            case 3:
                return new RightFoot();
            case 4:
                return new LeftHand();
            case 5:
                return new RightHand();
            case 6:
                return new CPU();
            case 7:
                return new RAM();
            case 8:
                return new HDD();
        }
        return randomProduce();
    }
}
