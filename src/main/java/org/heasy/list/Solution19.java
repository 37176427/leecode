package org.heasy.list;

import org.heasy.model.ListNode;

public class Solution19 {

    /**
     * leecode 19 删除链表的倒数第 n 个节点
     * 题解： 快慢指针 两个指针间隔n个节点 然后删除慢指针的next节点即可
     * 难点： 空指针异常 边界条件优雅判定
     * 技巧： 使用虚拟头节点 可以防止null 或只有一个结点时的问题
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode fast = h;
        ListNode slow = h;
        //快指针先走N步
        for (int i=0;i<=n;i++){
            fast = fast.next;
        }
        while (fast!=null){
            fast  = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return h.next;
    }


    /**
     * test
     */
    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);


        Solution19 s = new Solution19();
        ListNode listNode = s.removeNthFromEnd(l, 3);
        System.out.println(listNode);
    }
}