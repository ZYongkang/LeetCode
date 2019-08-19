package code;

import model.ListNode;
import util.ListNodeUtils;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc 实现一个单向链表的逆序 ListNodeUtils.reverse()
 * @time 2019-08-16 17:47
 */
public class ReverseOutput {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNodeUtils.createListNode(head, 5);
        ListNode reverse = ListNodeUtils.reverse(head);
        System.out.println(reverse);
    }
}
