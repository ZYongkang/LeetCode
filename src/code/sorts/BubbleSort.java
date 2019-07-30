package code.sorts;

import static code.sorts.SortUtils.*;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc 冒泡排序
 * @time 2019-07-08 20:15
 */
public class BubbleSort implements SortAlgorithm {

    public static void main(String[] args) {
        Integer[] a = {7 , 9 , 6 , 5, 38 , 82, 75, 98,6};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(a);
        print(a);
    }

    public  <T extends Comparable<T>> T[] sort(T[] array) {
        int last = array.length;
        boolean swap;
        do {
            swap = false;
            for (int count = 0; count < last - 1; count++) {
                if (than(array[count], array[count + 1])) {
                    swap = swap(array, count, count + 1);
                }
            }
            last--;
        } while (swap);
        return array;
    }
}
