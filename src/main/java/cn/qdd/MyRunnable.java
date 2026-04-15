package cn.qdd;

/**
 * @Author: qdd
 * @Description: MyRunnable
 * @DateTime: 2026/3/5 20:14
 **/
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("MyRunnable...run...");
    }

    public static void main(String[] args) {

        // 创建MyRunnable对象
        MyRunnable mr = new MyRunnable();

        // 创建线程对象
        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);

        t1.start();
        t2.start();


    }
}
