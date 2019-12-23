package org.heasy.list;

import org.heasy.model.ListNode;

/**
 * 描述 ：
 * 作者 ：WYH
 * 时间 ：2019/12/23 15:43
 **/
public class Solution82 {
    /**
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     * 示例 1:
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     * 示例 2:
     * 输入: 1->1->1->2->3
     * 输出: 2->3
     * 难点： 控制前驱指针移动的时机 和前驱指针的next指针赋值
     * 题解：定义一个 dummy 头结点，链接上原链表，cur 指向原链表头部
     *      1 当前结点value ！= 当前结点的下一结点value。那么让pre指针来到当前结点，这样就链接了前一结点和当前结点。然后当前结点移至下一结点
     *      2 当前结点value == 当前结点的下一结点value。那么就让 cur 一直往下走直到 当前结点value ！= 当前结点的下一结点value，然后此时是不能动 pre 指针的，要避免后面还有重复的，所以让 pre->next = cur->next。然后当前结点移至下一结点。
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode hold = new ListNode(0);
        hold.next = head;
        ListNode p = hold;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            //当前节点和下个节点值相同
            if (curr.val == curr.next.val) {
                //找到不同于当前节点值的节点
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                p.next = curr.next;
            //如果当前节点和下个节点值不同 则说明这个节点需要保留 移动前驱节点p
            } else {
                p = curr;
            }
            curr = curr.next;
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
        Solution82 s = new Solution82();
        ListNode listNode = s.deleteDuplicates(c);
        System.out.println(listNode);
    }
}
