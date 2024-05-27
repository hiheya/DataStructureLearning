package work.icu007.day07;

public class Day07 {
    public static void main(String[] args) {

    }

    // 反转链表
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        // 初始化前一个节点为null
        ListNode prev = null;
        // 初始化当前节点为头节点
        ListNode current = head;
        // 当当前节点不为空时，继续循环
        while (current != null) {
            // 保存当前节点的下一个节点
            ListNode nextTemp = current.next;
            // 将当前节点的下一个节点指向前一个节点
            current.next = prev;
            // 前一个节点指向当前节点
            prev = current;
            // 当前节点指向下一个节点
            current = nextTemp;
        }
        // 返回前一个节点
        return prev;
    }
}
