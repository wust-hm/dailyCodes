package zhong.test202011.test1119.dynamic_proxy;

/**
 * @author zhong
 * @description
 * @date 2020/11/19 14:01
 * @motto talk is cheap, show me your code!
 */
public class MaotaiWine implements SellWine {
    @Override
    public void sellWine() {
        System.out.println("我卖的是茅台酒！");
    }

    @Override
    public void test() {
        System.out.println("抑郁到爆炸！！！");
    }
}
