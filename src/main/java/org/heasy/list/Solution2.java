package org.heasy.list;

import org.heasy.model.ListNode;

public class Solution2 {

    /**
     * 2 两数相加
     * <p>
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * 注意
     * l1=[0,1]，l2=[0,1,2]l2=[0,1,2]	当一个列表比另一个列表长时
     * l1=[]l1=[]，l2=[0,1]l2=[0,1]	当一个列表为空时，即出现空列表
     * l1=[9,9]l1=[9,9]，l2=[1]l2=[1]
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode res = l;
        ListNode a = l1, b = l2;
        int sum, carry = 0;
        while (a != null || b != null) {
            int aV = a == null ? 0 : a.val;
            int bV = b == null ? 0 : b.val;
            sum = aV + bV + carry;
            carry = sum / 10;
            a = a == null ? null : a.next;
            b = b == null ? null : b.next;
            l.next = new ListNode(sum % 10);
            l = l.next;
        }
        if (carry > 0) {
            l.next = new ListNode(carry);
        }
        return res.next;
    }


    /**
     * test
     */
    public static void main(String[] args) {
        ListNode l = new ListNode(2);
        l.next = new ListNode(4);
        l.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        Solution2 s = new Solution2();
        System.out.println(s.addTwoNumbers(l, l2));
    }
}