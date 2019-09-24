import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Java - 根据实体类字段过滤 ArrayList
 *
 * @author: liudong
 * @date: 2019/9/24
 */
public class Application {

    public static void main(String[] args) {

        UserEntity user1 = new UserEntity(1, "user1", "user1@mail.com");
        UserEntity user2 = new UserEntity(2, "user2", "user2@mail.com");
        UserEntity user3 = new UserEntity(3, "user3", "user3@mail.com");
        UserEntity user4 = new UserEntity(4, "user4", "user4@mail.com");
        List<UserEntity> userList = new ArrayList<>(Arrays.asList(user1, user2, user3, user4));

        System.err.println("filter ArrayList - before: ");
        userList.forEach(user -> System.err.println(user.getId() + "  " + user.getUsername() + "  " + user.getEmail()));

        List<UserEntity> filterUserList = userList.stream().filter(user -> user.getId() > 2).collect(Collectors.toList());

        System.err.println("filter ArrayList - after: ");
        filterUserList.forEach(user -> System.err.println(user.getId() + "  " + user.getUsername() + "  " + user.getEmail()));

    }

}
