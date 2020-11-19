package zhong.test1119.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhong
 * @description
 * @date 2020/11/19 14:02
 * @motto talk is cheap, show me your code!
 */
public class GuitaiA implements InvocationHandler {

    /**
     * 品牌
     */
    Object brand;

    public GuitaiA(Object brand) {
        this.brand = brand;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println("销售开始 柜台是：" + this.getClass().getSimpleName());
        Object result = method.invoke(brand, args);
//        System.out.println("销售结束");
        return result;
    }
}
