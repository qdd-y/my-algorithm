package cn.qdd;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: qdd
 * @Description: MyCallable
 * @DateTime: 2026/3/5 20:17
 **/
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("MyCallable...call...");
        return "OK";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建MyCallable对象
        MyCallable mc = new MyCallable();
        // 创建FutureTask对象
        FutureTask<String> ft = new FutureTask<String>(mc) ;
        //
        Thread t1 = new Thread(ft);
        Thread t2 = new Thread(ft);

        // 启动线程
        t1.start();
        String result = ft.get();

        System.out.println(result);
    }
}
