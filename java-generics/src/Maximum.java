/**
 * 比较并获取最大值
 *
 * @author: liudong
 * @date: 2019/10/23
 */
public class Maximum<T extends Comparable<T>> {

    public T maximum(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }

}
