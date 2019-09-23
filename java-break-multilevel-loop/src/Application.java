/**
 * Java - 使用 break 跳出多层循环
 *
 * @author: liudong
 * @date: 2019/9/22
 */
public class Application {

    public static void main(String[] args) {

        out:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.err.println(i + j);
                if ((i + j) == 3) {
                    break out;
                }
            }
        }

    }

}
