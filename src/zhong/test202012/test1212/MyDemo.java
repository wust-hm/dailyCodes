package zhong.test202012.test1212;

/**
 * @author zhong
 * @description 在类里面可以写一个和类名相同的方法，但是注意需要有返回值，和构造方法区别开来。
 * @date 2020/12/12 10:26
 * @motto talk is cheap, show me your code!
 */
public class MyDemo {
    String name;

    public void MyDemo(){
        System.out.println("可以在类里面定义一个和类同名的方法");
    }

    public MyDemo(String name) {
        this.name = name;
    }
}
