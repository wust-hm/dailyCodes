package zhong.test0820;

/**
 * @description:
 * @author: code-zero
 * @date: 2020/8/20 14:26
 */
public class ThreadTest2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        Thread.sleep(1000);
        t.interrupt(); // 中断t线程
        t.join(); // 等待t线程结束
        System.out.println("end");
    }
}

/**
 * @description: myThread线程里面又启动了一个hello线程
 * @date: 2020/8/20 14:38
 */
class MyThread extends Thread {
    @Override
    public void run() {
        Thread hello = new HelloThread();
        //启动hello线程
        hello.start();
        try {
            //等待hello线程结束
            hello.join();
        } catch (InterruptedException e) {
            System.out.println("interrupted!");
        }
        hello.interrupt();
    }
}

/**
 * @description: HelloThread也是一个线程，需要实时监听是否被中断
 * @date: 2020/8/20 15:03
 */
class HelloThread extends Thread {
    @Override
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
