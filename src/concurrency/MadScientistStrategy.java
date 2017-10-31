package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class MadScientistStrategy implements Runnable {

    private static final int DAYS = 100;
    private MadScientist madScientist;
    private Semaphore semaphore;
    private CyclicBarrier cyclicBarrier;
    private Dumb dumb;

    public MadScientistStrategy(MadScientist madScientist, Semaphore semaphore, CyclicBarrier cyclicBarrier, Dumb dumb) {
        this.madScientist = madScientist;
        this.semaphore = semaphore;
        this.cyclicBarrier = cyclicBarrier;
        this.dumb = dumb;
    }

    @Override
    public void run() {
        for (int i = 0; i < DAYS; i++) {
            try {
                cyclicBarrier.await();
                semaphore.acquire();
                System.out.println(madScientist.getName() + " отправляет своего помощника "
                        + madScientist.getServant().getName() + " за деталями.");
                madScientist.getServant().mine(dumb);
                semaphore.release();
                madScientist.takeParts();
                madScientist.createRobot();
                Thread.sleep(100);
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
