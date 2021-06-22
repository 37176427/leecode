package org.heasy.list;

import org.heasy.model.ListNode;

/**
 * @author wyh
 * @date 2021/6/22 16:48
 **/
public class S203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                //遇到相等的值 将前驱节点的next指向当前节点next 断开了当前节点
                pre.next = cur.next;
            }else{
                //一定要在不相等的时候才移动这个节点
                pre = pre.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
