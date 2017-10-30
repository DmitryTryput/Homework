package concurrency;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Challenge {

    private static final int TREADS_COUNT = 3;
    private static final int PARTIES = 3;
    private static final int PERMITS = 1;
    private static int night = 1;

    public static void main(String[] args) {
        MadScientist first = new MadScientist("Рик", new Servant());
        MadScientist second = new MadScientist("Эммэтт", new Servant());
        Factory factory = new Factory();
        Dumb dumb = new Dumb();
        ExecutorService executorService
                = Executors.newFixedThreadPool(TREADS_COUNT);
        Semaphore semaphore = new Semaphore(PERMITS);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(PARTIES, () -> {
            System.out.println("Началась " + night + " ночь");
            night++;
        });
        executorService.submit(new MadScientistStrategy(first, semaphore, cyclicBarrier, dumb));
        executorService.submit(new MadScientistStrategy(second, semaphore, cyclicBarrier, dumb));
        executorService.submit(new FactoryStrategy(factory, semaphore, cyclicBarrier, dumb));
        executorService.shutdown();
        try {
            executorService.awaitTermination(1L, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (executorService.isShutdown()) {
            if (first.robotCount() > second.robotCount()) {
                System.out.println(first.getName() + " победил, собрав " + first.robotCount() + " роботов. " +
                        second.getName() + " собрал " + second.robotCount() + " роботов.");
            } else if (second.robotCount() > first.robotCount()) {
                System.out.println(second.getName() + " победил, собрав " + second.robotCount() + " роботов. " +
                        first.getName() + " собрал " + first.robotCount() + " роботов.");
            } else {
                System.out.println("Ничья. " + first.getName() + " и " + second.getName() + " собрали по "
                        + first.robotCount() + " роботов.");
            }
        }
    }
}
