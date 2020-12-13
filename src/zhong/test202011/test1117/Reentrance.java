package zhong.test202011.test1117;/**
 * @description
 * @author zhong
 * @date 2020/11/17 18:20
 * @motto talk is cheap, show me your code!
 */
public class Reentrance {
    public synchronized void outter(){
        System.out.println("enter outter");
        inner();
    }

    public synchronized void inner(){
        System.out.println("enter inner");
    }

    public static void main(String[] args) {
        new Reentrance().outter();
    }
}
