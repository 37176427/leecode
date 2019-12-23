package org.heasy.list;

import org.heasy.model.ListNode;

/**
 * 描述 ：
 * 作者 ：WYH
 * 时间 ：2019/12/23 15:43
 **/
public class Sulotion82 {
    /**
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     * 示例 1:
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     * 示例 2:
     * 输入: 1->1->1->2->3
     * 输出: 2->3
     * todo: 未解决
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode hold = new ListNode(0);
        hold.next = head;
        ListNode p = hold;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            int currV = curr.val;
            //当前节点和下个节点值相同
            if (curr.next.val == currV) {
                while (curr != null && curr.val == currV) {
                    curr = curr.next;
                }
                p.next = curr;
            } else {
                curr = curr.next;
            }
            p = p.next;
        }
        return hold.next;
    }


    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        ListNode c = l;
        l.next = new ListNode(2);
        l = l.next;
        l.next = new ListNode(3);
        l = l.next;
        l.next = new ListNode(3);
        l = l.next;
        l.next = new ListNode(4);
        l = l.next;
        l.next = new ListNode(4);
        l = l.next;
        l.next = new ListNode(5);
        Sulotion82 s = new Sulotion82();
        ListNode listNode = s.deleteDuplicates(c);
        System.out.println(listNode);
    }
}
