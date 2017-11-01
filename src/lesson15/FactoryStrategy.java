package lesson15;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class FactoryStrategy implements Runnable {

    private static final int DAYS = 100;
    private Factory factory;
    private Semaphore semaphore;
    private CyclicBarrier cyclicBarrier;
    private Dumb dumb;

    public FactoryStrategy(Factory factory, Semaphore semaphore, CyclicBarrier cyclicBarrier, Dumb dumb) {
        this.factory = factory;
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
                System.out.println("Фабрика выкидывает детали на свалку.");
                factory.addPartsToDumb(dumb);
                semaphore.release();
                Thread.sleep(100);
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
