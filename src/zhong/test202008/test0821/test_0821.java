package zhong.test202008.test0821;

/**
 * @description:
 * @author: code-zero
 * @date: 2020/8/21 15:45
 */
public class test_0821 {
    public static void main(String[] args) throws ClassNotFoundException {
        String[] arg = {"zhong.test202008.test0821.STUDENT"};
        for (String className : arg){
            System.out.println("创建的sql建表语句是：\n" + TableCreator.createTableSql(className));
        }
    }
}
