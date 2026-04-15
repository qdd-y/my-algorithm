package cn.qdd;

/**
 * @Author: qdd
 * @Description: WaitSleepCase
 * @DateTime: 2026/3/5 21:05
 **/
public class WaitSleepCase {

    static final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        waiting();
//        sleeping();
    }

    private static void illegalWait() throws InterruptedException {
        LOCK.wait();
    }

    private static void waiting() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (LOCK) {
                try {
                    System.out.println(Thread.currentThread().getName() + " sleeping...");
                    LOCK.wait(5000L);
                    System.out.println(Thread.currentThread().getName() + " wake up...");
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " interrupted...");
                    e.printStackTrace();
                }
            }
        }, "t1");
        t1.start();

        Thread.sleep(100);
        synchronized (LOCK) {
           System.out.println("main...");
        }

    }

    private static void sleeping() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (LOCK) {
                try {
                    System.out.println(Thread.currentThread().getName() + " sleeping...");
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " interrupted...");
                    e.printStackTrace();
                }
            }
        }, "t1");
        t1.start();

        Thread.sleep(100);
        synchronized (LOCK) {
            System.out.println("main...");
        }
    }
}
