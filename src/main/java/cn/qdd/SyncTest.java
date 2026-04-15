package cn.qdd;

/**
 * @Author: qdd
 * @Description: SyncTest
 * @DateTime: 2026/3/5 21:51
 **/
public class SyncTest {
    static final Object lock = new Object();
    static int counter = 0;
    public static void main(String[] args) {
        synchronized (lock) {
            counter++;
        }
    }
}
