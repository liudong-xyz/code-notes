import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Java - JDK 8 新特性 Optional
 *
 * @author: liudong
 * @date: 2019/10/10
 */
public class Application {

    public static void main(String[] args) {

        // Optional use guide
        // Preface: Our intention was to provide a limited mechanism for library method return types where there needed to be a clear way to represent "no result", and using null for such was overwhelmingly likely to cause errors
        // Brian Goetz [working on the Java language at Oracle] - https://stackoverflow.com/questions/26327957/should-java-8-getters-return-optional-type/26328555#26328555
        // ------------------------------------------------
        // 1. Optional should only be used for methods results
        // 2. Do not use Optional for arrays or collections, an empty array or collection is better than an empty Optional or null
        // 3. Do not use Optional in constructors and method arguments, There is no obvious benefit to doing so, and it makes the code more redundant
        // 4. Do not use Optional in any POJO fields including their get/set method
        //  4 - (1) Fields can't Autoboxing and Unboxing, you have to do some extra processing, so code becomes more redundant
        // 	4 - (2) You can't serialize your POJOs, like JSON, and if you must, make sure the libraries and frameworks you use handle Optional completely
        // 5. Not a silver bullet
        // ------------------------------------------------


        // Optional 使用指南
        // 前言: 我们的目的是为库方法返回类型提供一种有限的机制, 在这种情况下, 需要有一种明确的方法来表示"无返回", 而使用 null 表示这种类型极有可能导致错误 - [机翻]
        // 由 Brian Goetz 回答, 他正在 Oracle 从事 Java 语言的开发 - https://stackoverflow.com/questions/26327957/should-java-8-getters-return-optional-type/26328555#26328555
        // ------------------------------------------------
        // 1. Optional 应该应用于方法的返回结果
        // 2. 不要使用 Optional 用于数组或集合, 空的数组或集合优于空的 Optional 或 null
        // 3. 不要在构造函数及方法参数中使用 Optional, 这么做不会有明显的好处, 反而它会使代码变得更加冗余
        // 4. 不要在任何 POJO 字段中使用 Optional 包括它们的 get/set 方法
        // 	4 - (1) 字段无法直接拆箱装箱, 你不得不做一些额外处理, 它将代码会变得更为冗余
        // 	4 - (2) 你无法对你 POJO 进行序列化操作, 如转成 JSON 格式, 如果你非得这么做, 那么请确保你所使用的库和框架能完全处理 Optional
        // 5. Optional 不是最终解, 它不能完全解决 null, 但如果你在合适的时机正确的使用了 Optional 那么它会使代码更加简洁高效
        // ------------------------------------------------


        // Reference:
        // Should Java 8 getters return optional type: https://stackoverflow.com/questions/26327957/should-java-8-getters-return-optional-type/26328555#26328555
        // Java 8 Optional best practices and wrong usage: http://dolszewski.com/java/java-8-optional-use-cases/
        // Why should Java 8's Optional not be used in arguments: https://stackoverflow.com/questions/31922866/why-should-java-8s-optional-not-be-used-in-arguments
        // [Java8] How to use Optional gracefully: http://www.programmersought.com/article/730933356/
        // java 8 Optional: https://www.javadevjournal.com/java/java-8-optional/


        UserService userService = new UserService();
        DeptService deptService = new DeptService();

        // --------------------- 基本使用 ---------------------
        Optional<User> optionalUserForNonNull = userService.createNonNullUser();
        Optional<User> optionalUserForNull = userService.createNullUser();

        // 无论 getEmail 是否为空或者不存在, orElse() 方法始终都会被调用
        String emailForOrElse = optionalUserForNull.map(User::getEmail).orElse("orElse");
        System.err.println("emailForOrElse: " + emailForOrElse);

        // 只有当 getEmail 为空或者不存在的时候, orElseGet() 才会被调用
        String emailForOrElseGet = optionalUserForNull.map(User::getEmail).orElseGet(Application::createStringForOrElseGet);
        System.err.println("emailForOrElseGet: " + emailForOrElseGet);

        // 如果 getEmail 为空或者不存在, 则会调用 orElseThrow() 方法
        String emailForOrElseThrow = optionalUserForNull.map(User::getEmail).orElseThrow(NullPointerException::new);
        System.err.println("emailForOrElseThrow: " + emailForOrElseThrow);


        // --------------------- 最佳实践 ---------------------
        // 1. 链式调用
        Optional<Department> optionalDepartment = deptService.createNullDetp();
        String email = optionalDepartment.map(Department::getUserList)
                .map(users -> users.get(0).getEmail())
                .orElseGet(Application::createStringForOrElseGet);

        // 例[1]的反例, 尽量使用链式调用, 避免使用冗余的 if 判断
        if (optionalDepartment.isPresent()) {
            Department department = optionalDepartment.get();
            List<User> userList = department.getUserList();
            if (userList != null && !userList.isEmpty()) {
                String email1 = userList.get(0).getEmail();
            }
        }

        // 2. 充分使用 filter() 方法
        Optional<Department> optionalDepartment1 = deptService.createNullDetp();
        // 获取部门 ID 大于 100 的集合
        List<User> userList = optionalDepartment1.filter(department -> department.getId() > 100)
                .map(Department::getUserList)
                .orElseThrow(NoSuchElementException::new);


        // --------------------- 错误用法 ---------------------
        Optional<User> optionalUser1 = userService.createNonNullUser();
        Optional<User> optionalUser2 = userService.createNonNullUser();
        Optional<User> optionalUser3 = userService.createNonNullUser();

        // 1. 不要嵌套使用 ifPresent() 方法
        optionalUser1.ifPresent(user1 -> optionalUser2.ifPresent(user2 -> optionalUser3.ifPresent(user3 -> {
            // do something
        })));

        // 例[1]中更好的做法
        if (optionalUser1.isPresent() && optionalUser2.isPresent() && optionalUser3.isPresent()) {
            // do something
        }

        // 2. 谨慎调用 get() 方法, 因为它极有可能产生 NPE
        Optional<User> optionalNullUser = userService.createNullUser();
        User nullUser = optionalNullUser.get();
        nullUser.getEmail();

        // 例[2]中更好的做法
        optionalNullUser.ifPresent(User::getEmail);

    }

    private static String createStringForOrElseGet() {
        return "orElseGet";
    }

    public static class UserService {
        Optional<User> createNonNullUser() {
            return Optional.ofNullable(new User(1, "username", "user@mail.com"));
        }

        Optional<User> createNullUser() {
            return Optional.ofNullable(null);
        }
    }

    public static class DeptService {
        Optional<Department> createNullDetp() {
            return Optional.ofNullable(null);
        }
    }


}
