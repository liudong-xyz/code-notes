package xyz.liudong;

/**
 * Java - cglib 代理
 *
 * @author: liudong
 * @date: 2019/10/25
 */
public class Application {

    public static void main(String[] args) {

        BusinessService businessService = (BusinessService) new CglibProxy(new BusinessServiceImpl()).getInstance();
        businessService.select();

    }

}
