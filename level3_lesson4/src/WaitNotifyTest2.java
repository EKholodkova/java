public class WaitNotifyTest2 {
    public final Object mon1 = new Object();
    public final Object mon2 = new Object();
    public final Object mon3 = new Object();
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        WaitNotifyTest2 w = new WaitNotifyTest2();
        Thread t1 = new Thread(() -> {w.printA();});
        Thread t2 = new Thread(() -> {w.printB();});
        Thread t3 = new Thread(() -> {w.printC();});
        t1.start();
        t2.start();
        t3.start();
    }

    public void printA() {
        synchronized (mon1) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'A') {
                        mon1.wait();
                    }
                    System.out.println("A");
                    currentLetter = 'B';
                    synchronized (mon2) {
                        mon2.notify();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (mon2) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B') {
                        mon2.wait();
                    }
                    System.out.println("B");
                    currentLetter = 'C';
                    synchronized (mon3) {
                        mon3.notify();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (mon3) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'C') {
                        mon3.wait();
                    }
                    System.out.println("C");
                    currentLetter = 'A';
                    synchronized (mon1) {
                        mon1.notify();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
