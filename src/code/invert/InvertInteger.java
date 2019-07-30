package code.invert;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc 给出一个 32 位的有符号整数，将这个整数中每位上的数字进行反转
 * @time 2019-07-30 14:44
 */
public class InvertInteger {

    public static void main(String[] args) {
        int x = -1204;
        InvertInteger invertInteger = new InvertInteger();
        int reverse = invertInteger.reverse(x);
        System.out.println(reverse);
    }

    private int reverse(int x) {
        long r = 0;
        while (x != 0) {
            r = r * 10 + x % 10;
            x /= 10;
        }
        if (r >= Integer.MIN_VALUE && r <= Integer.MAX_VALUE) {
            return (int) r;
        }else {
            return 0;
        }
    }

}
