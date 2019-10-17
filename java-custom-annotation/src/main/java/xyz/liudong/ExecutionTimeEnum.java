package xyz.liudong;

/**
 * ExecutionTime 注解所需的枚举类
 *
 * @author: liudong
 * @date: 2019/10/17
 */
public enum ExecutionTimeEnum {

    /**
     * 秒, 单位: s
     */
    SECOND,

    /**
     * 毫秒, 单位: ms
     */
    MILLISECOND,

    /**
     * 纳秒, 单位: ns
     */
    NANOSECOND,

    /**
     * 使用全部时间类型: [s, ms, ns]
     */
    ALLTIMEUNIT

}
