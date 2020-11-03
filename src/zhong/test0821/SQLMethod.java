package zhong.test0821;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 添加到方法的注解
 * @author codezero
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLMethod {
    String name() default "我是你大爷";
    String value() default "我是你爹";
}
