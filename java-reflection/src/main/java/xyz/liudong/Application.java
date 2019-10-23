package xyz.liudong;

/**
 * Java - 反射
 *
 * @author: liudong
 * @date: 2019/10/24
 */
public class Application {

    public static void main(String[] args) {

        UserEntity userEntity = new UserEntity(1, "username1", "username1@mail.com");
        UserDTO userDTO = ConvertUtils.sourceToTarget(userEntity, UserDTO.class);

        System.err.println("get fields and methods for UserEntity");
        ClassUtils.printClassInfo(userEntity);

        System.err.println("get fields and methods for UserDTO");
        ClassUtils.printClassInfo(userDTO);

    }

}
// reference:
// Java 反射由浅入深 | 进阶必备: https://juejin.im/post/598ea9116fb9a03c335a99a4#heading-0
// 深入解析Java反射（1） - 基础: https://www.sczyh30.com/posts/Java/java-reflection-1/
