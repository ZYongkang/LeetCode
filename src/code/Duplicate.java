package code;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-07-08 20:46
 */
public class Duplicate {

    public static void main(String[] args) {
        int[] a = new int[]{9, 8, 7, 5, 0, 3, 6, 8 , 1 , 2};
        Duplicate duplicate = new Duplicate();
        int[] res = new int[1];
        boolean hasResult = duplicate.duplicate(a, a.length, res);
        if (hasResult) {
            System.out.println(res[0]);
        }else {
            System.out.println("GG");
        }
    }

    private boolean duplicate(int[] nums, int length, int[] duplicate) {
        if (nums == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < length - 1; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplicate[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    private void swap(int num[], int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
