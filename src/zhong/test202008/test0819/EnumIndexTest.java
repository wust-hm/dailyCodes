package zhong.test202008.test0819;

/**
 * @description:
 * @author: code-zero
 * @date: 2020/8/6 11:22
 */

public class EnumIndexTest {
    enum Constants2 {
        /**
         * Constants_A、Constants_B等为Enum类中的name属性（还有一个是ordinal属性），任何枚举类都是Enum类的子类
         */
        Constants_A("枚举成员A"), Constants_B("枚举成员B"), Constants_C("枚举成员C"), Constants_DD(3);

        /**
         * 自定义属性
         */
        private String description;

        /**
         */
        private int i = 4;

        private Constants2() {

        }

        private Constants2(String myDescription) {
            this.description = myDescription;
        }

        private Constants2(int i) {
            this.i = this.i + i;
        }

        public String getDescription() {
            return description;
        }

        public int geti() {
            return i;
        }

    }

    public static void main(String[] args) {
        Constants2[] constants2ListTest = Constants2.values();
        for (int i = 0; i < Constants2.values().length; i++) {
            System.out.println(Constants2.values()[i] + "调用getDescription()方法为：" + Constants2.values()[i].getDescription());
        }
        System.out.println(Constants2.valueOf("Constants_DD") + "调用geti() 方法为：" + Constants2.valueOf("Constants_DD").geti());
    }
}
