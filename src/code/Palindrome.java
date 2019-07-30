package code;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 * @time 2019-07-30 14:52
 */
public class Palindrome {

    public static void main(String[] args) {
        int x = 123;
        Palindrome palindrome = new Palindrome();
        boolean isPalindrome = palindrome.isPalindrome(x);
        System.out.println(isPalindrome);
    }

    private boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int len = str.length();
        if (len <= 0) {
            return false;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < len / 2; i++) {
            if (chars[i] != chars[len - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
