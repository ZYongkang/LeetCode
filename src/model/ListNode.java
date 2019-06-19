package model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-05-28 20:07
 */
public class ListNode implements Serializable {

    private static final long serialVersionUID = 1L;

    private int num;
    private ListNode next;

    public ListNode(int num) {
        this.num = num;
    }

    public ListNode(int num, ListNode next) {
        this.num = num;
        this.next = next;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return num == listNode.num &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, next);
    }

    @Override
    public String toString() {
        if (next == null) {
            return num + " -> null";
        }
        return num + " -> " + next.toString();
    }
}
