package code;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-08-02 16:38
 */
public class FindSecondBiggest {

    public static void main(String[] args) {
        int[] nums = new int[1000000];
        initArray(nums);
        FindSecondBiggest findSecondBiggest = new FindSecondBiggest();
        int num = findSecondBiggest.findSecondBiggest(nums);
        System.out.println(num);
    }

    private static int[] initArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        return nums;
    }
    //获取数据中第二大的数据，去除重复后的
    private int findSecondBiggest(int[] nums) {
        long startTime = System.currentTimeMillis();
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int max = nums[0];
        int second = nums[1];
        for (int temp : nums) {
            if (temp > max) {
                second = max;
                max = temp;
            } else if (temp > second && temp != max) {
                second = temp;
            }
        }
        System.out.println("用时：" + (System.currentTimeMillis() - startTime) + "ms");
        return second;
    }
}
