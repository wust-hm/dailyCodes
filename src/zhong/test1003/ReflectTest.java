package zhong.test1003;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description: 重学反射的知识点练习实例
 * @author: code-zero
 * @date: 2020/10/3 15:15
 */
public class ReflectTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Proxy target = new Proxy();
        Method method = Proxy.class.getDeclaredMethod("run");
        method.invoke(target);
    }

    static class Proxy{
        public void run(){
            System.out.println("代理run！");
        }
    }
}
