package cn.qdd;

/**
 * @Author: qdd
 * @Description: WaitNotify
 * @DateTime: 2026/3/5 20:52
 **/
public class WaitNotify {
    static boolean flag = false;
    static Object lock = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (lock){
                while (!flag){
                    System.out.println(Thread.currentThread().getName()+"...wating...");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+"...flag is true");
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock){
                while (!flag){
                    System.out.println(Thread.currentThread().getName()+"...wating...");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+"...flag is true");
            }
        });

        Thread t3 = new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " hold lock");
                lock.notifyAll();
                flag = true;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();

    }

}
