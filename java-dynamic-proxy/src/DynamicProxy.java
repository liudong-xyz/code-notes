import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * DynamicProxy
 *
 * @author: liudong
 * @date: 2019/10/25
 */
public class DynamicProxy implements InvocationHandler {

    private Object target;

    private DynamicProxy(Object target) {
        this.target = target;
    }

    public static Object getInstance(Object serviceImpl) {
        ClassLoader classLoader = serviceImpl.getClass().getClassLoader();

        Class[] interfaces = serviceImpl.getClass().getInterfaces();

        InvocationHandler logHandler = new DynamicProxy(serviceImpl);

        return Proxy.newProxyInstance(classLoader, interfaces, logHandler);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = method.invoke(target, args);
        long endTime = System.currentTimeMillis();
        System.err.println("get execution time by [dynamic proxy]: " + (endTime - startTime) + "ms");
        return result;
    }

}
