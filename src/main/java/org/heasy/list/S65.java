package org.heasy.list;

import org.heasy.model.ListNode;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 * @author wyh
 * @date 2021/6/22 15:16
 **/
public class S65 {
    public ListNode rotateRight(ListNode head, int k) {
        //特殊参数处理
        if(head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l = dummy;
        ListNode r = dummy;
        //链表长度
        int n = 0;
        ListNode c = head;
        while(c !=null){
            c=c.next;
            n++;
        }
        //如果是长度倍数 不需要改变
        int add = k % n;
        if(add == 0){
            return head;
        }
        //右指针先走k步
        while (add > 0){
            add--;
            r = r.next;
        }
        //左右同时移动 直到r.next为null
        while (r.next != null){
            l = l.next;
            r = r.next;
        }
        dummy.next = l.next;
        //k与链表长度相等时 l未移动 也就不需要变换
        l.next = null;
        r.next = head;
        return dummy.next;
    }

}
