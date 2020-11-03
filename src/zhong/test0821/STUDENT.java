package zhong.test0821;

/**
 * @description: 注解的测试类
 * @author: code-zero
 * @date: 2020/8/21 13:58
 */
@DBTable(name = "STUDENT")
public class STUDENT {
    /**
     * 主键ID
     */
    @SQLString(name = "ID", value = 50, constraint = @Constraints(primaryKey = true))
    private String id;

    /**
     * 名字
     */
    @SQLString(name = "NAME", value = 30)
    private String name;

    /**
     * 年龄
     */
    @SQLInteger(name = "AGE")
    private int age;

    /**
     * 个人描述
     */
    @SQLString(name = "DESCRIPTION", value = 150, constraint = @Constraints(allowNull = true))
    private String description;

    @SQLMethod(name = "这是我的测试注解")
    public static void print(){
        System.out.println("为什么我的眼里常含泪水，因为我有一个算法不会！");
    }
}
