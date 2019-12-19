package org.heasy.list;

import org.heasy.model.ListNode;


public class Solution21 {


    /**
     * 简单
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode m = listNode;
        int c;
        while (l1 != null && l2 != null) {
            if (l1.val<l2.val){
                c=l1.val;
                l1=l1.next;
            }else {
                c=l2.val;
                l2=l2.next;
            }
            m.next = new ListNode(c);
            m = m.next;
        }
        if (l1!=null){
            m.next = l1;
        }
        if (l2!=null){
            m.next = l2;
        }
        return listNode.next;
    }


    /**
     * test
     */
    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        Solution21 s = new Solution21();
        ListNode listNode = s.mergeTwoLists(l, l2);
        System.out.println(listNode);
    }


}
