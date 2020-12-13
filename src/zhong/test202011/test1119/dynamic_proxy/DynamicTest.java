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

        // 获取类加载器。
        ClassLoader classLoader = MaotaiWine.class.getClassLoader();
        // 获取其实现的接口
        Class[] classes = MaotaiWine.class.getInterfaces();
        // 获取其实现类
        Class s = MaotaiWine.class;

        SellWine dynamicProxy = (SellWine) Proxy.newProxyInstance(MaotaiWine.class.getClassLoader(), MaotaiWine.class.getInterfaces(), invocationHandler);
        dynamicProxy.sellWine();
        dynamicProxy.test();
        int flag = 0;
    }
}
