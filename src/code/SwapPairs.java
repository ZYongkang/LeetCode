package code;

import model.ListNode;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @time 2019-08-23 11:08
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode now = head;
        ListNode nextNode = head.getNext();
        head = nextNode;
        ListNode prev = null;
        while (null != nextNode && null != now) {
            now.setNext(nextNode.getNext());
            nextNode.setNext(now);
            if (prev != null) {
                prev.setNext(nextNode);
            }
            prev = now;
            now = now.getNext();
            if (null != now) {
                nextNode = now.getNext();
            }
        }
        return head;
    }
}
