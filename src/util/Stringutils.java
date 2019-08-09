package util;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-08-09 13:47
 */
public class Stringutils {

    public static boolean isEmpty(String s) {
        return s == null || s.length() <= 0;
    }

    public static boolean isNotEmpty(String s) {
        return s != null && s.length() > 0;
    }
}
