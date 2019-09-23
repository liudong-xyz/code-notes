import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * Java - 在 ArrayList 中删除重复元素
 *
 * @author: liudong
 * @date: 2019/9/23
 */
public class Application {

    public static void main(String[] args) {

        // 在简单的 ArrayList 中去重
        // 参考和更多方式: https://www.geeksforgeeks.org/how-to-remove-duplicates-from-arraylist-in-java/
        String s1 = "a";
        String s1Duplicate = "a";
        String s2 = "b";
        String s2Duplicate = "b";

        List<String> stringList = new ArrayList<>(Arrays.asList(s1, s1Duplicate, s2, s2Duplicate));
        System.err.println("remove duplicates before - simple ArrayList: " + stringList);

        List<String> uniqueStringList = stringList.stream().distinct().collect(Collectors.toList());
        System.err.println("remove duplicates after - simple ArrayList: " + uniqueStringList);

        // -----------------------------------------------------------------------------------------

        // 在 ArrayList<UserEntity> 中根据字段去重
        // 参考: https://stackoverflow.com/questions/29670116/remove-duplicates-from-a-list-of-objects-based-on-property-in-java-8
        UserEntity user1 = new UserEntity(1, "username1", "user1@mail.com");
        UserEntity user1Duplicate = new UserEntity(1, "username1", "user1@mail.com");
        UserEntity user2 = new UserEntity(2, "username2", "user2@mail.com");
        UserEntity user2Duplicate = new UserEntity(2, "username2", "user2@mail.com");

        List<UserEntity> userList = new ArrayList<>(Arrays.asList(user1, user1Duplicate, user2, user2Duplicate));
        userList.forEach(user -> System.err.println("remove duplicates before - ArrayList<UserEntity>: " +
                user.getId() + "  " +
                user.getUsername() + "  " +
                user.getEmail()));

        List<UserEntity> uniqueUserList = userList.stream().collect(collectingAndThen(toCollection(() ->
                new TreeSet<>(comparingInt(UserEntity::getId).thenComparing(UserEntity::getEmail))), ArrayList::new));

        System.err.println();
        uniqueUserList.forEach(user -> System.err.println("remove duplicates after - ArrayList<UserEntity>: " +
                user.getId() + "  " +
                user.getUsername() + "  " +
                user.getEmail()));

        // 除了这种写法, 我们还可以通过重写实体类的 equals 和 hashCode 方法进行判断

    }

}
