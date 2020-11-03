package zhong.test0819;

/**
 * @description:
 * @author: code-zero
 * @date: 2020/8/19 19:04
 */
public class ThreadTest {

    public static void main(String[] args) {
        MyRunnableTest myRunnableTest = new MyRunnableTest();
        Thread thread1 = new Thread(myRunnableTest, "线程1");
        Thread thread2 = new Thread(myRunnableTest, "线程2");
        Thread thread3 = new Thread(myRunnableTest, "线程3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
