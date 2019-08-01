package code;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-08-01 16:11
 */
public class RomanToInt {

    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        String s = "III";
        int num = romanToInt.romanToInt(s);
        System.out.println(num);
    }

    private int romanToInt(String s) {
        int sum = 0;
        if (s == null || s.length() <= 0) return 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'I':
                    if (i < chars.length - 1 && chars[i + 1] == 'V') {
                        i++;
                        sum += 4;
                        break;
                    }
                    else if (i < chars.length-1 && chars[i + 1] == 'X') {
                        i++;
                        sum += 9;
                        break;
                    }
                    else {
                        sum += 1;
                        break;
                    }
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    if (i < chars.length-1 && chars[i + 1] == 'L') {
                        i++;
                        sum += 40;
                        break;
                    }
                    else if (i < chars.length-1 && chars[i + 1] == 'C') {
                        i++;
                        sum += 90;
                        break;
                    }
                    else {
                        sum += 10;
                        break;
                    }
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    if (i < chars.length-1 && chars[i + 1] == 'D') {
                        i++;
                        sum += 400;
                        break;
                    }
                    else if (i < chars.length-1 && chars[i + 1] == 'M') {
                        i++;
                        sum += 900;
                        break;
                    }
                    else {
                        sum += 100;
                        break;
                    }
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;
                default:
                    sum += 0;
                    break;
            }
        }
        return sum;
    }
}
