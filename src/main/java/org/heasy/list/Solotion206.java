package org.heasy.list;

import org.heasy.model.ListNode;

public class Solotion206 {


    /**
     * 反转一个单链表。
     * 示例:
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     * 迭代 ： 保存下一个节点的引用 反转当前节点next指针
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 递归 没做出来 官方题解：
     * 看了半个小时可算是把这个递归看懂了！
     * 不妨假设链表为1，2，3，4，5。按照递归，当执行reverseList（5）的时候返回了5这个节点，
     * reverseList(4)中的p就是5这个节点，我们看看reverseList（4）接下来执行完之后，
     * 5->next = 4, 4->next = null。这时候返回了p这个节点，也就是链表5->4->null，
     * 接下来执行reverseList（3），代码解析为4->next = 3,3->next = null，
     * 这个时候p就变成了，5->4->3->null, reverseList(2), reverseList(1)依次类推，
     * p就是:5->4->3->2->1->null
     */
    public ListNode reverseList2(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if (head == null || head.next == null) {
            System.out.println("if返回" + head);
            return head;
        }
        //这里的p就是最后一个节点
        ListNode p = reverseList2(head.next);
        //如果链表是 1->2->3->4->5，那么此时的p就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回p，也就是最后一个节点
        return p;
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

        Solotion206 s = new Solotion206();
        ListNode listNode = s.reverseList2(l);
        System.out.println(listNode);
    }
}
