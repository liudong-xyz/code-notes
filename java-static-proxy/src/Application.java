/**
 * Java - 静态代理
 *
 * @author: liudong
 * @date: 2019/10/25
 */
public class Application {

    public static void main(String[] args) {

        BusinessService businessService = StaticProxyToBusiness.getInstance();
        businessService.select();

    }

}
// reference:
// Java 动态代理详解: https://juejin.im/post/5c1ca8df6fb9a049b347f55c
// java静态代理和动态代理: https://blog.csdn.net/giserstone/article/details/17199755
// Java三种代理模式：静态代理、动态代理和cglib代理: https://segmentfault.com/a/1190000011291179
// Java动态代理: https://juejin.im/post/5ad3e6b36fb9a028ba1fee6a
// Proxy Design Pattern: https://www.geeksforgeeks.org/proxy-design-pattern/
