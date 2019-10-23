package xyz.liudong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * ConvertUtils
 *
 * @author: liudong
 * @date: 2019/10/24
 */
public class ConvertUtils {

    private static final Logger logger = LoggerFactory.getLogger(ConvertUtils.class);

    // the [Class.newInstance()] was deprecated in Java 9
    // reference:
    // Java 9 replace Class.newInstance: https://stackoverflow.com/questions/53257073/java-9-replace-class-newinstance
    // Why is Class.newInstance() “evil”?: https://stackoverflow.com/questions/195321/why-is-class-newinstance-evil
    // Automatically Mapping DTO to Entity on Spring Boot APIs: https://auth0.com/blog/automatically-mapping-dto-to-entity-on-spring-boot-apis/
    // Java Objects Mapping with ModelMapper: http://appsdeveloperblog.com/java-objects-mapping-with-modelmapper/
    // Entity To DTO Conversion for a Spring REST API: https://www.baeldung.com/entity-to-and-from-dto-for-a-java-spring-application
    // Java Bean Copy框架性能对比: https://yq.aliyun.com/articles/392185

    /**
     * 对象拷贝
     */
    public static <T> T sourceToTarget(Object source, Class<T> target) {
        if (source == null) {
            return null;
        }
        T targetObject = null;
        try {
            targetObject = target.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(source, targetObject);
        } catch (Exception e) {
            logger.error("convert error ", e);
        }

        return targetObject;
    }

    /**
     * 集合拷贝
     */
    public static <T> List<T> sourceToTarget(Collection<?> sourceList, Class<T> target) {
        if (sourceList == null) {
            return null;
        }

        List<T> targetList = new ArrayList<>(sourceList.size());
        try {
            for (Object source : sourceList) {
                T targetObject = target.getDeclaredConstructor().newInstance();
                BeanUtils.copyProperties(source, targetObject);
                targetList.add(targetObject);
            }
        } catch (Exception e) {
            logger.error("convert error ", e);
        }

        return targetList;
    }

//    /**
//     * Map 对象转换为 Json 字符串
//     */
//    public static String mapToString(Map<String, Object> map) {
//        String res = "";
//        try {
//            res = JSON.toJSONString(map);
//        }catch (Exception e){
//            logger.error("mapToString convert error ", e);
//        }
//        return res;
//    }
//
//    /**
//     * List 对象转换为 Json 字符串
//     */
//    public static String objToJsonString(List<?> objList) {
//        String res = "";
//        try {
//            res = JSON.toJSONString(objList);
//        }catch (Exception e){
//            logger.error("objToJsonString convert error ", e);
//        }
//        return res;
//    }
//
//    /**
//     * 对象转换为 Json 字符串
//     */
//    public static String objToJsonString(Object obj) {
//        String res = "";
//        try {
//            res = JSON.toJSONString(obj);
//        }catch (Exception e){
//            logger.error("objToJsonString convert error ", e);
//        }
//        return res;
//    }

}
