import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaitNotifyTest3 {
    public static CountDownLatch cdlA = new CountDownLatch(0);
    public static CountDownLatch cdlB = new CountDownLatch(1);
    public static CountDownLatch cdlC = new CountDownLatch(2);
    public static ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException {
        WaitNotifyTest3 w = new WaitNotifyTest3();
        executorService.execute(new Thread(() -> {w.printA();}));
        executorService.execute(new Thread(() -> {w.printB();}));
        executorService.execute(new Thread(() -> {w.printC();}));
//        executorService.awaitTermination(2, TimeUnit.SECONDS);
        executorService.shutdown();
    }

    public void printA() {
        try {
            for (int i = 0; i < 5; i++) {
                cdlA.await();
                System.out.println("A");
                cdlA = new CountDownLatch(2);
                cdlB.countDown();
                cdlC.countDown();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void printB() {
        try {
            for (int i = 0; i < 5; i++) {
                cdlB.await();
                System.out.println("B");
                cdlB = new CountDownLatch(2);
                cdlA.countDown();
                cdlC.countDown();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printC() {
        try {
            for (int i = 0; i < 5; i++) {
                cdlC.await();
                System.out.println("C");
                cdlC = new CountDownLatch(2);
                cdlA.countDown();
                cdlB.countDown();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
