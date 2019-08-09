package code;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc 最长公共前缀
 * @time 2019-08-01 16:42
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String str = longestCommonPrefix.longestCommonPreFix(strs);
        System.out.println(str);
    }

    private String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    private String longestCommonPreFix(String[] strs) {
        if (strs == null || strs.length <= 1) {
            return "";
        }
        String res = strs[0];
        int len = res.length();
        for (int i = 0; i < len; i++) {
            int j = 1;
            while (j < strs.length) {
                if (!strs[j].startsWith(res)) {
                    res = res.substring(0, res.length() - 1);
                    break;
                }
                j++;
            }
        }
        return res;
    }
}
