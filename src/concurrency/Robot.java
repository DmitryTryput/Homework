package concurrency;

import lombok.Data;

@Data
public class Robot {

    private Head head;
    private Body body;
    private LeftHand leftHand;
    private LeftFoot leftFoot;
    private RightFoot rightFoot;
    private RightHand rightHand;
    private CPU cpu;
    private HDD hdd;
    private RAM ram;

    public Robot(Head head, Body body, LeftHand leftHand, LeftFoot leftFoot, RightFoot rightFoot, RightHand rightHand, CPU cpu, HDD hdd, RAM ram) {
        this.head = head;
        this.body = body;
        this.leftHand = leftHand;
        this.leftFoot = leftFoot;
        this.rightFoot = rightFoot;
        this.rightHand = rightHand;
        this.cpu = cpu;
        this.hdd = hdd;
        this.ram = ram;
    }
}
