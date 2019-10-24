/**
 * Java - 动态代理
 *
 * @author: liudong
 * @date: 2019/10/25
 */
public class Application {

    public static void main(String[] args) {

        BusinessService businessService = (BusinessService) DynamicProxy.getInstance(new BusinessServiceImpl());
        businessService.select();

    }

}
