package xyz.liudong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Java - 普通类获取由 Spring 容器管理的类, 并调用
 *
 * @author: liudong
 * @date: 2019/9/24
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        IsNotSpringBean isNotSpringBean = new IsNotSpringBean();
        isNotSpringBean.callSpringBean();
    }

}
