package org.heasy;

import org.heasy.model.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 通过次数117,254提交次数177,812
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * @author wyh
 * @date 2020/6/28 14:02
 **/
public class S24 {
    //1->2->3->4  --- 2->1->4->3
    public ListNode swapPairs(ListNode head) {
        //要交换的都不为null才进行交换
        if(head!=null && head.next!=null){
            //记录要返回的节点 2
            ListNode ret = head.next;
            //记录 除本次交换节点 后的链表 3->4
            ListNode tmp = ret.next;
            //2.next -> 1
            ret.next = head;
            //1.next -> 交换后的tmp
            head.next =  swapPairs(tmp);
            return ret;
        }
        return head;
    }
}
