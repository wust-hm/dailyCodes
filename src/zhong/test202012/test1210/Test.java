package zhong.test202012.test1210;

/**
 * @author zhong
 * @description
 * @date 2020/12/10 18:30
 * @motto talk is cheap, show me your code!
 */
public class Test {
    public static void main(String[] args) {
        // 创建在堆内存里面
        String str1 = new String("123");

        // 然后在常量池里面放一个引用，引用指向的是堆中的地址
        str1.intern();

        // 常量池中的地址
        String str2 = "123";

        // 常量池中
        String str3 = "1";

        // 常量池中
        String str4 = "23";

        // 先是使用StringBuffer类的append方法，将两个拼接在一起，然后在toString。所以str5在堆内存中
        String str5 = str3 + str4;

        System.out.println(str1 == str2);

        System.out.println(str1.equals(str2));


    }
}
