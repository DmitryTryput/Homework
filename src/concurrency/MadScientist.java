package concurrency;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MadScientist {

    private String name;
    private Servant servant;
    private List<RobotPart> parts = new ArrayList<>();
    private List<Robot> robots = new ArrayList<>();

    public MadScientist(String name, Servant servant) {
        this.name = name;
        this.servant = servant;
    }

    public void createRobot() {
        while (checkParts()) {
            produceRobot();
        }
    }

    public void takeParts() {
        getParts().addAll(getServant().getParts());
        getServant().getParts().clear();
    }

    private boolean checkParts() {
        return getParts().contains(new Head()) && getParts().contains(new Body()) && getParts().contains(new LeftFoot())
                && getParts().contains(new LeftHand()) && getParts().contains(new RightFoot()) && getParts().contains(new RightHand())
                && getParts().contains(new CPU()) && getParts().contains(new RAM()) && getParts().contains(new HDD());
    }

    private void produceRobot() {
        Robot robot = new Robot(new Head(), new Body(), new LeftHand(), new LeftFoot(), new RightFoot(),
                new RightHand(), new CPU(), new HDD(), new RAM());
        getParts().remove(robot.getBody());
        getParts().remove(robot.getHdd());
        getParts().remove(robot.getHead());
        getParts().remove(robot.getCpu());
        getParts().remove(robot.getLeftFoot());
        getParts().remove(robot.getRightHand());
        getParts().remove(robot.getLeftHand());
        getParts().remove(robot.getRightFoot());
        getParts().remove(robot.getRam());
        getRobots().add(robot);
    }

    public int robotCount() {
        return getRobots().size();
    }
}
