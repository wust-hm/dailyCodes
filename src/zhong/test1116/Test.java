package zhong.test1116;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author zhong
 * @date 2020/11/16 19:35
 * @motto talk is cheap, show me your code!
 */
public class Test {

    /**
     * 单例模式下，
     */
    private static Test test;

    /**
     * @description 空的构造方法。记住，构造方法是private，只能自己创建自己，不能由他人来创建
     * @param
     * @return
     * @date 2020/11/17 10:15
     */
    private Test(){

    }

    /**
     * @description 获取实例的方法，注意，必须要为static修饰，因为只能通过类来访问，不能通过对象来访问。
     * 同时实例对象也要用static来修饰，因为static方法不能访问非static的变量
     * @param
     * @return zhong.test1116.Test
     * @date 2020/11/17 10:18
     */
    public static Test getInstance(){
        // 如果实例为空，则直接创建一个，如果不为空，则直接返回。注意，在多线程环境下是不安装的
        if (test == null){
            test = new Test();
        }
        return test;
    }

    /**
     * 在多线程环境下安全的返回。
     * 多线程环境下，如果
     * @return
     */
    public static Test getInstanceSafety(){
        // 如果实例为空，则先获取当前这个类的锁🔒
        if (test == null){
            synchronized (Test.class){
                /**
                 * 尤其注意，如果线程A获得了类的锁🔒，而线程B没获取到，线程就会等待。
                 * 然后线程A完成了实例的创建后，释放类锁。线程B进入同步代码块，因为之前已经
                 * 判断过了实例为null（但是此时线程A已经创建了，现在已经不为null了），所以还会再次创建，
                 * 故必须在同步代码块里面再判断一次，防止创建duo'ge实例
                 */
                // 第二次判断是否为null
                if (test == null){
                    test = new Test();
                }
            }
        }
        return test;
    }
}
