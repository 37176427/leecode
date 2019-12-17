package org.heasy.model;

/**
 * 链表实体类
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(val+"");
        ListNode tmp = next;
        while (tmp != null) {
            s.append(",").append(tmp.val);
            tmp = tmp.next;
        }
        return s.toString();
    }
}
