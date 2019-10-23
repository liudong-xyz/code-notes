package xyz.liudong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ClassUtils
 *
 * @author: liudong
 * @date: 2019/10/24
 */
public class ClassUtils {

    private static final Logger logger = LoggerFactory.getLogger(ClassUtils.class);

    public static void printClassInfo(Object object) {
        try {
            // print fields
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                Object type = field.getType();
                String name = field.getName();

                field.setAccessible(true);
                Object value = field.get(object);
                field.setAccessible(false);

                logger.info("{} - {} - {}", type, name, value);
            }

            // print methods
            Method[] methods = object.getClass().getDeclaredMethods();
            for (Method method : methods) {
                logger.info("{}", method.getName());
            }
        } catch (Exception e) {
            logger.error("printClassInfo Error: ", e);
        }
    }

}
// reference:
// 用java类中的映射获取变量名：java反射机制: https://blog.csdn.net/pianistOfSoftware/article/details/51899165
// 通过Java反射机制获取对象、方法和成员变量: https://blog.csdn.net/jim8757/article/details/50765617
// Java获取类中的所有方法: https://blog.csdn.net/u011983531/article/details/80248945