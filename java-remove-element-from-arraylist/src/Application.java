import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Java - 在 ArrayList 中删除元素
 *
 * @author: liudong
 * @date: 2019/9/23
 */
public class Application {

    public static void main(String[] args) {

        // 初始化
        List<Integer> integerArrayListFor = new ArrayList<>(Arrays.asList(1, 3, 6, 10, 15));
        List<Integer> integerArrayListWhile = new ArrayList<>(Arrays.asList(1, 3, 6, 10, 15));
        List<Integer> integerArrayListLambda = new ArrayList<>(Arrays.asList(1, 3, 6, 10, 15));

        // for
        for (Iterator<Integer> integerIterator = integerArrayListFor.iterator(); integerIterator.hasNext(); ) {
            Integer integer = integerIterator.next();
            if (integer == 1 || integer == 10) {
                integerIterator.remove();
            }
        }

        // while
        Iterator<Integer> integerIterator = integerArrayListWhile.iterator();
        while (integerIterator.hasNext()) {
            Integer integer = integerIterator.next();
            if (integer == 1 || integer == 10) {
                integerIterator.remove();
            }
        }

        // Lambda
        integerArrayListLambda.removeIf(integer -> integer == 1 || integer == 10);

        // 验证
        System.err.println("for: " + Arrays.toString(integerArrayListFor.toArray()));
        System.err.println("while: " + Arrays.toString(integerArrayListWhile.toArray()));
        System.err.println("lambda: " + Arrays.toString(integerArrayListLambda.toArray()));

    }

}
