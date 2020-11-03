package zhong.test0821;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author codezero
 */
//表示运用到字段上
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLInteger {
    //对应数据库的列名
    String name() default "";
    //嵌套注解
    Constraints constraint() default @Constraints;
}
