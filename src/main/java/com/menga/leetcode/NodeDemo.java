package com.menga.leetcode;

/**
 * Created by Marvel on 2019/9/17.
 */
public class NodeDemo {

    /**
     * 反转链表
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    public static ListNode build(int[] arr) {
        ListNode head = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            ListNode n = new ListNode(arr[i]);
            n.next = head;
            head = n;
        }
        return head;
    }

    public static void print(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val);
            System.out.print("->");
            p = p.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = build(arr);
        print(head);
        print(reverseList(head));
    }
}
