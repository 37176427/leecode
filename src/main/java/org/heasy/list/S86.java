package org.heasy.list;

import org.heasy.model.ListNode;

/**
 * @author wyh
 * @date 2021/6/22 16:10
 **/
public class S86 {


    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode dummya = new ListNode(0), dummyb = new ListNode(0);
        ListNode ahead = dummya, bhead = dummyb;
        ListNode cur = head;
        while (cur != null) {
            final ListNode listNode = new ListNode(cur.val);
            if (cur.val < x) {
                ahead.next = listNode;
                ahead = ahead.next;
            }else{
                bhead.next = listNode;
                bhead = bhead.next;
            }
            cur = cur.next;
        }
        //链接两个子链表
        ahead.next = dummyb.next;
        return dummya.next;
    }
}
