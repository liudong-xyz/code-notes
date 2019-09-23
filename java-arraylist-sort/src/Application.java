import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Java - ArrayList 根据字段排序
 *
 * @author: liudong
 * @date: 2019/9/23
 */
public class Application {

    public static void main(String[] args) {

        UserEntity user1 = new UserEntity(1, "username1", "user1@mail.com");
        UserEntity user2 = new UserEntity(2, "username2", "user2@mail.com");
        UserEntity user3 = new UserEntity(3, "username3", "user3@mail.com");
        List<UserEntity> list = new ArrayList<>(Arrays.asList(user2, user3, user1));

        list.forEach((o1) -> System.err.println("unsorted ArrayList: " + o1.getId()));

        // 该写法使用了 Lambda 表达式
        // 注意点:
        // 1. 返回结果应是一对相反数
        // 2. 比较结果相同时, 应返回 0
        list.sort((o1, o2) -> {
            if (Objects.equals(o1.getId(), o2.getId())) {
                return 0;
            }
            if (o1.getId() > o2.getId()) {
                return 1;
            }
            return -1;
        });

        list.forEach((o1) -> System.err.println("sorted ArrayList: " + o1.getId()));

    }

}
