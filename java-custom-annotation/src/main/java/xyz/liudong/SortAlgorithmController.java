package xyz.liudong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 排序算法 Controller 层
 *
 * @author: liudong
 * @date: 2019/10/17
 */
@RestController
@RequestMapping("/sort-algorithm")
public class SortAlgorithmController {

    private static final Logger logger = LoggerFactory.getLogger(SortAlgorithmController.class);

    @ExecutionTime(timeUnit = ExecutionTimeEnum.ALLTIMEUNIT)
    @RequestMapping("/bubble-sort")
    public String bubbleSort() {
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        logger.info("sort before: {}", arr);
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        logger.info("sort after: {}", arr);
        return "Bubble Sort!";
    }

}
