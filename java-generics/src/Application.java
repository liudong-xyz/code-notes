import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Java - 泛型
 *
 * @author: liudong
 * @date: 2019/10/23
 */
public class Application {

    public static void main(String[] args) {

        // 参数类型
        // T - Type
        // E - Element
        // K - Key
        // V - Value
        // N - Number

        // ----------------------- 使用 [PrintArray] 泛型类的示例 -----------------------
        Integer[] integerArray = {1, 2, 3, 4, 5};
        PrintArray<Integer> integerPrintArray = new PrintArray<>();
        integerPrintArray.printArray(integerArray);

        Double[] doubleArray = {1.1, 1.2, 1.3, 1.4, 1.5};
        PrintArray<Double> doublePrintArray = new PrintArray<>();
        doublePrintArray.printArray(doubleArray);

        Character[] characterArray = {'H', 'E', 'L', 'L', 'O'};
        PrintArray<Character> characterPrintArray = new PrintArray<>();
        characterPrintArray.printArray(characterArray);


        // ----------------------- 使用 [Maximum] 泛型类的示例 -----------------------
        Maximum<Integer> integerMaximum = new Maximum<>();
        System.err.println("5, 4, 3 中最大的数为 " + integerMaximum.maximum(5, 4, 3));

        Maximum<Double> doubleMaximum = new Maximum<>();
        System.err.println("1.2, 1.3, 1.1 中最大的数为 " + doubleMaximum.maximum(1.2, 1.3, 1.1));


        // ----------------------- 使用 [getData] 泛型方法示例 -----------------------
        List<String> stringListInGetData = new ArrayList<>(Arrays.asList("Hello", "World"));
        getData(stringListInGetData);

        List<Integer> integerListInGetData = new ArrayList<>(Arrays.asList(1, 2, 3));
        getData(integerListInGetData);


        // ----------------------- 使用 [getNumberDataByUp] 泛型方法示例 -----------------------
        // List<> 中只能使用 Number 的子类
        List<Integer> integerListInGetNumberDataByUp = new ArrayList<>(Arrays.asList(4, 5, 6));
        getNumberDataByUp(integerListInGetNumberDataByUp);

        List<Double> doubleListInGetNumberDataByUp = new ArrayList<>(Arrays.asList(1.1, 1.2, 1.3));
        getNumberDataByUp(doubleListInGetNumberDataByUp);


        // ----------------------- use [getIntegerDataByLow] generics method example -----------------------
        // List<> 中你可以使用 Integer 类型和它的父类, 如 Number
        List<Integer> integerListInGetIntegerDataByLow = new ArrayList<>(Arrays.asList(7, 8, 9));
        getIntegerDataByLow(integerListInGetIntegerDataByLow);

        List<Number> numberListInGetIntegerDataByLow = new ArrayList<>(Arrays.asList(10, 11, 12));
        getIntegerDataByLow(numberListInGetIntegerDataByLow);

    }

    // Java 中泛型的通配符

    /**
     * 任何类型
     *
     * @param data java.util.List
     */
    private static void getData(List<?> data) {
        System.err.println("getData: " + data.get(0));
    }

    /**
     * Number 的子类
     * e.g. Integer, Float, Double...
     *
     * @param data java.util.List
     */
    private static void getNumberDataByUp(List<? extends Number> data) {
        System.err.println("getNumberDataByUp: " + data.get(0));
    }

    /**
     * Integer 的超类
     *
     * @param data java.util.List
     */
    private static void getIntegerDataByLow(List<? super Integer> data) {
        System.err.println("getIntegerDataByLow: " + data.get(0));
    }


}
// reference:
// Java 泛型: https://www.runoob.com/java/java-generics.html
// 深入理解Java泛型: https://juejin.im/post/5b614848e51d45355d51f792
// Generics in Java - Javatpoint: https://www.javatpoint.com/generics-in-java
// Generics in Java - GeeksforGeeks: https://www.geeksforgeeks.org/generics-in-java/
// The Basics of Java Generics: https://www.baeldung.com/java-generics
