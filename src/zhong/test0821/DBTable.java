package zhong.test0821;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author codezero
 */
//表明只能用于类上
@Target(ElementType.TYPE)
//保存到运行时，因为后面运用反射的时候会用到
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
    //表名字
    String name() default "";
}

