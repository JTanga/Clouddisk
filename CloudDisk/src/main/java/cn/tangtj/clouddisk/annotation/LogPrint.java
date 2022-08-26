package cn.tangtj.clouddisk.annotation;

import java.lang.annotation.*;


@Target(ElementType.METHOD) // 作用于方法
@Retention(RetentionPolicy.RUNTIME)
public @interface LogPrint {
    String module() default "";
}
