package org.heasy.list;

import org.heasy.model.ListNode;

import java.util.Arrays;

/**
 * @author wyh
 * @date 2021/6/22 16:48
 **/
public class S203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                //遇到相等的值 将前驱节点的next指向当前节点next 断开了当前节点
                pre.next = cur.next;
            } else {
                //一定要在不相等的时候才移动这个节点
                pre = pre.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void insertSort(int[] array) {
        if (array == null || array.length < 1) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int val = array[i];
            if (val < array[i - 1]) {
                int j = i;
                while (j > 0 && array[j - 1] > val) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[j] = val;
            }
        }


    }

    //核心代码---结束
    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,1,6,3,8,5,7,9};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr) {
        doQuick(arr, 0, arr.length-1);
    }

    private static void doQuick(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int key = arr[left];
        while (l < r) {
            while (l < r && arr[r] > key) {
                r--;
            }
            arr[l] = arr[r];

            while (l < r && arr[l] < key) {
                l++;
            }
            arr[r] = arr[l];

        }
        arr[l] = key;

        doQuick(arr, left, l - 1);
        doQuick(arr, l + 1, right);
    }
}
