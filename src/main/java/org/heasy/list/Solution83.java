package org.heasy.list;

import org.heasy.model.ListNode;

/**
 * 描述 ：
 * 作者 ：WYH
 * 时间 ：2019/12/23 15:12
 **/
public class Solution83 {

    /**
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     * 题解：遍历一次 如果next的值和自己相同 则将自己的next指向next.next 跳过相同的节点
     * 示例 1:
     * 输入: 1->1->2
     * 输出: 1->2
     * 示例 2:
     * 输入: 1->1->2->3->3
     * 输出: 1->2->3
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode s = new ListNode(0);
        s.next = head;
        ListNode s1 = s.next;
        while (s1 != null) {
            if (s1.next == null) {
                break;
            }
            if (s1.val == s1.next.val) {
                s1.next = s1.next.next;
            } else {
                s1 = s1.next;
            }
        }
        return s.next;
    }
}
