package xyz.liudong;

import org.apache.commons.lang3.StringUtils;

/**
 * Java - 判断字符串是否为空或者 null, 使用 apache-commons-lang3
 *
 * @author: liudong
 * @date: 2019/9/22
 */
public class Application {

    public static void main(String[] args) {

        String string = "";

        // 传统方式, 判断字符串是否为空或者 null
        if (string != null && !"".equals(string)) {
            System.err.println("the string is not null or empty - traditional way");
        }

        // 引入 apache-commons-lang3, 并使用 StringUtils.isNotBlank 进行判断
        if (StringUtils.isNotBlank(string)) {
            System.err.println("the string is not null or empty - StringUtils.isNotBlank way");
        }

        // 更多方法 -> isNotBlank, isBlank, isNotEmpty, isEmpty...

    }

}
