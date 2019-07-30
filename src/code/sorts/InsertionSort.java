package code.sorts;

import static code.sorts.SortUtils.*;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc 插入排序
 * @time 2019-07-23 21:04
 */
public class InsertionSort implements SortAlgorithm {

    public static void main(String[] args) {
        Integer[] a = {7 , 9 , 6 , 5, 38 , 82, 75, 98,6};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(a);
        print(a);
    }

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        int len = array.length;
        for (int i = 1; i < len; i++) {
            T temp = array[i];
            int j = i - 1;
            while (j >= 0 && less(temp, array[j])) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        return array;
    }
}
