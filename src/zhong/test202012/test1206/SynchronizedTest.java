package zhong.test202012.test1206;

/**
 * @author zhong
 * @description
 * @date 2020/12/5 16:51
 * @motto talk is cheap, show me your code!
 */
public class SynchronizedTest {
    public synchronized void doSth(){
        System.out.println("hello, world!");
    }

    public void doSth1(){
        synchronized (SynchronizedTest.class){
            System.out.println("我是你爸爸！");
        }
    }
}
