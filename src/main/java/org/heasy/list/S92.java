package org.heasy.list;

import org.heasy.model.ListNode;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]

 * @author wyh
 * @date 2021/6/22 15:03
 **/
public class S92 {

    /**
     * 自己做出来的 yes
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //4个指针 左指针的前驱节点
        ListNode lp = dummy;
        //右指针的下一节点
        ListNode rn = head.next;
        //左指针
        ListNode l = head;
        //右指针
        ListNode r = head;
        //方便循环的索引处理
        left = left-1;
        right = right-1;
        while (left > 0 || right > 0){
            //移动2个左指针
            if (left > 0){
                left--;
                lp = lp.next;
                l = l.next;
            }
            //移动2个右指针
            if (right > 0){
                right--;
                rn = rn.next;
                r = r.next;
            }
        }
        //链表反转的代码 一些少许不同
        //将pre为null 改为rn 这样第一个反转区间内的节点的next指向rn 也就是反转链表尾节点的指向
        ListNode pre = rn;
        ListNode cur = l;
        //链表结束反转的标志从!=null 改为 !=rn
        while (cur != rn){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //反转结束后 pre代表反转链表的头节点 使原链表与反转后链表连接
        lp.next = pre;
        return dummy.next;
    }
}
