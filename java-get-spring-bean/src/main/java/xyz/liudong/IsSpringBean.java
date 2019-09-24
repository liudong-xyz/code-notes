package xyz.liudong;

import org.springframework.stereotype.Component;

/**
 * 由 Spring 容器管理的类, 通过 @Component 注解注册成 Bean
 *
 * @author: liudong
 * @date: 2019/9/24
 */
@Component
public class IsSpringBean {

    public void get() {
        System.err.println("get Spring Bean!");
    }

}
