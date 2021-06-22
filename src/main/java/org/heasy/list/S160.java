package org.heasy.list;

import org.heasy.model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 *
 * @author wyh
 * @date 2021/6/22 16:36
 **/
public class S160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB){
            if (pA == null){
                pA = headB;
            }else {
                pA = pA.next;
            }

            if (pB == null){
                pB = headA;
            }else {
                pB = pB.next;
            }
        }
        return pA;
    }
}
