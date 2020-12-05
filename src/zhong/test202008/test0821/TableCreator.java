package zhong.test202008.test0821;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 运行时注解处理器，构造表创建语句
 * @author: code-zero
 * @date: 2020/8/21 14:05
 */
public class TableCreator {

    public static String createTableSql(String className) throws ClassNotFoundException{
        //运用反射拿到Class对象
        Class<?> cl = Class.forName(className);
        DBTable dbTable = cl.getAnnotation(DBTable.class);
        if (dbTable == null){
            System.out.println("没有找到DBTable类的注解!");
            return null;
        }
        String tableName = dbTable.name();

        if (tableName.length() < 1){
            tableName = cl.getName().toUpperCase();
        }

        List<String> columnDefs = new ArrayList<String>();
        Field[] fields = cl.getDeclaredFields();
        Method[] methods = cl.getDeclaredMethods();
        //获取当前类的所有字段，包括私有的，但是不能获取继承的字段
        for (Field field : cl.getDeclaredFields()){
            String columnName = null;
            Annotation[] annotations = field.getDeclaredAnnotations();
            //如果在该字段上没有注解，则跳过
            if (annotations.length < 1){
                continue;
            }

            if (annotations[0] instanceof SQLInteger){
                SQLInteger sqlInteger = (SQLInteger) annotations[0];
                //获取字段对应列名称，如果没有就是使用字段名来代替
                if (sqlInteger.name().length() < 1){
                    columnName = field.getName().toUpperCase();
                }else{
                    columnName = sqlInteger.name();
                }
                columnDefs.add(columnName + " INT " + getConstraints(sqlInteger.constraint()));
            }

            if (annotations[0] instanceof SQLString){
                SQLString sqlString = (SQLString) annotations[0];

                if (sqlString.name().length() < 1){
                    columnName = field.getName().toUpperCase();
                }else{
                    columnName = sqlString.name();
                }
                columnDefs.add(columnName + " varchar(" + sqlString.value() + ") " + getConstraints(sqlString.constraint()));
            }

        }

        StringBuilder stringBuilder = new StringBuilder("create table " + tableName + "(");
        for (String columnDef : columnDefs){
            stringBuilder.append("\n").append(columnDef).append(",");
        }
        String tableCreate = stringBuilder.substring(0, stringBuilder.length() - 1) + ");";
        return tableCreate;
    }

    /**
     * @description: 获取注解字段上面的具体注解
     * @param con: 数据表条件限制的注解
     * @return: java.lang.String
     * @date: 2020/8/21 15:29
     */
    private static String getConstraints(Constraints con){
        String constraints = "";
        if (!con.allowNull()){
            constraints += "not null ";
        }
        if (con.primaryKey()){
            constraints += "primary key ";
        }
        if (con.unique()){
            constraints += "unique ";
        }
        return constraints;
    }
}
