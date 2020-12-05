package zhong.test202008.test0819;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: code-zero
 * @date: 2020/8/19 18:53
 */
public class MyRunnableTest implements Runnable {

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName() + "-------------进入");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(currentThread.getName() + "-------------离开");
        }

    }
}
