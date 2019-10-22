import java.util.*;

/**
 * Java - 集合
 *
 * @author: liudong
 * @date: 2019/10/22
 */
public class Application {

    public static void main(String[] args) {

        // 最佳实践
        // ---------------------------------------
        // 1. 选择合适的集合
        //  1.1 集合是否需要保证元素的顺序
        //  1.2 集合是否允许重复元素
        //  1.3 集合是否允许元素为 null
        //  1.4 集合中的元素是否能够通过索引进行访问
        //  1.5 集合是否能够快速的新增或者删除元素
        //  1.6 集合是否支持并发
        //  1.7 集合是否支持键值对(key-value)的形式存储元素
        // 2. 使用接口类型声明集合
        // 3. 使用 isEmpty() 方法检查集合是否为空, 而不是使用 size() > 0
        // 4. 如果无返回结果, 最好是返回空的集合, 而不是 null
        // ---------------------------------------

        // ArrayList
        // 动态集合
        // 低效的插入或删除元素
        // 适用遍历元素
        // ArrayList 只存储对象, 所以占用内存较少
        // 线程不安全
        List<String> arrayList = new ArrayList<>();

        // LinkedList
        // 双链表式的集合
        // 高效的插入或删除元素
        // 适用于操作元素
        // LinkedList 存储对象以及对象的地址, 所以需要占用更多的内存
        // 线程不安全
        List<String> linkedList = new LinkedList<>();

        // HashMap
        // 可以存储一个 null key 和多个 null value
        // 继承至 AbstractMap
        // 线程不安全
        Map<String, Object> hashMap = new HashMap<>();

        // Hashtable
        // 不能存储任何 null key 和 value
        // 继承至 Dictionary
        // 线程安全
        Map<String, Object> hashtable = new Hashtable<>();

        // HashSet
        // 操作元素很快
        // 无法保证元素的顺序
        // 不允许重复元素
        // 线程不安全
        Set<String> hashSet = new HashSet<>();

        // TreeSet
        // 操作元素很慢
        // 保证元素的顺序
        // 不允许重复元素
        // 线程不安全
        Set<String> treeSet = new TreeSet<>();


        // 在有可能并发的情况下, 请不要这么做
        List<String> syncList = new ArrayList<>();

        @SuppressWarnings("all")
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 50; i++) {
                syncList.add(String.valueOf(i));
                syncList.forEach(System.err::println);
            }
        });

        @SuppressWarnings("all")
        Thread thread2 = new Thread(() -> {
            for (int i = 50; i <= 100; i++) {
                syncList.add(String.valueOf(i));
                syncList.forEach(System.err::println);
            }
        });

        thread1.start();
        thread2.start();

        System.err.println("syncList size is: " + syncList.size());

        // 如果你在多线程或者并发环境下编程, 你可以参考以下链接:
        // Java - Concurrent Collections: https://www.logicbig.com/tutorials/core-java-tutorial/java-collections/concurrent-collection-cheatsheet.html
        // An Introduction to Synchronized Java Collections: https://www.baeldung.com/java-synchronized-collections
        // Understand Java Collections and Thread Safety: https://www.codejava.net/java-core/collections/understanding-collections-and-thread-safety-in-java


    }

}

// reference:
// 18 Java Collections and Generics Best Practices: https://www.codejava.net/java-core/collections/18-java-collections-and-generics-best-practices#ChooseRightCollections
// java.util.Collections Class API Guide: https://www.javaguides.net/2018/07/java-util-collections-class-methods-guide.html
// Collections in Java - GeeksforGeeks: https://www.geeksforgeeks.org/collections-in-java-2/
// Collections in Java - Javatpoint: https://www.javatpoint.com/collections-in-java
// Java 集合框架: https://www.runoob.com/java/java-collections.html
// Hashset vs Treeset: https://stackoverflow.com/questions/1463284/hashset-vs-treeset
// Understanding Object Ordering in Java with Comparable and Comparator: https://www.codejava.net/java-core/collections/understanding-object-ordering-in-java-with-comparable-and-comparator
