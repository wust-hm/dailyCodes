package zhong.test202010.test1014;

/**
 * @description:
 * @author: code-zero
 * @date: 2020/10/14 18:11
 */
public class JUnitDemo {
    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    public JUnitDemo() {
    }

    public JUnitDemo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int add(int a, int b){
        a = b;
        return a + b;
    }

    public int multip(int a, int b){
        int temp = a * b;
        return temp;
    }

    public static void main(String[] args) {

    }
}
