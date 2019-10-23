/**
 * 打印数组
 *
 * @author: liudong
 * @date: 2019/10/23
 */
public class PrintArray<E> {

    public void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.err.print(element + " ");
        }
        System.err.println();
    }


}
