package org.heasy.list;

import org.heasy.model.ListNode;

public class Solution141 {
    /**
     * 题解： 快慢指针法 有环必定会相遇
     *
     * 给定一个链表，判断链表中是否有环。
     *
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     *
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head,fast = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
