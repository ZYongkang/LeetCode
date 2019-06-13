import java.util.Stack;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-06-13 16:48
 */
public class Calculator {

    public static void main(String[] args) {
        String s = " 3+5 / 2 ";
        Calculator calculator = new Calculator();
        int calculate = calculator.calculate(s);
        System.out.println(calculate);
    }

    public int calculate(String s) {
        int res = 0;
        s = s.replaceAll(" ", "");
        if (s == null || s.isEmpty()) {
            return res;
        }
        Stack<Integer> nums = new Stack<>();
        char[] chars = s.toCharArray();
        char sign = '+';
        int len = chars.length;
        int d = 0;
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            if (c >= '0' && c <= '9') {
                d = d * 10 - '0' + c;
            }
            if (c < '0' || i == len - 1) {
                if (sign == '+') {
                    nums.push(d);
                } else if (sign == '-') {
                    nums.push(-d);
                } else if (sign == '*') {
                    Integer n = nums.pop();
                    int i1 = n * d;
                    nums.push(i1);
                } else if (sign == '/') {
                    Integer n = nums.pop();
                    int i1 = n / d;
                    nums.push(i1);
                }
                sign = c;
                d = 0;
            }

        }
        for (Integer num : nums) {
            res += num;
        }
        return res;
    }
}
