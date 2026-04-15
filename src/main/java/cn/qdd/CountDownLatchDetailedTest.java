package cn.qdd;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: qdd
 * @Description: CountDownLatch 详细演示 - 展示不同的执行时间导致的问题
 * @DateTime: 2026/3/12
 **/
public class CountDownLatchDetailedTest {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public static void main(String[] args) throws InterruptedException {
        System.out.println("==================== 详细演示：问题场景 ====================");
        System.out.println("场景：主线程只sleep 1秒，但工作线程需要2秒才能完成");
        System.out.println("结果：任务未完成就继续执行\n");
        problemScenario();

        System.out.println("\n==================== 详细演示：使用CountDownLatch ====================");
        System.out.println("场景：使用CountDownLatch优雅等待所有任务完成");
        System.out.println("结果：准确等待到任务完成为止\n");
        solutionWithCountDownLatch();
    }

    /**
     * 问题场景演示：不使用CountDownLatch导致的问题
     */
    public static void problemScenario() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        System.out.println("[" + now() + "] 【主线程】开始分配任务\n");
        long startTime = System.currentTimeMillis();

        // 分配3个任务
        for (int i = 1; i <= 3; i++) {
            final int taskId = i;
            executorService.submit(() -> {
                System.out.println("[" + now() + "] 【线程 " + taskId + "】进入线程，开始初始化...");
                try {
                    // 模拟初始化时间
                    Thread.sleep(500);
                    System.out.println("[" + now() + "] 【线程 " + taskId + "】初始化完成，开始耗时操作");
                    
                    // 模拟耗时操作（2秒）
                    Thread.sleep(2000);
                    
                    System.out.println("[" + now() + "] 【线程 " + taskId + "】耗时操作完成，正在处理结果...");
                    
                    // 处理结果
                    Thread.sleep(300);
                    System.out.println("[" + now() + "] 【线程 " + taskId + "】任务完全完成！");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("[" + now() + "] 【线程 " + taskId + "】被中断了");
                }
            });
        }

        System.out.println("[" + now() + "] 【主线程】所有任务已分配");
        System.out.println("[" + now() + "] 【主线程】调用 shutdown()...");
        executorService.shutdown();
        
        System.out.println("[" + now() + "] 【主线程】开始等待（只sleep 1秒）");
        Thread.sleep(1000); // ⚠️ 问题：只等待了1秒，但工作线程需要2.8秒
        
        System.out.println("[" + now() + "] 【主线程】1秒时间到，继续执行");
        System.out.println("[" + now() + "] 【主线程】打印结果数据...");
        System.out.println("[" + now() + "] 【主线程】数据处理完成");

        long endTime = System.currentTimeMillis();
        System.out.println("[" + now() + "] 【主线程】总耗时: " + (endTime - startTime) + "ms");
        
        System.out.println("\n⚠️  问题分析：");
        System.out.println("  ✗ 主线程在1秒时就继续执行了");
        System.out.println("  ✗ 工作线程的任务需要2.8秒才能完成");
        System.out.println("  ✗ 结果：打印结果数据时，工作线程还在忙碌，数据不完整！");
        System.out.println("  ✗ 如果依赖这些数据进行下一步操作，会出现数据丢失或错误！\n");

        // 让程序继续运行，看看实际情况
        Thread.sleep(3000);
    }

    /**
     * 使用 CountDownLatch 的优雅解决方案
     */
    public static void solutionWithCountDownLatch() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CountDownLatch latch = new CountDownLatch(3);

        System.out.println("[" + now() + "] 【主线程】创建 CountDownLatch(3)，代表要等待3个任务");
        System.out.println("[" + now() + "] 【主线程】开始分配任务\n");
        long startTime = System.currentTimeMillis();

        // 分配3个任务
        for (int i = 1; i <= 3; i++) {
            final int taskId = i;
            executorService.submit(() -> {
                System.out.println("[" + now() + "] 【线程 " + taskId + "】进入线程，开始初始化...");
                try {
                    // 模拟初始化时间
                    Thread.sleep(500);
                    System.out.println("[" + now() + "] 【线程 " + taskId + "】初始化完成，开始耗时操作");
                    
                    // 模拟耗时操作（2秒）
                    Thread.sleep(2000);
                    
                    System.out.println("[" + now() + "] 【线程 " + taskId + "】耗时操作完成，正在处理结果...");
                    
                    // 处理结果
                    Thread.sleep(300);
                    System.out.println("[" + now() + "] 【线程 " + taskId + "】任务完全完成！");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("[" + now() + "] 【线程 " + taskId + "】被中断了");
                } finally {
                    System.out.println("[" + now() + "] 【线程 " + taskId + "】调用 latch.countDown()，计数-1");
                    latch.countDown();
                }
            });
        }

        System.out.println("[" + now() + "] 【主线程】所有任务已分配");
        System.out.println("[" + now() + "] 【主线程】调用 latch.await()，阻塞等待...");
        latch.await(); // ✅ 优雅地阻塞，直到所有任务完成
        
        System.out.println("[" + now() + "] 【主线程】latch计数已变为0，所有任务都完成了！");
        System.out.println("[" + now() + "] 【主线程】开始打印结果数据...");
        System.out.println("[" + now() + "] 【主线程】数据处理完成");

        long endTime = System.currentTimeMillis();
        System.out.println("[" + now() + "] 【主线程】总耗时: " + (endTime - startTime) + "ms");
        
        System.out.println("\n✅ 优势分析：");
        System.out.println("  ✓ 主线程精确等待了2.8秒");
        System.out.println("  ✓ 确保所有工作线程都完成后才继续");
        System.out.println("  ✓ 打印结果数据时，所有数据都已准备好");
        System.out.println("  ✓ 无需猜测等待时间，无需手动调整");
        System.out.println("  ✓ 代码逻辑清晰，易于维护\n");

        executorService.shutdown();
    }

    /**
     * 获取当前时间（用于演示执行顺序）
     */
    private static String now() {
        return LocalTime.now().format(formatter);
    }

}
