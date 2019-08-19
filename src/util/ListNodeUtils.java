package util;

import model.ListNode;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc 链表的一些通用方法
 * @time 2019-08-16 17:52
 */
public class ListNodeUtils {


    public static void createListNode(ListNode head, Integer length) {
        if (head == null || head.getNum() == null) {
            throw new RuntimeException("head, 没有初始化数值");
        }
        if (length == null || length < 0) {
            throw new RuntimeException("length, 没有初始化数值");
        }
        int num = head.getNum();
        initListNode(head, ++num, length);
    }

    public static void createListNode(ListNode head, int num , int length) {
        if (length < 0) {
            return;
        }
        length = length - 2;
        initListNode(head, ++num, length);
    }

    /**
     * 递增的数字链表
     * @param head
     * @param num
     * @param length
     */
    private static void initListNode(ListNode head, int num , int length) {
        if (length < 0) {
            return;
        }
        ListNode node = new ListNode(num);
        head.setNext(node);
        initListNode(node, ++num , --length);
    }

    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static ListNode reverseBetween(ListNode head, int m, int n, int size) {
        if (m < 1 || m >= n || n > size) {
            return head;
        }
        int changeLen = n - m + 1;
        ListNode preNode = null;
        ListNode res = head;
        while (head != null && --m > 0) {
            preNode = head;
            head = head.getNext();
        }
        ListNode modifyListNode = head;
        ListNode newHeadNode = null;
        while (head != null && changeLen > 0) {
            ListNode temp = head.getNext();
            head.setNext(newHeadNode);
            newHeadNode = head;
            head = temp;
            changeLen--;
        }
        modifyListNode.setNext(head);
        if (preNode != null) {
            preNode.setNext(newHeadNode);
        }else {
            res = newHeadNode;
        }
        return res;
    }
}
