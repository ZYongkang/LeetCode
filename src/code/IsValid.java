package code;

import util.Stringutils;

import java.util.Stack;

import static util.Stringutils.isEmpty;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc 有效的括号
 * @time 2019-08-09 13:46
 */
public class IsValid {

    public static void main(String[] args) {
        String s = "()[]{}";
        IsValid isValid = new IsValid();
        boolean res = isValid.isValid(s);
        System.out.println(res);
    }

    private boolean isValid(String s) {
        if (isEmpty(s)) {
            return true;
        }
        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        Character c;
        for (char aChar : chars) {
            switch (aChar) {
                case '(':
                case '[':
                case '{':
                    stack.push(aChar);
                    break;
                case ')':
                    if (stack.isEmpty()) return false;
                    c = stack.pop();
                    if (!c.equals('(')) return false;
                    break;
                case ']':
                    if (stack.isEmpty()) return false;
                    c = stack.pop();
                    if (!c.equals('[')) return false;
                    break;
                case '}':
                    if (stack.isEmpty()) return false;
                    c = stack.pop();
                    if (!c.equals('{')) return false;
                    break;
            }
        }
        return stack.isEmpty();
    }

}
