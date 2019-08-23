package code;

import java.util.regex.Pattern;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc 正则表达式匹配
 * @time 2019-08-20 16:00
 */
public class RegularExpression {

    public static void main(String[] args) {
        String s1 = "0551-45542107";
        String s2 = "551-54524473895";
        boolean pattern = pattern(s1);
        boolean pattern1 = pattern(s2);
        System.out.println(pattern);
        System.out.println(pattern1);
    }

    /**
     * 0551-8位任意数字 或者 551-11位任意数字
     * @param str
     * @return
     */
    public static boolean pattern(String str) {
        String pattern = "^(0551-\\d{8})|(551-\\d{11})$";
        return Pattern.matches(pattern, str);
    }

}
