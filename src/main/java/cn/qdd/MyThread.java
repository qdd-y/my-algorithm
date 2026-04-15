package cn.qdd;

/**
 * @Author: qdd
 * @Description: MyThread
 * @DateTime: 2026/3/5 20:12
 **/
public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("MyThread...run...");
    }

    public static void main(String[] args) {
        // 创建线程对象
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        // 启动线程
        t1.start();
        t2.start();
    }
}
