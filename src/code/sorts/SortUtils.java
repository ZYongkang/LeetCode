package code.sorts;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-07-23 20:26
 */
public class SortUtils {

    public static <T> boolean swap(T[] array, int idx, int idy) {
        T swap = array[idx];
        array[idx] = array[idy];
        array[idy] = swap;
        return true;
    }

    public static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    public static <T extends Comparable<T>> boolean than(T v, T w) {
        return v.compareTo(w) >= 0;
    }

    public static void print(List<?> toPrint) {
        toPrint.stream()
                .map(Object::toString)
                .map(str -> str + " ")
                .forEach(System.out::print);
        System.out.println();
    }

    public static void print(Object[] toPrint) {
        System.out.println(Arrays.toString(toPrint));
    }

    public static <T extends Comparable<T>> void flip(T[] array, int left, int right) {
        while (left <= right) {
            swap(array, left++, right--);
        }
    }

}
