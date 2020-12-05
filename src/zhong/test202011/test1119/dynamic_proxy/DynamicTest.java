package zhong.test202011.test1119.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author zhong
 * @description
 * @date 2020/11/19 14:05
 * @motto talk is cheap, show me your code!
 */
public class DynamicTest {
    public static void main(String[] args) {
        MaotaiWine maotaiWine = new MaotaiWine();
        InvocationHandler invocationHandler = new GuitaiA(maotaiWine);

        ClassLoader classLoader = MaotaiWine.class.getClassLoader();
        Class[] classes = MaotaiWine.class.getInterfaces();
        Class s = MaotaiWine.class;

        SellWine dynamicProxy = (SellWine) Proxy.newProxyInstance(MaotaiWine.class.getClassLoader(), MaotaiWine.class.getInterfaces(), invocationHandler);
        dynamicProxy.sellWine9();
        int flag = 0;
    }
}
