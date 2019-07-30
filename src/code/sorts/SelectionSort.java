package code.sorts;

import static code.sorts.SortUtils.*;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc 选择排序
 * @time 2019-07-23 20:59
 */
public class SelectionSort implements SortAlgorithm {

    public static void main(String[] args) {
        Integer[] a = {7 , 9 , 6 , 5, 38 , 82, 75, 98,6};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(a);
        print(a);
    }

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            int min = i;

            for (int j = i; j < len; j++) {
                if (than(array[i], array[j])) {
                    min = j;
                }
            }

            if (min != i) {
                swap(array, i, min);
            }
        }

        return array;
    }
}
