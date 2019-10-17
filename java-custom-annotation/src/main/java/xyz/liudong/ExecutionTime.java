package xyz.liudong;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ExecutionTime 注解
 * 使用在方法上, 用于打印记录方法执行时间
 *
 * @author: liudong
 * @date: 2019/10/17
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExecutionTime {

    /**
     * 时间单位, 默认: ms
     *
     * @return ExecutionTimeEnum[]
     */
    ExecutionTimeEnum[] timeUnit() default ExecutionTimeEnum.MILLISECOND;

}
