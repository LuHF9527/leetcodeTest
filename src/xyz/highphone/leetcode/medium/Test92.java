package xyz.highphone.leetcode.medium;

import xyz.highphone.leetcode.ListNode;

import java.util.List;

/**
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class Test92 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        head.next = node2;
        printNode(head);
        printNode(new Test92().reverseBetween(head, 2, 4));
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(null == head)
            return head;
        ListNode myhead = new ListNode(-1);
        myhead.next = head;
        int cnt = 0;
        ListNode mNode = myhead;
        ListNode nNode =myhead;
        while (myhead != null)
        {
            myhead = myhead.next;
            cnt++;

        }
        return null;
    }

    public static void printNode(ListNode node)
    {
        while (node != null)
        {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("NULL");
    }
}

