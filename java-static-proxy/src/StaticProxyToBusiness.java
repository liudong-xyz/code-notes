/**
 * StaticProxyToBusiness
 *
 * @author: liudong
 * @date: 2019/10/25
 */
public class StaticProxyToBusiness implements BusinessService {

    private BusinessService businessService;

    private StaticProxyToBusiness(BusinessService businessService) {
        this.businessService = businessService;
    }

    public static BusinessService getInstance() {
        return new StaticProxyToBusiness(new BusinessServiceImpl());
    }

    @Override
    public void select() {
        long startTime = System.currentTimeMillis();
        businessService.select();
        long endTime = System.currentTimeMillis();
        System.err.println("get execution time by [static proxy]: " + (endTime - startTime) + "ms");
    }

}
