package org.heasy.list;

import org.heasy.model.ListNode;

public class Solution23 {
    /**
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     * 示例:
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     * 笨方法：遍历每次找最小的添加到后面
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(0);
        ListNode curr = res;
        int length = lists.length;
        if (length == 0) {
            return null;
        }
        while (length > 0) {
            int m = 0;
            for (int i = 0; i < length; i++) {
                if (lists[i] == null) {
                    if (length - 1>= i) {
                        System.arraycopy(lists, i + 1, lists, i, length - 1 - i);
                    }
                    --length;
                    i--;
                    continue;
                }
                if (lists[m].val > lists[i].val) {
                    m = i;
                }

            }
            if (lists[m] == null) {
                break;
            }
            curr.next = lists[m];
            curr = curr.next;
            lists[m] = lists[m].next;
        }

        return res.next;
    }


    /**
     * test
     */
    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(4);
        l.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode[] ls = new ListNode[3];
        ls[0] = null;
        ls[1] = null;
//        ls[2] = l3;
        Solution23 solution23 = new Solution23();
        ListNode listNode = solution23.mergeKLists(ls);
        System.out.println(listNode);
    }
}
