package code;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc 使用尾递归来求阶乘
 * @time 2019-07-26 16:30
 */
public class FactTail {

    public static void main(String[] args) {
        FactTail factTail = new FactTail();
        int n = 10;
        int r = 1;
        int fact = factTail.fact(n);
        int tail = factTail.factTail(n, r);
        System.out.println(fact);
        System.out.println(tail);
    }

    private int factTail(int n, int r) {
        if (n <= 0) {
            return r;
        }
        return factTail(n - 1, r * n);
    }


    private int fact(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

}
