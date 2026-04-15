package cn.qdd;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: qdd
 * @Description: MyExecutors
 * @DateTime: 2026/3/5 20:21
 **/
public class MyExecutors implements Runnable{
    @Override
    public void run() {
        System.out.println("MyRunnable...run...");
    }

    public static void main(String[] args) {
        // 创建线程池对象
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        threadPool.submit(new MyExecutors()) ;

        // 关闭线程池
        threadPool.shutdown();


    }
}
