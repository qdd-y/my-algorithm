package cn.qdd;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: qdd
 * @Description: CountDownLatch 演示 - 与不使用 CountDownLatch 的区别
 * @DateTime: 2026/3/12
 **/
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("========== 演示1: 不使用 CountDownLatch 的情况 ==========");
        withoutCountDownLatch();

        System.out.println("\n========== 演示2: 使用 CountDownLatch 的情况 ==========");
        withCountDownLatch();
    }

    /**
     * 不使用 CountDownLatch：主线程无法准确等待所有工作线程完成
     */
    public static void withoutCountDownLatch() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        
        System.out.println("主线程开始分配任务");
        long startTime = System.currentTimeMillis();

        // 分配3个任务
        for (int i = 1; i <= 3; i++) {
            final int taskId = i;
            executorService.submit(() -> {
                try {
                    System.out.println("线程 " + taskId + " 开始工作");
                    Thread.sleep(2000); // 模拟耗时操作
                    System.out.println("线程 " + taskId + " 工作完成");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // 问题：这里只是关闭线程池，但不能保证所有任务都完成了
        executorService.shutdown();
        
        // 如果不加这个等待，主线程会继续往下执行，可能打印的时候任务还没完成
        Thread.sleep(3000); // 需要手动sleep来等待，不够优雅
        
        long endTime = System.currentTimeMillis();
        System.out.println("主线程继续执行（可能任务未完成）");
        System.out.println("耗时: " + (endTime - startTime) + "ms\n");
    }

    /**
     * 使用 CountDownLatch：主线程可以优雅地等待所有工作线程完成
     */
    public static void withCountDownLatch() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CountDownLatch latch = new CountDownLatch(3); // 创建 CountDownLatch，设置计数为3

        System.out.println("主线程开始分配任务");
        long startTime = System.currentTimeMillis();

        // 分配3个任务
        for (int i = 1; i <= 3; i++) {
            final int taskId = i;
            executorService.submit(() -> {
                try {
                    System.out.println("线程 " + taskId + " 开始工作");
                    Thread.sleep(2000); // 模拟耗时操作
                    System.out.println("线程 " + taskId + " 工作完成");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown(); // 任务完成后，计数减1
                }
            });
        }

        // 主线程在这里等待，直到 latch 的计数变为0
        System.out.println("主线程等待所有工作线程完成...");
        latch.await(); // 优雅地阻塞，直到所有任务完成

        long endTime = System.currentTimeMillis();
        System.out.println("主线程继续执行（所有任务都已完成）");
        System.out.println("耗时: " + (endTime - startTime) + "ms\n");

        executorService.shutdown();
    }

}
