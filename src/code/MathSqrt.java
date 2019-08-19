package code;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc 简单实现一个Math.sqrt()方法
 * @time 2019-08-16 18:14
 */
public class MathSqrt {

    private static final double EPSILON = 0.0000000001;

    public static void main(String[] args) {
        double num = 1.414;
        double expect = 2;
        double sqrt = MathSqrt.sqrt(num, expect);
        System.out.println(sqrt);
    }

    private static double sqrt(Double num, double expect) {
        if (num == null || num < 0 || expect < 0) {
            return -1;
        }
        int length = String.valueOf(num).length() - String.valueOf(num).indexOf(".") - 1;
        BigDecimal b = new BigDecimal(num);
        double low = b.setScale(length - 1, RoundingMode.FLOOR).doubleValue();
        double high = b.setScale(length - 1, RoundingMode.CEILING).doubleValue();
        return sqrt(low, high, expect);
    }

    private static double sqrt(Double low, Double high, double expect) {
        if (expect < 0) {
            return -1;
        }
        double mid = (low + high) / 2;
        while (high - low > EPSILON) {
            if (mid * mid > expect) {
                high = mid;
            }else {
                low = mid;
            }
            mid = (low + high) / 2;
        }
        return mid;
    }
}
