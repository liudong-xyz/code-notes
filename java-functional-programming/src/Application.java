import java.util.Objects;

/**
 * Java - 函数式编程
 *
 * @author: liudong
 * @date: 2019/10/12
 */
public class Application {

    public static void main(String[] args) {

        // --------------------- 简单了解 ---------------------
        // 在 Java 没有引入函数式编程(或称 Lambda 表达式)前, 我们通常使用匿名内部类来创建线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.err.println("use anonymous inner class create thread");
            }
        }).start();

        // 使用 Lambda 表达式创建线程
        new Thread(() -> System.err.println("use lambda expression create thread")).start();


        // --------------------- 自定义函数式接口 ---------------------
        // 1. 创建接口类
        // 2. 在你所创建的接口类上添加 @FunctionalInterface 注解
        // 3. 写入你的方法

        // 使用你的自定义函数式接口
        // 1. 消费型接口
        Consumer<String> consumerFunctionalInterface = s -> System.err.println("we have " + s + " surplus fuel");
        consumerFunctionalInterface.accept("60%");

        // 2. 功能型接口
        Function<String, String> functionFunctionalInterface = s -> {
            System.err.println(s.toUpperCase());
            return s.toUpperCase();
        };
        functionFunctionalInterface.apply("Hello World");

        // 3. 供给型接口
        Supply<String> supplyFunctionalInterface = () -> String.valueOf(Math.random() * 100);
        System.err.println(supplyFunctionalInterface.get());

        // 4. 断言型接口
        Predicate<String> predicateFunctionalInterface = s -> Objects.equals(s, "test");
        System.err.println(predicateFunctionalInterface.test("test"));

    }

    // 四种常见的函数式接口

    /**
     * 1. 消费型接口
     * 接收参数, 不返回结果
     *
     * @param <T>
     */
    @FunctionalInterface
    public static interface Consumer<T> {
        void accept(T t);
    }

    /**
     * 2. 功能型接口
     * 接收参数, 返回结果
     *
     * @param <T>
     * @param <R>
     */
    @FunctionalInterface
    public static interface Function<T, R> {
        R apply(T t);
    }

    /**
     * 3. 供给型接口
     * 不接收参数, 返回结果
     *
     * @param <T>
     */
    @FunctionalInterface
    public static interface Supply<T> {
        T get();
    }

    /**
     * 4. 断言型接口
     * 接收参数, 返回 boolean 类型的结果
     *
     * @param <T>
     */
    public static interface Predicate<T> {
        boolean test(T t);
    }

    // reference:
    // Lambda与函数接口: https://blog.csdn.net/kingboyworld/article/details/84882268#331_Consumer_195
    // 关于Java Lambda表达式看这一篇就够了: http://objcoding.com/2019/03/04/lambda/
    // 「Java8系列」神奇的函数式接口: https://www.javaguides.net/2018/07/java-8-functional-interfaces.html
    // Java Custom Functional Interface: https://www.concretepage.com/java/java-8/java-functional-interface
    // Functional interfaces: https://developer.ibm.com/articles/j-java8idioms7/
    // Functional Interfaces in Java 8 Explained: https://www.javabrahman.com/java-8/functional-interfaces-java-8/
    // Java 8 Functional Interfaces: https://www.javaguides.net/2018/07/java-8-functional-interfaces.html

}
