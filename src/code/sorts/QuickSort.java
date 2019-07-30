package code.sorts;

import static code.sorts.SortUtils.*;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc 快排
 * @time 2019-07-23 20:19
 */
public class QuickSort implements SortAlgorithm {

    public <T extends Comparable<T>> T[] sort(T[] array) {
        doSort(array, 0, array.length - 1);
        return array;
    }

    private <T extends Comparable<T>> void doSort(T[] array, int left, int right) {
        if (left < right) {
            int pivot = randomPartition(array, left, right);
            doSort(array, left, pivot - 1);
            doSort(array, pivot, right);
        }
    }

    private <T extends Comparable<T>> int randomPartition(T[] array, int left, int right) {
        int radomIndex = left + (int) (Math.random() * (right - left + 1));
        swap(array, radomIndex, right);
        return partition(array, left, right);
    }

    private <T extends Comparable<T>> int partition(T[] array, int left, int right) {
        int mid = (right + left) / 2;
        T pivot = array[mid];
        while (left <= right) {
            while ((less(array[left], pivot))) {
                ++left;
            }
            while (less(pivot, array[right])) {
                --right;
            }
            if (left <= right) {
                swap(array, left, right);
                ++left;
                --right;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Integer[] array = {10, 7, 19, 48, 57, 573, 21, 502, 237};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array);
        print(array);
    }

}
