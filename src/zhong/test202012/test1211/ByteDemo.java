package zhong.test202012.test1211;

/**
 * @author zhong
 * @description
 * @date 2020/12/11 18:34
 * @motto talk is cheap, show me your code!
 */
public class ByteDemo {

    public void add(Byte b) {
        b = b++;
    }

    public void test() {
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.print(a + " ");
        add(b);
        System.out.print(b + "");
    }
}
