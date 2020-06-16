package org.heasy;

import org.heasy.model.ListNode;

/**
 * 难度：困难
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * 通过次数130,873提交次数252,178
 * @author wyh
 * @date 2020/6/16 10:23
 **/
public class S23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int length = lists.length;
        while (length > 1) {
            //当前操作下标
            int curr = 0;
            //最多操作次数
            int stop = length >> 1;
            //如果长度为奇数 需要与null多操作一次
            if ((length & 1) == 1) {
                stop += 1;
            }
            //将0替换为0、1的合并结果， 1替换为2、3的合并结果 如果下标3越界 则使用null
            for (int i = 0; i < stop; i++) {
                lists[i] = mergeTwo(lists[curr], curr + 1 >= length ? null : lists[curr + 1]);
                curr += 2;
            }
            //如果为奇数 补偿多减掉的1
            if ((length & 1) == 1) {
                length++;
            }
            length -= stop;
        }
        return lists[0];
    }

    /**
     * 合并两个有序链表
     **/
    private ListNode mergeTwo(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode curr = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }
        return res.next;
    }

}
