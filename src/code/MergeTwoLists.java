package code;

import model.ListNode;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc 合并两个有序的链表
 * @time 2019-08-09 14:20
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l1.setNext(l2);
        l2.setNext(l3);
        l4.setNext(l5);
        l5.setNext(l6);
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode listNode = mergeTwoLists.mergeTwoLists(l1, l4);
        System.out.println(listNode);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 != null && l2 == null) return l1;
        if (l1 == null) return l2;
        ListNode headNode;
        ListNode lastNode;
        if (l1.getNum() <= l2.getNum()) {
            headNode = l1;
            l1 = l1.getNext();
        }else {
            headNode = l2;
            l2 = l2.getNext();
        }
        lastNode = headNode;
        while(l1 != null && l2 != null) {
            if (l1.getNum() <= l2.getNum()) {
                lastNode.setNext(l1);
                l1 = l1.getNext();
                lastNode = lastNode.getNext();
            }else {
                lastNode.setNext(l2);
                l2 = l2.getNext();
                lastNode = lastNode.getNext();
            }
        }
        if (l1 == null) lastNode.setNext(l2);
        if (l2 == null) lastNode.setNext(l1);
        return headNode;
    }
}
