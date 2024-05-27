package work.icu007.day09;

import work.icu007.day08.Day08;

public class Day09 {
    public static void main(String[] args) {

    }

    // 删除链表的倒数第 N 个结点
    // 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头节点
        ListNode dummyNode = new ListNode(0,head);
        // 快慢指针
        ListNode fastNode = dummyNode;
        ListNode slowNode = dummyNode;
        // 注意边界问题；快指针先走n + 1步，因为初始化时 fastNode = dummyNode，所以这里是 i <= n；如果是 fastNode = head, 则 i < n;
        for(int i = 0; i <= n; i++) {
            fastNode = fastNode.next;
        }
        // 快慢指针同时走，直到快指针走到最后一个节点
        while (fastNode != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        // 走完后 快指针走到最后一个节点，慢指针走到需要被删除节点的前一个节点。
        // 删除节点
        slowNode.next = slowNode.next.next;
        return dummyNode.next;
    }
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
