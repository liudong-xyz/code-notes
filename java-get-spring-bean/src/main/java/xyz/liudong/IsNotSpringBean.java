package xyz.liudong;

/**
 * 普通类, 未被 Spring 注册成 Bean
 *
 * @author: liudong
 * @date: 2019/9/24
 */
public class IsNotSpringBean {

    private IsSpringBean isSpringBean = SpringContextUtils.getBean(IsSpringBean.class);

    public void callSpringBean() {
        isSpringBean.get();
    }

}
