package code;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc 最长公共前缀
 * @time 2019-08-01 16:42
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"adsf", "addsf", "addds"};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String str = longestCommonPrefix.longestCommonPrefix(strs);
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
}
