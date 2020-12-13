package zhong.test202012.test1207;

/**
 * @author zhong
 * @description
 * @date 2020/12/7 19:08
 * @motto talk is cheap, show me your code!
 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    private byte[]  bigSize = new byte[2 * _1MB];

    public static void main(String[] args){
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();

    }
}
