package code;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-07-26 13:59
 */
public class MaxCutting {


    public static void main(String[] args) {
        MaxCutting maxCutting = new MaxCutting();
        int n = 4;
        int maxCuttingMultiply = maxCutting.getMaxCuttingMultiply(n);
        System.out.println(maxCuttingMultiply);
    }

    //动态规划算法获取最大
    private int getMaxCuttingMultiply(int n) {
        //最简单的三个解可以直接获得到，用来当作最小解
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int[] products = new int[n + 1]; // 因为没有products[0]，也就是说没有0米的绳子
        //当前存放的不是乘积的最大值，而是绳子的长度，因为需要先拿绳子的长度去算最大值
        // 当从f(4)开始的时候数组中存放的就是当前绳子切段乘积最大值
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        for (int i = 4; i <= n; i++) {
            int maxModify = 0;
            for (int j = 1; j <= (i / 2); j++) {
                int product = products[j] * products[i - j];
                if (product > maxModify) {
                    maxModify = product;
                }
            }
            products[i] = maxModify;
        }

        return products[n];
    }

    //贪心算法中选择3为最贪心的数字，这个好像也是有原因的
    //f(n) = max(f(1)max(f(n-1)) , f(2)max(f(n-2)), f(3)max(f(n-3)))
    //f(n) = max(max(f(n-1)), 2max(f(n-2)), 3max(f(n-3)))
    //我简单的推算， f(n-2) 是不可能大于 2倍的f(n-3)的，但是是有条件的，当n > 4（瞎猜的。。。）
}
