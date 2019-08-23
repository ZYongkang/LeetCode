package code.invert;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *       不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题
 * @time 2019-08-23 11:07
 */
public class ReverseString {

    public void reverseString(char[] s) {
        if (s == null || s.length < 1) {
            return;
        }
        for (int i = 0; i < s.length / 2; i++) {
            char c = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = c;
        }
    }
}
