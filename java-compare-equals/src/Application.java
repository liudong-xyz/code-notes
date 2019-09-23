import java.util.Objects;

/**
 * Java - 比较和判断
 *
 * @author: liudong
 * @date: 2019/9/22
 */
public class Application {

    public static void main(String[] args) {

        String string = "Good";

        // 传统做法, 将字符串前置, 对象后置(防止 NPE)
        if ("Good".equals(string)) {
            System.out.println("true");
        }

        // 使用 Java 7 新引入的方法
        if (Objects.equals("Good", string)) {
            System.out.println("true");
        }

    }

}
